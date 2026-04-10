1. ¿Cuál es la diferencia entre una clase y un objeto? Da un ejemplo con tu propio código.
La clase es la plantilla para crear un objeto, es su tipo de dato, mientras el objeto es una variable creada en base a la clase. 
Por ejemplo, tenemos a la clase "Cartas", a la cual no podemos asignarle valores porque no es una variable, pero si podemos crear una variable usándola de plantilla; pero también tenemos el objeto "Soldado", de la clase "Cartas", al cual se le pueden asignar valores a sus parámetros y tiene dirección de memoria, ya que es una variable.

2. ¿Por qué usaste 3 constructores distintos? ¿Qué problema resuelve cada uno?
Cada constructor sirve para crear un distinto tipo de carta: 
El que pide toda la información sirve para crear tropas; el que pide daño pero no vida sirve para crear hechizos; y el que no pide vida ni daño sirve para crear cartas de utilidad.

3. ¿Qué pasaría si no tuvieras constructores definidos? ¿Java sigue funcionando? ¿Por qué?
Se crearía el objeto sin ningún valor en sus parámetros, ya que Java lo trataría como un constructor vacío.
