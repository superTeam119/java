/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import static MediaPackage.ObjectProfileForm.videoPopUp;
import static MediaPackage.ObjectProfileForm.videoStage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class VideoFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane mvPane;

    @FXML
    private MediaView mediaView;
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
    @FXML
    private HBox mediaBar;
    @FXML
    private Button playButton;
    public static MediaPlayer m;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

              
        String path =  videoPopUp;
        Media media = new Media(new File(path).toURI().toString());
        m= new MediaPlayer(media);
        m.setAutoPlay(false);
        mediaView.setMediaPlayer(m);    
        mvPane.setStyle("-fx-background-color: gray;");

        mediaBar.setAlignment(Pos.CENTER);
        mediaBar.setPadding(new Insets(5, 10, 5, 10));
        BorderPane.setAlignment(mediaBar, Pos.CENTER);
        HBox.setHgrow(timeSlider, Priority.ALWAYS);
        //timeSlider.setMinWidth(50);
      //  timeSlider.setMaxWidth(Double.MAX_VALUE);

       // playTime.setPrefWidth(60);
       // playTime.setMinWidth(30);

        //volumeSlider.setPrefWidth(25);
       // volumeSlider.setMaxWidth(Region.USE_PREF_SIZE);
       // volumeSlider.setMinWidth(30);
        mediaView.setFitWidth(500);
        mediaView.setFitHeight(77750);
        playButton.setOnAction((ActionEvent e) -> {
            Status status = m.getStatus();
            
            if (status == Status.UNKNOWN || status == Status.HALTED) {
                // don't do anything in these states
                return;
            }
            
            if (status == Status.PAUSED
                    || status == Status.READY
                    || status == Status.STOPPED) {
                // rewind the movie if we're sitting at the end
                if (atEndOfMedia) {
                    m.seek(m.getStartTime());
                    atEndOfMedia = false;
                }
                m.play();
            } else {
                m.pause();
            }
        });

        m.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
        });
        m.setOnPlaying(() -> {
            if (stopRequested) {
                m.pause();
                stopRequested = false;
            } else {
                playButton.setText("||");
            }
        });
        m.setOnPaused(() -> {
            System.out.println("onPaused");
            playButton.setText(">");
        });
        m.setOnReady(() -> {
            duration = m.getMedia().getDuration();
            updateValues();
        });
        timeSlider.valueProperty().addListener((Observable ov) -> {
            if (timeSlider.isValueChanging()) {
                // multiply duration by percentage calculated by slider position
                m.seek(duration.multiply(timeSlider.getValue() / 100.0));
            }
        });
        volumeSlider.valueProperty().addListener((Observable ov) -> {
            if (volumeSlider.isValueChanging()) {
                m.setVolume(volumeSlider.getValue() / 100.0);
            }
        });
    }
    
    public void updateValues() {
        if (playTime != null && timeSlider != null && volumeSlider != null) {
            Platform.runLater(() -> {
                Duration currentTime = m.getCurrentTime();
                playTime.setText(formatTime(currentTime, duration));
                timeSlider.setDisable(duration.isUnknown());
                if (!timeSlider.isDisabled()
                        && duration.greaterThan(Duration.ZERO)
                        && !timeSlider.isValueChanging()) {
                    timeSlider.setValue(currentTime.divide(duration).toMillis()
                            * 100.0);
                }
                if (!volumeSlider.isValueChanging()) {
                    volumeSlider.setValue((int) Math.round(m.getVolume()
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
