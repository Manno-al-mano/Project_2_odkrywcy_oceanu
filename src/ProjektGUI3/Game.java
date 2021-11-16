package ProjektGUI3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Game extends Thread{
protected Nurek nurek;
protected Octopus octopus;
private boolean isOver=false;
protected boolean isWon=false;
private boolean exists=true;
    protected Rectangle macka11, macka12, macka13a, macka14a, macka13b,macka14b, macka21, macka22, macka23, macka24,
    macka25, macka31, macka32, macka33, macka34,macka41,macka42,macka43;

    public void makenurek (String playerName)
    {
        this.nurek=new Nurek(playerName);
    }
public Game(){

    this.octopus= new Octopus();
    macka11 = new Rectangle(116, 132, 37, 21);
    macka11.setFill(Color.WHITE);

    macka12 = new Rectangle(104, 152, 28, 30);
    macka12.setFill(Color.WHITE);

    macka13a = new Rectangle(87, 140, 25, 22);
    macka13a.setFill(Color.WHITE);

    macka14a = new Rectangle(74, 116, 28, 25);
    macka14a.setFill(Color.WHITE);

    macka13b = new Rectangle(85, 178, 34, 27);
    macka13b.setFill(Color.WHITE);

    macka14b = new Rectangle(75, 208, 36, 30);
    macka14b.setFill(Color.WHITE);

    macka21 = new Rectangle(157, 146, 42, 35);
    macka21.setFill(Color.WHITE);

    macka22 = new Rectangle(145, 181, 37, 36);
    macka22.setFill(Color.WHITE);

   macka23 = new Rectangle(138, 219, 33, 32);
    macka23.setFill(Color.WHITE);

     macka24 = new Rectangle(133, 250, 30, 30);
    macka24.setFill(Color.WHITE);

    macka25 = new Rectangle(132, 283, 35, 41);
    macka25.setFill(Color.WHITE);

    macka31 = new Rectangle(208, 176, 34, 29);
    macka31.setFill(Color.WHITE);

    macka32 = new Rectangle(213, 211, 29, 42);
    macka32.setFill(Color.WHITE);

    macka33 = new Rectangle(213, 254, 31, 35);
    macka33.setFill(Color.WHITE);

     macka34 = new Rectangle(232, 288, 33, 31);
    macka34.setFill(Color.WHITE);

    macka41 = new Rectangle(297, 203, 44, 33);
    macka41.setFill(Color.WHITE);

     macka42 = new Rectangle(312, 236, 41, 43);
    macka42.setFill(Color.WHITE);
     macka43= new Rectangle(314, 277, 43, 44);
    macka43.setFill(Color.WHITE);
}

    public static void wstrzymanie(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public void run () {
    while (exists){


 drawtenacleone();
 drawtenacletwo();
 drawtenaclethree();
 drawtenaclefour();
        endconditions() ;
        System.out.println(nurek.getPosition());
        octopus.attack();
        if (Math.random()<0.5){
        octopus.attack();}

        wstrzymanie(200+3*(int)(100*Math.random()));
    }
        try {
            nurek.endgame();
        } catch (IOException e) {
            e.printStackTrace();
        }
isOver=true;
    }

    public boolean isOver() {
        return isOver;
    }

    public void endconditions(){
        if (nurek.getPoints()>=99){
            exists=false;
            isWon=true;
        }
        if (nurek.getPosition()==1&&
                octopus.getMacka1().stage==octopus.getMacka1().stagenumber&&
                octopus.isStrategiaon()){
            exists=false;
        }
        else if(nurek.getPosition()==2&&
                octopus.getMacka1().stage==octopus.getMacka1().stagenumber&&
                !octopus.isStrategiaon()){
            exists=false;
        }
        else if(nurek.getPosition()==3&&
                octopus.getMacka2().stage==octopus.getMacka2().stagenumber
        ){
            exists=false;
        }
        else if(nurek.getPosition()==4&&
                octopus.getMacka3().stage==octopus.getMacka3().stagenumber){
            exists=false;
        }
        else if(nurek.getPosition()==5&&
                octopus.getMacka4().stage==octopus.getMacka4().stagenumber){
            exists=false;
        }
    }
    public void drawtenacleone(){
        if(octopus.getMacka1().getStage()>0){
            macka11.setVisible(false);
        }
        else macka11.setVisible(true);;

        if(octopus.getMacka1().getStage()>1){
            macka12.setVisible(false);
        }
        else macka12.setVisible(true);

        if(octopus.getMacka1().getStage()>2&&octopus.isStrategiaon()){
            macka13a.setVisible(false);
        }
        else macka13a.setVisible(true);;
        if(octopus.getMacka1().getStage()>3&&octopus.isStrategiaon()){
            macka14a.setVisible(false);
        }
        else macka14a.setVisible(true);;
        if(octopus.getMacka1().getStage()>2&&!octopus.isStrategiaon()){
            macka13b.setVisible(false);
        }
        else macka13b.setVisible(true);;
        if(octopus.getMacka1().getStage()>3&&!octopus.isStrategiaon()){
            macka14b.setVisible(false);
        }
        else macka14b.setVisible(true);;



    }
    public void drawtenacletwo() {
        if (octopus.getMacka2().getStage() > 0) {
            macka21.setVisible(false);
        } else {
            macka21.setVisible(true);;
        }

        if (octopus.getMacka2().getStage() > 1) {
            macka22.setVisible(false);
        } else {
            macka22.setVisible(true);;
        }

        if (octopus.getMacka2().getStage() > 2) {
            macka23.setVisible(false);
        } else {
            macka23.setVisible(true);
        }

        if (octopus.getMacka2().getStage() > 3) {
            macka24.setVisible(false);
        } else {
            macka24.setVisible(true);
        }

        if (octopus.getMacka2().getStage() > 4) {
            macka25.setVisible(false);
        } else {
            macka25.setVisible(true);
        }
    }
    public void drawtenaclethree() {
        if (octopus.getMacka3().getStage() > 0) {
            macka31.setVisible(false);
        } else {
            macka31.setVisible(true);
        }

        if (octopus.getMacka3().getStage() > 1) {
            macka32.setVisible(false);
        } else {
            macka32.setVisible(true);
        }

        if (octopus.getMacka3().getStage() > 2) {
            macka33.setVisible(false);
        } else {
            macka33.setVisible(true);
        }

        if (octopus.getMacka3().getStage() > 3) {
            macka34.setVisible(false);
        } else {
            macka34.setVisible(true);
        }
    }
    public void drawtenaclefour() {
        if (octopus.getMacka4().getStage() > 0) {
            macka41.setVisible(false);
        } else {
            macka41.setVisible(true);
        }

        if (octopus.getMacka4().getStage() > 1) {
            macka42.setVisible(false);
        } else {
            macka42.setVisible(true);
        }

        if (octopus.getMacka4().getStage() > 2) {
            macka43.setVisible(false);
        } else {
            macka43.setVisible(true);
        }
    }
}
