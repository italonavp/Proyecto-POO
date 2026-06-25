# 📘 Manual de Usuario - Sistema Northwind

## ¡Bienvenido!

Este manual te guiará paso a paso sobre cómo usar el **Sistema Northwind**, una aplicación para gestionar información de clientes, productos, pedidos, empleados y mucho más. No necesitas conocimientos técnicos, solo sigue las instrucciones.

---

## 📋 Tabla de Contenidos

1. [Inicio de Sesión](#inicio-de-sesión)
2. [Pantalla Principal](#pantalla-principal)
3. [Gestión de Datos](#gestión-de-datos)
4. [Procesamiento de Pedidos](#procesamiento-de-pedidos)
5. [Reportes](#reportes)
6. [Análisis Avanzados](#análisis-avanzados)
7. [Consejos Útiles](#consejos-útiles)

---

## 🔐 Inicio de Sesión

### Primer paso: Acceder a la aplicación

Cuando ejecutes la aplicación, verás una ventana con dos campos:

1. **Usuario**: Escribe tu nombre de usuario
2. **Contraseña**: Escribe tu contraseña

### Botones disponibles:
- **Entrar**: Accede al sistema con tus credenciales
- **Salir**: Cierra la aplicación

### ⚠️ Importante:
- Asegúrate de escribir correctamente el usuario y la contraseña
- Si olvidas tus datos, contacta a tu administrador
- Por seguridad, nunca compartas tu contraseña

---

## 🏠 Pantalla Principal

Una vez dentro, verás la **pantalla principal** del sistema. Esta es tu zona de trabajo donde encontrarás:

### Elementos principales:

**Menú superior** (arriba de la pantalla):
- Aquí encontrarás todas las opciones del sistema organizadas por categorías

**Área de trabajo** (centro de la pantalla):
- Es donde se abren las ventanas de cada función que uses

---

## 📊 Gestión de Datos

Esta es la sección donde puedes gestionar toda la información del negocio. Accede a ella desde el menú **"Mantenimiento"**.

### ¿Qué puedes gestionar?

#### 1️⃣ **Productos**
Aquí administras todos los artículos que vende tu empresa.

**Acceso:** Menú → Mantenimiento → Productos

**¿Qué puedes hacer?**
- **Ver lista**: Se muestra una tabla con todos los productos
- **Buscar**: En el campo de búsqueda, escribe el nombre del producto
- **Agregar nuevo**: Completa los campos y haz clic en guardar
- **Editar**: Selecciona un producto de la lista y modifica sus datos
- **Eliminar**: Selecciona un producto y haz clic en eliminar

**Datos del producto:**
- ID del producto
- Nombre
- Proveedor (quién lo suministra)
- Categoría (tipo de producto)
- Precio unitario
- Cantidad en stock (cuánto hay disponible)
- Cantidad en orden (cuánto está pendiente de llegar)

---

#### 2️⃣ **Clientes**
Aquí administras la información de tus clientes.

**Acceso:** Menú → Mantenimiento → Clientes

**¿Qué puedes hacer?**
- **Ver lista**: Observa todos los clientes registrados
- **Buscar**: Busca un cliente específico
- **Agregar nuevo**: Añade un nuevo cliente
- **Editar**: Modifica los datos de un cliente existente
- **Eliminar**: Elimina un cliente (si no tiene pedidos activos)

**Datos del cliente:**
- ID del cliente
- Nombre de la empresa
- Nombre del contacto
- Cargo del contacto
- Dirección
- Ciudad
- Región/Provincia
- Código postal
- País
- Teléfono
- Fax

---

#### 3️⃣ **Órdenes/Pedidos**
Aquí registras los pedidos que hacen tus clientes.

**Acceso:** Menú → Transacciones → Órdenes

**¿Qué puedes hacer?**
- **Ver todos los pedidos**
- **Crear un nuevo pedido**
- **Ver detalles del pedido**
- **Modificar pedidos**
- **Cambiar estado de envío**

**Información importante:**
- Cada pedido necesita un cliente
- Puedes agregar múltiples productos a un pedido
- El sistema calcula automáticamente totales

---

#### 4️⃣ **Empleados**
Gestiona la información de tu equipo de trabajo.

**Acceso:** Menú → Mantenimiento → Empleados

**Datos que puedes gestionar:**
- Nombre del empleado
- Cargo
- Fecha de nacimiento
- Fecha de contratación
- Dirección
- Ciudad
- Teléfono
- Salario

---

#### 5️⃣ **Otras Opciones de Mantenimiento**

El menú de mantenimiento también incluye:
- **Categorías**: Tipos de productos
- **Proveedores**: Empresas que te suministran productos
- **Usuarios**: Personas que acceden al sistema
- **Regiones**: Zonas geográficas
- **Transportistas**: Empresas de envío
- **Territorios**: Áreas de venta

Todas funcionan de manera similar: puedes ver, buscar, agregar, editar y eliminar.

---

## 📦 Procesamiento de Pedidos

### Crear un nuevo pedido

1. Ve a **Menú → Transacciones → Órdenes**
2. Haz clic en **Nuevo**
3. Completa los datos:
   - Selecciona el cliente
   - Selecciona la fecha
   - Elige el transportista (empresa de envío)
4. Haz clic en **Guardar**

### Agregar productos a un pedido

1. Una vez creado el pedido, ve a la sección de detalles
2. Haz clic en **Agregar artículo**
3. Selecciona el producto
4. Ingresa la cantidad
5. El sistema calculará automáticamente el precio

### Cambiar estado de un pedido

- **En proceso**: Acaba de ser creado
- **Enviado**: Ya partió hacia el cliente
- **Entregado**: Llegó a su destino

---

## 📈 Reportes

Los reportes te ayudan a ver información resumida y útil de tu negocio. Los encuentras en el menú principal.

### Tipos de reportes disponibles:

#### 📊 **Reportes de Productos**
- Lista de todos los productos
- Productos con parámetros específicos (por rango de precio)

#### 👥 **Reportes de Clientes**
- Lista de clientes
- Clientes por región
- Clientes con parámetros específicos

#### 📋 **Reportes de Empleados**
- Lista de empleados
- Empleados con parámetros

#### 🏷️ **Reportes de Categorías**
- Productos por categoría
- Categorías con detalle

#### 🚚 **Reportes de Pedidos**
- Pedidos por transportista
- Pedidos con parámetros de fecha

#### 📋 **Otros Reportes**
- Usuarios
- Proveedores
- Territorios
- Tabla cruzada (comparativas)

### ¿Cómo generar un reporte?

1. Abre el menú de reportes
2. Selecciona el tipo de reporte que quieres
3. Si es "con parámetros", ingresa los filtros:
   - Rango de fechas
   - Categoría específica
   - Cliente específico
   - Etc.
4. Haz clic en **Generar** o **Mostrar**
5. El reporte se abrirá en una nueva ventana
6. Desde allí puedes:
   - **Visualizar** los datos
   - **Imprimir** el reporte
   - **Exportar** a PDF (si está disponible)

---

## 🔮 Análisis Avanzados

### 1. Dashboard Gráfico

El **Dashboard** te muestra análisis visuales de tu información.

**Acceso:** Se abre automáticamente o desde el menú de análisis

**¿Qué ves?**
- Gráficos de ventas
- Tendencias de productos populares
- Información resumida del negocio

---

### 2. Análisis de Cadena de Markov

Esta es una función avanzada que **predice qué productos se compran juntos**.

**Acceso:** Menú → Análisis → Cadena de Markov

**¿Cómo funciona?**

1. Selecciona un producto de la lista
2. Haz clic en **Analizar**
3. El sistema te mostrará:
   - Qué otros productos se compran después de este
   - Con qué frecuencia se compran juntos
   - Probabilidades de compra

**¿Para qué sirve?**
- Saber qué productos promover juntos
- Entender los patrones de compra
- Mejorar estrategias de marketing
- Hacer recomendaciones a clientes

**Ejemplo:**
Si analizas "Arroz", el sistema podría decirte:
- "Después de comprar arroz, el 60% de las veces se compra aceite"
- "Después de aceite, el 40% de las veces se compra sal"

---

## 💡 Consejos Útiles

### 🔍 Búsquedas rápidas
- En casi todas las pantallas hay un campo de búsqueda
- Escribe parte del nombre para filtrar resultados
- Presiona **Enter** para buscar

### 💾 Guardar datos
- Siempre haz clic en **Guardar** después de hacer cambios
- Si cierras sin guardar, se perderán los datos

### ⚠️ Eliminar datos
- Algunos datos no se pueden eliminar si están vinculados a otros
- Ejemplo: No puedes eliminar un cliente si tiene pedidos
- El sistema te dirá si algo no se puede eliminar

### 🔄 Actualizar información
- Si otro usuario hace cambios, presiona **F5** o haz clic en **Actualizar**
- Así verás los cambios más recientes

### 📋 Trabajar con tablas
- Haz clic en cualquier fila para seleccionarla
- Los datos aparecerán en los campos de arriba
- Puedes editar los campos y guardar los cambios

### 🖱️ Atajos comunes
- **Guardar**: Ctrl + S (en algunos formularios)
- **Buscar**: Ctrl + F
- **Cerrar ventana**: Alt + F4 o botón X

### 💬 Si algo no funciona
1. Intenta actualizar la pantalla (F5)
2. Cierra la ventana y abre nuevamente
3. Cierra sesión y vuelve a entrar
4. Contacta a tu administrador si persiste el problema

---

## 🎓 Tareas Comunes - Paso a Paso

### Tarea 1: Registrar un nuevo cliente

1. **Menú → Mantenimiento → Clientes**
2. Haz clic en **Nuevo**
3. Completa los campos:
   - ID del cliente
   - Nombre de empresa
   - Nombre del contacto
   - Dirección, ciudad, país
   - Teléfono
4. Haz clic en **Guardar**
5. ¡Listo! El cliente está registrado

---

### Tarea 2: Crear un pedido para un cliente

1. **Menú → Transacciones → Órdenes**
2. Haz clic en **Nuevo**
3. Selecciona el cliente de la lista
4. Escoge la fecha del pedido
5. Selecciona quién va a enviar (transportista)
6. Haz clic en **Guardar**
7. Ahora agrega los productos:
   - Haz clic en **Agregar artículo**
   - Elige el producto
   - Indica la cantidad
   - Haz clic en **Agregar**
8. Repite para todos los productos que quieras
9. Haz clic en **Finalizar pedido**

---

### Tarea 3: Generar un reporte de ventas

1. Ve a **Menú → Reportes**
2. Busca el tipo de reporte que necesitas (ej: Productos, Clientes)
3. Si tiene parámetros:
   - Selecciona las fechas (desde y hasta)
   - Escoge la categoría (si aplica)
4. Haz clic en **Generar**
5. El reporte se mostrará en pantalla
6. Para imprimir: **Ctrl + P** o busca el botón de impresora

---

### Tarea 4: Analizar predicciones de compra

1. Ve a **Menú → Análisis → Cadena de Markov**
2. Selecciona un producto del dropdown
3. Haz clic en **Analizar**
4. Observa:
   - Qué productos se compran después
   - Con qué probabilidad
5. Usa esta información para marketing

---

## ❓ Preguntas Frecuentes

**P: ¿Puedo recuperar datos que eliminé?**
R: Generalmente no. Por eso es importante estar seguro antes de eliminar. Si necesitas recuperar algo, contacta a tu administrador de base de datos.

**P: ¿Por qué no puedo eliminar este cliente?**
R: Probablemente tiene pedidos asociados. Primero debes eliminar o modificar esos pedidos.

**P: ¿Qué significa "Tabla cruzada"?**
R: Es un reporte que compara dos cosas. Por ejemplo, muestra cuántos productos se vendieron en cada categoría.

**P: ¿Cómo cambio mi contraseña?**
R: Generalmente a través de **Menú → Configuración → Cambiar Contraseña** (si está disponible) o contacta a tu administrador.

**P: ¿Puedo usar esto desde otro dispositivo?**
R: Sí, si tienes acceso a la red y la aplicación está instalada.

---

## 🆘 Solución de Problemas

| Problema | Solución |
|----------|----------|
| La aplicación no abre | Verifica que Java esté instalado en tu computadora |
| No puedo conectarme | Revisa tu conexión a internet y que tengas acceso a la base de datos |
| No veo los cambios que hice | Presiona F5 para actualizar o cierra y abre nuevamente la ventana |
| Error al guardar datos | Verifica que todos los campos estén llenos correctamente |
| La aplicación es muy lenta | Reinicia la aplicación o contacta a tu administrador |

---

## 📞 Soporte

Si tienes dudas o problemas:
1. **Consulta este manual** - La respuesta podría estar aquí
2. **Habla con tu jefe o supervisor** - Ellos pueden tener la respuesta
3. **Contacta al administrador del sistema** - Para problemas técnicos

---

## 📝 Información Importante

- **Datos**: Todos tus datos se guardan en la base de datos central
- **Seguridad**: Nunca compartas tu usuario y contraseña
- **Respaldo**: Los datos se respaldan regularmente
- **Privacidad**: La información de clientes es confidencial

---

## 🎉 ¡Estás listo!

Ahora ya sabes cómo usar el **Sistema Northwind**. Recuerda:
- ✅ Guarda siempre tus cambios
- ✅ Usa las búsquedas para encontrar información rápidamente
- ✅ Consulta los reportes para análisis
- ✅ Pide ayuda si la necesitas

¡Bienvenido al equipo! Si tienes sugerencias para mejorar este manual, no dudes en comentarlo.

---

**Versión**: 1.0  
**Última actualización**: 2024  
**Autor**: Documentación del Sistema Northwind
