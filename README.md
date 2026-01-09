# ⚽ Sistema de Gestión de Torneos de Fútbol

![Java](https://img.shields.io/badge/Java-17-orange)
![JPA](https://img.shields.io/badge/JPA-Hibernate-blue)
![Architecture](https://img.shields.io/badge/Architecture-Multilayer-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

Aplicación Java completa para la administración y seguimiento de torneos de fútbol, desarrollada con mapeo objeto-relacional JPA/Hibernate y arquitectura en capas.

## 📋 Características Principales

- **Gestión completa de equipos** (CRUD completo)
- **Administración de jugadores** con asignación a equipos
- **Registro de partidos** con marcador y fechas
- **Sistema de goles** detallado por jugador y minuto
- **Asignación de posiciones/roles** a jugadores
- **Interfaz gráfica intuitiva** (Swing)
- **Arquitectura en 3 capas** bien definidas

## 🏗️ Arquitectura del Proyecto

```
Capa de Presentación (Swing UI)
         ↓
Capa de Servicios (Interfaces/Impl)
         ↓
Capa de Persistencia (JPA/Hibernate)
         ↓
Base de Datos (MySQL)
```

## 🗄️ Estructura de la Base de Datos

### Diagrama Entidad-Relación
```
┌─────────────┐      ┌─────────────┐      ┌─────────────┐
│   EQUIPOS   │◄──┐  │  JUGADORES  │      │  POSICIONES │
├─────────────┤   │  ├─────────────┤      ├─────────────┤
│ ID_Equipo   │   └──│ ID_Equipo   │      │ ID_Posicion │
│ Nombre      │      │ ID_Jugador  │      │ Nombre      │
└─────────────┘      │ Nombre      │      └─────────────┘
       │             │ Fecha_Nac   │            │
       │             └─────────────┘            │
       │                   │                    │
       ▼                   ▼                    ▼
┌─────────────┐    ┌─────────────┐    ┌─────────────────┐
│   PARTIDOS  │    │    GOLES    │    │ JUGADOR_POSICION│
├─────────────┤    ├─────────────┤    ├─────────────────┤
│ ID_Partido  │◄───│ ID_Partido  │    │ ID_Jugador      │
│ ID_Local    │    │ ID_Gol      │    │ ID_Posicion     │
│ ID_Visitante│    │ ID_Jugador  │    └─────────────────┘
│ Goles_Local │    │ Minuto      │
│ Goles_Visit │    └─────────────┘
│ Fecha       │
└─────────────┘
```

## 🚀 Tecnologías Utilizadas

- **Java 17** - Lenguaje principal
- **JPA/Hibernate** - Mapeo objeto-relacional
- **MySQL** - Sistema de gestión de base de datos
- **Swing** - Interfaz gráfica de usuario
- **Maven** - Gestión de dependencias
- **Lombok** - Reducción de código boilerplate
- **JUnit** - Pruebas unitarias

## 📁 Estructura del Proyecto

```
src/main/java/com/torneofutbol/
├── config/                 # Configuraciones JPA/Hibernate
├── model/                 # Entidades JPA
│   ├── Equipo.java
│   ├── Jugador.java
│   ├── Partido.java
│   ├── Gol.java
│   └── Posicion.java
├── repository/            # Repositorios JPA
├── service/              # Capa de servicios
│   ├── interfaces/       # Interfaces de servicio
│   └── impl/            # Implementaciones
├── dto/                  # Objetos de transferencia
├── ui/                   # Interfaz gráfica Swing
│   ├── frames/          # Ventanas principales
│   ├── dialogs/         # Diálogos
│   └── components/      # Componentes reutilizables
└── Main.java            # Punto de entrada
```

## 🛠️ Configuración e Instalación

### Requisitos Previos
- Java JDK 17 o superior
- MySQL Server 8.0+
- Maven 3.8+
- IDE (Eclipse, IntelliJ, o VS Code)

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tuusuario/torneo-futbol.git
   cd torneo-futbol
   ```

2. **Configurar la base de datos**
   ```sql
   CREATE DATABASE torneo_futbol;
   CREATE USER 'torneo_user'@'localhost' IDENTIFIED BY 'password123';
   GRANT ALL PRIVILEGES ON torneo_futbol.* TO 'torneo_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configurar archivo `persistence.xml`**
   ```xml
   <property name="javax.persistence.jdbc.url" 
             value="jdbc:mysql://localhost:3306/torneo_futbol"/>
   <property name="javax.persistence.jdbc.user" value="torneo_user"/>
   <property name="javax.persistence.jdbc.password" value="password123"/>
   ```

4. **Compilar y ejecutar**
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.torneofutbol.Main"
   ```

## 📊 Funcionalidades Implementadas

### ✅ CRUD Completo
- **Equipos**: Crear, leer, actualizar, eliminar
- **Jugadores**: Registro completo con fecha de nacimiento
- **Partidos**: Programación y resultados
- **Goles**: Registro detallado por minuto

### 🔧 Operaciones Especiales
- Asignar múltiples posiciones a jugadores
- Calcular estadísticas de equipos
- Historial de partidos por fecha
- Búsqueda avanzada de jugadores

## 🎯 Diagrama de Clases

```
+----------------+       +----------------+       +----------------+
|    Equipo      |       |   Jugador      |       |   Partido      |
+----------------+       +----------------+       +----------------+
| - idEquipo     |1      | - idJugador    |       | - idPartido    |
| - nombre       |◄------|- nombre        |       | - equipoLocal  |
| - jugadores    |*      | - fechaNac     |       | - equipoVisit  |
+----------------+       | - equipo       |       | - golesLocal   |
        |                +----------------+       | - golesVisit   |
        |                        |                | - fecha        |
        |                        |                +----------------+
        |                        |                        |
        ▼                        ▼                        ▼
+----------------+       +----------------+       +----------------+
|   Posicion     |       |     Gol        |       |   Services     |
+----------------+       +----------------+       +----------------+
| - idPosicion   |       | - idGol        |       | + gestionarEquipo()
| - nombre       |       | - partido      |       | + gestionarJugador()
+----------------+       | - jugador      |       | + registrarPartido()
        |                | - minuto       |       | + registrarGol()
        |                +----------------+       +----------------+
        |
+----------------+
| JugadorPosicion|
+----------------+
| - jugador      |
| - posicion     |
+----------------+
```

## 📝 Ejemplos de Uso

### Crear un equipo
```java
EquipoService equipoService = new EquipoServiceImpl();
Equipo nuevoEquipo = new Equipo();
nuevoEquipo.setNombre("Real Madrid");
equipoService.guardarEquipo(nuevoEquipo);
```

### Registrar un partido
```java
Partido partido = new Partido();
partido.setEquipoLocal(realMadrid);
partido.setEquipoVisitante(barcelona);
partido.setGolesLocal(3);
partido.setGolesVisitante(2);
partido.setFecha(new Date());
partidoService.registrarPartido(partido);
```


## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 🤝 Contribuciones

Invítame un café
El código de esta página es libre de usar. Si te fue útil o gusto, puedes apoyar mi trabajo invitándome un café 

## Buy Me A Coffee
(https://PayPal.me/Alejandromtzg1394)

