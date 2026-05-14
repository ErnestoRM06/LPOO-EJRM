1. ¿Qué ventaja concreta te dio la herencia en este ejercicio? ¿Qué código evitaste repetir?

La herencia nos permite tener la información básica de los usuarios sin tener que hacerla en todas las clases.

2. ¿Cuándo es apropiado usar =super()= y cuándo no es necesario?

Super solo se usa en el constructor para los atributos de la clase padre, no se usa en otros métodos.

3. ¿Qué pasa si una clase hija no sobrescribe un método de la clase padre? ¿Cuál versión se ejecuta?

Si no se sobrescribe el método, entonces la clase hija tendrá el método de la clase padre. Por lo que al ejecutar el método en la clase hija este ejecuta el método de la clase padre tal cual esta.
