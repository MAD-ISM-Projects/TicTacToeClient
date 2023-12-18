package tictactoeclient;

import Recorder.GamePlay;
import Recorder.GamePlayManager;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import services.Navigator;


public class RecordPlay extends BoardUI {

    private GamePlayManager manager;
    private String lastGamePlaySteps;
    private Thread recordReader;

    public RecordPlay() {
        recordGame.setText("Back");
        recordGame.addEventHandler(ActionEvent.ACTION, (event) -> {
            recordReader.stop();
            Navigator.navigateTo(new ChooseModeBase(), event);
 
     });
        
        manager = new GamePlayManager();
        lastGamePlaySteps = getLastRecordedGamePlaySteps(manager);

        if (lastGamePlaySteps != null) {
            System.out.println("Last recorded game play steps: " + lastGamePlaySteps);
        } else {
            System.out.println("No recorded game plays.");
        }

        showRecord();
    }
    private String getLastRecordedGamePlaySteps(GamePlayManager manager) {
        Map<String, GamePlay> gamePlays = manager.getGamePlays();
        if (!gamePlays.isEmpty()) {
            String lastRecordedGamePlayId = findLastRecordedGamePlayId(gamePlays);
            return gamePlays.get(lastRecordedGamePlayId).getSteps();
        }
        return null;
    }

    private String findLastRecordedGamePlayId(Map<String, GamePlay> gamePlays) {
        // Find the last recorded game play ID
        return gamePlays.keySet().stream().max(String::compareTo).orElse(null);
    }


    void showRecord() {
        
        recordReader=new Thread(() -> {
        for (int stepper = 0; stepper < lastGamePlaySteps.length(); stepper++) {
            char move = (stepper % 2 == 0) ? 'X' : 'O';
            int index = Character.getNumericValue(lastGamePlaySteps.charAt(stepper));

            Platform.runLater(() -> {
                Button btn = bordRecorder.get(index);
                updateButton(btn, move);
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RecordPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
        recordReader.start();
    }

    private void updateButton(Button btn, char move) {
        if (move == 'X') {
            btn.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 36;");
            btn.setText("X");
        } else if (move == 'O') {
            btn.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill:#ff8fda; -fx-font-size: 36;");
            btn.setText("O");
        }
    }

    @Override
    protected void addListen(Button btn) {
        // Implementation of the addListen method (if needed)
    }
}
