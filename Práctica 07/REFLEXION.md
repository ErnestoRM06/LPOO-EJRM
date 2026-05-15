1. ¿Cuál es la diferencia entre una excepción chequeada (checked) y una no chequeada (unchecked)?

Las excepciones chequeadas son producidas por la conexión con un recurso externo, como al crear un archivo, además de que es obligatorio manejarlos con try/catch o throw. Mientras que las excepciones no chequeadas son las que se dan por errores en la programación y no es obligatorio manejarlos.

2. ¿Por qué creaste una jerarquía de excepciones en lugar de usar =Exception= directamente?

Para poder personalizar que genera error y poder explicarlo mejor al lanzar el error.

3. ¿Qué ventaja tiene =try-with-resources= sobre un bloque =finally= tradicional?

Tiene como ventaja el que cierra el recurso que se este usando al final, por ejemplo, si usas un archivo, se cerrara al final aunque haya error.
