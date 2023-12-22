package tictactoeclient;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.Navigator;

public class ChooseModeBase extends AnchorPane {

    protected final ImageView mode_image;
    protected final Text text_tic;
    protected final Text text_tac;
    protected final Text text_toe;
    protected final Button btn_Single;
    protected final Button btn_multi;
    protected final Button btn_online;
    protected final Button btn_Record;
    protected final Button btnBack;
    TextField ipAddress = new TextField();
    GridPane gridPane = new GridPane();
    String ip;
    public ChooseModeBase() {

        mode_image = new ImageView();
        text_tic = new Text();
        text_tac = new Text();
        text_toe = new Text();
        btn_Single = new Button();
        btn_multi = new Button();
        btn_online = new Button();
        btn_Record = new Button();
        btnBack = new Button();
        gridPane.add(new Label("Server IP: "), 0, 0);
        gridPane.add(ipAddress, 1, 0);

        setId("AnchorPane");
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        mode_image.setFitHeight(200.0);
        mode_image.setFitWidth(200.0);
        mode_image.setLayoutX(300.0);
        mode_image.setLayoutY(37.0);
        mode_image.setPickOnBounds(true);
        mode_image.setPreserveRatio(true);
        mode_image.setImage(new Image(getClass().getResource("xoImg.png").toExternalForm()));
        
        btnBack.setLayoutX(60.0);
        btnBack.setLayoutY(50.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(37.0);
        btnBack.setPrefWidth(80.0);
        btnBack.setStyle("-fx-background-radius: 10;");
        btnBack.setText("Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btnBack.setFont(new Font(MyFont.MY_FONT, 19.0));
        btnBack.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Navigator.navigateTo(new StartPageBase(), e);
            }
        });
        
        text_tic.setFill(javafx.scene.paint.Color.WHITE);
        text_tic.setLayoutX(312.0);
        text_tic.setLayoutY(276.0);
        text_tic.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_tic.setStrokeWidth(0.0);
        text_tic.setText("Tic");
        text_tic.setFont(new Font(MyFont.MY_FONT, 40.0));

        text_tac.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        text_tac.setLayoutX(370.0);
        text_tac.setLayoutY(276.0);
        text_tac.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_tac.setStrokeWidth(0.0);
        text_tac.setText("Tac");
        text_tac.setFont(new Font(MyFont.MY_FONT, 40.0));

        text_toe.setFill(javafx.scene.paint.Color.WHITE);
        text_toe.setLayoutX(436.0);
        text_toe.setLayoutY(276.0);
        text_toe.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text_toe.setStrokeWidth(0.0);
        text_toe.setText("Toe");
        text_toe.setFont(new Font(MyFont.MY_FONT, 40.0));

        btn_Single.setLayoutX(315.0);
        btn_Single.setLayoutY(345.0);
        btn_Single.setMnemonicParsing(false);
        btn_Single.setPrefHeight(37.0);
        btn_Single.setPrefWidth(170.0);
        btn_Single.setStyle("-fx-background-radius: 10;");
        btn_Single.setText("Single mode");
        btn_Single.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btn_Single.setFont(new Font(MyFont.MY_FONT, 19.0));
        btn_Single.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Navigator.navigateTo(new selectLevelBase(), e);
            }
        });

        btn_multi.setLayoutX(315.0);
        btn_multi.setLayoutY(395.0);
        btn_multi.setMnemonicParsing(false);
        btn_multi.setPrefHeight(37.0);
        btn_multi.setPrefWidth(170.0);
        btn_multi.setStyle("-fx-background-radius: 10;");
        btn_multi.setText("Multi mode");
        btn_multi.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btn_multi.setFont(new Font(MyFont.MY_FONT, 18.0));
        btn_multi.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Navigator.navigateTo(new SetPlayersBase(), e);
            }
        });
        btn_online.setLayoutX(315.0);
        btn_online.setLayoutY(445.0);
        btn_online.setMnemonicParsing(false);
        btn_online.setPrefHeight(37.0);
        btn_online.setPrefWidth(170.0);
        btn_online.setStyle("-fx-background-radius: 10;");
        btn_online.setText("online");
        btn_online.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btn_online.setFont(new Font(MyFont.MY_FONT, 19.0));
        btn_online.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Server IP");
                alert.setHeaderText("Enter Server IP");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if (ipAddress.getText().isEmpty()) {
                    ipAddress.setStyle("");
                } else {
                     StartConnection con = new StartConnection();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        //con.connectServer(ipAddress.toString());
                        ip=ipAddress.getText();
                        Navigator.navigateTo(new SignIn(), e);

                    }
                }
            }
        });
        btn_Record.setLayoutX(315.0);
        btn_Record.setLayoutY(495.0);
        btn_Record.setMnemonicParsing(false);
        btn_Record.setPrefHeight(37.0);
        btn_Record.setPrefWidth(170.0);
        btn_Record.setStyle("-fx-background-radius: 10;");
        btn_Record.setText("Record");
        btn_Record.setTextFill(javafx.scene.paint.Color.valueOf("#8b76a4"));
        btn_Record.setFont(new Font(MyFont.MY_FONT, 19.0));
        btn_Record.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent e){
                Navigator.navigateTo(new RecordPlay(), e);

            }
        });
        getChildren().add(mode_image);
        getChildren().add(text_tic);
        getChildren().add(text_tac);
        getChildren().add(text_toe);
        getChildren().add(btn_Single);
        getChildren().add(btn_multi);
        getChildren().add(btn_online);
        getChildren().add(btn_Record);
        getChildren().add(btnBack);
    }
}
