Las clases usadas fueron:

- Practica07: contiene el método main y las pruebas hechas.

- ExceptionBase: es la clase padre de los errores, la cual solo maneja el mensaje de error.

- ClaveIncorrectaException: es una clase de error que hereda de ExceptionBase, maneja el error de cuando se da un clave no registrada en la tienda y agrega al mensaje de error información relacionada.

- ProductoNoEncontradoException: es una clase de error que hereda de ExceptionBase, maneja el error de cuando se da un producto no registrado en la tienda y agrega al mensaje de error información relacionada.

- SaldoInsuficienteException: es una clase de error que hereda de ExceptionBase, maneja el error de cuando no se tiene el suficiente saldo en la tarjeta para pagar un producto y agrega al mensaje de error información relacionada.

- Tienda: es una clase que gestiona los objetos, tiene métodos para registrar tarjetas y productos, un método para comprar productos y métodos auxiliares de este, además de un método para crear el archivo log.

- Producto: es una clase que ayuda a crear y manejar los productos de la tienda.

- Tarjeta: es una clase que ayuda a crear y manejar las tarjetas de la tienda.

Las clases de Exception dan información de que es lo que esta mal, y en la clase de Tienda se da más información sobre cual es el objeto en concreto que provoca el error. Esto sería muy util para proyectos grandes ya que dice completamente en que esta el error.
