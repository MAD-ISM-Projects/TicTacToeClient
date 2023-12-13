package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.Navigator;

public  class selectLevelBase extends AnchorPane {

    protected final ImageView EeasyImage;
    protected final Button EasyButton;
    protected final ImageView HardImage;
    protected final Button HardButton;

    public selectLevelBase() {

        EeasyImage = new ImageView();
        EasyButton = new Button();
        HardImage = new ImageView();
        HardButton = new Button();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        EeasyImage.setFitHeight(200.0);
        EeasyImage.setFitWidth(200.0);
        EeasyImage.setLayoutX(105.0);
        EeasyImage.setLayoutY(123.0);
        EeasyImage.setPickOnBounds(true);
        EeasyImage.setPreserveRatio(true);
        EeasyImage.setRotate(15.0);
        EeasyImage.setImage(new Image(getClass().getResource("xoImg.png").toExternalForm()));

        EasyButton.setLayoutX(150.0);
        EasyButton.setLayoutY(392.0);
        EasyButton.setMnemonicParsing(false);
        EasyButton.setPrefHeight(40.0);
        EasyButton.setPrefWidth(120.0);
        EasyButton.setStyle("-fx-background-color: #8B91B5;");
        EasyButton.setText("Easy");
        EasyButton.setTextFill(javafx.scene.paint.Color.WHITE);

        HardImage.setFitHeight(200.0);
        HardImage.setFitWidth(200.0);
        HardImage.setLayoutX(496.0);
        HardImage.setLayoutY(123.0);
        HardImage.setPickOnBounds(true);
        HardImage.setPreserveRatio(true);
        HardImage.setImage(new Image(getClass().getResource("Controllers/hard.png").toExternalForm()));

        HardButton.setLayoutX(551.0);
        HardButton.setLayoutY(392.0);
        HardButton.setMnemonicParsing(false);
        HardButton.setPrefHeight(40.0);
        HardButton.setPrefWidth(120.0);
        HardButton.setStyle("-fx-background-color: #8B91B5;");
        HardButton.setText("Hard");
        HardButton.setTextFill(javafx.scene.paint.Color.WHITE);
        HardButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigator.navigateTo(new SingleHardModeBase(), e);
            }
        });
        getChildren().add(EeasyImage);
        getChildren().add(EasyButton);
        getChildren().add(HardImage);
        getChildren().add(HardButton);

    }
}
