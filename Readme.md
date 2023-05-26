# Arquitectura MVC con Observer

En esta rama, utilizaremos el patrón Observer.
Los cambios de la velocidad que se hagan en el model serán observados por el Controller.
Para notificar a los observadores, hacemos dos pasos:
* Actualizamos el estado a 'algo ha cambiado' con `setChanged()`.
* Notificamos a los observadores `notifyObservers(valor)`.

De esta manera, se *dispara* en todos los observadores el método `update()`.

Aplicación que trabaja con objetos coches,los crea, modifica la velocidad y la muestra.

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observable{
        +setChanged()
        +notifyObserver(valor)
    }
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {
      +mostrarVelocidad(String, Integer)
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String,String)
          +getCoche(String)
          +subirVelocidad(String,Integer)
          +bajarVelocidad(String,Integer)
          +getVelocidad(String)
      }
      class IU {
          +crearVentana()
      }
      class Dialog {
          +crearDialog()
      }
      class ObserverVelocidad {
      +update()
      }
      
      class ObsExceso {
      +update()
      }
    Controller "1" *-- "1" ObserverVelocidad : association
    Controller "1" *-- "1" ObsExceso : association
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1..1" IU : association
    View "1" *-- "1..1" Dialog : association
    Observable<|--Model
      
```

---

## Diagrama de Secuencia
Qué ocurre cuando se cambia la velocidad.

```mermaid
sequenceDiagram
    actor user
    participant View
    participant Controller
    participant ObserverVelocidad
    participant ObsExceso
    participant Model
    
    user-->>View: Crea el coche
    activate View
    View-->>Controller: El User quiere crear un coche
    activate Controller
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Aquí tienes el coche
    deactivate Model
    Controller-->>View: Coche creado!
    deactivate Controller
    View-->>user: Listo, tu coche se creó!
    deactivate View
    
    user-->>View: Quiero subir la velocidad
    activate View
    View-->>Controller: El User quiere subir la velocidad
    activate Controller
    Controller->>Model: Puedes subir la velocidad?
    activate Model
    Model-->>ObserverVelocidad: Notificación de cambio de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: Muestra la velocidad aumentada
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>user: Listo, la velocidad de tu coche se ha aumentado!    deactivate View
    
    user-->>View: Quiero bajar la velocidad
    activate View
    View-->>Controller: El User quiere bajar la velocidad
    activate Controller
    Controller->>Model: Puedes bajar la velocidad?
    activate Model
    Model-->>ObserverVelocidad: Notificación de cambio de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: Muestra la velocidad reducida
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>user: Listo, la velocidad de tu coche se ha reducido! 
    deactivate View
    
    user-->>View: Quiero controlar la velocidad
    activate View
    View-->>Controller: El User quiere controlar la velocidad
    activate Controller
    Controller->>Model: Puedes controlar la velocidad?
    activate Model
    Model-->>ObsExceso: Notificación de exceso de velocidad
    deactivate Model
    activate ObsExceso
    ObsExceso-->>+View: Muestra el aviso de exceso de velocidad
    deactivate ObsExceso
    deactivate Controller
    View-->>user: Listo, el exceso de velocidad de tu coche se ha mostrado! 
    deactivate View
```

El mismo diagrama con los nombres de los métodos
```mermaid
sequenceDiagram
        actor user    
        participant IU
        participant Dialog
        participant View
        participant Controller
        participant ObserverVelocidad
        participant ObsExceso
        participant Model
    
    user-->>IU: Crea el coche
    IU-->Controller: crearCoche(modelo,matricula)
    activate Controller
    Controller->>Model: crearCoche(modelo, matricula)
    activate Model
    Model-->>Controller: Aquí tienes el coche
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
    user-->>IU: Sube la velocidad del coche
    IU-->>Controller: aumentarVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: subirVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
    user-->>IU: Baja la velocidad del coche
    IU-->>Controller: reducirVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: bajarVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
    user-->>IU: Controla la velocidad del coche
    IU-->>Controller: aumentarVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: aumentarVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObsExceso: update()
    deactivate Model
    activate ObsExceso
    ObsExceso-->>+View: excesoVelocidad(matricula, velocidad)
    deactivate ObsExceso
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
   ```

---
## Pasos para la configuración.

1. Model
    * Extender `Observable` en `Model`.
    * En el método en donde ocurra el cambio:
        * setChanged()
        * notifyObserver(valor)
2. Crear una clase que sea el observador, que implementa la interface `Observer`.
    * Definir el método `update()`
3. Controller
    * Instanciar el observer, definido en el punto anterior.
    * Añadir este observer al observable con `addObserver()`.