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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hashan Perera
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_exit;
    @FXML
    private AnchorPane main_manu;

//    @FXML
//    private Label label;
////    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//      AnchorPane root = new AnchorPane();
//      Scene scene = new Scene(root);

//    @FXML
//    public void btn_play_clicked(ActionEvent event) throws Exception {
//        try {
//            AnchorPane pane =FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
//            main_manu.getChildren().setAll(pane);
//        } catch (IOException e) {
//        }
//    }
//  
//    private void btn_play_clicked(MouseEvent event) {
//
//        try {
//            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
//            main_manu.getChildren().setAll(pane);
//        } catch (IOException e) {
//        }
//    }
    @FXML
    private void btn_play_clicked(ActionEvent event) {
//        try {
//            Parent transferParent =FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
//            Scene transferScene = new Scene(transferParent);
//            Stage window = Stage
//            
//        } catch (IOException e) {
//            
//        }
    }

    @FXML
    private void btn_exit_clicked(ActionEvent event) {
        System.exit(0);
    }

}
