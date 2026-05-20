Las clases usadas fueron:

- Practica10: contiene el método main y las pruebas realizadas.

- BufferCajas: es la clase que gestiona las operaciones que realizaran los hilos, representa las cajas de supermercado abiertas, en las que pueden pasar clientes y cobrarles, ya que tiene una fila en ella que los representa.

- FilaClientes: es una clase en la cual se tiene una fila de clientes para pasar a un método de BufferCajas, el cual los agrega a la fila de esa clase. Esta clase implementa Runnable.

- Caja: es una clase en la cual se cobra a los clientes en BufferCajas, vaciando su fila. Además de que guarda los registros de los clientes cobrados.

- Registro: es la clase que crea los logs.

- Cliente: es una clase auxiliar que usan las demás clases, la cual cuenta con un nombre y un grupo de productos, además del método para calcular el total que debe pagar.

- Producto: es una clase auxiliar que usa la clase Cliente, tiene el nombre y el precio del producto como parámetros.

En esta práctica usé una fila de clientes y un grupo de cajas para procesarlos, esto lo hice con concurrencia porque las cajas no procesan a los clientes en orden, sino que según se vayan desocupando pasan a otro cliente. La sincronización ayuda a que no se agregue o procese el mismo cliente en diferentes hilos.
