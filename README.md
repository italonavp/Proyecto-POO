# 🏢 Sistema Northwind - Gestor de Ventas y Pedidos

![Northwind](https://img.shields.io/badge/Sistema-Northwind-blue)
![Java](https://img.shields.io/badge/Desarrollado%20en-Java-red)
![Status](https://img.shields.io/badge/Status-Activo-green)

Bienvenido al **Sistema Northwind**, una aplicación completa de gestión empresarial para administrar clientes, productos, pedidos, empleados, reportes y análisis avanzados.

---

## 📚 Tabla de Contenidos

- [¿Qué es Northwind?](#qué-es-northwind)
- [Características Principales](#características-principales)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Manual de Usuario](#manual-de-usuario)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Módulos Disponibles](#módulos-disponibles)
- [Soporte](#soporte)

---

## ¿Qué es Northwind?

**Sistema Northwind** es una aplicación de escritorio diseñada para gestionar todas las operaciones de una empresa de ventas. Permite:

- 📊 Gestionar productos, clientes, empleados y proveedores
- 📋 Registrar y dar seguimiento a pedidos
- 📈 Generar reportes detallados
- 🔮 Realizar análisis predictivos usando inteligencia de datos
- 📉 Ver análisis gráficos de ventas y tendencias

Es perfecto para empresas pequeñas y medianas que necesitan una solución de gestión integral.

---

## ✨ Características Principales

### 🔐 Seguridad
- Sistema de login con usuario y contraseña
- Control de permisos por usuario
- Sesiones seguras

### 📊 Gestión de Datos
- Mantenimiento de productos
- Registro de clientes
- Gestión de empleados
- Control de proveedores
- Administración de territorios y regiones

### 📦 Gestión de Pedidos
- Creación de órdenes de venta
- Asignación de transportistas
- Seguimiento de estados
- Detalles de items en pedidos

### 📈 Reportes Profesionales
- Reportes simples por entidad
- Reportes parametrizados con filtros
- Reportes gráficos
- Tabla cruzada para análisis comparativos
- Exportación de reportes

### 🔮 Análisis Avanzados
- **Cadena de Markov**: Predicción de patrones de compra
- **Dashboard Gráfico**: Visualización de métricas clave
- **Análisis de Árbol de Decisión**: Modelo predictivo de compras de clientes

---

## 💻 Requisitos del Sistema

Para ejecutar **Sistema Northwind** necesitas tener instalado:

### Software Obligatorio
- **Java Runtime Environment (JRE)** versión 8 o superior
  - Descarga: https://www.java.com/es/download/

### Base de Datos
- La aplicación se conecta a una base de datos SQL Server o MySQL
- Asegúrate de que la base de datos esté disponible y accesible

### Hardware Mínimo
- **Procesador**: Intel/AMD de 1.5 GHz o superior
- **RAM**: 2 GB mínimo (4 GB recomendado)
- **Espacio en disco**: 500 MB
- **Pantalla**: Resolución 1024x768 mínimo

### Sistema Operativo
- Windows 7 o superior
- macOS 10.12 o superior
- Linux (cualquier distribución moderna)

---

## 🚀 Instalación y Ejecución

### Opción 1: Ejecutar desde NetBeans (Desarrollo)

1. **Abre el proyecto en NetBeans**
   ```bash
   Archivo → Abrir Proyecto → Selecciona la carpeta Proyecto-POO
   ```

2. **Verifica la conexión a base de datos**
   - En la carpeta `nbproject/private/config.properties` configura tus credenciales

3. **Ejecuta la aplicación**
   ```bash
   Click derecho en el proyecto → Ejecutar
   O presiona: F6
   ```

### Opción 2: Ejecutar el JAR compilado

1. **Compila el proyecto** (si aún no lo has hecho)
   ```bash
   Click derecho en el proyecto → Construir
   ```

2. **Busca el archivo JAR en:**
   ```
   Proyecto-POO/dist/Proyecto-POO.jar
   ```

3. **Ejecuta desde la línea de comandos:**
   ```bash
   java -jar Proyecto-POO.jar
   ```

4. **O haz doble clic en el archivo JAR** (si Java está configurado como predeterminado)

### Opción 3: Crear un Acceso Directo (Windows)

1. Click derecho en el escritorio → Nueva → Acceso directo
2. En la ubicación, pega:
   ```
   java -jar "C:\ruta\a\Proyecto-POO\dist\Proyecto-POO.jar"
   ```
3. Asigna un nombre y una imagen
4. ¡Listo! Ahora puedes ejecutar con doble clic

---

## 📖 Manual de Usuario

### ¡IMPORTANTE! Lee el Manual Completo

Para usar correctamente el **Sistema Northwind**, lee el **[Manual de Usuario Completo](MANUAL_DE_USUARIO.md)**.

En el manual encontrarás:
- ✅ Cómo iniciar sesión
- ✅ Cómo gestionar productos, clientes y empleados
- ✅ Cómo crear y procesar pedidos
- ✅ Cómo generar reportes
- ✅ Cómo usar análisis avanzados
- ✅ Preguntas frecuentes y solución de problemas
- ✅ Tareas paso a paso

### 📖 Acceso Rápido a Temas

- [Login y Seguridad](MANUAL_DE_USUARIO.md#-inicio-de-sesión)
- [Pantalla Principal](MANUAL_DE_USUARIO.md#-pantalla-principal)
- [Gestión de Datos](MANUAL_DE_USUARIO.md#-gestión-de-datos)
- [Procesamiento de Pedidos](MANUAL_DE_USUARIO.md#-procesamiento-de-pedidos)
- [Reportes](MANUAL_DE_USUARIO.md#-reportes)
- [Análisis Avanzados](MANUAL_DE_USUARIO.md#-análisis-avanzados)

---

## 📂 Estructura del Proyecto

```
Proyecto-POO/
├── src/                          # Código fuente
│   ├── PRESENTACION/             # Clases de inicio
│   │   ├── Main.java            # Punto de entrada
│   │   └── ReporteGrafico.java  # Dashboard visual
│   ├── UI/                       # Formularios (Interfaz gráfica)
│   │   ├── FrmLogin.java        # Pantalla de login
│   │   ├── MDIPrincipal.java    # Pantalla principal
│   │   ├── FrmCustomer.java     # Gestión de clientes
│   │   ├── FrmProducts.java     # Gestión de productos
│   │   ├── FrmOrders.java       # Gestión de pedidos
│   │   └── ...                  # Otros formularios
│   ├── DAO/                      # Acceso a datos
│   │   ├── CustomerDAO.java     # Datos de clientes
│   │   ├── ProductDAO.java      # Datos de productos
│   │   └── ...                  # Otros DAOs
│   ├── BEAN/                     # Modelos de datos
│   │   ├── Customer.java        # Entidad Cliente
│   │   ├── Product.java         # Entidad Producto
│   │   └── ...                  # Otras entidades
│   ├── ALGORITMO/               # Algoritmos de análisis
│   │   └── ArbolDecision.java   # Árbol de decisión
│   ├── Markov/                  # Análisis de Cadena de Markov
│   │   ├── MarkovChain.java
│   │   ├── FormMarkov.java
│   │   └── MarkovDAO.java
│   ├── REPORTS/                 # Archivos de reportes
│   │   ├── *.jrxml              # Definiciones de reportes
│   │   └── *.jasper             # Reportes compilados
│   └── UTIL/                    # Clases de utilidad
├── build/                        # Archivos compilados
│   └── classes/                 # Clases .class
├── dist/                         # Archivo JAR ejecutable
│   └── Proyecto-POO.jar
├── nbproject/                    # Configuración de NetBeans
├── build.xml                     # Configuración de compilación
└── README.md                     # Este archivo
```

---

## 🎯 Módulos Disponibles

### 1. 🔐 Módulo de Autenticación
- Login con usuario/contraseña
- Control de acceso por rol
- Seguridad de sesión

### 2. 📊 Módulo de Mantenimiento
Gestiona los datos maestros de la empresa:
- **Productos**: Catálogo completo con precios y stock
- **Clientes**: Información de contacto y dirección
- **Empleados**: Datos del personal
- **Categorías**: Clasificación de productos
- **Proveedores**: Información de suministradores
- **Usuarios**: Control de usuarios del sistema
- **Regiones**: Divisiones geográficas
- **Transportistas**: Empresas de logística
- **Territorios**: Áreas de venta

### 3. 📦 Módulo de Transacciones
- **Órdenes**: Gestión de pedidos de clientes
- **Detalles de Orden**: Items específicos en cada pedido

### 4. 📈 Módulo de Reportes
Más de 25 reportes disponibles:
- Reportes simples de cada entidad
- Reportes parametrizados (con filtros)
- Reportes gráficos
- Análisis comparativos

### 5. 🔮 Módulo de Análisis Avanzados
- **Cadena de Markov**: Predice patrones de compra
- **Árbol de Decisión**: Analiza comportamiento de clientes
- **Dashboard**: Visualización de métricas claves

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java
- **IDE**: NetBeans
- **GUI**: Swing (Java AWT)
- **Base de Datos**: SQL Server / MySQL
- **Reportes**: JasperReports
- **Algoritmos**: Árbol de Decisión, Cadena de Markov
- **Build**: Apache Ant

---

## 🎓 Primeros Pasos

### Para el Usuario Nuevo:
1. Lee el [Manual de Usuario](MANUAL_DE_USUARIO.md)
2. Ejecuta la aplicación
3. Inicia sesión con tus credenciales
4. Explora los menús
5. Sigue los ejemplos del manual

### Para el Administrador:
1. Verifica la conexión a base de datos
2. Crea usuarios en el sistema
3. Asigna roles y permisos
4. Capacita a los usuarios finales

### Para el Desarrollador:
1. Clona o descarga el proyecto
2. Abre en NetBeans
3. Revisa la estructura del código
4. Modifica según necesidades
5. Compila y distribuye

---

## ⚙️ Configuración

### Conexión a Base de Datos
Edita el archivo: `nbproject/private/config.properties`

```properties
database.url=jdbc:sqlserver://tu-servidor:1433;databaseName=Northwind
database.user=tu-usuario
database.password=tu-contraseña
```

### Parámetros de Algoritmos
En [Main.java](src/PRESENTACION/Main.java) puedes ajustar:
- Profundidad del árbol de decisión
- Muestras mínimas para división
- Proporción de datos de entrenamiento/prueba

---

## 📞 Soporte y Ayuda

### ❓ Preguntas Comunes
Consulta la sección [Preguntas Frecuentes](MANUAL_DE_USUARIO.md#-preguntas-frecuentes) del manual

### 🆘 Problemas Técnicos
Ver [Solución de Problemas](MANUAL_DE_USUARIO.md#-solución-de-problemas) en el manual

### 👥 Contacto
- **Usuario**: Contacta a tu supervisor o administrador del sistema
- **Administrador**: Revisa los logs y la configuración
- **Desarrollador**: Consulta el código fuente y la documentación técnica

---

## 📋 Checklist de Instalación

- [ ] Java JRE 8+ instalado
- [ ] Base de datos configurada y accesible
- [ ] Archivo `config.properties` actualizado
- [ ] Proyecto compilado correctamente
- [ ] Archivo JAR generado en `/dist`
- [ ] Usuarios y contraseñas creados en el sistema
- [ ] Manual de usuario leído
- [ ] Aplicación ejecutada con éxito
- [ ] Todos los módulos accesibles

---

## 🚀 Mejoras Futuras

Posibles enhancements para versiones futuras:
- [ ] Interfaz web (para acceso remoto)
- [ ] App móvil
- [ ] Machine Learning avanzado
- [ ] Integración con e-commerce
- [ ] Dashboard en tiempo real
- [ ] Exportación a Excel mejorada

---

## 📝 Versión y Cambios

**Versión Actual**: 1.0  
**Fecha de Última Actualización**: 2024  
**Estado**: Estable y en producción

---

## 📄 Licencia

Este proyecto es propiedad de [Tu Empresa]. Todos los derechos reservados.

---

## 🎉 ¡Gracias!

Gracias por usar el **Sistema Northwind**. Tu feedback nos ayuda a mejorar.

Para sugerencias, reporta a tu administrador del sistema.

---

**¿Necesitas ayuda?** 👉 [Lee el Manual Completo](MANUAL_DE_USUARIO.md)

*Documentación actualizada al 2024*
