package chasseautresor;

public class Coordonnee {

    // Attributs de la classe Coordonnee
    private int x; // Coordonnée en abscisse
    private int y; // Coordonnée en ordonnée

    // Constructeur de la classe Coordonnee
    public Coordonnee(int x, int y) {
        this.x = x; // Initialisation de la coordonnée en abscisse
        this.y = y; // Initialisation de la coordonnée en ordonnée
    }

    // Méthode pour récupérer la coordonnée en abscisse
    public int getX() {
        return x;
    }

    // Méthode pour récupérer la coordonnée en ordonnée
    public int getY() {
        return y;
    }
}
