/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;

import static FxmlFiles.FXMLMediaController.className;
import static FxmlFiles.FXMLMediaController.objectName;
import static MediaPackage.AudioFormController.audioMediaPlayer2;
import static MediaPackage.VideoFormController.m;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class ObjectProfileForm implements Initializable {

    /**
     * Initializes the controller class.
     */
    private File f;
public  static String audioPopUp;
public  static String videoPopUp;
    @FXML private ImageView pictureView;
     @FXML private ImageView videoImageView;
    @FXML private Tab pictureTab;
    @FXML private Tab videoTab;
    @FXML private Tab audioTab;
     @FXML protected MediaView videoMediaView;
      @FXML protected ImageView   audioMediaView;
      @FXML private TextField pictureFilteredField;
      @FXML private TextField audioFilteredField;
      @FXML private TextField videoFilteredField;
      @FXML private ListView pictureFilteredListView; 
      @FXML private ListView audioFilteredListView; 
      @FXML private ListView videoFilteredListView; 
      @FXML private Label audioName;
     public   MediaPlayer videoMediaPlayer;
     public static  MediaPlayer audioMediaPlayer;
     public  static  Stage audioStage;
      public  static  Stage videoStage;
      Media media;
    Image image;

    private int audioIndex=0,videoIndex=0,pictureIndex=0;
    ArrayList<String> videoPaths;
    ArrayList<String> audioPaths;
    ArrayList<String> picturePaths;
private  String mediaPath;
private  String audioPlaying;
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
audioFilteredListView.getItems().addAll(audioPaths);
pictureFilteredListView.getItems().addAll(picturePaths);
videoFilteredListView.getItems().addAll(videoPaths);
if(picturePaths.size()!=0)
    pictureFilteredListView.getSelectionModel().selectFirst();
if(videoPaths.size()!=0)
    videoFilteredListView.getSelectionModel().selectFirst();
if(audioPaths.size()!=0)
{audioFilteredListView.getSelectionModel().selectFirst();
  audioPopUp=new File(audioFolderPath+audioFilteredListView.getSelectionModel().getSelectedItem()).getAbsolutePath();
    System.out.println(audioPopUp);}
//mediaPath=new File(videoPaths.get(videoIndex)).getAbsolutePath();
if(videoPaths.size()>0)
{
    mediaPath=new File(videoFolderPath+videoPaths.get(videoIndex)).getAbsolutePath();
videoPopUp=mediaPath;
          videoFilteredField.textProperty().addListener((observable, oldValue, newValue) -> {
       videoFilteredListView.getItems().clear();
    String filteredValue=videoFilteredField.getText();
        for (int i = 0; i < videoPaths.size(); i++) 
            if(videoPaths.get(i).contains(filteredValue))
               videoFilteredListView.getItems().add(videoPaths.get(i));
          });
          
//media = new Media(new File(videoPopUp).toURI().toString());
//videoMediaPlayer = new MediaPlayer(media);
//videoMediaView.setMediaPlayer(videoMediaPlayer);
videoMediaView.setFitWidth(345);
videoMediaView.setFitHeight(370);
//audioMediaView
}
videoFilteredListView.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> {
         if(newValue!=null){
             mediaPath=videoFolderPath+videoFilteredListView.getSelectionModel().getSelectedItem();
//         String   po=new File(videoFolderPath+newValue.toString()).getAbsolutePath();
//           videoPopUp=po;
//             f=new File(mediaPath);
//           media = new Media(f.toURI().toString());
//           videoMediaPlayer = new MediaPlayer(media);
//           videoMediaView.setMediaPlayer(videoMediaPlayer);
         }       
        });



if(audioPaths.size()>0)
{ 
   // audioPopUp=new File(audioFolderPath+audioFilteredListView.getSelectionModel().getSelectedItem()).getAbsolutePath();
    
    audioName.setText(audioPaths.get(audioIndex));
    
   

}
audioFilteredListView.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> {
         if(newValue!=null){
           audioPlaying=new File(audioFolderPath+newValue.toString()).getAbsolutePath();
           audioPopUp=audioPlaying;
        }
         System.out.println(audioPopUp);
              
         
         System.out.println(oldValue);
          System.out.println(newValue);
         audioName.setText(newValue.toString());
         
        });

 audioFilteredField.textProperty().addListener((observable, oldValue, newValue) -> {
       audioFilteredListView.getItems().clear();
    String filteredValue=audioFilteredField.getText();
        for (int i = 0; i < audioPaths.size(); i++) 
            if(audioPaths.get(i).contains(filteredValue))
               audioFilteredListView.getItems().add(audioPaths.get(i));
          });
 
 pictureFilteredField.textProperty().addListener((observable, oldValue, newValue) -> {
       pictureFilteredListView.getItems().clear();
    String filteredValue=pictureFilteredField.getText();
        for (int i = 0; i < picturePaths.size(); i++) 
            if(picturePaths.get(i).contains(filteredValue))
               pictureFilteredListView.getItems().add(picturePaths.get(i));
          });
 
