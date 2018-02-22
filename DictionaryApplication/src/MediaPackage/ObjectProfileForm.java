/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
public  static String popUp;
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

    private int i=0;
    ArrayList<String> paths;
protected  String mediaPath;
List<String> MediaPaths;



    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//videoMediaView

mediaPath=new File("src/media/b.MP4").getAbsolutePath();
          
media = new Media(new File(mediaPath).toURI().toString());
mediaPlayer = new MediaPlayer(media);
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitWidth(400);
videoMediaView.setFitHeight(350);
//audioMediaView

mediaPath=new File("src/media/c.jpg").getAbsolutePath();
 image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);
 audioName.setText("a.mp3");


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
                 Parent home_page_parent;
                 try {
                     home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/AudioForm.fxml"));
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
    pictureTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
          mediaPlayer.setAutoPlay(false);
        }
    });
    }
    public void videoRemove(){
        System.out.println(mediaPath);
         File videoFile=new File(mediaPath);
      if(videoFile.exists()){
          videoFile.delete();
      }
     nextVideo();
    }
     public void pictureRemove(){
           System.out.println(mediaPath);
      File pictureFile=new File(mediaPath);
      if(pictureFile.exists()){
          pictureFile.delete();
      }
      nextPicture();
    }
 
      public void audioRemove(){
         
//          mediaPath.replaceAll("\\","\\\\");
         // "C:\\Users\\Abo Ali\\Documents\\NetBeansProjects\\JavaFXApplication14\\src\\media\\Person\\Hasan\\Audio\\03 - فتوى الغرام (عباس بدوي) - YouTube.mp3"
            System.out.println(mediaPath);
         File audioFile=new File(mediaPath);
      if(audioFile.exists()){
          audioFile.delete();
      }
  nextAudio();
    }
    public void nextPicture(){
        paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Pictures");
        String path="src\\media\\Person\\Hasan\\Pictures\\"+paths.get(i);
        i=(i+1)%(paths.size());
        image=new Image(new File(path).toURI().toString());
          pictureView.setImage(image);
          mediaPath=path;
          
    }
        public void previousPicture(){
                    paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Pictures");
   String path="src\\media\\Person\\Hasan\\Pictures\\"+paths.get(i);
   
                   if(i==0)
             i=paths.size()-1;
         else
        i=(i-1)%(paths.size());

  
        image=new Image(new File(path).toURI().toString());
       pictureView.setImage(image);
mediaPath=path;
    }
        
        
            public void nextVideo() {
                
                paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Video");
                System.out.println(paths.get(i));
        String path="src\\media\\Person\\Hasan\\Video\\"+paths.get(i);
        i=(i+1)%(paths.size());
        media=new Media(new File(path).toURI().toString());
        mediaPlayer=new MediaPlayer(media);  
  
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitHeight(400);
videoMediaView.setFitWidth(400);
audioName.setText(paths.get(i));
 popUp=path;
mediaPath=path;
    }
        public void previousVideo(){
            
                   paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Video");
                            String path="src\\media\\Person\\Hasan\\Video\\"+paths.get(i);
                            System.out.println(paths.get(i));
                   if(i==0)
             i=paths.size()-1;
         else
        i=(i-1)%(paths.size());
         media=new Media(new File(path).toURI().toString());
         media=new Media(new File(path).toURI().toString());
        mediaPlayer=new MediaPlayer(media);  
   popUp=path;
videoMediaView.setMediaPlayer(mediaPlayer);
videoMediaView.setFitHeight(400);
videoMediaView.setFitWidth(400);
audioName.setText(paths.get(i));
mediaPath=path;
    }
                    public void nextAudio() {
                paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Audio");
        String path="src\\media\\Person\\Hasan\\Audio\\"+paths.get(i);
                   if(i==paths.size())
             i=0;
         else
        i++;
        
  popUp="src\\media\\Person\\Hasan\\Audio\\"+paths.get(i);
//audioMediaView.setMediaPlayer(mediaPlayer);
//audioMediaView.setFitHeight(400);
//audioMediaView.setFitWidth(400);
audioName.setText(paths.get(i));
mediaPath=path;

    }
               public void previousAudio(){
                   paths=(ArrayList<String>) listFiles("src\\media\\Person\\Hasan\\Audio");
                            String path="src\\media\\Person\\Hasan\\Audio\\"+paths.get(i);
                   if(i==0)
             i=paths.size()-1;
         else
        i=(i-1)%(paths.size());
   popUp="src\\media\\Person\\Hasan\\Audio\\"+paths.get(i);

audioName.setText(paths.get(i));
mediaPath=path;
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
