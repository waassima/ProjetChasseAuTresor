package chasseautresor;
public class Aventurier {

    // Déclaration des attributs de la classe Aventurier
    private String nom; // Nom de l'aventurier
    private Coordonnee position; // Position de l'aventurier sur la grille
    private Orientation orientation; // Orientation de l'aventurier (Nord, Est, Sud, Ouest)
    private String sequenceDeMouvement; // Séquence de mouvement de l'aventurier
    private int tresorsCollectes; // Nombre de trésors collectés par l'aventurier
    
    // Constructeur de la classe Aventurier
    public Aventurier(String nom, Coordonnee position, Orientation orientation, String sequenceDeMouvement) {
        this.nom = nom; // Initialisation du nom de l'aventurier
        this.position = position; // Initialisation de la position de l'aventurier
        this.orientation = orientation; // Initialisation de l'orientation de l'aventurier
        this.sequenceDeMouvement = sequenceDeMouvement; // Initialisation de la séquence de mouvement de l'aventurier
        this.tresorsCollectes = 0; // Initialisation du nombre de trésors collectés à zéro
    }
    
    // Méthode permettant de récupérer le nom de l'aventurier
    public String getNom(){
    	return this.nom;
    }
    
    // Méthode permettant de modifier le nom de l'aventurier
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode permettant de récupérer la position de l'aventurier
    public Coordonnee getPosition() {
        return position;
    }

    // Méthode permettant de modifier la position de l'aventurier
    public void setPosition(Coordonnee position) {
        this.position = position;
    }

    // Méthode permettant de récupérer l'orientation de l'aventurier
    public Orientation getOrientation() {
        return orientation;
    }

    // Méthode permettant de modifier l'orientation de l'aventurier
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    // Méthode permettant de récupérer la séquence de mouvement de l'aventurier
    public String getSequenceDeMouvement() {
        return sequenceDeMouvement;
    }

    // Méthode permettant de modifier la séquence de mouvement de l'aventurier
    public void setSequenceDeMouvement(String sequenceDeMouvement) {
        this.sequenceDeMouvement = sequenceDeMouvement;
    }
    
    // Méthode permettant de récupérer le nombre de trésors collectés par l'aventurier
    public int getTresorsCollectes() {
        return tresorsCollectes;
    }

    // Méthode permettant d'incrémenter le nombre de trésors collectés par l'aventurier
    public void incrementerTresorsCollectes() {
        tresorsCollectes++;
    }
    
    // Méthode permettant de définir le nombre de trésors collectés par l'aventurier
    public void setTresorsCollectes(int tresor) {
    	this.tresorsCollectes= tresor;
    }
    
}