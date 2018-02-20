/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;


import DictionaryApplication.Generator;
import static FxmlFiles.DictionaryStart.pool;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aya
 */
public class FXMLMediaController implements Initializable {
    private String sourcePath;
    private String targetPath;
    @FXML
private ComboBox classNames;
@FXML
private ComboBox objectNames;

@FXML private MediaView mv;

@FXML private MediaView mv2;

@FXML private ImageView iv;

private MediaPlayer mp,mp2;
private Media me,me2;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        classNames.getItems().addAll(Generator.getClassNames());
//            
//        String path=new File("src/media/a.mp3").getAbsolutePath();
//        me=new Media(new File(path).toURI().toString());
//        mp=new MediaPlayer(me);
//        mv.setMediaPlayer(mp);
//        String path2=new File("src/media/b.mp4").getAbsolutePath();
//        me2=new Media(new File(path2).toURI().toString());
//        mp2=new MediaPlayer(me2);
//       mv2.setMediaPlayer(mp2);
        // TODO
    }    
    
     public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }
     
    public void classObjects(ActionEvent event){
        objectNames.getItems().addAll(pool.get(classNames.getValue().toString()).keySet());
//        Set<SuperType> keys=dictionaries.get(classNames.getValue().toString()).getElements().keySet();
//        if(keys==null)
//            System.out.println("empty");
//        if(keys.size()==0)
//            System.out.println("0");
//      //  System.out.println(keys.size());
////        System.out.println(keys.toArray()[0].toString());
//        List<String> poolKeys= Generator.getClassObject(classNames.getValue().toString());
//        for(SuperType key:keys)
//            System.out.println(key.toString());
//        for(String key:poolKeys){System.out.println(key);
//            System.out.println(keys.size());
//            if(keys.contains(pool.get(classNames.getValue().toString()).get(key)))
//                objectNames.getItems().add(key);
//        }
//objectNames.getItems().addAll(dictionaries.get(classNames.getValue().toString()).getElements().keySet());
    }
    
       public void Image(ActionEvent event) throws IOException {
       
          FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(

    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
    new FileChooser.ExtensionFilter("GIF", "*.gif"),
    new FileChooser.ExtensionFilter("BMP", "*.bmp"),
    new FileChooser.ExtensionFilter("PNG", "*.png")
);
                File file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
         System.out.println(file.toString());
          sourcePath = file.getAbsolutePath();
        Image image=new Image(new File(sourcePath).toURI().toString());
        iv.setImage(image);
        targetPath=String.format(".\\media\\%s\\%s\\Pictures\\%s",classNames.getValue().toString(),objectNames.getValue().toString(),file.getName());
     
     
           
       }
       
          public void Video(ActionEvent event) throws IOException {
              
              FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter("Media files (*.mp4)", "*.mp4")
);
      File file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
         System.out.println(file.toString());
         String path2=new File(file.toString()).getAbsolutePath();
        me2=new Media(new File(path2).toURI().toString());
        mp2=new MediaPlayer(me2);
        mv2.setMediaPlayer(mp2);
        mp2.play();

              
          }
          
         public void Audio(ActionEvent event) throws IOException {
             
             
        FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter("Media files (*.mp3)", "*.mp3")
);
        File file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
 String path=new File(file.toString()).getAbsolutePath();
        me=new Media(new File(path).toURI().toString());
        mp=new MediaPlayer(me);
        mv.setMediaPlayer(mp);
             System.out.println(file.getName());
         
        //mp.play();

String audioPath="C:\\Users\\Abo Ali\\Documents\\NetBeansProjects\\java\\DictionaryApplication\\src\\media\\"+classNames.getValue().toString()+"\\issa\\Audio\\"+file.getName();
             System.out.println(audioPath);
             System.out.println(path);
//              Path movefrom = FileSystems.getDefault().getPath("C:\\Users\\Issa\\Desktop\\Issaa\\aa.jpg");
//              Path target = FileSystems.getDefault().getPath(".\\media\\Person\\issa\\Pictures\\s.jpg");
       
                 
                //moveFileToDirectory(file,audioPath);
             }
         private boolean moveFileToDirectory(File sourceFile, String targetPath) {
    File tDir = new File(targetPath);
    if (tDir.exists()) {
        String newFilePath = targetPath+File.separator+sourceFile.getName();
        File movedFile = new File(newFilePath);
        if (movedFile.exists())
            movedFile.delete();
        return sourceFile.renameTo(new File(newFilePath));
    } else {
        System.out.println("unable to move file "+sourceFile.getName()+" to directory "+targetPath+" -> target directory does not exist");
        return false;
    }       
}
         
         public void AttachMedia(ActionEvent event) throws IOException {
             File f=new File(targetPath);
             if(f.exists()==false){
             Path movefrom = FileSystems.getDefault().getPath(sourcePath);
              Path target = FileSystems.getDefault().getPath(targetPath);
             Files.move(movefrom,target,  StandardCopyOption.REPLACE_EXISTING);
         
             }
         }
         }
    

