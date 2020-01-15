import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Game {
    private List<Joueur> listDeJoueurs;
    private List<Joyau> listDeJoyau;
    private List<Case> listDeCases;
    private int nbJoueur; // permet de determiner le plateau en fonction du nombre de joueur
    private int nbJoyau;

    public Game () {
        Scanner clavier = new Scanner (System.in);
        System.out.println ("Combien de joueur vont jouer ?");
        this.nbJoueur = clavier.nextInt ();

        this.listDeJoueurs = createPlayer (); //initialisation du nombre de joueur
        this.listDeJoyau = createJoyau ();
        setNbJoyau ();


        Plateau plateau = new Plateau (new Case(0,0,false," _______ ")); //initialise plateau
        plateau.initialisationPlateau (nbJoueur);
        System.out.println (plateau.getNiemeCase ());
        plateau.display (); //affiche le plateau
        //prendre en compte tous les joueurs

        for (int niemeJoyau = 0; niemeJoyau < this.nbJoyau; nbJoyau++) {         // prendre en compte tous les joyaux
            for (int niemeJoueur = 0; niemeJoueur < this.nbJoueur; niemeJoueur++) {
                if (listDeJoueurs.size () > 1) {
                    // égalité permettant à un joueur de gagner
                    System.out.println ("C'est à vous de jouer, Joueur" + (niemeJoueur + 1)+"\n");
                    System.out.println ("Si vous voulez compléter le programme, taper 1");
                    System.out.println ("Si vous voulez construire un mûr, taper 2");
                    System.out.println ("Si vous voulez exécuter le programme, taper 3\n");
                    int choix = clavier.nextInt ();


                    switch (choix) {
                        case 1:
                            System.out.println ("Voici vos cartes, Joueur" + (niemeJoueur + 1));
                            System.out.println (" ");
                            for (int j = 0; j < 5; j++) { // compteur j permet d'indiquer toutes les cartes du joueur
                                System.out.println (this.listDeJoueurs.get (niemeJoueur).getHand ().get (j).getColor ());
                            }
                            System.out.println (" ");
                            this.listDeJoueurs.get (niemeJoueur).completeAlgorithm ();
                            this.listDeJoueurs.get (niemeJoueur).setCurrentAlgorithm (this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ());

                            break;
                        case 2:
                            int nbreBloc = 5;
                            System.out.println ("Voici vos blocs, Joueur" + (niemeJoueur + 1) + "\n");
                            for (int a = 0; a < nbreBloc; a++) {
                                System.out.println (listDeJoueurs.get (niemeJoueur).getBlocsList ().get (a).getColor ());
                            }
                            listDeJoueurs.get (niemeJoueur).poseBloc (); // fonction qui permet à un joueur de poser un bloc
                            nbreBloc = nbreBloc - 1; // on vient de poser un bloc donc la liste de cartes de bloc est réduite de 1*/
                            break;
                        case 3:
                            for (int niemeCarte = 0; niemeCarte < this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().size (); niemeCarte++) {
                                System.out.println ("L'algorithme du joueur" + (niemeJoueur + 1) + " est:");
                                System.out.println (listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ());
                                if (this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ().equals ("bleue")) {
                                    this.listDeJoueurs.get (niemeJoueur).getTortue ().avance ();
                                } else if (this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ().equals ("jaune")) {
                                    this.listDeJoueurs.get (niemeJoueur).getTortue ().tourneGauche ();
                                } else if (this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ().equals ("violette")) {
                                    this.listDeJoueurs.get (niemeJoueur).getTortue ().tourneDroite ();
                                } else if (this.listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ().equals ("laser")) {
                                }
                                System.out.println ("Les nouvelles coord en x de la tortue sont (" + this.listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getX () + " , "
                                        + this.listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getY () + (")"));
                                System.out.println ("La nouvelle orientation de la tortue est: " + this.listDeJoueurs.get (niemeJoueur).getTortue ().getOrientationTortue () + "\n");

                                // affichage des cartes de l'algo caché

                        /*System.out.println ("L'algorithme du joueur" + (niemeJoueur + 1) + " est:");
                        for (int niemeCarte = 0; niemeCarte < listDeJoueurs.get(niemeJoueur).getCurrentAlgorithm ().size (); niemeCarte++) {
                            System.out.println (listDeJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte ).getColor ());
                        }
                        System.out.println (" ");*/
                                System.out.println ("Voici les coord de la case du joyau (" + listDeJoyau.get (niemeJoyau).getCases ().getX () + " , " + listDeJoyau.get (niemeJoyau).getCases ().getY () + ")");
                                System.out.println ("Les nouvelles coord de la tortue sont (" + this.listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getX () + " , "
                                        + this.listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getY () + (")"));
                                System.out.println ("La nouvelle orientation de la tortue est: " + this.listDeJoueurs.get (niemeJoueur).getTortue ().getOrientationTortue () + "\n");

                                if (listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getX () == listDeJoyau.get (niemeJoyau).getCases ().getX ()
                                        && listDeJoueurs.get (niemeJoueur).getTortue ().getUneCase ().getY () == listDeJoyau.get (niemeJoyau).getCases ().getY ()) {
                                    listDeJoueurs.remove (niemeJoueur);
                                    System.out.println ("La partie est finie");
                                }

                                //Permet l'affichage de la position finale et de son orientation
                        /*System.out.println (listDeJoueurs.get (0).getTortue ().getUneCase ().getX ());
                        System.out.println (listDeJoueurs.get (0).getTortue ().getOrientationTortue ());
                        System.out.println (listDeJoueurs.get (0).getTortue ().getUneCase ().getY () + "\n");*/
                            }
                            this.listDeJoueurs.get (niemeJoueur).clearAlgorithm ();
                            //permet d'afficher toutes les cartes de tous les joueurs
/*
        for (int i=0;i<nbJoueur;i++) {
            System.out.println (" ");
            System.out.println ("Cartes de joueur" + (i+1));
            System.out.println (" ");
            for (int j = 0; j < 5; j++) {
                System.out.println (listDeJoueurs.get (i).getHand ().get (j).getColor ());
            }
        }

 */

                    }
                    this.listDeJoueurs.get (niemeJoueur).setDefausseCarte ();
                    this.listDeJoueurs.get (niemeJoueur).setHand (this.listDeJoueurs.get (niemeJoueur).getHand ()); // permet de mettre en mémoire la main du joueur
                /*} else {
                    System.out.println ("Fin de la partie");*/
                }
            }
        }
    }

    public ArrayList<Joueur> createPlayer () {
        ArrayList<Joueur> listDeJoueur = new ArrayList<> ();
        switch (this.nbJoueur) {
            case 2:
                Joueur joueur1 = new Joueur (new Tortue ("tortueRouge", new Case (1, 0, true, "tortueRouge"), 'S'), null, null, null, null);
                joueur1.initialisationDeck ();
                joueur1.initialisationHand ();
                joueur1.initialisationBlockList ();
                Joueur joueur2 = new Joueur (new Tortue ("tortueVerte", new Case (0, 5, true, "tortueVerte"), 'S'), null, null, null, null);
                joueur2.initialisationDeck ();
                joueur2.initialisationHand ();
                joueur2.initialisationBlockList ();
                listDeJoueur.add (joueur1);
                listDeJoueur.add (joueur2);
                break;
            case 3:
                Joueur J1 = new Joueur (new Tortue ("tortueRouge", new Case (0, 0, true, "tortueRouge"), 'S'), null, null, null, null);

                J1.initialisationDeck ();
                J1.initialisationHand ();
                J1.initialisationBlockList ();
                Joueur J2 = new Joueur (new Tortue ("tortueVerte", new Case (0, 3, true, "tortueVerte"), 'S'), null, null, null, null);
                J2.initialisationDeck ();
                J2.initialisationHand ();
                J2.initialisationBlockList ();
                Joueur J3 = new Joueur (new Tortue ("tortueRose", new Case (0, 6, true, "tortueRose"), 'S'), null, null, null, null);
                J3.initialisationDeck ();
                J3.initialisationHand ();
                J3.initialisationBlockList ();
                listDeJoueur.add (J1);
                listDeJoueur.add (J2);
                listDeJoueur.add (J3);
                break;

            case 4:
                Joueur player1 = new Joueur (new Tortue ("tortueRouge", new Case (0, 0, true, "tortueRouge"), 'S'), null, null, null, null);
                player1.initialisationDeck ();
                player1.initialisationHand ();
                player1.initialisationBlockList ();
                Joueur player2 = new Joueur (new Tortue ("tortueVerte", new Case (0, 2, true, "tortueVerte"), 'S'), null, null, null, null);

                player2.initialisationDeck ();
                player2.initialisationHand ();
                player2.initialisationBlockList ();
                Joueur player3 = new Joueur (new Tortue ("tortueRose", new Case (0, 5, true, "tortueRose"), 'S'), null, null, null, null);

                player3.initialisationDeck ();
                player3.initialisationHand ();
                player3.initialisationBlockList ();
                Joueur player4 = new Joueur (new Tortue ("tortueBleue", new Case (0, 7, true, "tortueBleue"), 'S'), null, null, null, null);
                player4.initialisationDeck ();
                player4.initialisationHand ();
                player4.initialisationBlockList ();
                listDeJoueur.add (player1);
                listDeJoueur.add (player2);
                listDeJoueur.add (player3);
                listDeJoueur.add (player4);
                break;

        }
        return listDeJoueur;
    }

    public ArrayList<Joyau> createJoyau () {
        ArrayList<Joyau> listDeJoyau = new ArrayList<> ();
        switch (nbJoueur) {
            case 2:
                Joyau joyauVert = new Joyau (new Case (3, 7, true, "joyauVert"));
                listDeJoyau.add (joyauVert);
                break;
            case 3:
                Joyau joyauR = new Joyau (new Case (0, 7, true, "joyauRose"));
                Joyau joyauV = new Joyau (new Case (3, 7, true, "joyauVert"));
                Joyau joyauB = new Joyau (new Case (6, 7, true, "joyauBleu"));
                listDeJoyau.add (joyauB);
                listDeJoyau.add (joyauR);
                listDeJoyau.add (joyauV);
                break;
            case 4:
                Joyau joyauRose = new Joyau (new Case (1, 7, true, "joyauRose"));
                Joyau joyauBleu = new Joyau (new Case (6, 7, true, "joyauBleu"));
                listDeJoyau.add (joyauRose);
                listDeJoyau.add (joyauBleu);
                break;
        }
        return listDeJoyau;
    }

    public int getNbJoueur () {
        return nbJoueur;
    }

    public List<Joyau> getListDeJoyau () {
        return listDeJoyau;
    }

    public List<Joueur> getListDeJoueurs () {
        return listDeJoueurs;
    }

    public void setNbJoyau () {
        switch (this.nbJoueur) {
            case 2:
                this.nbJoyau = 1;
                break;
            case 3:
                this.nbJoyau = 3;
                break;
            case 4:
                this.nbJoyau = 2;
                break;
        }
    }
}


