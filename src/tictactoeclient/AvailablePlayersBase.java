package tictactoeclient;

import DTO.ClientRequest;
import DTO.ClientRequestHeader;
import DTO.DTOPlayer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import network.connection.NetworkConnection;
import services.Navigator;
import static tictactoeclient.BoardUI.scoreP1;
import static tictactoeclient.BoardUI.scoreP2;
import tictactoeclient.UsersItemListBase;

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
    private NetworkConnection network;
    String myName;

    ArrayList<DTOPlayer> onlinePlayrs = new ArrayList<>();

    public AvailablePlayersBase(String playerName) {

        network = new NetworkConnection();
        ArrayList<DTOPlayer> availablePlayers = new ArrayList<>();
        ClientRequest availablePlayersRequest = new ClientRequest(ClientRequestHeader.onlineUsers, playerName);
        myName = playerName;
        String availablePlayersResponse = availablePlayersRequest.toJson();
        network.sentMessage(availablePlayersResponse);
        System.out.println(availablePlayersResponse);
        String replyOnAvailablePlayers = network.getMessage();
        System.out.println(replyOnAvailablePlayers);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<DTOPlayer>>() {
        }.getType();
        availablePlayers = gson.fromJson(replyOnAvailablePlayers, listType);

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
        UsersListView.setPrefHeight(282.0);
        UsersListView.setPrefWidth(636.0);
        UsersListView.setStyle("-fx-background-radius: 15; -fx-background-color: #34365C;");
        BorderPane.setMargin(UsersListView, new Insets(0.0, 90.0, 20.0, 90.0));
        setCenter(UsersListView);
//        UsersItemListBase[] usersArray = new UsersItemListBase[6];
//        for (int i = 0; i < usersArray.length; i++) {
//            usersArray[i] = new UsersItemListBase();
//             UsersListView.getItems().add(usersArray[i]);
//       }

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
        rectangle.setHeight(49.0);
        rectangle.setLayoutX(89.0);
        rectangle.setLayoutY(85.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(620.0);

        ScoreLabel.setLayoutX(297.0);
        ScoreLabel.setLayoutY(91.0);
        ScoreLabel.setText("Score");
        ScoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        ScoreLabel.setFont(new Font(24.0));

        PlayerNameLabel.setLayoutX(111.0);
        PlayerNameLabel.setLayoutY(91.0);
        PlayerNameLabel.setText("player name");
        PlayerNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        PlayerNameLabel.setFont(new Font(24.0));

        StatusLabel.setLayoutX(425.0);
        StatusLabel.setLayoutY(91.0);
        StatusLabel.setText("Status");
        StatusLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        StatusLabel.setFont(new Font(24.0));
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
        LogOutButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
          public void handle(ActionEvent e) {
               /* // 1. Create a ClientRequest for sign-out
                ClientRequest signOutRequest = new ClientRequest(myName,ClientRequestHeader.signOut );

                // 2. Convert the ClientRequest to JSON
                String signOutRequestJson = signOutRequest.toJson();

                // 3. Send the sign-out request to the server
                network.sentMessage(signOutRequestJson);
                System.out.println("Sent sign-out request.");

                // 4. Close the network connection
                network.closeConnection();
                System.out.println("Closed network connection.");

                // 5. Navigate to the start screen
                Navigator.navigateTo(new StartPageBase(), e);*/
                ClientRequest signoutRequest=new ClientRequest(myName,ClientRequestHeader.signOut);
                            String signOutRaquest=signoutRequest.toJson();
                            network.sentMessage(signOutRaquest);
                            System.out.println(signOutRaquest);
                  
                            String replyOnSingIn = network.getMessage();
                             Navigator.navigateTo(new StartPageBase(), e);
                           
            }
        });

        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(ScoreLabel);
        anchorPane.getChildren().add(PlayerNameLabel);
        anchorPane.getChildren().add(StatusLabel);
        anchorPane0.getChildren().add(HomeButton);
        anchorPane0.getChildren().add(LogOutButton);
        SignIn signIn = new SignIn();
        signIn.receiveOnlinePlayers(availablePlayers);
    }

    // Import statements...
    public class SignIn {
        // Class variables and methods...

        public void receiveOnlinePlayers(ArrayList<DTOPlayer> onlinePlayers) {
            // Clear the list in a background thread
            Platform.runLater(() -> UsersListView.getItems().clear());

            new Thread(() -> {
                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {
                    ObservableList<UsersItemListBase> cellList = FXCollections.observableArrayList();
                    for (DTOPlayer player : onlinePlayers) {
                        UsersItemListBase cell = new UsersItemListBase();
                        cell.player.setText(player.getName());
                        cell.Score.setText(String.valueOf(player.getScore()));
                        cell.Status.setText(player.getStatus());

                        // Add cell to the ListView in the JavaFX Application Thread
                        UsersListView.getItems().add(cell);
                        cell.button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                String name = cell.player.getText();
                                network = new NetworkConnection();
                                ClientRequest InvitationRequest = new ClientRequest(myName, name, ClientRequestHeader.gameInvitation);
                                String InvitationResponse = InvitationRequest.toJson();
                                System.out.println(" ========== invitation Request ============");
                                network.sentMessage(InvitationRequest.toJson());
                                System.out.println(InvitationRequest.toJson());
                                System.out.println(" ========== invitation Response ============");
                                System.out.println(InvitationResponse);
                            }
                        });
                    }
                });
            }).start();
        }

        private void showInvitationDialog(String invitationData) {
            // Implement code to show a dialog to the user with the invitation details
            // Extract information from the invitationData and display it to the user
        }

        private void handleInvitationResponse(String response) {
            // Implement code to handle the invitation response
            // Extract information from the response and take appropriate actions
            // For example, open the game if the response is positive
        }

        // Other methods...
    }

}
