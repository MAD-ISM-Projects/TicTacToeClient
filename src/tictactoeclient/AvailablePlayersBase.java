package tictactoeclient;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class AvailablePlayersBase extends BorderPane {

    protected final ListView UsersListView;
    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final Rectangle rectangle;
    protected final Label ScoreLabel;
    protected final Label PlayerNameLabel;
    protected final Label StatusLabel;
    protected final AnchorPane anchorPane0;
    protected final Button HomeButton;
    protected final Button LogOutButton;
   // protected final ListView<UsersItemListBase> UsersListView;
    //public String[] cv = {"Ranoma"};


    
   

    public AvailablePlayersBase() {

        UsersListView = new ListView();
        anchorPane = new AnchorPane();
        text = new Text();
        rectangle = new Rectangle();
        ScoreLabel = new Label();
        PlayerNameLabel = new Label();
        StatusLabel = new Label();
        anchorPane0 = new AnchorPane();
        HomeButton = new Button();
        LogOutButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        BorderPane.setAlignment(UsersListView, javafx.geometry.Pos.CENTER);
        UsersListView.setEditable(true);
        UsersListView.setPrefHeight(306.0);
        UsersListView.setPrefWidth(600.0);
        UsersListView.setStyle("-fx-background-radius: 15;");
        //UsersListView.getItems().addAll(usersList);
        BorderPane.setMargin(UsersListView, new Insets(0.0, 50.0, 20.0, 50.0));
        setCenter(UsersListView);
       

        // Populate the ListView with UsersItemListBase items
        UsersItemListBase[] usersArray = new UsersItemListBase[2];
        for (int i = 0; i < usersArray.length; i++) {
            usersArray[i] = new UsersItemListBase();
            usersArray[i].player.setText("Player " + (i + 1));
            // Set other properties as needed
            UsersListView.getItems().add(usersArray[i]);
        }
    

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(170.0);
        anchorPane.setPrefWidth(800.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(270.0);
        text.setLayoutY(56.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Available Users");
        text.setFont(new Font(39.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#8b91b5"));
        rectangle.setHeight(64.0);
        rectangle.setLayoutX(63.0);
        rectangle.setLayoutY(77.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(672.0);

        ScoreLabel.setLayoutX(369.0);
        ScoreLabel.setLayoutY(91.0);
        ScoreLabel.setText("Score");
        ScoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        ScoreLabel.setFont(new Font(25.0));

        PlayerNameLabel.setLayoutX(126.0);
        PlayerNameLabel.setLayoutY(91.0);
        PlayerNameLabel.setText("player name");
        PlayerNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        PlayerNameLabel.setFont(new Font(25.0));

        StatusLabel.setLayoutX(583.0);
        StatusLabel.setLayoutY(91.0);
        StatusLabel.setText("Status");
        StatusLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        StatusLabel.setFont(new Font(25.0));
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(78.0);
        anchorPane0.setPrefWidth(800.0);

        HomeButton.setLayoutX(92.0);
        HomeButton.setLayoutY(20.0);
        HomeButton.setMnemonicParsing(false);
        HomeButton.setPrefHeight(35.0);
        HomeButton.setPrefWidth(120.0);
        HomeButton.setStyle("-fx-background-color: #8b91b5; -fx-background-radius: 5;");
        HomeButton.setText("Home");
        HomeButton.setTextFill(javafx.scene.paint.Color.valueOf("#f5eeee"));
        HomeButton.setFont(new Font(14.0));

        LogOutButton.setLayoutX(584.0);
        LogOutButton.setLayoutY(18.0);
        LogOutButton.setMnemonicParsing(false);
        LogOutButton.setPrefHeight(35.0);
        LogOutButton.setPrefWidth(120.0);
        LogOutButton.setStyle("-fx-background-color: #8b91b5; -fx-background-radius: 5;");
        LogOutButton.setText("Log Out");
        LogOutButton.setTextFill(javafx.scene.paint.Color.valueOf("#f8f5f5"));
        LogOutButton.setFont(new Font(14.0));
        setBottom(anchorPane0);

        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(ScoreLabel);
        anchorPane.getChildren().add(PlayerNameLabel);
        anchorPane.getChildren().add(StatusLabel);
        anchorPane0.getChildren().add(HomeButton);
        anchorPane0.getChildren().add(LogOutButton);

    }
}