if(picturePaths.size()>0)
{mediaPath=new File(picFolderPath+picturePaths.get(pictureIndex)).getAbsolutePath();
image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);}

pictureFilteredListView.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> {
         if(newValue!=null){
         mediaPath=new File(picFolderPath+newValue.toString()).getAbsolutePath();
image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);
        }
        
         
        });
   videoImageView.setOnMouseClicked((MouseEvent mouseEvent) -> {
       if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
           if(mouseEvent.getClickCount() == 2){
               Parent home_page_parent;
               try {                 
                  home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/VideoForm.fxml"));
                   Scene home_page_scene = new Scene(home_page_parent);
                   Stage app_stage = new Stage();
                   app_stage.setScene(home_page_scene);
                   //app_stage.setTitle("Methods");
                  // videoStage=app_stage;
                app_stage.setOnCloseRequest((WindowEvent event) -> {
            System.out.println("Closing......");
            videoMediaView=null;///////
            m.dispose();
            m=null;
            event.consume();
            //videoStage.close();
              app_stage.close();
        });
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
                   home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/VideoForm.fxml"));
                   Scene home_page_scene = new Scene(home_page_parent);
                   Stage app_stage = new Stage();
                   app_stage.setScene(home_page_scene);
                   //app_stage.setTitle("Methods");
                 //  audioStage=app_stage;
       
                     app_stage.setOnCloseRequest((WindowEvent event) -> {
            System.out.println("Closing......");
//            audioMediaPlayer.pause();
//            audioMediaPlayer=new MediaPlayer(new Media(new File("./src/images/tt.mp3").toURI().toString()));
//            audioMediaPlayer.stop();
//audioMediaPlayer=null;
//           audioMediaPlayer2.dispose();
//            audioMediaPlayer2=null;
            videoMediaView=null;///////
            m.dispose();
            m=null;
            event.consume();
          //  audioStage.close();
            app_stage.close();
            //home_page_scene= new Scene();            
        });
                   app_stage.show();
               } catch (IOException ex) {
                   Logger.getLogger(ObjectProfileForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
});
    }
    public void videoRemove() throws IOException{//try{
  
        if(videoPaths.size()>0){
          String targetPath=videoFolderPath+videoFilteredListView.getSelectionModel().getSelectedItem().toString();
           // System.out.println(targetPath);
        Path target = FileSystems.getDefault().getPath(targetPath);
        System.out.println(targetPath);
          if(Files.deleteIfExists(target))
             videoPaths.remove(videoFilteredListView.getSelectionModel().getSelectedItem().toString());
         videoFilteredListView.getItems().remove(videoFilteredListView.getSelectionModel().getSelectedItem().toString());
     }
  //  }catch(Exception ex){
        //System.out.println(ex.getMessage());
//    Alert alert = new Alert(AlertType.ERROR);
//alert.setTitle("Media Information");
//alert.setHeaderText("Look, an Error Dialog");
//alert.setContentText("Ooops, there are no Videos please check your video!");
//
//alert.showAndWait();
}
    
     public void pictureRemove() throws IOException{
        try{
         String targetPath=picFolderPath+pictureFilteredListView.getSelectionModel().getSelectedItem();;
        Path target = FileSystems.getDefault().getPath(targetPath);
       
          if(Files.deleteIfExists(target))
            picturePaths.remove(pictureFilteredListView.getSelectionModel().getSelectedItem());
            pictureFilteredListView.getItems().remove(pictureFilteredListView.getSelectionModel().getSelectedItem());
            pictureFilteredListView.getSelectionModel().selectFirst();   
         nextPicture();
     }
           catch(Exception ex){System.out.println(ex.getMessage());
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Pictures please check your Pictures!");

alert.showAndWait();
}
    }
 
       public void audioRemove() throws IOException{
           try{
        String targetPath=audioFolderPath + audioFilteredListView.getSelectionModel().getSelectedItem();
        Path target = FileSystems.getDefault().getPath(targetPath);//targetPath
       
         if(Files.deleteIfExists(target))
        audioPaths.remove(audioFilteredListView.getSelectionModel().getSelectedItem());
         audioFilteredListView.getItems().remove(audioFilteredListView.getSelectionModel().getSelectedItem());
         audioFilteredListView.getSelectionModel().selectFirst();
        // nextAudio();
         
           }    catch(Exception ex){System.out.println(ex.getMessage());
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Audio please check your Audio!");

alert.showAndWait();
}
    }
    public void nextPicture(){
        pictureIndex=pictureFilteredListView.getSelectionModel().getSelectedIndex();
        pictureFilteredListView.getSelectionModel().selectNext();
        if(picturePaths.size()>0){
                   if(pictureIndex==(picturePaths.size()-1))
             pictureIndex=0;
         else
        pictureIndex=pictureIndex+1;
                   mediaPath=picFolderPath+picturePaths.get(pictureIndex);
        image=new Image(new File(mediaPath).toURI().toString());
          pictureView.setImage(image);
        }
        else{
            
   
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Pictures please check your pictures!");

alert.showAndWait();


        }
   
          
    }
        public void previousPicture(){
            pictureIndex=pictureFilteredListView.getSelectionModel().getSelectedIndex();
            pictureFilteredListView.getSelectionModel().selectPrevious();
   if(picturePaths.size()>0){
                   if(pictureIndex==0)
             pictureIndex=picturePaths.size()-1;
         else
        pictureIndex=pictureIndex-1;
  mediaPath=picFolderPath+picturePaths.get(pictureIndex);
        image=new Image(new File(mediaPath).toURI().toString());
       pictureView.setImage(image);
    }
   
           else{
            
   
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Pictures please check your pictures!");

alert.showAndWait();


        }
        }
        
        
            public void nextVideo() {try{
                videoIndex=videoFilteredListView.getSelectionModel().getSelectedIndex();
            videoFilteredListView.getSelectionModel().selectNext();
//                if(videoPaths.size()>0){
//        if(videoIndex==(videoPaths.size()-1))
//        videoIndex=0;
//        else
//        videoIndex=videoIndex+1;
//          mediaPath=videoFolderPath+videoPaths.get(videoIndex);
//        media=new Media(new File(mediaPath).toURI().toString());
//        videoMediaPlayer=new MediaPlayer(media);  
//  
//videoMediaView.setMediaPlayer(videoMediaPlayer);
////videoMediaView.setFitWidth(345);
////videoMediaView.setFitHeight(370);
// videoPopUp=mediaPath;
               // }
                //else{
            }catch(Exception ex){
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Videos please check your videos!");

alert.showAndWait();
//}
    }}
        public void previousVideo(){try{
             videoIndex=videoFilteredListView.getSelectionModel().getSelectedIndex();
            videoFilteredListView.getSelectionModel().selectPrevious();
//if(videoPaths.size()>0){
//                     if(videoIndex==0)
//             videoIndex=videoPaths.size()-1;
//         else
//        videoIndex=videoIndex-1;
//                         mediaPath=videoFolderPath+videoPaths.get(videoIndex);
//        media=new Media(new File(mediaPath).toURI().toString());
//        videoMediaPlayer=new MediaPlayer(media);  
//  
//videoMediaView.setMediaPlayer(videoMediaPlayer);
//videoMediaView.setFitWidth(345);
//videoMediaView.setFitHeight(370);
// videoPopUp=mediaPath;}
// else{
        }catch(Exception ex){
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Videos please check your videos!");

alert.showAndWait();
//}
    }}
                    public void nextAudio() {
                        audioIndex=audioFilteredListView.getSelectionModel().getSelectedIndex();
            audioFilteredListView.getSelectionModel().selectNext();
      if(audioPaths.size()>0){
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
      else{
    Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Media Information");
alert.setHeaderText("Look, an Error Dialog");
alert.setContentText("Ooops, there are no Audio please check your Audio!");

alert.showAndWait();
}
    }
               public void previousAudio(){
                   audioIndex=audioFilteredListView.getSelectionModel().getSelectedIndex();
            audioFilteredListView.getSelectionModel().selectPrevious();
//                           if(audioPaths.size()>0){ 
//                     if(audioIndex==0)
//             audioIndex=picturePaths.size()-1;
//         else
//        audioIndex=audioIndex-1;
//   audioPopUp=mediaPath;
//   mediaPath=audioFolderPath+audioPaths.get(audioIndex);
audioName.setText(audioFilteredListView.getSelectionModel().getSelectedItem().toString());
                           //}
                        //   else{
//    Alert alert = new Alert(AlertType.ERROR);
//alert.setTitle("Media Information");
//alert.setHeaderText("Look, an Error Dialog");
//alert.setContentText("Ooops, there are no Audio please check your Audio!");
//
//alert.showAndWait();
}
    //}
               
  public List<String> listFiles(String directoryName){
        File directory = new File(directoryName);
         MediaPaths=new ArrayList<String>();
        //get all the files from a directory
        File[] fList = directory.listFiles();
        if(fList.length==0)
            return MediaPaths;
        for (File file : fList){
            if (file.isFile()){
               MediaPaths.add(file.getName());
            }
        }
        return MediaPaths ;
    }
  public void Back(Event event){
        try{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/FxmlFiles/FXMLMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
         home_page_scene.getStylesheets().add("/css/simple.css");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        stage.show();
      }
catch(Exception ex){
}
  }
        

  public static void main(String[] args) {
        launch(args);
    }
    
}
