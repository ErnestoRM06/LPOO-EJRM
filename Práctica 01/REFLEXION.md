1. ¿Qué diferencia hay entre JDK, JRE y JVM? ¿Por qué instalamos el JDK?
JDK es el kit de desarrollo de Java, cuenta con las herramientas para crear, compilar y ejecutar las aplicaciones. Mientras que JRE es el entorno de ejecución, por lo que solo permite ejecutar las aplicaciones. Por último, el JVM se encarga de convertir y ejecutar las instrucciones de Java en lenguaje ensamblador.
Nosotros instalamos el JDK porque nos interesa crear los programas, y es el único entre los 3 que nos lo permite.

2. ¿Por qué Java es considerado «write once, run anywhere»? Explica con tus propias palabras.
Es por el JVM, el cual compila el código a lenguaje ensamblador y lo interpreta, lo que garantiza que los ordenadores puedan entenderlo y permite que el programa se pueda ejecutar en múltiples plataformas.

3. ¿Qué hace exactamente =System.out.println()=? ¿Qué clase y método estás usando?
Imprime el valor que le pases y luego mueve el cursor a la siguiente línea, no sin antes resolver lo que escribas dentro del paréntesis, ya se una operación aritmética, una concatenación de Strings, o una llamada a función.
Se usa la clase "System", la cual tiene una variable de instancia "out" de la clase "PrintStream"; y la clase "PrintStream" tiene métodos sobrecargados "println" para cada tipo de dato básico, String y objetos.
