1. ¿Por qué marcamos atributos como =private=? ¿Qué riesgo evitamos?
Sirve para 3 propósitos:
Controlar los datos válidos que pueden tomar los atributos en los setters, como hicimos en el código.
Facilitar el entendimiento y el mantenimiento del código.
Evitar riesgos, como que otras clases cambien los valores sin control.

2. ¿Cuál es la diferencia entre =private=, =protected= y =public=? Ilustra con un ejemplo de tu código.
private hace que los parámetros/métodos solo puedan ser accedidos por dentro de la clase. Por ejemplo, en el código los atributos de "Alumno" solo pueden ser accedidos por medio de sus getters y sus setters.
protected hace que los parámetros/métodos solo puedan ser accedidos por un método dentro de la misma carpeta o por una subclase. Por ejemplo, en el código los atributos de "Profesor" no pueden ser accedidos por la clase "auxiliar", ya que se encuentra en otra carpeta.
public deja que cualquier método pueda acceder al parámetro/método. Por ejemplo, en el código la variable auxiliar puede acceder al getter del nombre de "Profesor", ya que es public.

3. ¿Qué validación incluiste en un setter? ¿Qué pasa si el valor recibido es inválido?
Incluí en la calificación que sea mayor o igual a 0 y menor o igual a 100. Si no se cumple la condición, el método muestra un mensaje de error y no guarda la información.
