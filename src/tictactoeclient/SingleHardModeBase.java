package tictactoeclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class SingleHardModeBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btn0;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn7;
    protected final Button btn8;
    protected final Text player1;
    protected final Text player2;
    protected final Text ticText;
    protected final Text tacText;
    protected final Text toeText;
    protected final Button scoreBtnX;
    protected final Button scoreBtnO;
    protected final Text scorePlayer1;
    protected final Text scorePlayer2;
    protected final Button recordGame;
    private char[][] board;
    private boolean playerTurn;
    private int scorePlayerX = 0;
    private int scorePlayerO = 0;
    private static final int MAX_DEPTH = 3; 

    public SingleHardModeBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btn0 = new Button();
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        player1 = new Text();
        player2 = new Text();
        ticText = new Text();
        tacText = new Text();
        toeText = new Text();
        scoreBtnX = new Button();
        scoreBtnO = new Button();
        scorePlayer1 = new Text();
        scorePlayer2 = new Text();
        recordGame = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(800.0);
        setStyle("-fx-background-color: #34365C;");

        gridPane.setLayoutX(235.0);
        gridPane.setLayoutY(135.0);
        gridPane.setPrefHeight(330.0);
        gridPane.setPrefWidth(330.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        btn0.setMnemonicParsing(false);
        btn0.setOpacity(0.7);
        btn0.setPrefHeight(100.0);
        btn0.setPrefWidth(100.0);
        btn0.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");
        GridPane.setMargin(btn0, new Insets(0.0));

        GridPane.setColumnIndex(btn1, 1);
        btn1.setMnemonicParsing(false);
        btn1.setOpacity(0.7);
        btn1.setPrefHeight(100.0);
        btn1.setPrefWidth(100.0);
        btn1.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setColumnIndex(btn2, 2);
        btn2.setMnemonicParsing(false);
        btn2.setOpacity(0.7);
        btn2.setPrefHeight(100.0);
        btn2.setPrefWidth(100.0);
        btn2.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setRowIndex(btn3, 1);
        btn3.setMnemonicParsing(false);
        btn3.setOpacity(0.7);
        btn3.setPrefHeight(100.0);
        btn3.setPrefWidth(100.0);
        btn3.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setColumnIndex(btn4, 1);
        GridPane.setRowIndex(btn4, 1);
        btn4.setMnemonicParsing(false);
        btn4.setOpacity(0.7);
        btn4.setPrefHeight(100.0);
        btn4.setPrefWidth(100.0);
        btn4.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setColumnIndex(btn5, 2);
        GridPane.setRowIndex(btn5, 1);
        btn5.setMnemonicParsing(false);
        btn5.setOpacity(0.7);
        btn5.setPrefHeight(100.0);
        btn5.setPrefWidth(100.0);
        btn5.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setRowIndex(btn6, 2);
        btn6.setMnemonicParsing(false);
        btn6.setOpacity(0.7);
        btn6.setPrefHeight(100.0);
        btn6.setPrefWidth(100.0);
        btn6.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setColumnIndex(btn7, 1);
        GridPane.setRowIndex(btn7, 2);
        btn7.setMnemonicParsing(false);
        btn7.setOpacity(0.7);
        btn7.setPrefHeight(100.0);
        btn7.setPrefWidth(100.0);
        btn7.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");

        GridPane.setColumnIndex(btn8, 2);
        GridPane.setRowIndex(btn8, 2);
        btn8.setMnemonicParsing(false);
        btn8.setOpacity(0.7);
        btn8.setPrefHeight(100.0);
        btn8.setPrefWidth(100.0);
        btn8.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 46;");
        
        player1.setFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        player1.setLayoutX(50.0);
        player1.setLayoutY(150.0);
        player1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1.setStrokeWidth(0.0);
        player1.setText("  You");
        player1.setFont(new Font("Times New Roman Italic", 36.0));

        player2.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        player2.setLayoutX(620.0);
        player2.setLayoutY(150.0);
        player2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2.setStrokeWidth(0.0);
        player2.setText("Computer");
        player2.setFont(new Font(MyFont.MY_FONT, 36.0));

        ticText.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        ticText.setLayoutX(272.0);
        ticText.setLayoutY(100.0);
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setText("Tic");
        ticText.setFont(new Font(MyFont.MY_FONT, 36.0));

        tacText.setFill(javafx.scene.paint.Color.WHITE);
        tacText.setLayoutX(348.0);
        tacText.setLayoutY(100.0);
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);
        tacText.setText("Tac");
        tacText.setFont(new Font(MyFont.MY_FONT, 36.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
        toeText.setLayoutX(434.0);
        toeText.setLayoutY(100.0);
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);
        toeText.setText("Toe");
        toeText.setFont(new Font(MyFont.MY_FONT, 36.0));

        scoreBtnX.setLayoutX(113.0);
        scoreBtnX.setLayoutY(170.0);
        scoreBtnX.setMnemonicParsing(false);
        scoreBtnX.setText("0");

        scoreBtnO.setLayoutX(676.0);
        scoreBtnO.setLayoutY(170.0);
        scoreBtnO.setMnemonicParsing(false);
        scoreBtnO.setText("0");

        scorePlayer1.setFill(javafx.scene.paint.Color.valueOf("#aea5b8"));
        scorePlayer1.setLayoutX(59.0);
        scorePlayer1.setLayoutY(191.0);
        scorePlayer1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer1.setStrokeWidth(0.0);
        scorePlayer1.setText("Score");

        scorePlayer2.setFill(javafx.scene.paint.Color.valueOf("#aea5b8"));
        scorePlayer2.setLayoutX(622.0);
        scorePlayer2.setLayoutY(191.0);
        scorePlayer2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        scorePlayer2.setStrokeWidth(0.0);
        scorePlayer2.setText("Score");

        recordGame.setLayoutX(640.0);
        recordGame.setLayoutY(471.0);
        recordGame.setMnemonicParsing(false);
        recordGame.setPrefHeight(30.0);
        recordGame.setPrefWidth(100.0);
        recordGame.setStyle("-fx-background-color: #ff8fda;");
        recordGame.setText("Record");
        recordGame.setTextFill(javafx.scene.paint.Color.WHITE);
        recordGame.setFont(new Font(MyFont.MY_FONT, 18.0));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btn0);
        gridPane.getChildren().add(btn1);
        gridPane.getChildren().add(btn2);
        gridPane.getChildren().add(btn3);
        gridPane.getChildren().add(btn4);
        gridPane.getChildren().add(btn5);
        gridPane.getChildren().add(btn6);
        gridPane.getChildren().add(btn7);
        gridPane.getChildren().add(btn8);
        getChildren().add(gridPane);
        getChildren().add(player1);
        getChildren().add(player2);
        getChildren().add(ticText);
        getChildren().add(tacText);
        getChildren().add(toeText);
        getChildren().add(scoreBtnX);
        getChildren().add(scoreBtnO);
        getChildren().add(scorePlayer1);
        getChildren().add(scorePlayer2);
        getChildren().add(recordGame);
	initializeGame();
        setEventHandlers();
    }
	 private void initializeGame() {
        board = new char[3][3];
        playerTurn = true;
    }
    private void setEventHandlers() {
          // Button event handlers
            btn0.setOnAction(e -> handleButtonClick(0, 0));
            btn1.setOnAction(e -> handleButtonClick(0, 1));
            btn2.setOnAction(e -> handleButtonClick(0, 2));
            btn3.setOnAction(e -> handleButtonClick(1, 0));
            btn4.setOnAction(e -> handleButtonClick(1, 1));
            btn5.setOnAction(e -> handleButtonClick(1, 2));
            btn6.setOnAction(e -> handleButtonClick(2, 0));
            btn7.setOnAction(e -> handleButtonClick(2, 1));
            btn8.setOnAction(e -> handleButtonClick(2, 2));
         
          recordGame.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                  System.out.println("Recording the game...");
                  //recordGame.setOnAction(e -> recordGame());
              }
          });
      }       
        private void recordGame() {
       // Add your logic to record the game here
       System.out.println("Recording the game...");
       // You might want to save the game state, moves, or any relevant information.
   }
    private int[] minimax(char[][] board, char player, int depth) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // Shuffle the list of available moves
        List<int[]> availableMoves = getAvailableMoves(board);
        Collections.shuffle(availableMoves);

        for (int[] move : availableMoves) {
            int i = move[0];
            int j = move[1];

            if (board[i][j] == 0) {
                board[i][j] = player;
                int score = minimaxHelper(board, depth + 1, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                board[i][j] = 0;

                if ((player == 'O' && score > bestScore) || (player == 'X' && score < bestScore)) {
                    bestScore = score;
                    bestMove[0] = i;
                    bestMove[1] = j;
                }
            }
        }

        return bestMove;
    }

    private void handleButtonClick(int row, int col) {
        Button clickedButton = getButton(row, col);
        if (board[row][col] == 0 && playerTurn) {
            clickedButton.setText("X");
            board[row][col] = 'X';
            checkGameStatus();
            playerTurn = false;
            computerMove();
            playerTurn = true;
        }
    }
