import java.util.ArrayList;

public class Case {

    private int x;
    private int y;
    private boolean isUsed;
    private String see;

    public Case (int x, int y, boolean isUsed, String see) {
        this.x = x;
        this.y = y;
        this.isUsed = isUsed;
        this.see = see;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public boolean getUsed () {
        return isUsed;
    }

    public String getSee () {
        return see;
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }


    public void setUsed (boolean used) {
        isUsed = used;
    }

    public void setSee (String see) {
        this.see = see;
    }

    public void casePleine(){
        if (this.isUsed == false){
            this.see = " ____ ";
        }
    }


}
