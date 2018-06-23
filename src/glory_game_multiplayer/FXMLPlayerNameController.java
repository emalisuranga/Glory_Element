/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hashan Perera
 */
public class FXMLPlayerNameController implements Initializable {

    @FXML
    private AnchorPane player_name;
    @FXML
    private Button btn_enter;
    @FXML
    private Button Player_back;
    @FXML
    private TextField field_name;
    @FXML
    private Label info;

    AnchorPane root = new AnchorPane();
    Scene scene = new Scene(root);
    
    public static String pname;
     

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
 
    @FXML
    private void btn_enter_clicked(ActionEvent event) throws IOException, SQLException {

        Connection connection;
        System.out.println("Tile pressed ");
        pname = field_name.getText();
        try {
            connection = DBConnector.getConnection();
//            pname = field_name.getText();
            if (connection != null) {
                System.out.println("Connected");

//                String pname = field_name.getText();
                int rows = 0;
                Statement stmt = connection.createStatement();
                String selectQuery = "select player_name from MasterPool where player_name='" + pname + "'";
                System.out.println(selectQuery);
                ResultSet rs = stmt.executeQuery(selectQuery);
                rs.first(); //rs.last();rs.first();

                if (rs.getRow() > 0) {
                    String name = rs.getString("player_name");
                    if (name != null) //Check value is ex 
                    {
                        System.out.println(rs.getString(1));
                        System.out.println("Nick Name Already Exist - welcome");
                        String sql = "update MasterPool set online_status = 1  where `player_name` = '" + pname + "'";
                        stmt.executeUpdate(sql);

                        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
                        player_name.getChildren().setAll(pane);

                    }

                } else {
                    System.out.println("Nick Name Already Tot Exist - welcome");
                    //String sql = "insert into MasterPool(player_name) values('" + pname + "')";
                    //stmt.executeUpdate(sql);     
                    rows = stmt.executeUpdate("insert into MasterPool(player_name) values('" + pname + "')");
                    System.out.println("Rows inserted = " + rows);

                    String sql = "update MasterPool set online_status = 1  where `player_name` = '" + pname + "'";
                    int res = stmt.executeUpdate(sql);

                    System.out.println("online");

                    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
                    player_name.getChildren().setAll(pane);

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void Player_back_clicked(ActionEvent event) throws IOException, SQLException {
        try {
            Connection connection = DBConnector.getConnection();
            pname = FXMLPlayerNameController.pname;
            Statement stmt = connection.createStatement();
            String sql = "update MasterPool set online_status = 0  where `player_name` = '" + pname + "'";
            int res = stmt.executeUpdate(sql);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
            player_name.getChildren().setAll(pane);
        } catch (IOException e) {
        }
    }
    
    public void close(){
    System.exit(0);
    }

}
