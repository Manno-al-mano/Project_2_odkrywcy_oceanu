package ProjektGUI3;

public class Macka {
   protected int stage=0;
   private boolean is_stretched=false;
  protected   int stagenumber;
    public Macka(int stagenumber){
        this.stagenumber=stagenumber;
    }
public void moveTentacle() {
    if (!is_stretched) {
        stage++;
        if (stage == stagenumber)
        {is_stretched = true;
    }
}
    else {stage--;
    if(stage==0){
        is_stretched=false;
    }
    }
}

    public int getStage() {
        return stage;
    }

    public int getStagenumber() {
        return stagenumber;
    }
}

