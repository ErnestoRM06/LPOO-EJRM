1. ¿Por qué usaste cada estructura de colección para cada tipo de dato? ¿Qué pasaría si usaras =ArrayList= para todo?

Use ArrayList en productos en productos porque se pueden repetir y porque es el atributo más importante de la clase. LinkedList en filaClientes porque es una fila en donde importa el orden. HashMap en empleados porque solo ocupo relacionar su nombre y su clave, y un empleado tiene solo una clave relacionada. HashSet en marcas porque no se pueden repetir y además no importa el orden en el que se guarden.
Se puede usar ArrayList para todo, pero se tendrían que cambiar muchas cosas en las clases usadas para que el resultado quede igual, por lo que usar la Colección indicada ahorra trabajo.

2. ¿Qué diferencia hay entre =Comparable= y =Comparator=? ¿Cuándo usarías cada uno?

Comparable solo puede comparar de acuerdo a una unica forma, mientras que Comparator permite comparar de acuerdo a varias formas que tu elijas. Es mejor usar Comparable si la clase tiene una unica forma de ordenar, y Comparator si se tienen varios criterios de ordenación.

3. Explica con tus palabras qué hace una operación Stream. ¿Por qué es más legible que un bucle =for=?

Un Stream recorre un arreglo de objetos, permitiendo hacer operaciones y alterar que objetos recibirán las operaciones o de que forma. Es más legible que un bucle for porque usa métodos prehechos que ayudan a no tener que hacerlos tu, que además se nota muy bien que hace cada uno.
