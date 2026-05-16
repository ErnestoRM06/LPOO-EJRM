1. ¿Qué es la serialización y cuándo es útil en comparación con guardar texto plano?

Serialización es cuando guardas un objeto tal cual esta

2. ¿Por qué usamos =BufferedReader= en lugar de leer byte a byte? ¿Qué mejora en rendimiento ofrece?

Es más eficiente, ya que lee trozos de texto por trozos, en vez de bit por bit, es más rápido y mejora el rendimiento del programa

3. ¿Qué riesgos tiene no cerrar un archivo después de usarlo? ¿Cómo los mitigaste?

El archivo consume recursos, se puede perder información de él, así como queda bloqueado al proceso que lo usa. Lo mitigue usando el =try with resources= para que el archivo se cierre después de usarlo.
