package ProjektGUI3;

import java.io.*;
import java.util.LinkedList;

public class MainMenu {
  private   LinkedList<String> wielka_kolekcja = new LinkedList<>();
protected  Game game;
    Main main;
public MainMenu() throws IOException {
    this.game=new Game();
    File plik = new File("highscore.txt");
    if( !plik.isFile()){
        try{
            boolean b = plik.createNewFile();
        }
        catch(IOException e){
            System.out.println("Nie można utworzyć pliku");
        }
    }
    BufferedReader br = new BufferedReader(new FileReader(plik));
    String line;
    while ((line=br.readLine())!=null){
        wielka_kolekcja.add(line);
    }
}

public void sort_by_points(){
    String arr[]=new String[wielka_kolekcja.size()];
    for(int i=0;i<wielka_kolekcja.size();i++){
        arr[i]= wielka_kolekcja.get(i);
    }

    String tmp="";
    for (int i=0;i<arr.length;i++){
for(int j=1;j<(arr.length-i);j++){
    if(reducetopoints(arr[j-1])<reducetopoints(arr[j])){
        tmp=arr[j-1];
        arr[j-1]=arr[j];
        arr[j]=tmp;
    }
}
    }
wielka_kolekcja.clear();
    for (String str:arr){
        wielka_kolekcja.add(str);
    }

}

    public void sort_by_time(){
        String arr[]=new String[wielka_kolekcja.size()];
        for(int i=0;i<wielka_kolekcja.size();i++){
            arr[i]= wielka_kolekcja.get(i);
        }

        String tmp="";
        for (int i=0;i<arr.length;i++){
            for(int j=1;j<(arr.length-i);j++){
                if(reducetotime(arr[j-1])<reducetotime(arr[j])){
                    tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        wielka_kolekcja.clear();
        for (String str:arr){
            wielka_kolekcja.add(str);
        }

    }


    public double reducetotime(String str){
        boolean to_save=false,firstSpace=false;
        String time="";
        for(int i =0; i<str.length();i++)
        {
            char a = str.charAt(i);
            if (a==' '&&!firstSpace){
               firstSpace=true;
            }
            else if(a==' '&&firstSpace){
                to_save=true;
            }
            else if(a=='\n'){
                to_save=false;
            }
            else if (to_save){
                time=time+a;}

        }
        double timenumber=Double.parseDouble(time);
        return timenumber;
    }

public int reducetopoints(String str){
   boolean to_save=false;
   String points="";
   for(int i =0; i<str.length();i++)
   {
       char a = str.charAt(i);
       if (a==' '&&!to_save){
           to_save=true;
       }
       else if(a==' '&&to_save){
           to_save=false;
       }
       else if (to_save){
           points=points+a;}
       }
   int pointnumber=Integer.parseInt(points);
   return pointnumber;
   }

public void startGame(String playerName){
  this.game.makenurek(playerName);
  game.start();
}

    public LinkedList<String> getWielka_kolekcja() {
        return wielka_kolekcja;
    }
}
