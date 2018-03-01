/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;

//import static MediaPackage.ObjectProfileForm.audioMediaPlayer2;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import static MediaPackage.ObjectProfileForm.audioPopUp;
import static MediaPackage.ObjectProfileForm.audioStage;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class AudioFormController implements Initializable {
     @FXML private Pane mvPane;

 @FXML private MediaView mediaView;
 
    private final boolean repeat = false;
    private boolean stopRequested = false;
    private boolean atEndOfMedia = false;
    private Duration duration;
    @FXML
    private Slider timeSlider;
    @FXML
    private Label playTime;
    @FXML
    private Slider volumeSlider;
    public static  MediaPlayer   audioMediaPlayer2;
    @FXML
    private Button playButton;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   String path =  audioPopUp;
     
  
  
       // mediaView.setMediaPlayer(new MediaPlayer(new Media(new File(path).toURI().toString())));
      Media media = new Media(new File(path).toURI().toString());
           audioMediaPlayer2 = new MediaPlayer(media);
           // mediaView.setMediaPlayer(audioMediaPlayer2); 
        playButton.setStyle("-fx-background-color: transparent;"); 
        playButton.setOnAction((ActionEvent e) -> {
            MediaPlayer.Status status = audioMediaPlayer2.getStatus();
            
            if (status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED) {
                // don't do anything in these states
                return;
            }
            
            if (status == MediaPlayer.Status.PAUSED
                    || status == MediaPlayer.Status.READY
                    || status == MediaPlayer.Status.STOPPED) {
                // rewind the movie if we're sitting at the end
                if (atEndOfMedia) {
                    audioMediaPlayer2.seek(audioMediaPlayer2.getStartTime());
                    atEndOfMedia = false;
                }
                audioMediaPlayer2.play();
            } else {
                audioMediaPlayer2.pause();
            }
     });
                audioMediaPlayer2.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        audioMediaPlayer2.setOnEndOfMedia(() -> {
            if (!repeat) {
                playButton.setText(">");
                stopRequested = true;
                atEndOfMedia = true;
            }
     });
        
//
        audioMediaPlayer2.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
     });
        audioMediaPlayer2.setOnPlaying(() -> {
            if (stopRequested) {
                audioMediaPlayer2.pause();
                stopRequested = false;
            } else {
                playButton.setText("||");
            }
     });
        audioMediaPlayer2.setOnPaused(() -> {
            System.out.println("onPaused");
            playButton.setText(">");
     });
        audioMediaPlayer2.setOnReady(() -> {
            duration = audioMediaPlayer2.getMedia().getDuration();
            updateValues();
     });
        timeSlider.valueProperty().addListener((Observable ov) -> {
            if (timeSlider.isValueChanging()) {
                // multiply duration by percentage calculated by slider position
                audioMediaPlayer2.seek(duration.multiply(timeSlider.getValue() / 100.0));
            }
     });
        volumeSlider.valueProperty().addListener((Observable ov) -> {
            if (volumeSlider.isValueChanging()) {
                audioMediaPlayer2.setVolume(volumeSlider.getValue() / 100.0);
            }
     });
        

 
    }

    public void updateValues() {
        if (playTime != null && timeSlider != null && volumeSlider != null) {
            Platform.runLater(() -> {
                Duration currentTime = audioMediaPlayer2.getCurrentTime();
                playTime.setText(formatTime(currentTime, duration));
                timeSlider.setDisable(duration.isUnknown());
                if (!timeSlider.isDisabled()
                        && duration.greaterThan(Duration.ZERO)
                        && !timeSlider.isValueChanging()) {
                    timeSlider.setValue(currentTime.divide(duration).toMillis()
                            * 100.0);
                }
                if (!volumeSlider.isValueChanging()) {
                    volumeSlider.setValue((int) Math.round(audioMediaPlayer2.getVolume()
                            * 100));
                }
            });
        }
    }

    public static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }    
    }
}
