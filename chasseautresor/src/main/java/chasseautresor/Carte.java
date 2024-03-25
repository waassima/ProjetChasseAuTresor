package chasseautresor;
import java.util.List;
import java.util.ArrayList;

public class Carte {

    // Déclaration des attributs de la classe Carte
    private int largeur; // Largeur de la carte
    private int hauteur; // Hauteur de la carte
    private List<Coordonnee> montagnes; // Liste des coordonnées des montagnes présentes sur la carte
    private List<Tresor> tresors; // Liste des trésors présents sur la carte

    // Constructeur de la classe Carte
    public Carte(int largeur, int hauteur) {
        this.largeur = largeur; // Initialisation de la largeur de la carte
        this.hauteur = hauteur; // Initialisation de la hauteur de la carte
        this.montagnes = new ArrayList<>(); // Initialisation de la liste des montagnes
        this.tresors = new ArrayList<>(); // Initialisation de la liste des trésors
    }

    // Méthode permettant de récupérer la largeur de la carte
    public int getLargeur() {
        return largeur;
    }

    // Méthode permettant de récupérer la hauteur de la carte
    public int getHauteur() {
        return hauteur;
    }

    // Méthode permettant de récupérer la liste des coordonnées des montagnes
    public List<Coordonnee> getMontagnes() {
        return montagnes;
    }

    // Méthode permettant de récupérer la liste des trésors
    public List<Tresor> getTresors() {
        return tresors;
    }

    // Méthode permettant d'ajouter une montagne à la carte avec les coordonnées spécifiées
    public void ajouterMontagne(int x, int y) {
        montagnes.add(new Coordonnee(x, y));
    }

    // Méthode permettant d'ajouter un trésor à la carte avec les coordonnées et le nombre spécifiés
    public void ajouterTresor(int x, int y, int nombre) {
        tresors.add(new Tresor(x, y, nombre));
    }
}