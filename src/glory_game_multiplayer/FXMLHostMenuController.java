/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hashan Perera
 */
public class FXMLHostMenuController implements Initializable {

    @FXML
    private Button btn_back;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_join;
    @FXML
    private AnchorPane host_menu;
    public String pname;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    AnchorPane root = new AnchorPane();
    Scene scene = new Scene(root);

    @FXML
    private void btn_back_clicked(ActionEvent event) throws IOException, SQLException {

        try {
            Connection connection = DBConnector.getConnection();
            pname = FXMLPlayerNameController.pname;

            Statement stmt = connection.createStatement();
            String sql = "update MasterPool set online_status = 0  where `player_name` = '" + pname + "'";
            int res = stmt.executeUpdate(sql);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            host_menu.getChildren().setAll(pane);
        } catch (IOException e) {
        }
    }

    @FXML
    private void btn_create_clicked(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLCreateGame.fxml"));
            host_menu.getChildren().setAll(pane);
        } catch (IOException e) {
        }
    }

    @FXML
    private void btn_join_clicked(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLJoinGame.fxml"));
            host_menu.getChildren().setAll(pane);
        } catch (IOException e) {
        }
    }
}