private List<int[]> getAvailableMoves(char[][] board) {
    List<int[]> availableMoves = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == 0) {
                availableMoves.add(new int[]{i, j});
            }
        }
    }

    return availableMoves;
}

  private void computerMove() {
    int[] bestMove = minimax(board, 'O', 0);  // Assuming the initial depth is 0
    int row = bestMove[0];
    int col = bestMove[1];
    board[row][col] = 'O';
    getButton(row, col).setText("O");
    checkGameStatus();
}

    private int minimaxHelper(char[][] board, int depth, int alpha, int beta, boolean isMaximizing) {
        char result = isWinner();
        if (result == 'X') {
            return -1;
        } else if (result == 'O') {
            return 1;
        } else if (result == 'T') {
            return 0;
        }

        if (depth >= MAX_DEPTH) {
            return heuristicEvaluation(board);
        }

        // Shuffle the list of available moves
        List<int[]> availableMoves = getAvailableMoves(board);
        Collections.shuffle(availableMoves);

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int[] move : availableMoves) {
                int i = move[0];
                int j = move[1];

                if (board[i][j] == 0) {
                    board[i][j] = 'O';
                    int score = minimaxHelper(board, depth + 1, alpha, beta, false);
                    board[i][j] = 0;
                    bestScore = Math.max(score, bestScore);
                    alpha = Math.max(score, alpha);

                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int[] move : availableMoves) {
                int i = move[0];
                int j = move[1];

                if (board[i][j] == 0) {
                    board[i][j] = 'X';
                    int score = minimaxHelper(board, depth + 1, alpha, beta, true);
                    board[i][j] = 0;
                    bestScore = Math.min(score, bestScore);
                    beta = Math.min(score, beta);

                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return bestScore;
        }
    }
     private int heuristicEvaluation(char[][] board) {
        // Implement your heuristic evaluation logic here
        // This is a placeholder, you can customize it based on your strategy
        return 0;
    }

   private void checkGameStatus() {
        char winner = getWinner();

        if (winner != 0) {
            announceWinner(winner);
        } else if (isBoardFull()) {
            announceTie();
        }
    }
	private char getWinner() {
       char winner = isWinner();
    
        if (winner != 0) {
            return winner;
        }

        // Check if the board is full
        if (isBoardFull()) {
            return 'T'; // 'T' represents a tie
        }

        // No winner yet
        return 0;
       }
          private char isWinner() {
            // Check rows
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                    return board[i][0];
                }
            }
            // Check columns
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != 0) {
                    return board[0][j];
                }
            }
            // Check diagonals
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
                return board[0][0];
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
                return board[0][2];
            }
            return 0; // No winner
        }
        private boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        return false; // There is an empty cell, the board is not full
                    }
                }
            }
            return true; // All cells are filled, the board is full
        }
       
        private void announceTie() {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText("It's a tie!");

                alert.showAndWait();
                resetBoard();
            }

            private void announceWinner(char winner) {
                String winnerName = (winner == 'X') ? "Player X" : "Player O";
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText(winnerName + " wins!");
                updateScores(winner);
                alert.showAndWait();
                resetBoard();
            }
        private Button getButton(int row, int col) {
            return (Button) gridPane.getChildren().get(row * 3 + col);
        }
        private void resetBoard() {
            // Clear the board array
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = 0;
                }
            }
            // Clear button text
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    getButton(i, j).setText("");
                }
            }
            // Reset player turn
            playerTurn = true; // Player goes first
        } 
        private void updateScores(char winner) {
        if (winner == 'X') {
            scorePlayerX++;
           scoreBtnX.setText(Integer.toString(scorePlayerX));
        } else if (winner == 'O') {
            scorePlayerO++;
            scoreBtnO.setText(Integer.toString(scorePlayerO));
        }
      }
        
}
