package practica02;

public class Cartas {

    String nombre;
    String tipo;
    String descripcion;
    float coste;
    int daño;
    int vida;
    int nivel;
    int dañoBase;
    int vidaBase;

    public Cartas(String nombre, String descripcion, float coste, int daño, int vida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vida = vida;
        this.daño = daño;
        this.coste = coste;

        nivel = 1;
        dañoBase = daño;
        vidaBase = vida;

        tipo = "Tropa";
    }

    public Cartas(String nombre, String descripcion, float coste, int daño) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.daño = daño;
        this.coste = coste;

        nivel = 1;
        dañoBase = daño;

        tipo = "Hechizo";
    }

    public Cartas(String nombre, String descripcion, float coste) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste = coste;

        tipo = "Utilidad";
    }

    void subirNivel() {
        if (nivel < 10) {
            if (tipo.equals("Tropa")) {
                daño += dañoBase * 0.1;
                vida += vidaBase * 0.1;
                nivel++;
            } else {
                if (tipo.equals("Hechizo")) {
                    daño += dañoBase * 0.1;
                    nivel++;
                } else {
                    System.out.println("ERROR: No se puede subir de nivel una carta de utilidad.");
                }
            }
        } else {
            System.out.println("ERROR: Carta al nivel máximo.");
        }
    }

    void cambiarCoste(float nuevoCoste) {
        coste = nuevoCoste;
    }

    void cambiarVidaBase(int nuevaVida) {
        float aux;
        if (tipo.equals("Tropa")) {
            vidaBase = nuevaVida;
            aux = (float) (vidaBase * (1 + ( (float) nivel - 1) / 10));
            vida = (int) aux;
        } else {
            System.out.println("ERROR: Solo se le puede asignar vida a las tropas.");
        }
    }

    void cambiarDañoBase(int nuevoDaño) {
        float aux;
        if (!tipo.equals("Utilidad")) {
            dañoBase = nuevoDaño;
            aux = (float) (dañoBase * (1 + ( (float) nivel - 1) / 10));
            daño = (int) aux;
        } else {
            System.out.println("ERROR: No se le puede asignar daño a cartas de utilidad.");
        }
    }

    float reiniciarNivel() {
        float compensación = 0;
        if (nivel > 1) {
            if (tipo.equals("Tropa")) {
                daño = dañoBase;
                vida = vidaBase;
                nivel = 1;

                compensación = (float) coste * (nivel - 1) / 2;
            } else {
                if (tipo.equals("Hechizo")) {
                    daño = dañoBase;
                    nivel = 1;
                } else {
                    System.out.println("ERROR: No se puede cambiar el nivel de una carta de utilidad.");
                }
            }
        } else {
            System.out.println("ERROR: Carta al nivel 1.");
        }
        return compensación;
    }

    void mostrarInformación() {
        System.out.println("- " + nombre + " (" + tipo + "): " + descripcion);
        if (tipo.equals("Tropa")) {
            System.out.println("  Vida: " + vida + ". Daño: " + daño + ". Nivel: " + nivel + ". Coste para subir de nivel: " + coste);
        } else {
            if (tipo.equals("Hechizo")) {
                System.out.println("  Daño: " + daño + ". Nivel: " + nivel + ". Coste en juego/ para subir de nivel: " + coste);
            } else {
                System.out.println("  Coste en juego: " + coste);
            }
        }
    }
}
