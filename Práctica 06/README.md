Las clases usadas fueron:

- Practica06: contiene el método main y las pruebas hechas.

- Carta: es la clase abstracta, tiene los atributos de nombre y descripción, así como métodos relacionados a estos y el método de colocar.

- Destruible: es una interfase para las cartas con vida, tiene el método de recibir daño

- Movil: es una interfase para las cartas que se pueden mover, tiene el método de moverse

- Atacante: es una interfase para las cartas que atacan, tiene el método de hacer daño

- Vehiculo: es una clase que hereda de la clase abstracta y de las interfases Destruible y Movil, esto porque tiene vida y se puede mover

- Tropa: es una clase que hereda de la clase abstracta y de las interfases Destruible, Atacante y Movil, esto porque tiene vida, se puede mover y puede atacar a otras cartas

- EdificioDefensivo: es una clase que hereda de la clase abstracta y de las interfases Destruible y Atacante, esto porque tiene vida y puede atacar a otras cartas
