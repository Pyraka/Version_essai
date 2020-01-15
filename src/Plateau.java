import javax.swing.*;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plateau {

    private List<List<Case>> plateau; // une liste de liste définie un tableau
    private List<Case> colo = new ArrayList<> ();
    private Case cases;
    private JButton button;

    public Plateau (Case cases) {
        this.plateau = new ArrayList<> (); //initialisation du plateau
        this.cases = cases;
    }

    public List<Case> getColo () {
        return colo;
    }

    public void setColo (List<Case> colo) {
        this.colo = colo;
    }

    public void initialisationPlateau (int nbJoueur) {
        for (int colonne = 0; colonne < 8; colonne++) { //on commence à compter à 0 donc il y a bien 8 lignes
            List<Case> colo = new ArrayList<> ();
            for (int ligne = 0; ligne < 8; ligne++) { // de meme pour les colonnes
                if (nbJoueur == 2) {
                    this.button = new JButton ();
                    cases = new Case (colonne, ligne, false, " _______ ");
                    if (ligne == 7 && colonne < 8) {
                        cases = new Case (colonne, ligne, true, "    X    ");
                    } else if (colonne == 0 && ligne == 1) {
                        cases = new Case (colonne, ligne, true, " tortueRouge ");

                    } else if (colonne == 0 && ligne == 5) {
                        cases = new Case (colonne, ligne, true, "tortueVerte");


                    } else if (colonne == 7 && ligne == 3) {
                        cases = new Case (colonne, ligne, true, " joyauVert ");
                        //Joyau joyauxVert = new Joyau (new Case(colonne, ligne, true, " joyauVert ")); version qui ne s'affiche pas mais qui peut être utile
                    } else {
                        cases = new Case (colonne, ligne, false, " ____ ");
                    }
                    this.colo.add (cases); // on ajoute des colonnes a chaque fois
                } else if (nbJoueur == 3) {
                    this.button = new JButton ();
                    cases = new Case (colonne, ligne, false, " ____ ");
                    if (ligne == 7 && colonne < 8) {
                        cases = new Case (colonne, ligne, true, "    X    ");
                    } else if (colonne == 0 && ligne == 0) {
                        cases = new Case (colonne, ligne, true, " tortueRouge ");
                    } else if (colonne == 0 && ligne == 3) {
                        cases = new Case (colonne, ligne, true, "tortueVerte");
                    } else if (colonne == 0 && ligne == 6) {
                        cases = new Case (colonne, ligne, true, "tortueRose");
                    } else if (colonne == 7 && ligne == 0) {
                        cases = new Case (colonne, ligne, true, " joyauRose ");
                    } else if (colonne == 7 && ligne == 3) {
                        cases = new Case (colonne, ligne, true, "joyauVert");
                    } else if (colonne == 7 && ligne == 6) {
                        cases = new Case (colonne, ligne, true, "joyauBleu");
                    } else {
                        cases = new Case (colonne, ligne, false, " ____ ");
                    }
                    this.colo.add (cases);
                } else if (nbJoueur == 4) {
                    this.button = new JButton ();
                    cases = new Case (colonne, ligne, false, " ____ ");
                    if (colonne == 0 && ligne == 0) {
                        cases = new Case (colonne, ligne, true, " tortueRouge ");
                    } else if (colonne == 0 && ligne == 2) {
                        cases = new Case (colonne, ligne, true, "tortueVerte");
                    } else if (colonne == 0 && ligne == 5) {
                        cases = new Case (colonne, ligne, true, "tortueRose");
                    } else if (colonne == 0 && ligne == 7) {
                        cases = new Case (colonne, ligne, true, "tortueBleue");
                    } else if (colonne == 7 && ligne == 1) {
                        cases = new Case (colonne, ligne, true, " joyauRose ");
                    } else if (colonne == 7 && ligne == 6) {
                        cases = new Case (colonne, ligne, true, "joyauBleu");
                    } else {
                        cases = new Case (colonne, ligne, false, " ____ ");
                    }
                    this.colo.add (cases);
                }

            }
            this.plateau.add (this.colo); // permet de faire une liste de colonne ce qui donne un tableau de 8 par 8
        }
    }

    public void display () { // permet de creer une fonction pour afficher le plateau en console
        for (List<Case> listColonnes : this.plateau) { // list de case
            for (Case uneCase : this.colo) { // la case
                System.out.print (uneCase.getSee ());
            }
            System.out.println ("");
            //}
        }
    }

    public int getNiemeCase () {
        int niemeCase = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                niemeCase = j + i;
            }
        }
        return niemeCase;
    }
}
    /*public void newPLateau(int nbJoueur){
        Game game = new Game ();
        Plateau plateau = new Plateau ();
        for (int colonne = 0; colonne < 8; colonne++) { //on commence à compter à 0 donc il y a bien 8 lignes
            List<Case> colo = new ArrayList<> ();
            for (int ligne = 0; ligne < 8; ligne++) { // de meme pour les colonnes
                Cases cases = null;
                if (nbJoueur == 2) {
                    cases = new Cases (colonne, ligne, false, " _______ ");
                    if (ligne == game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getX () && game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getY () < 8) {
                        cases = new Cases (colonne, ligne, true, "    X    ");
                    }
                    else if (colonne == 0 && ligne == 1) {
                        cases = new Cases (colonne, ligne, true, " tortueRouge ");
                    } else if (colonne == 0 && ligne == 5) {
                        cases = new Cases (colonne, ligne, true, "tortueVerte");
                    } else if (colonne == 7 && ligne == 3) {
                        cases = new Cases (colonne, ligne, true, " joyauVert ");
                    } else {
                        cases = new Cases (colonne, ligne, false, " ____ ");
                    }
                    colo.add(cases); // on ajoute des colonnes a chaque fois
                }
    }
     */




