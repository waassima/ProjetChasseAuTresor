package chasseautresor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe de tests unitaires pour la classe ChasseAuTresor.
 */
public class ChasseAuTresorTests {

    /**
     * Teste la création d'une carte.
     */
    @Test
    public void testCreationCarte() {
        // Crée une carte de taille 5x5
        Carte carte = new Carte(5, 5);
        // Vérifie que la largeur de la carte est correcte
        assertEquals(5, carte.getLargeur());
        // Vérifie que la hauteur de la carte est correcte
        assertEquals(5, carte.getHauteur());
    }

    /**
     * Teste l'ajout d'une montagne à la carte.
     */
    @Test
    public void testAjouterMontagne() {
        // Crée une carte de taille 5x5
        Carte carte = new Carte(5, 5);
        // Ajoute une montagne à la position (2, 3)
        carte.ajouterMontagne(2, 3);
        // Vérifie que la montagne a été ajoutée avec succès
        assertEquals(1, carte.getMontagnes().size());
    }

    /**
     * Teste l'ajout d'un trésor à la carte.
     */
    @Test
    public void testAjouterTresor() {
        // Crée une carte de taille 5x5
        Carte carte = new Carte(5, 5);
        // Ajoute un trésor à la position (1, 2) avec 3 trésors
        carte.ajouterTresor(1, 2, 3);
        // Vérifie que le trésor a été ajouté avec succès
        assertEquals(1, carte.getTresors().size());
    }

    /**
     * Teste la création d'une coordonnée.
     */
    @Test
    public void testCreationCoordonnee() {
        // Crée une coordonnée avec x=3 et y=4
        Coordonnee coordonnee = new Coordonnee(3, 4);
        // Vérifie que les coordonnées sont correctes
        assertEquals(3, coordonnee.getX());
        assertEquals(4, coordonnee.getY());
    }

    /**
     * Teste la création d'un trésor.
     */
    @Test
    public void testCreationTresor() {
        // Crée un trésor à la position (1, 2) avec 3 trésors
        Tresor tresor = new Tresor(1, 2, 3);
        // Vérifie que les informations sur le trésor sont correctes
        assertEquals(1, tresor.getX());
        assertEquals(2, tresor.getY());
        assertEquals(3, tresor.getNombre());
    }

    /**
     * Teste la création d'un aventurier.
     */
    @Test
    public void testCreationAventurier() {
        // Crée une position pour l'aventurier
        Coordonnee position = new Coordonnee(1, 1);
        // Crée un aventurier nommé Lara à la position (1, 1), orienté vers le sud avec la séquence de mouvement "AADADAGGA"
        Aventurier aventurier = new Aventurier("Lara", position, Orientation.S, "AADADAGGA");
        // Vérifie que les informations sur l'aventurier sont correctes
        assertEquals("Lara", aventurier.getNom());
        assertEquals(position, aventurier.getPosition());
        assertEquals(Orientation.S, aventurier.getOrientation());
        assertEquals("AADADAGGA", aventurier.getSequenceDeMouvement());
        assertEquals(0, aventurier.getTresorsCollectes());
    }

    /**
     * Teste le deplacement en avant d'un Aventurier.
     */
    @Test
    public void testDeplacerAventurierEnAvant() {
        // Création d'une carte avec des montagnes et des trésors
        Carte carte = new Carte(5, 5);
        carte.ajouterMontagne(2, 3);
        carte.ajouterTresor(1, 1, 1);

        // Déplacement de l'aventurier en avant
        Coordonnee position = new Coordonnee(1, 1);
        Aventurier aventurier = new Aventurier("Lara", position, Orientation.E, "A");
        ChasseAuTresor.deplacerAventurierEnAvant(carte, aventurier);

        // Vérification de la nouvelle position de l'aventurier
        Coordonnee nouvellePosition = aventurier.getPosition();
        assertEquals(2, nouvellePosition.getX());
        assertEquals(1, nouvellePosition.getY());
    }

    /**
     * Teste le deplacement à gauche d'un Aventurier.
     */
    @Test
    public void testTournerAventurierAGauche() {
        // Création d'un aventurier avec une orientation initiale vers le nord
        Aventurier aventurier = new Aventurier("Indiana", new Coordonnee(2, 2), Orientation.N, "G");
        ChasseAuTresor.tournerAventurierAGauche(aventurier);
        // Vérification de la nouvelle orientation de l'aventurier
        assertEquals(Orientation.O, aventurier.getOrientation());
    }

    /**
     * Teste le deplacement à droite d'un Aventurier.
     */
    @Test
    public void testTournerAventurierADroite() {
        // Création d'un aventurier avec une orientation initiale vers le nord
        Aventurier aventurier = new Aventurier("Lara", new Coordonnee(2, 2), Orientation.N, "D");
        ChasseAuTresor.tournerAventurierADroite(aventurier);
        // Vérification de la nouvelle orientation de l'aventurier
        assertEquals(Orientation.E, aventurier.getOrientation());
    }
    
    /**
     * Teste la nouvelle position vers le nord d'un Aventurier.
     */
    @Test
    public void testCalculerNouvellePositionVersNord() {
        Coordonnee positionActuelle = new Coordonnee(2, 2);
        // Calcul de la nouvelle position vers le nord à partir d'une position actuelle
        Coordonnee nouvellePosition = ChasseAuTresor.calculerNouvellePosition(positionActuelle, Orientation.N);
        // Vérification des coordonnées de la nouvelle position
        assertEquals(2, nouvellePosition.getX());
        assertEquals(1, nouvellePosition.getY());
    }

    /**
     * Teste la nouvelle position vers l'est d'un Aventurier.
     */
    @Test
    public void testCalculerNouvellePositionVersEst() {
        Coordonnee positionActuelle = new Coordonnee(2, 2);
        // Calcul de la nouvelle position vers l'est à partir d'une position actuelle
        Coordonnee nouvellePosition = ChasseAuTresor.calculerNouvellePosition(positionActuelle, Orientation.E);
        // Vérification des coordonnées de la nouvelle position
        assertEquals(3, nouvellePosition.getX());
        assertEquals(2, nouvellePosition.getY());
    }

    /**
     * Teste la nouvelle position vers le sud d'un Aventurier.
     */
    @Test
    public void testCalculerNouvellePositionVersSud() {
        Coordonnee positionActuelle = new Coordonnee(2, 2);
        // Calcul de la nouvelle position vers le sud à partir d'une position actuelle
        Coordonnee nouvellePosition = ChasseAuTresor.calculerNouvellePosition(positionActuelle, Orientation.S);
        // Vérification des coordonnées de la nouvelle position
        assertEquals(2, nouvellePosition.getX());
        assertEquals(3, nouvellePosition.getY());
    }

    /**
     * Teste la nouvelle position vers l'ouest d'un Aventurier.
     */
    @Test
    public void testCalculerNouvellePositionVersOuest() {
        Coordonnee positionActuelle = new Coordonnee(2, 2);
        // Calcul de la nouvelle position vers l'ouest à partir d'une position actuelle
        Coordonnee nouvellePosition = ChasseAuTresor.calculerNouvellePosition(positionActuelle, Orientation.O);
        // Vérification des coordonnées de la nouvelle position
        assertEquals(1, nouvellePosition.getX());
        assertEquals(2, nouvellePosition.getY());
    }

}



