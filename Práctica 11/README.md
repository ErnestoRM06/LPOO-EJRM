Las clases usadas fueron:

- Practica11: contiene el método main y el método start que abre el menú principal.

- FXMLVistaController: es la clase que controla al menú principal, tiene el método para llamar a la pantalla de la tabla.

- FXMLTablaController: es la clase que controla la pantalla con la tabla de registros, tiene todos los métodos que ocupa esta pantalla, ya sean los de los botones, los TextFields o la tabla.

- CRUDCliente: es la clase con los formularios CRUD necesarios para manejar los registros de la tabla.

- TextFieldFloat: es una clase que extiende a TextField, solo acepta números.

- BotonAzul: es una clase que extiende a Button, hace que los botones sean azules.

- Nexo: es una clase auxiliar que guarda los objetos de las Stages usadas.

Además, cuenta con los archivos:

- FXMLVista.fxml: es el archivo fxml del menú principal.

- FXMLTabla.fxml: es el archivo fxml de la pantalla de la tabla.

- fxml.css: es el archivo css que utilizan los arcivos fxml para dr estilo a los objetos de la interfaz gráfica.

En la tabla usé como método de filtrado la fecha del registro, para esto primero use una FilteredList, al cual le creamos un "observador", el cual se ejecuta cada vez que el texto cambia. Después, se le agrega el filtro al FilteredList, el cual: si no se escribe nada, uestra todos los registros; si se escribe algo, se compara con todos los registros y se ocultan los que no tengan una parte igual a la escrita.
Después se crea una SorteredList en base a la FilteredList, y se agrega esta SorteredList a la tabla.
