package tictactoeclient;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import services.Navigator;
//import servcies.Navigator;

public  class StartpageBase extends AnchorPane {

    protected final Button startButton;
    protected final Label label;
    protected final Text tictoeText;
    protected final Text miniText;
    protected final Text gamText;
    protected final Text text;
    protected final ImageView imageView;
    protected final ImageView xoImage;

    public StartpageBase() {

        startButton = new Button();
        label = new Label();
        tictoeText = new Text();
        miniText = new Text();
        gamText = new Text();
        text = new Text();
        imageView = new ImageView();
        xoImage = new ImageView();

        setId("AnchorPane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");
        startButton.setLayoutX(98.0);
        startButton.setLayoutY(334.0);
        
        startButton.setPrefHeight(51.0);
        startButton.setPrefWidth(145.0);
        startButton.setStyle("-fx-background-radius: 15;");
        startButton.setText("Start");
        startButton.setTextFill(javafx.scene.paint.Color.valueOf("#aea5b8"));
        startButton.setFont(new Font(24.0));
        startButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigator.navigateTo(new ChooseModeBase(), e);
            }
        });
        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        tictoeText.setFill(javafx.scene.paint.Color.valueOf("#8b91b5"));
        tictoeText.setLayoutX(24.0);
        tictoeText.setLayoutY(181.0);
        tictoeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tictoeText.setStrokeWidth(0.0);
        tictoeText.setText("Tic       Toe");
        tictoeText.setWrappingWidth(324.765625);
        tictoeText.setFont(new Font("Times New Roman Bold Italic", 70.0));

        miniText.setFill(javafx.scene.paint.Color.valueOf("#8b91b5"));
        miniText.setLayoutX(65.0);
        miniText.setLayoutY(280.0);
        miniText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        miniText.setStrokeWidth(0.0);
        miniText.setText("mini ");
        miniText.setWrappingWidth(93.9999908208847);
        miniText.setFont(new Font("Times New Roman Italic", 45.0));

        gamText.setFill(javafx.scene.paint.Color.valueOf("#8b91b5"));
        gamText.setLayoutX(159.0);
        gamText.setLayoutY(283.0);
        gamText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gamText.setStrokeWidth(0.0);
        gamText.setText("Game");
        gamText.setWrappingWidth(151.94921875);
        gamText.setFont(new Font("Times New Roman Bold Italic", 55.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        text.setLayoutX(126.0);
        text.setLayoutY(181.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tac");
        text.setFont(new Font("Times New Roman Bold Italic", 70.0));

        imageView.setFitHeight(248.0);
        imageView.setFitWidth(345.0);
        imageView.setLayoutX(445.0);
        imageView.setLayoutY(154.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        xoImage.setFitHeight(318.0);
        xoImage.setFitWidth(316.0);
        xoImage.setLayoutX(437.0);
        xoImage.setLayoutY(118.0);
        URL imageUrl = getClass().getResource("xoImg.png");
          if (imageUrl == null) {
         System.out.println("Image not found!");
        } else {
           xoImage.setImage(new Image(imageUrl.toExternalForm()));
        }
        getChildren().add(startButton);
        getChildren().add(label);
        getChildren().add(tictoeText);
        getChildren().add(miniText);
        getChildren().add(gamText);
        getChildren().add(text);
        getChildren().add(imageView);
        getChildren().add(xoImage);

    }


}
