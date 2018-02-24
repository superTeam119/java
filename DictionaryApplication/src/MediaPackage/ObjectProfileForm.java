/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;

import static FxmlFiles.FXMLMediaController.className;
import static FxmlFiles.FXMLMediaController.objectName;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class ObjectProfileForm implements Initializable {

    /**
     * Initializes the controller class.
     */
public  static String audioPopUp;
public  static String videoPopUp;
    @FXML private ImageView pictureView;
    @FXML private Tab pictureTab;
    @FXML private Tab videoTab;
    @FXML private Tab audioTab;
     @FXML protected MediaView videoMediaView;
      @FXML protected ImageView   audioMediaView;
      @FXML private Label audioName;
      MediaPlayer mediaPlayer;
      Media media;
    Image image;

    private int audioIndex=0,videoIndex=0,pictureIndex=0;
    ArrayList<String> videoPaths;
    ArrayList<String> audioPaths;
    ArrayList<String> picturePaths;
protected  String mediaPath;
List<String> MediaPaths;

@FXML private ListView oListView;

    String audioFolderPath;
    String videoFolderPath;
    String picFolderPath;
      @Override
    public void initialize(URL url, ResourceBundle rb) {
//          System.out.println(className+objectName);
        // TODO
        //videoMediaView
      
 audioFolderPath="media\\"  + className+"\\"+objectName + "\\Audio\\";
          System.out.println(audioFolderPath);
audioPaths=(ArrayList<String>) listFiles(audioFolderPath);
  videoFolderPath="media\\"  + className +"\\"+objectName+ "\\Video\\";
videoPaths=(ArrayList<String>) listFiles(videoFolderPath);
 picFolderPath="media\\"  + className+"\\"+objectName + "\\Pictures\\";
picturePaths=(ArrayList<String>) listFiles(picFolderPath);
//videoMediaView

//mediaPath=new File(videoPaths.get(videoIndex)).getAbsolutePath();
mediaPath=new File(videoFolderPath+videoPaths.get(videoIndex)).getAbsolutePath();

          
media = new Media(new File(mediaPath).toURI().toString());
mediaPlayer = new MediaPlayer(media);
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitWidth(450);
videoMediaView.setFitHeight(370);
//audioMediaView
videoPopUp=mediaPath;
audioPopUp=new File(audioFolderPath+audioPaths.get(audioIndex)).getAbsolutePath();
mediaPath=new File(picFolderPath+picturePaths.get(pictureIndex)).getAbsolutePath();
 image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);
         if(audioPaths.size()>0)
 audioName.setText(audioPaths.get(audioIndex));


   videoMediaView.setOnMouseClicked((MouseEvent mouseEvent) -> {
       if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
           if(mouseEvent.getClickCount() == 2){
               Parent home_page_parent;
               try {
                  
                   home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/VideoForm.fxml"));
                   Scene home_page_scene = new Scene(home_page_parent);
                   Stage app_stage = new Stage();
                   app_stage.setScene(home_page_scene);
                   //app_stage.setTitle("Methods");
                   
                   app_stage.show();
               }           catch (IOException ex) {
                   Logger.getLogger(ObjectProfileForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
});
     audioMediaView.setOnMouseClicked((MouseEvent mouseEvent) -> {
       if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
           if(mouseEvent.getClickCount() == 2){
               try {
                   Parent home_page_parent;
                   
                   home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/AudioForm.fxml"));
                   Scene home_page_scene = new Scene(home_page_parent);
                   Stage app_stage = new Stage();
                   app_stage.setScene(home_page_scene);
                   //app_stage.setTitle("Methods");
                   
                   app_stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(ObjectProfileForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
});
    pictureTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
          mediaPlayer.setAutoPlay(false);
        }
    });
    }
    public void videoRemove(){
   videoPaths.remove(videoIndex);
     nextVideo();
    }
     public void pictureRemove(){
    picturePaths.remove(pictureIndex);
      nextPicture();
    }
 
      public void audioRemove(){
         
         audioPaths.remove(audioIndex);
  nextAudio();
    }
    public void nextPicture(){
       
        
                   if(pictureIndex==(picturePaths.size()-1))
             pictureIndex=0;
         else
        pictureIndex=pictureIndex+1;
                   mediaPath=picFolderPath+picturePaths.get(pictureIndex);
        image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);
   
          
    }
        public void previousPicture(){
   
                   if(pictureIndex==0)
             pictureIndex=picturePaths.size()-1;
         else
        pictureIndex=pictureIndex-1;
  mediaPath=picFolderPath+picturePaths.get(pictureIndex);
        image=new Image(new File(mediaPath).toURI().toString());
       pictureView.setImage(image);
    }
        
        
            public void nextVideo() {
        if(videoIndex==(videoPaths.size()-1))
        videoIndex=0;
        else
        videoIndex=videoIndex+1;
          mediaPath=videoFolderPath+videoPaths.get(videoIndex);
        media=new Media(new File(mediaPath).toURI().toString());
        mediaPlayer=new MediaPlayer(media);  
  
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitHeight(450);
videoMediaView.setFitWidth(370);
audioName.setText(videoPaths.get(videoIndex));
 videoPopUp=mediaPath;

    }
        public void previousVideo(){

                     if(videoIndex==0)
             videoIndex=videoPaths.size()-1;
         else
        videoIndex=videoIndex-1;
                         mediaPath=videoFolderPath+videoPaths.get(videoIndex);
        media=new Media(new File(mediaPath).toURI().toString());
        mediaPlayer=new MediaPlayer(media);  
  
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitHeight(450);
videoMediaView.setFitWidth(370);
 videoPopUp=mediaPath;
    }
                    public void nextAudio() {
      
          if(audioIndex==(audioPaths.size()-1))
        audioIndex=0;
        else
        audioIndex=audioIndex+1;
          mediaPath=audioFolderPath+audioPaths.get(audioIndex);
  audioPopUp=mediaPath;
//audioMediaView.setMediaPlayer(mediaPlayer);
//audioMediaView.setFitHeight(400);
//audioMediaView.setFitWidth(400);
audioName.setText(audioPaths.get(audioIndex));


    }
               public void previousAudio(){
                  
                          
                     if(audioIndex==0)
             audioIndex=picturePaths.size()-1;
         else
        audioIndex=audioIndex-1;
   audioPopUp=mediaPath;
   mediaPath=audioFolderPath+audioPaths.get(audioIndex);
audioName.setText(audioPaths.get(audioIndex));

    }
               
  public List<String> listFiles(String directoryName){
        File directory = new File(directoryName);
         MediaPaths=new ArrayList();
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
               MediaPaths.add(file.getName());
            }
        }
        return MediaPaths ;
    }
        

  public static void main(String[] args) {
        launch(args);
    }
    
}
