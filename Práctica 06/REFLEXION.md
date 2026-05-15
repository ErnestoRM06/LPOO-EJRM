1. ¿Cuándo preferirías una clase abstracta sobre una interfaz? ¿Y al revés?

Es preferible usar las clases abstractas cuando se tienen métodos concretos y atributos que varían (cosas más específicas). Mientras que es mejor usar interfaces cuando se tienen atributos que no cambian y constructores de clases (para cosas más generales).

2. ¿Una clase puede implementar varias interfaces? ¿Por qué Java permite eso pero no herencia múltiple de clases?

Las clases pueden heredar de varias interfaces, esto se debe a que las interfaces no tienen información instanciada, por lo que no va a haber conflictos por ver cual se implementa , mientras que las clases tienen atributos y métodos instanciados, por lo que una clase podría heredar varios métodos con la misma cabeza y no sabra cual aplicar.

3. Si agregas un método nuevo a una de tus interfaces, ¿Qué clases se ven afectadas? ¿Cómo lo resolverías con un método =default=?

Si se agrega un método nuevo a las interfaces se verían afectadas las clases que la heredan, pero el método =default= permite que el método tenga un comportamiento default y que pueda ser sobrescrito o no sin problemas.
