/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Generator;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    private  File file;
    private  String mediaFileName;
    private String sourcePath;
    private String targetPath;
    public static String className, objectName;
    @FXML
    private ComboBox classNames;
    @FXML
    private ComboBox objectNames;

    @FXML
    private MediaView mv;

    @FXML
    private MediaView mv2;

    @FXML
    private ImageView iv;

    @FXML
    private TextField mediaName;

    private MediaPlayer mp, mp2;
    private Media me, me2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaName.setEditable(false);
        classNames.getItems().addAll(dictionaries.keySet());
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
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getStylesheets().add("/css/simple.css");
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    public void classObjects(ActionEvent event) {
        objectNames.getItems().clear();
        objectNames.getItems().addAll(Generator.dictionaryObjects(classNames.getValue().toString()));

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
        try {
            mediaName.setEditable(false);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("jpg", "*.jpg"),
                    new FileChooser.ExtensionFilter("gif", "*.gif"),
                    new FileChooser.ExtensionFilter("jpeg", "*.jpeg"),
                    new FileChooser.ExtensionFilter("png", "*.png")
            );
             file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
            System.out.println(file.toString());
            sourcePath = file.getAbsolutePath();
            Image image = new Image(new File(sourcePath).toURI().toString());
            iv.setImage(image);
            mediaName.setEditable(true);
            mediaName.setText(file.getName().substring(0,file.getName().lastIndexOf(".")));
        } catch (Exception e) {System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("choose a compatable file format");
            alert.showAndWait();
        }
    }

    public void Video(ActionEvent event) throws IOException {
        try {
            mediaName.setEditable(false);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Media files (*.mp4)", "*.mp4"));

            // File file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
             file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
            sourcePath = file.getAbsolutePath();
            me2 = new Media(new File(sourcePath).toURI().toString());
            mp2 = new MediaPlayer(me2);
            mv2.setMediaPlayer(mp2);

            mediaName.setEditable(true);
            mediaName.setText(file.getName().substring(0,file.getName().lastIndexOf(".")));
           
        } catch (Exception e) {System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("choose a compatable file format");
            alert.showAndWait();
        }

    }

    public void Audio(ActionEvent event) throws IOException {
        try {
            mediaName.setEditable(false);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Media files (*.mp3)", "*.mp3")
            );
             file = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
            sourcePath = file.getAbsolutePath();
            me = new Media(new File(sourcePath).toURI().toString());
            mp = new MediaPlayer(me);
//        mv.setMediaPlayer(mp);

            mediaName.setEditable(true);
           mediaName.setText(file.getName().substring(0,file.getName().lastIndexOf(".")));
            //mp.play();
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("choose a compatable file format");
            alert.showAndWait();
        }

//String audioPath="C:\\Users\\Abo Ali\\Documents\\NetBeansProjects\\java\\DictionaryApplication\\src\\media\\"+classNames.getValue().toString()+"\\issa\\Audio\\"+file.getName();
//             System.out.println(audioPath);
//             System.out.println(path);
//              Path movefrom = FileSystems.getDefault().getPath("C:\\Users\\Issa\\Desktop\\Issaa\\aa.jpg");
//              Path target = FileSystems.getDefault().getPath(".\\media\\Person\\issa\\Pictures\\s.jpg");
        //moveFileToDirectory(file,audioPath);
    }

    private boolean moveFileToDirectory(File sourceFile, String targetPath) {
        File tDir = new File(targetPath);
        if (tDir.exists()) {
            String newFilePath = targetPath + File.separator + sourceFile.getName();
            File movedFile = new File(newFilePath);
            if (movedFile.exists()) {
                movedFile.delete();
            }
            return sourceFile.renameTo(new File(newFilePath));
        } else {
            System.out.println("unable to move file " + sourceFile.getName() + " to directory " + targetPath + " -> target directory does not exist");
            return false;
        }
    }

    public void AttachMedia(ActionEvent event) throws IOException {
          mediaFileName = mediaName.getText() + file.getName().substring(file.getName().lastIndexOf("."));
          System.out.println(mediaFileName);
          if(mediaFileName.contains("mp4") || mediaFileName.contains("MP4"))
            targetPath = String.format(".\\media\\%s\\%s\\Video\\%s", classNames.getValue().toString(), objectNames.getValue().toString(), mediaFileName);
            if(mediaFileName.contains("mp3"))
            targetPath = String.format(".\\media\\%s\\%s\\Audio\\%s", classNames.getValue().toString(), objectNames.getValue().toString(), mediaFileName);
            if(mediaFileName.contains("png") || mediaFileName.contains("jpg") || mediaFileName.contains("gif") || mediaFileName.contains("jpeg"))
            targetPath = String.format(".\\media\\%s\\%s\\Pictures\\%s", classNames.getValue().toString(), objectNames.getValue().toString(), mediaFileName);
        System.out.println(targetPath);
        System.out.println(sourcePath);
        
        try {
            File f=new File(targetPath);
            if (f.exists() == false) {
                Path movefrom = FileSystems.getDefault().getPath(sourcePath);
                Path target = FileSystems.getDefault().getPath(targetPath);
                Files.copy(movefrom, target, StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (Exception e) {System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("please fill all the required fields");
            alert.showAndWait();
        }
  mediaName.setText("");
    }

    public void showProfile(ActionEvent event) throws IOException {
    //  try{
        className = classNames.getValue().toString();
        objectName = objectNames.getValue().toString();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/ObjectProfileForm.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        stage.show();
     // }
//     catch(Exception ex){
//              
//          Alert alert = new Alert(Alert.AlertType.ERROR);
//alert.setTitle("Media Information");
//alert.setHeaderText("Look, an Error Dialog");
//alert.setContentText("Please choose your class and object");
//
//alert.showAndWait();
//     }
     
    }
}
