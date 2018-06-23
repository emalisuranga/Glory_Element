/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestController {
    static Thread tread = new Thread();
    private double xOffset = 0;
    private double yOffset = 0;
      //@FXML
    //private TextField testText;
 public void loginButtonClicked(){
   System.out.println("User");
   }      
 
  @FXML
    void newPage(ActionEvent event) throws IOException {
       Stage stage = new Stage(); 
      Parent root = FXMLLoader.load(getClass().getResource("FXMLPlayerName.fxml"));
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setScene(new Scene(root));
      stage.show();
      
              root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }
                });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }
    
@FXML private javafx.scene.control.Button closeButton;

@FXML
 public void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}
// @FXML
//      public void timer() throws InterruptedException{
//         for (int i = 60; i >= 0; i--) {
//             tread.sleep(1000);
//             //String a = Integer.toString(i);
//             testText.setText(Integer.toString(i));
//             
//         }
    // }
 @FXML
    void newPage2(ActionEvent event) throws IOException {
       Stage stage = new Stage(); 
      Parent root = FXMLLoader.load(getClass().getResource("LeaderBoard/LeaderBoard.fxml"));
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setScene(new Scene(root));
      stage.show();
      
              root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }
                });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }
}
