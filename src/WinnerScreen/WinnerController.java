/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinnerScreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Shahy
 */
public class WinnerController implements Initializable {

    
    @FXML
    private MediaView mv;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      //   public void initialize(URL location, ResourceBundle resources) {
        
        String videoPath="win.mp4";
        Media media = new Media(WinnerScreen.JavaProject.class.getResource(videoPath).toExternalForm());
      //  Media media =new Media(videoPath);
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mv.setMediaPlayer(mediaPlayer);
         mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        
         
       
    }
        
    }