/*
    public void plateauGame (int nbJoueur) {
        System.out.println ("Le plateauuuuu");
        Game game = new Game ();
        for (int ligne = 0; ligne < 8; ligne++) { //on commence à compter à 0 donc il y a bien 8 colonnes
            List<Case> colo = new ArrayList<> ();
            for (int colonne = 0; colonne < 8; colonne++) { // de meme pour les lignes
                Case cases = null;


                if (game.getNbJoueur () == 2) {
                    cases = new Case (ligne, colonne, false, " _______ ");
                    if (colonne == 7 && ligne < 8) {
                        cases = new Case (ligne, colonne, true, "    X    ");
                    }
                    else if (ligne == game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getX ()  && colonne == game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getY () ) {
                        cases = new Case (ligne, colonne, true, " tortueRouge ");

                    } else if (ligne == game.getListDeJoueurs ().get (1).getTortue ().getUneCase ().getX ()  && colonne == game.getListDeJoueurs ().get (1).getTortue ().getUneCase ().getY () ) {
                        cases = new Case (ligne, colonne, true, "tortueVerte");


                    } else if (ligne == game.getListDeJoyau ().get (0).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (0).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, " joyauVert ");
                        //Joyau joyauxVert = new Joyau (new Case(ligne, colonne, true, " joyauVert ")); version qui ne s'affiche pas mais qui peut être utile
                    } else {
                        cases = new Case (ligne, colonne, false, " ____ ");
                    }
                    colo.add(cases); // on ajoute des lignes a chaque fois
                }


                else if (game.getNbJoueur () == 3) {
                    cases = new Case (ligne, colonne, false, " ____ ");
                    if (colonne == 7 && ligne < 8) {
                        cases = new Case (ligne, colonne, true, "    X    ");
                    }
                    else if (ligne == game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getX ()  && colonne == game.getListDeJoueurs ().get (0).getTortue ().getUneCase ().getY () ) {
                        cases = new Case (ligne, colonne, true, " tortueRouge ");
                    } else if (ligne == game.getListDeJoueurs ().get (1).getTortue ().getUneCase ().getX ()  && colonne == game.getListDeJoueurs ().get (1).getTortue ().getUneCase ().getY () ) {
                        cases = new Case (ligne, colonne, true, "tortueVerte");
                    } else if (ligne == game.getListDeJoueurs ().get (2).getTortue ().getUneCase ().getX ()  && colonne == game.getListDeJoueurs ().get (2).getTortue ().getUneCase ().getY () ) {
                        cases = new Case (ligne, colonne, true, "tortueRose");
                    } else if (ligne == game.getListDeJoyau ().get (0).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (0).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, " joyauRose ");
                    } else if (ligne == game.getListDeJoyau ().get (1).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (1).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, "joyauVert");
                    } else if (ligne == game.getListDeJoyau ().get (2).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (2).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, "joyauBleu");
                    } else {
                        cases = new Case (ligne, colonne, false, " ____ ");
                    }
                    colo.add(cases);
                }

                else if (game.getNbJoueur () == 4) {
                    cases = new Case (ligne, colonne, false, " ____ ");
                    if (ligne == 0 && colonne == 0) {
                        cases = new Case (ligne, colonne, true, " tortueRouge ");
                    } else if (ligne == 0 && colonne == 2) {
                        cases = new Case (ligne, colonne, true, "tortueVerte");
                    } else if (ligne == 0 && colonne == 5) {
                        cases = new Case (ligne, colonne, true, "tortueRose");
                    } else if (ligne == 0 && colonne == 7) {
                        cases = new Case (ligne, colonne, true, "tortueBleue");
                    } else if (ligne == game.getListDeJoyau ().get (0).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (0).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, " joyauRose ");
                    } else if (ligne == game.getListDeJoyau ().get (1).getCases ().getX ()  && colonne == game.getListDeJoyau ().get (1).getCases ().getY () ) {
                        cases = new Case (ligne, colonne, true, "joyauBleu");
                    } else {
                        cases = new Case (ligne, colonne, false, " ____ ");
                    }
                    colo.add(cases);
                }

            }

            plateau.add(colo); // permet de faire une liste de ligne ce qui donne un tableau de 8 par 8
        }
    }
}

 */



