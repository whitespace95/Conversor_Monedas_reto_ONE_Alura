# 💸 Conversor de monedas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue?style=for-the-badge&logo=intellij-idea)

> Proyecto de convertidor de monedas en Java, pensado para facilitar la conversión entre diversas monedas incluyendo el peso colombiano (COP).
> El convertidor registra cada conversión con una marca de tiempo y permite al usuario seleccionar entre múltiples opciones de divisas.
> Este proytecto se relaiza en el Bootcamp de One y Alura, como reto en modalidad Back.End

---

## 🌟 Características

- **Soporte para Múltiples Monedas**: Convierta entre diferentes tipos de monedas, incluyendo USD, EUR, COP, y muchas más.
- **Registro de Conversiones**: Cada conversión realizada se almacena junto con la fecha y hora, usando la biblioteca `java.time`.
- **Interfaz de Usuario Intuitiva**: Menú sencillo y fácil de navegar para realizar conversiones.
- **Optimización y Código Limpio**: Estructura de código mejorada siguiendo las mejores prácticas de Java.

---

## 📂 Estructura del Proyecto
```plaintext

📁 src
 ┣ 📂 com.aluracursos.conversor
 ┃ ┣ 📂 modelo
 ┃ ┃ ┣ 📄 Moneda.java          # Representación de cada moneda como un record
 ┃ ┣ 📂 vista
 ┃ ┃ ┣ 📄 Menu.java            # Interfaz de usuario para el menú principal
 ┃ ┣ 📂 controlador
 ┃ ┃ ┣ 📄 Conversor.java       # Lógica de conversión entre monedas
 ┣ 📄 Main.java               # Punto de entrada del programa
```

---
## 🛠️ Tecnologías Utilizadas


* Java - Lenguaje de programación
* Java Time API - Para el registro de la marca de tiempo de cada conversión
* IntelliJ IDEA - IDE de desarrollo
* Git - Control de versiones

---

## 🚀 Instalación y Ejecución
1. Clona este repositorio en tu máquina local:
bash git clone https://github.com/whitespace95/Conversor_Monedas_reto_ONE_Alura.git
2. Abre el proyecto en tu IDE preferido (se recomienda IntelliJ IDEA).
3. Asegúrate de tener Java instalado (Java 14 o superior).
4. Ejecuta la clase Main para iniciar el convertidor.

---

## 📝 Uso

1. Al iniciar el programa, se mostrará un menú donde puedes seleccionar las monedas de origen y destino.
2. Introduce la cantidad a convertir y el programa realizará el cálculo.
3. Cada conversión se registra automáticamente con la fecha y hora de ejecución.
Puedes revisar el historial de conversiones durante la sesión actual.

![image](https://github.com/user-attachments/assets/4381a57a-31a0-4818-bd2a-db5330523fa3)



---

## 📈 Ejemplos de Conversión
Aquí hay algunos ejemplos de cómo el programa maneja diferentes conversiones:

* USD a COP: 100 USD → 375,000 COP
* EUR a USD: 50 EUR → 55 USD
* COP a JPY: 100,000 COP → 2,700 JPY

  ![image](https://github.com/user-attachments/assets/cb746528-acd5-4acb-8ef7-0e1528fd389c)

  
*Nota: Las tasas de cambio son simuladas para este ejemplo. Asegúrate de actualizar las tasas según el mercado actual.*

---

## 🗒️ Historial de Conversiones
Cada conversión se guarda en el historial, incluyendo la fecha y hora de ejecución:
[2024-10-07 10:00:00] 100 USD → 375,000 COP
[2024-10-07 10:05:00] 50 EUR → 55 USD

---

## 📬 Contacto
Para cualquier duda o sugerencia, puedes contactarme a través de:

Email: eyesid30@gmail.com
LinkedIn: [linkedin.com/in/tu_usuario](https://www.linkedin.com/in/edwin-cristancho-scrum/)

---


