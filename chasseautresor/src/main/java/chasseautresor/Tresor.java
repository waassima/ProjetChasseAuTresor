package chasseautresor;
public class Tresor {
    // Attributs de la classe Tresor
    private int x; // Coordonnée en abscisse du trésor
    private int y; // Coordonnée en ordonnée du trésor
    private int nombre; // Nombre de trésors présents sur cette case

    // Constructeur de la classe Tresor
    public Tresor(int x, int y, int nombre) {
        this.x = x; // Initialisation de la coordonnée en abscisse du trésor
        this.y = y; // Initialisation de la coordonnée en ordonnée du trésor
        this.nombre = nombre; // Initialisation du nombre de trésors sur cette case
    }

    // Méthode pour récupérer la coordonnée en abscisse du trésor
    public int getX() {
        return x;
    }

    // Méthode pour récupérer la coordonnée en ordonnée du trésor
    public int getY() {
        return y;
    }

    // Méthode pour récupérer le nombre de trésors présents sur cette case
    public int getNombre() {
        return nombre;
    }
    
    // Méthode pour définir le nombre de trésors présents sur cette case
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}