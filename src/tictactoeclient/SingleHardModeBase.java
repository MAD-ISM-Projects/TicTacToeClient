package tictactoeclient;
import Recorder.GamePlayManager;
import javafx.scene.control.Button;
import services.Navigator;
import services.Saver;
import WinnerScreen.WinnerScreenBase;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;

public class SingleHardModeBase extends BoardUI {
    private final Saver saver = Saver.saverObject();
        String currentGamePlaySteps="";
        //int stepper=0;
        Map<String, String> players;
        GamePlayManager manager;

    public SingleHardModeBase(String p1, String pc) {
        player1Name.setText(p1);
        player2Name.setText(pc);
        recordGame.addEventHandler(ActionEvent.ACTION, (event) -> {
        manager = new GamePlayManager();
        players = new HashMap<>();
        players.put("player1", player1Name.getText());
        players.put("player2", player2Name.getText());  
     });
    }
        private void hardLevel() {
            int[] bestMove = findBestMove();

            if (bestMove[0] != -1 && bestMove[1] != -1) {
                int row = bestMove[0];
                int col = bestMove[1];

                bord[row][col].setStyle("-fx-background-color: #FFFFFF; -fx-text-fill:#ff8fda; -fx-font-size: 36;");
                bord[row][col].setText("O");
                bord[row][col].setDisable(true);
                currentGamePlaySteps+=(row*3)+col;


                isPlayerTurn();
            }
        }

            private int[] findBestMove() {
            int bestScore = Integer.MIN_VALUE;
            int[] bestMove = new int[]{-1, -1};

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (bord[i][j].getText().isEmpty()) {
                        bord[i][j].setText("O");
                        int score = minimax(bord, 0, false);
                        bord[i][j].setText("");

                        if (score > bestScore) {
                            bestScore = score;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                    }
                }
            }

            return bestMove;
        }
        private int minimax(Button[][] board, int depth, boolean isMaximizing) {
            int result = evaluateBoard();

            if (result == 10) {
                return result - depth;
            } else if (result == -10) {
                return result + depth;
            } else if (isBoardFull(board)) {
                return 0;
            }

            if (isMaximizing) {
                int maxScore = Integer.MIN_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].getText().isEmpty()) {
                            board[i][j].setText("O");
                            maxScore = Math.max(maxScore, minimax(board, depth + 1, false));
                            board[i][j].setText("");
                        }
                    }
                }

                return maxScore;
            } else {
                int minScore = Integer.MAX_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].getText().isEmpty()) {
                            board[i][j].setText("X");
                            minScore = Math.min(minScore, minimax(board, depth + 1, true));
                            board[i][j].setText("");
                        }
                    }
                }

                return minScore;
            }
        }
        private int evaluateBoard() {
            // Placeholder logic - replace with your actual implementation
            for (int row = 0; row < 3; row++) {
                if (bord[row][0].getText().equals("X") && bord[row][1].getText().equals("X") && bord[row][2].getText().equals("X")) {
                    return -10; // Player wins
                } else if (bord[row][0].getText().equals("O") && bord[row][1].getText().equals("O") && bord[row][2].getText().equals("O")) {
                    return 10; // AI wins
                }
            }

            for (int col = 0; col < 3; col++) {
                if (bord[0][col].getText().equals("X") && bord[1][col].getText().equals("X") && bord[2][col].getText().equals("X")) {
                    return -10; // Player wins
                } else if (bord[0][col].getText().equals("O") && bord[1][col].getText().equals("O") && bord[2][col].getText().equals("O")) {
                    return 10; // AI wins
                }
            }

            // Diagonal checks
            if (bord[0][0].getText().equals("X") && bord[1][1].getText().equals("X") && bord[2][2].getText().equals("X")) {
                return -10; // Player wins
            } else if (bord[0][0].getText().equals("O") && bord[1][1].getText().equals("O") && bord[2][2].getText().equals("O")) {
                return 10; // AI wins
            }

            if (bord[0][2].getText().equals("X") && bord[1][1].getText().equals("X") && bord[2][0].getText().equals("X")) {
                return -10; // Player wins
            } else if (bord[0][2].getText().equals("O") && bord[1][1].getText().equals("O") && bord[2][0].getText().equals("O")) {
                return 10; // AI wins
            }

            return 0; // No winner yet
        }

        private boolean isBoardFull(Button[][] board) {
            // Placeholder logic - replace with your actual implementation
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getText().isEmpty()) {
                        return false; // Board is not full
                    }
                }
            }
            return true; // Board is full
        }

        protected void doPlay(Button btn) {
            if (btn.getText().isEmpty()) {
                if (isPlayerTurn()) {
                    btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
                    btn.setText("X");
                    player1Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));
                    player2Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                    currentGamePlaySteps+=bordRecorder.indexOf(btn);

                    if (isWin()) return;
                    hardLevel();

                    player1Name.setFill(javafx.scene.paint.Color.valueOf("#ffffff"));
                    player2Name.setFill(javafx.scene.paint.Color.valueOf("#ff8fda"));  
                }
            }
        }

        protected void addListen(Button btn) {
            btn.setOnAction(
                    e -> {
                        doPlay(btn);

                           System.out.println(currentGamePlaySteps);

                        if (isWin()) {
                            if (isPlayerTurn) {
                                BordBase.winner = 1;
                                BordBase.page = 2;
                                Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                                isPlayerTurn = !isPlayerTurn;
                                BordBase.scoreP1++;
                            } else {
                                BordBase.winner = 2;
                                BordBase.page = 2;
                                Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                                BordBase.scoreP2++;
                            }
                            if(manager!=null) 
                            {
                                manager.saveGamePlay( players, currentGamePlaySteps);
                                currentGamePlaySteps="";
                            }
                            resetGame();
                        } else if (isDraw() == true) {
                            BordBase.winner = 3;
                            BordBase.page = 2;
                            Navigator.navigateTo(new WinnerScreenBase("YOU", winner, page), e);
                            if(manager!=null) 
                            {
                                manager.saveGamePlay( players, currentGamePlaySteps);
                                currentGamePlaySteps="";
                            }
                            resetGame();
                            isPlayerTurn = !isPlayerTurn;
                        }
                        scoreBtnX.setText(Integer.toString(scoreP1));
                        scoreBtnO.setText(Integer.toString(scoreP2));
                    }
            );
        }
}
