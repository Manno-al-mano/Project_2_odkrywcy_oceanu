package ProjektGUI3;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainMenu menu =new MainMenu();
        primaryStage.setTitle("Octopus");
        primaryStage.show();
        primaryStage.setResizable(false);
        final String[] playerName = {""};
//---------------------------------------------------Okno1--------------------------------------------------------------
         StackPane layoutWynikow = new StackPane();
        ListView<String> testowy = new ListView<>();
            testowy.getItems().addAll(menu.getWielka_kolekcja());

        layoutWynikow.getChildren().addAll(testowy);
//---------------------------------------------------Okno2--------------------------------------------------------------
        BorderPane layoutGracza = new BorderPane();
        Label imie = new Label();
        imie.setText(playerName[0]);
        ListView<String> testowy2 = new ListView<>();
        testowy2.setOrientation(Orientation.HORIZONTAL);
        testowy2.getItems().addAll(
                "A", "B","C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X",
                "Y", "Z","0","1","2","3","4",
                "5","6","7","8","9","0", "END"
        );
        //layoutGracza.getChildren().addAll(testowy2,imie);
        layoutGracza.setCenter(testowy2);
        layoutGracza.setBottom(imie);
//---------------------------------------------------Okno3--------------------------------------------------------------
        BorderPane layoutGry = new BorderPane();
        Label test =new Label();
        layoutGry.setTop(test);
        FileInputStream inp = new FileInputStream("octo.png");
        Image im = new Image(inp);
        BackgroundImage bck = new BackgroundImage(im,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bckg = new Background(bck);
        layoutGry.setBackground(bckg);
        Rectangle pole0 = new Rectangle(55, 0, 35, 50);
        pole0.setFill(Color.WHITE);

        Rectangle pole1 = new Rectangle(28, 98, 42, 82  );
        pole1.setFill(Color.WHITE);

        Rectangle pole2 = new Rectangle(28, 227, 42, 82  );
        pole2.setFill(Color.WHITE);

        Rectangle pole3 = new Rectangle(98, 298, 32, 72 );
        pole3.setFill(Color.WHITE);

        Rectangle pole4 = new Rectangle(200, 310, 40, 80 );
        pole4.setFill(Color.WHITE);

        Rectangle pole5 = new Rectangle(330, 320, 35, 70 );
        pole5.setFill(Color.WHITE);




        layoutGry.getChildren().addAll(pole0,pole1,pole2,pole3,pole4,pole5);


        layoutGry.getChildren().addAll(menu.game.macka11, menu.game.macka12, menu.game.macka13a, menu.game.macka13b,
                menu.game.macka14a, menu.game.macka14b, menu.game.macka21, menu.game.macka22, menu.game.macka23,
                menu.game.macka24, menu.game.macka25, menu.game.macka31, menu.game.macka32, menu.game.macka33,
                menu.game.macka34, menu.game.macka41, menu.game.macka42, menu.game.macka43
        );

        BorderPane layoutKonca = new BorderPane();
        Label koniec =new Label();
        layoutKonca.setCenter(koniec);
        koniec.setFont(Font.font("Century Gothic",60));
//----------------------------------------------Sceny-------------------------------------------------------------------


        Scene wyniki, gracz, gra, koniecgry;
        wyniki=new Scene(layoutWynikow, 400, 400);
        primaryStage.setScene(wyniki);
        gracz=new Scene(layoutGracza,400, 400);
        gra=new Scene(layoutGry,400,400);
        koniecgry = new Scene(layoutKonca,400,400);
//-------------------------------Przyciski-Okna-1-----------------------------------------------------------------------
        wyniki.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if(keyEvent.getCode()== KeyCode.SPACE){
                primaryStage.setScene(gracz);
                }
                else if(keyEvent.getCode()==KeyCode.LEFT){
                    menu.sort_by_points();
                    testowy.getItems().clear();
                    for (String str:menu.getWielka_kolekcja()){
                        testowy.getItems().add(str);}


                }
                else if (keyEvent.getCode()==KeyCode.RIGHT){
                    testowy.getItems().clear();
                    menu.sort_by_time();
                    for (String str:menu.getWielka_kolekcja()) {
                        testowy.getItems().add(str);
                    }
                }

            }
        });
