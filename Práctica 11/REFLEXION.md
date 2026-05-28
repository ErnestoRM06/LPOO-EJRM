1. ¿Qué es el hilo de la UI (JavaFX Application Thread) y por qué no debes hacer operaciones pesadas en él?

Este hilo es en el que se ejecutan todas las operaciones de UI. No se deben ejecutar tareas pesadas en el porque esto podría causar el congelamiento de la interfaz.

2. ¿Qué es un =EventHandler=? ¿Cómo conecta la acción del usuario con la lógica de tu programa?

Este es un objeto que define qué acción ejecutar cuando ocurre un evento en la interfaz gráfica. Este objeto conecta la acción del usuario al programa ya que tiene especificado el tipo de evento que recibirá, además del código que se ejecutará cuando lo reciba.

3. ¿Qué diferencia hay entre un =Stage=, una =Scene= y un =Node= en JavaFX?

Stage es la ventana, el contenedor de más alto nivel. Scene es un contenedor de los elementos visuales que tienes y que vas a mostrar en la ventana, el cual es contenido por el Stage. Node se utiliza para los elemento individuales contenidos en la Scene.
