package Recorder;

import java.util.Map;

public class GamePlay {
    private Map<String, String> players;
    private String steps;
   // public static int gamePlayID=0;

    public GamePlay(Map<String, String> players, String steps) {
        this.players = players;
        this.steps = steps;
    //    gamePlayID++;
  //      gamePlayID=gamePlayID/10;
    }

    public Map<String, String> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, String> players) {
        this.players = players;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
    @Override
    public String toString() {
        return "GamePlay{" +
                "players=" + players +
                ", steps='" + steps + '\'' +
                '}';
    }
}
