/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;

/**
 *
 * @author Hashan Perera
 */
public class Glory_Game_Multiplayer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Group res = new Group();
//        Image image = new Image("522499");
//        ImageView view = new ImageView(image);
//        res.getChildren().add(view);
//        Scene sc = new Scene(res ,300,200.Color.TRANSPARENT);
//        stage.setScene(sc);
//        stage.show();
       
        
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
