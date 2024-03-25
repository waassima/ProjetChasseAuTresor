package chasseautresor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;


public class ChasseAuTresor {

    // Méthode pour déplacer l'aventurier en avant
    public static void deplacerAventurierEnAvant(Carte carte, Aventurier aventurier) {
        Coordonnee nouvellePosition = calculerNouvellePosition(aventurier.getPosition(), aventurier.getOrientation());

        if (estPositionValide(carte, nouvellePosition)) {
            aventurier.setPosition(nouvellePosition);

            // Vérifier si la case contient des trésors
            for (Tresor tresor : carte.getTresors()) {
                if (tresor.getX() == nouvellePosition.getX() && tresor.getY() == nouvellePosition.getY()) {
                    // Collecter le trésor
                    collecterTresor(carte, aventurier, tresor);	
                }
            }
        }
    }

    // Méthode pour tourner l'aventurier à gauche
    public static void tournerAventurierAGauche(Aventurier aventurier) {
        Orientation orientationActuelle = aventurier.getOrientation();
        Orientation nouvelleOrientation;

        switch (orientationActuelle) {
            case N:
                nouvelleOrientation = Orientation.O;
                break;
            case E:
                nouvelleOrientation = Orientation.N;
                break;
            case S:
                nouvelleOrientation = Orientation.E;
                break;
            case O:
                nouvelleOrientation = Orientation.S;
                break;
            default:
                nouvelleOrientation = orientationActuelle;
                break;
        }

        aventurier.setOrientation(nouvelleOrientation);
    }

    // Méthode pour tourner l'aventurier à droite
    public static void tournerAventurierADroite(Aventurier aventurier) {
        Orientation orientationActuelle = aventurier.getOrientation();
        Orientation nouvelleOrientation;

        switch (orientationActuelle) {
            case N:
                nouvelleOrientation = Orientation.E;
                break;
            case E:
                nouvelleOrientation = Orientation.S;
                break;
            case S:
                nouvelleOrientation = Orientation.O;
                break;
            case O:
                nouvelleOrientation = Orientation.N;
                break;
            default:
                nouvelleOrientation = orientationActuelle;
                break;
        }

        aventurier.setOrientation(nouvelleOrientation);
    }

    // Méthode pour calculer la nouvelle position en fonction de l'orientation
    public static Coordonnee calculerNouvellePosition(Coordonnee positionActuelle, Orientation orientation) {
        int x = positionActuelle.getX();
        int y = positionActuelle.getY();

        switch (orientation) {
            case N:
                y--;
                break;
            case E:
                x++;
                break;
            case S:
                y++;
                break;
            case O:
                x--;
                break;
            default:
                // Ne devrait pas arriver
                break;
        }

        return new Coordonnee(x, y);
    }

    // Méthode pour vérifier si la position est valide sur la carte
    public static boolean estPositionValide(Carte carte, Coordonnee position) {
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();

        int x = position.getX();
        int y = position.getY();

        return x >= 0 && x < largeur && y >= 0 && y < hauteur && !estMontagne(carte, position);
    }

    // Méthode pour vérifier si la position contient une montagne
    public static boolean estMontagne(Carte carte, Coordonnee position) {
        for (Coordonnee montagne : carte.getMontagnes()) {
            if (montagne.getX() == position.getX() && montagne.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }	
	
    // Méthode pour collecter le trésor
    public static void collecterTresor(Carte carte, Aventurier aventurier, Tresor tresor) {
        int nombreDeTresors = tresor.getNombre();
        if (nombreDeTresors > 0) {
            // Augmenter le nombre de trésors collectés par l'aventurier
            aventurier.incrementerTresorsCollectes();
            // Réduire le nombre de trésors restants sur la case
            tresor.setNombre(nombreDeTresors - 1);
        }
    }
    
    public static void main(String[] args) {
        Carte carte = null;
        Aventurier aventurier = null;
        Path repertoireCourant = Paths.get("").toAbsolutePath();
       // String filePath = "C:\\Users\\Wassima\\eclipse-workspace\\Chasse_au_tresor\\src\\Input.txt";
        // Lecture du fichier d'entrée
        
        // Demander à l'utilisateur de saisir le chemin du fichier input.txt
        System.out.println("Veuillez saisir le chemin du fichier input.txt :");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = "";
        try {
            filePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                if (line.startsWith("C")) {
                    String[] elements = line.split(" - ");
                    int largeur = Integer.parseInt(elements[1]);
                    int hauteur = Integer.parseInt(elements[2]);
                    carte = new Carte(largeur, hauteur);
                } else if (line.startsWith("M")) {
                    String[] elements = line.split(" - ");
                    int x = Integer.parseInt(elements[1]);
                    int y = Integer.parseInt(elements[2]);
                    carte.ajouterMontagne(x, y);
                } else if (line.startsWith("T")) {
                    String[] elements = line.split(" - ");
                    int x = Integer.parseInt(elements[1]);
                    int y = Integer.parseInt(elements[2]);
                    int nombre = Integer.parseInt(elements[3]);
                    carte.ajouterTresor(x, y, nombre);
                } else if (line.startsWith("A")) {
                    String[] elements = line.split(" - ");
                    String nom = elements[1];
                    int x = Integer.parseInt(elements[2]);
                    int y = Integer.parseInt(elements[3]);
                    Coordonnee position = new Coordonnee(x, y);
                    Orientation orientation = Orientation.valueOf(elements[4]);
                    String sequenceDeMouvement = elements[5];
                    aventurier = new Aventurier(nom, position, orientation, sequenceDeMouvement);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Simulation des mouvements des aventuriers
        if (carte != null && aventurier != null) {
            for (char mouvement : aventurier.getSequenceDeMouvement().toCharArray()) {
                switch (mouvement) {
                    case 'A':
                        deplacerAventurierEnAvant(carte, aventurier);
                        break;
                    case 'G':
                        tournerAventurierAGauche(aventurier);
                        break;
                    case 'D':
                        tournerAventurierADroite(aventurier);
                        break;
                    default:
                        // Mouvement invalide, ignorer
                        break;
                }
            }
            // Enregistrez le résultat dans un fichier de sortie
            try (FileWriter writer = new FileWriter("output.txt")) {
                // Écrivez le résultat dans le fichier de sortie
                writer.write("C - " + carte.getLargeur() + " - " + carte.getHauteur() + "\n");

                // Écrire les montagnes dans le fichier de sortie
                for (Coordonnee montagne : carte.getMontagnes()) {
                    writer.write("M - " + montagne.getX() + " - " + montagne.getY() + "\n");
                }

                // Écrire les trésors dans le fichier de sortie
                for (Tresor tresor : carte.getTresors()) {
                    if (tresor.getNombre() != 0 ) {
                        writer.write("T - " + tresor.getX() + " - " + tresor.getY() + " - " + tresor.getNombre() + "\n");
                    }
                }

                // Écrire les aventuriers dans le fichier de sortie
                writer.write("A - " + aventurier.getNom() + " - " + aventurier.getPosition().getX() + " - " +
                        aventurier.getPosition().getY() + " - " + aventurier.getOrientation() + " - " +
                        aventurier.getTresorsCollectes() + "\n");
                
                
                System.out.println("Le fichier output.txt a été créé avec succès à l'emplacement : " + repertoireCourant);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
