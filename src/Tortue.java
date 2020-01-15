public class Tortue {

    private String tortueCouleur;
    private char orientationTortue;
    private Case uneCase;

    public Tortue (String tortueCouleur, Case uneCase, char orientationTortue) {
        this.uneCase = uneCase;
        this.tortueCouleur = tortueCouleur;
        this.orientationTortue = orientationTortue;
    }

    public String getCouleur () {
        return this.tortueCouleur;
    }

    public Case getUneCase () {
        return this.uneCase;
    }

    public String getTortueCouleur () {
        return this.tortueCouleur;
    }

    public char getOrientationTortue () {
        return this.orientationTortue;
    }

    public void setOrientationTortue (char orientationTortue) {
        this.orientationTortue = orientationTortue;
    }

    public void initialisationOrientationTortue () {
        this.orientationTortue = 'S'; // l'orientation de la tortue est sud par défaut
    }

    public void avance () {
        //if (this.uneCase.getUsed ()==true){
            switch (this.orientationTortue) {
            case 'S':
                this.uneCase.setY (this.uneCase.getY () + 1);
                break;
            case 'N':
                this.uneCase.setY (this.uneCase.getY () - 1);
                break;
            case 'E':
                this.uneCase.setX (this.uneCase.getX () + 1);
                break;
            case 'O':
                this.uneCase.setX (this.uneCase.getX () - 1);
                break;
        }
    }

    public void tourneGauche () {
        switch (this.orientationTortue) {
            case 'S':
                this.setOrientationTortue ('E');
                break;
            case 'E':
                this.setOrientationTortue ( 'N');
                break;
            case 'N':
                this.setOrientationTortue ('O');
                break;
            case 'O':
                this.setOrientationTortue ('S');
                break;
        }
    }

    public void tourneDroite () {
        switch (this.orientationTortue) {
            case 'S':
                this.setOrientationTortue ('O');
                break;
            case 'O':
                this.setOrientationTortue ('N');
                break;
            case 'N':
                this.setOrientationTortue ('E');
                break;
            case 'E':
                this.setOrientationTortue ('S');
                break;
        }
    }

    public void tortueBloque(){
        if (this.uneCase.getUsed ()==true){

        }
    }
}

