1. ¿Qué es una race condition? Describe un escenario concreto de tu código donde podría ocurrir.

Una race condition es cuando dos o más hilos acceden y modifican el mismo dato, haciendo que haya posibles errores y sea impredecible el resultado. En mi código podría ocurrir cuando se pasan clientes a las cajas, que se pase más de una vez; o cuando se les cobra, que se le agregue al monto total más de una vez.

2. ¿Por qué =synchronized= resuelve el problema? ¿Qué desventaja de rendimiento tiene?

synchronized lo que hace es que restringe el acceso a los recursos del bloque a solo un hilo, lo cual estabiliza que no haya race condition, pero también podría bajar el rendimiento al reducir el paralelismo y al poder producir bloqueos.

3. ¿Qué diferencia hay entre =Thread.sleep()= y =Object.wait()=? ¿Cuándo usarías cada uno?

Thread.sleep() espera el tiempo que le des (en milisegundos); mientras que Object.wait() se espera a que se sincronicen los hilos, esto pasa cuando el hilo desocupa el monitor, que es el permiso de usar los recursos en el bloque, y lo adquiere otro hilo.
