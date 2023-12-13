package WinnerScreen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import services.Navigator;
import tictactoeclient.BordBase;
import tictactoeclient.ChooseModeBase;
import tictactoeclient.StartpageBase;

public  class WinnerScreenBase extends BorderPane {

    protected final MediaView mv;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final ColumnConstraints columnConstraints9;
    protected final ColumnConstraints columnConstraints10;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label PlayerNameLabelWinner;
    protected final Label WinnerStatus;
    static String videoPath;
    public WinnerScreenBase(String name , int num) {

        mv = new MediaView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        gridPane0 = new GridPane();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        columnConstraints10 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        PlayerNameLabelWinner = new Label();
        WinnerStatus = new Label();
        if (num == 1){
             videoPath = "win.mp4";
        
        }else if (num == 2){
            //vid loser 
             videoPath = "loser.mp4";
        }else if(num == 3){
            //draw vid
             videoPath = "draw.mp4";
        }
        
        //String videoPath="win.mp4";
        Media media = new Media(WinnerScreen.JavaProject.class.getResource(videoPath).toExternalForm());
      //  Media media =new Media(videoPath);
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mv.setMediaPlayer(mediaPlayer);
         mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        BorderPane.setAlignment(mv, javafx.geometry.Pos.CENTER);
        mv.setFitHeight(400.0);
        mv.setFitWidth(600.0);
        BorderPane.setMargin(mv, new Insets(0.0, 0.0, 50.0, 0.0));
        setCenter(mv);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(50.0);
        gridPane.setPrefWidth(591.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(175.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(0.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(334.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(23.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(334.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(129.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(464.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(318.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(334.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(115.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(117.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(23.0);

        rowConstraints.setMaxHeight(11.0);
        rowConstraints.setMinHeight(0.0);
        rowConstraints.setPrefHeight(0.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(37.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(37.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(19.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(13.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(button, 2);
        GridPane.setRowIndex(button, 1);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(112.0);
        button.setStyle("-fx-background-radius: 10;");
        button.setText("Back");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#81778d"));
        button.setOnAction(e->{
            Navigator.navigateTo(new ChooseModeBase(),e);
            BordBase.scoreP1=0;
            BordBase.scoreP2=0;
        });

        GridPane.setColumnIndex(button0, 4);
        GridPane.setRowIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(31.0);
        button0.setPrefWidth(112.0);
        button0.setStyle("-fx-background-radius: 10;");
        button0.setText("Play Again");
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#81778d"));
        button0.setFont(new Font("Times New Roman", 16.0));
        setBottom(gridPane);
        button0.setOnAction(e->{
            Navigator.navigateTo(new BordBase(),e);
        });

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(95.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(18.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(182.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(158.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(192.0);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(124.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(232.0);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(159.0);

        columnConstraints9.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints9.setMaxWidth(200.0);
        columnConstraints9.setMinWidth(10.0);
        columnConstraints9.setPrefWidth(117.0);

        columnConstraints10.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints10.setMaxWidth(95.0);
        columnConstraints10.setMinWidth(0.0);
        columnConstraints10.setPrefWidth(24.0);

        rowConstraints2.setMaxHeight(25.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(70.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(70.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(25.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(10.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(PlayerNameLabelWinner, 2);
        GridPane.setRowIndex(PlayerNameLabelWinner, 1);
        PlayerNameLabelWinner.setPrefHeight(46.0);
        PlayerNameLabelWinner.setPrefWidth(200);
        PlayerNameLabelWinner.setText(name);
        PlayerNameLabelWinner.setTextFill(javafx.scene.paint.Color.WHITE);
        PlayerNameLabelWinner.setFont(new Font("Times New Roman Italic", 40.0));

        GridPane.setColumnIndex(WinnerStatus, 3);
        GridPane.setRowIndex(WinnerStatus, 1);
        WinnerStatus.setPrefHeight(58.0);
        WinnerStatus.setPrefWidth(400.0);
        if(num==1){
            WinnerStatus.setText(" Winner!");
        }else if(num==2){
                    WinnerStatus.setText(" Loser!");

        }else if(num==3){
                    WinnerStatus.setText(" Draw!");

        }
        WinnerStatus.setTextFill(javafx.scene.paint.Color.valueOf("#d31b9c"));
        WinnerStatus.setFont(new Font("Times New Roman Italic", 40.0));
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getColumnConstraints().add(columnConstraints6);
        gridPane0.getColumnConstraints().add(columnConstraints7);
        gridPane0.getColumnConstraints().add(columnConstraints8);
        gridPane0.getColumnConstraints().add(columnConstraints9);
        gridPane0.getColumnConstraints().add(columnConstraints10);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getChildren().add(PlayerNameLabelWinner);
        gridPane0.getChildren().add(WinnerStatus);

    }
}
