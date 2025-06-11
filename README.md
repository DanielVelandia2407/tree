# 🌳 El Árbol de la Corrupción 💰
### *Un Cuento de Políticos y Sobornos*

En el mágico y sombrío reino macondiano de **Corruptópolis**, los *polirratas* no se miden por su ética, sino por su habilidad para sobornar sin ser descubiertos. El objetivo: mantener la etiqueta de “**buenos muchachos**”.

Cada político es un nodo en un **Árbol Binario de la Vergüenza**, donde:

- **Si acepta sobornos**: sigue la gloriosa tradición desde 1492 — la cadena de corrupción continúa.
- **Si es incorruptible** (o al menos no acepta el soborno en esta ocasión): ocurre una hecatombe — toda su rama se desploma como un castillo de naipes en un debate político.

---

## 🎯 Tu Misión

Si decides aceptarla (y no te sobornan antes):  
**Encuentra la ruta más corrupta desde el jefazo (raíz) hasta el último lamebotas (hoja).**

---

## 🧱 Especificaciones Técnicas

### 🧍‍♂️ La Estructura del Político

- **Valor de corrupción**: un número entero que indica cuánto dinero público ha redirigido.  
  Puede ser negativo si fue tan inepto que hasta perdió plata.

- **Aceptar soborno**:
    - `true` → *“Sí, mi jefe, lo que usted diga.”*
    - `false` → *“Yo soy honesto (mentira, pero esta vez no me dejo comprar).”*

---

### 🔗 Las Conexiones

- `izquierdo`: el subordinado leal (*el que siempre dice “sí”*).
- `derecho`: el subordinado ambicioso (*el que quiere el puesto del jefe*).

---

### 📜 Las Reglas (porque hasta la corrupción tiene reglas)

1. Si un político **no acepta soborno**, su rama **no cuenta** y detiene la cadena.
2. La ruta debe ir **desde la raíz hasta una hoja** (sin subordinados).
3. Se debe **sumar el valor de corrupción** de todos los políticos en la ruta válida.

---

## 💻 Implementación

Diseñe e implemente un programa en **Java** que permita:

- Representar la estructura del árbol binario.
- Recorrerlo para encontrar la **ruta más corrupta** posible.

---

## 📦 Entregables

- Un archivo `.zip` que contenga:
    - El **código fuente** del proyecto.
    - **No incluir binarios** (`.class`, `.jar`, etc.).

---

## Grupo
1. Daniel Felipe Velandia Jerez 20191020140
2. Nicolás Andrés Yepes Cortés 20222020004
