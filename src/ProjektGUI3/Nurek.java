package ProjektGUI3;
import java.io.*;

public class Nurek {
  private   String playerName;
  private   double startTime;
  private  double endTime;
   private int position;
   private int points;
   private boolean is_gold_carried;

   public Nurek(String playerName){
       this.playerName = playerName;
       startTime=System.currentTimeMillis();
   this.position=0;
   this.points=0;
   this.is_gold_carried=false;
   }

    public int getPoints() {
        return points;
    }

    public int getPosition() {
        return position;
    }

    public void move_right(){
       if (position<5){
           position++;
       }
       else {points++;
       is_gold_carried=true;
    }
   }
   public void move_left(){
       if(position>0)
       {
           if (position==1&&is_gold_carried){
               points++;
               if(points<99){
                   points++;
               }
               is_gold_carried=false;
           }
           position--;

       }
   }

   public void endgame() throws IOException {
       endTime=(System.currentTimeMillis()-startTime)/1000;
       String highscore = playerName + " "+points+" "+endTime+"\n";
       FileWriter edytorPliku = new FileWriter("highscore.txt", true);
       BufferedWriter out = new BufferedWriter(edytorPliku);
       out.write(highscore);
       out.close();
       System.out.println("Wynik: "+points+"Czas: "+endTime);
   }




}