//----------------------------------------------------------------------------------------------------------------------
        gracz.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.SPACE){
                    if(testowy2.getSelectionModel().getSelectedItem()=="END"&&playerName[0].length()>0){
                        primaryStage.setScene(gra);
                        menu.startGame(playerName[0]);
                        pole0.setOpacity(0);
                    }
                    else if(testowy2.getSelectionModel().getSelectedItem()!="END"){
                        playerName[0] += testowy2.getSelectionModel().getSelectedItem();
                        imie.setText(playerName[0]);
                    }

                }
            }
        });

//----------------------------------------------------------------------------------------------------------------------
        gra.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (menu.game.isOver()) {
                    if (menu.game.isWon){
                        koniec.setText("VICTORY ACHIEVED");
                    }
                    else {
                        koniec.setText("YOU DIED!");
                    }
                    primaryStage.setScene(koniecgry);
                }
                test.setText("" + menu.game.nurek.getPoints());
                if (keyEvent.getCode() == KeyCode.LEFT) {



                    menu.game.nurek.move_left();

                    if (menu.game.nurek.getPoints() >= 99) {
                        menu.game.setExists(false);
                        menu.game.setOver(true);
                    }
                    if (menu.game.nurek.getPosition() == 1 &&
                            menu.game.octopus.getMacka1().stage == menu.game.octopus.getMacka1().stagenumber &&
                            menu.game.octopus.isStrategiaon()) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 2 &&
                            menu.game.octopus.getMacka1().stage == menu.game.octopus.getMacka1().stagenumber &&
                            !menu.game.octopus.isStrategiaon()) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 3 &&
                            menu.game.octopus.getMacka2().stage == menu.game.octopus.getMacka2().stagenumber
                    ) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 4 &&
                            menu.game.octopus.getMacka3().stage == menu.game.octopus.getMacka3().stagenumber) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 5 &&
                            menu.game.octopus.getMacka4().stage == menu.game.octopus.getMacka4().stagenumber) {
                        menu.game.setExists(false);
                    }

                    switch (menu.game.nurek.getPosition()) {
                        case 0:
                            pole0.setOpacity(0);
                            pole1.setOpacity(100);
                            break;
                        case 1:
                            pole1.setOpacity(0);
                            pole2.setOpacity(100);
                            break;
                        case 2:
                            pole2.setOpacity(0);
                            pole3.setOpacity(100);
                            break;
                        case 3:
                            pole3.setOpacity(0);
                            pole4.setOpacity(100);
                            break;
                        case 4:
                            pole4.setOpacity(0);
                            pole5.setOpacity(100);
                            break;
                    }
                }





                else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    menu.game.nurek.move_right();
                    test.setText("" + menu.game.nurek.getPoints());
                    if (menu.game.nurek.getPoints() >= 99) {
                        menu.game.setExists(false);
                        menu.game.setOver(true);
                    }
                    if (menu.game.nurek.getPosition() == 1 &&
                            menu.game.octopus.getMacka1().stage == menu.game.octopus.getMacka1().stagenumber &&
                            menu.game.octopus.isStrategiaon()) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 2 &&
                            menu.game.octopus.getMacka1().stage == menu.game.octopus.getMacka1().stagenumber &&
                            !menu.game.octopus.isStrategiaon()) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 3 &&
                            menu.game.octopus.getMacka2().stage == menu.game.octopus.getMacka2().stagenumber
                    ) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 4 &&
                            menu.game.octopus.getMacka3().stage == menu.game.octopus.getMacka3().stagenumber) {
                        menu.game.setExists(false);
                    } else if (menu.game.nurek.getPosition() == 5 &&
                            menu.game.octopus.getMacka4().stage == menu.game.octopus.getMacka4().stagenumber) {
                        menu.game.setExists(false);
                    }


                    switch (menu.game.nurek.getPosition()) {
                            case 5:
                                pole5.setOpacity(0);
                                pole4.setOpacity(100);
                                break;
                            case 1:
                                pole1.setOpacity(0);
                                pole0.setOpacity(100);
                                break;
                            case 2:
                                pole2.setOpacity(0);
                                pole1.setOpacity(100);
                                break;
                            case 3:
                                pole3.setOpacity(0);
                                pole2.setOpacity(100);
                                break;
                            case 4:
                                pole4.setOpacity(0);
                                pole3.setOpacity(100);
                                break;
                        }




                }
            }
        });
        koniecgry.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
            primaryStage.close();
            }
        });


        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);



    }
}
