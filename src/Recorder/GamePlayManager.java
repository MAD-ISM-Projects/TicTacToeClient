package Recorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlayManager {
    private final String filePath;
    private final Gson gson;
    private Map<String, GamePlay> gamePlays;
    public static int index;

    public GamePlayManager() {
        this.filePath = "src/Recorder/Records.json"; 
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.gamePlays = new HashMap<>();
        loadGamePlays();
        index=gamePlays.size();
    }
    static{
        index=0;
    }

    private void loadGamePlays() {
        try (Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<String, GamePlay>>() {}.getType();
            Map<String, GamePlay> loadedGamePlays = gson.fromJson(reader, type);

            if (loadedGamePlays != null) {
                gamePlays = loadedGamePlays;
                System.out.println("Loaded game plays: " + gamePlays);
            } else {
                System.err.println("Failed to load game plays from file: " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGamePlay(Map<String, String> players, String steps) {
        GamePlay gamePlay = new GamePlay(players, steps);
        gamePlays.put("GamePlay "+GamePlayManager.index, gamePlay);
        GamePlayManager.index++;
        updateFile();
    }

    private void updateFile() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(gamePlays, writer);
            ((FileWriter) writer).flush();  
            System.out.println("Saved game plays to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, GamePlay> getGamePlays() {
        return new HashMap<>(gamePlays);
    }
        public ArrayList<GamePlay> getAllGamePlays() {
        return new ArrayList<>(gamePlays.values());
    }
}
    