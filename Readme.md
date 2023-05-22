# Arquitectura MVC

Aplicación que trabaja con objetos coches,los crea, modifica la velocidad y la muestra.

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {
      +muestraVelocidad(String, Integer)
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +subirVelocidad(String, Integer)
          +bajarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class IU {
      +crearVentana()
      }
      class Dialog {
      +crearDialog()
      }
      
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1" IU : association
    View "1" *-- "1" Dialog : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos.


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    actor User
    
    User-->>View: Crea el coche
    activate View
    View-->>Controller: El User quiere crear un coche
    activate Controller
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Aquí tienes el coche
    deactivate Model
    Controller->>View: Coche creado!
    deactivate Controller
    View-->>User: Listo, tu coche se creó!
    deactivate View
    
    User->>View: Quiero subir la velocidad
    activate View
    View-->>Controller: El User quiere subir la velocidad
    activate Controller
    Controller->>Model: Puedes subir la velocidad?
    activate Model
    Model-->>Controller: Aquí tienes la velocidad aumentada
    deactivate Model
    Controller-->>View: Velocidad aumentada!
    deactivate Controller
    View-->>User: Listo, la velocidad de tu coche se ha aumentado!
    deactivate View
    
    User->>View: Quiero bajar la velocidad
    activate View
    View-->>Controller: El User quiere bajar la velocidad
    activate Controller
    Controller->>Model: Puedes bajar la velocidad?
    activate Model
    Model-->>Controller: Aquí tienes la velocidad reducida
    deactivate Model
    Controller-->>View: Velocidad reducida!
    deactivate Controller
    View-->>User: Listo, la velocidad de tu coche se ha reducido
    deactivate View
```

El mismo diagrama con los nombres de los métodos.

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant Dialog
    participant IU
    actor User
    
    User-->>IU: Crea el coche
    IU-->Controller: crearCoche(modelo,matricula)
    activate Controller
    Controller->>Model: crearCoche(modelo,matricula)
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula,velocidad)
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
       
    User-->>IU: Sube la velocidad del coche
    IU-->Controller: aumentarVelocidad(matricula,velocidad)
    activate Controller    
    Controller->>Model: subirVelocidad(matricula, velocidad)
    activate Model
    Model-->>Controller: El coche con la velocidad aumentada
    deactivate Model
    Controller->>+View: mostrarVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
    User-->>IU: Baja la velocidad del coche
    IU-->Controller: reducirVelocidad(matricula,velocidad)
    activate Controller       
    Controller->>Model: bajarVelocidad(matricula, velocidad)
    activate Model
    Model-->>Controller: El coche con la velocidad reducida
    deactivate Model
    Controller-->>+View: mostrarVelocidad(matricula,velocidad)
    deactivate Controller
    View-->>-Dialog: crearDialog(mensaje)
    
   ```