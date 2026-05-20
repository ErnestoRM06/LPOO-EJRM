Se usaron las siguientes estrategias:

- Se transformaron los objetos a paralelizar a Thread y se le dio .start, el cual aplica el método run en los diferentess hilos.

- Se uso el método run, el cual viene de la clase Thread o de la interfase Runnable, el cual se usa con los hilos.

- Se uso la palabra synchronized, junto a los métodos wait y notifyAll, los cuales sirven para mantener orden en los hilos

- Se uso el método .join en los objetos transformados a Thread para saber cuando acaban los procesos paralelizados y poder hacer una operación al final de estos.
