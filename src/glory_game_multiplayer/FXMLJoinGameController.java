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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hashan Perera
 */
public class FXMLJoinGameController implements Initializable {

    @FXML
    private TableView<ModelTablejoin> Join_table;
    @FXML
    private AnchorPane join_game;
    @FXML
    private Button btn_back2;
    @FXML
    private TableColumn<ModelTablejoin, String> col_name;
    @FXML
    private TableColumn<ModelTablejoin, String> col_hscore;
    @FXML
    private TableColumn<ModelTablejoin, String> col_online;
    @FXML
    private Button btn_refresh;
    public String pname;

    
    ObservableList<ModelTablejoin> oblist = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Connection con;
        try {
            con = DBConnector.getConnection();
            pname = FXMLPlayerNameController.pname;
            ResultSet rs = con.createStatement().executeQuery("select * from MasterPool where online_status = 1 AND player_name NOT LIKE '" + pname + "'");
          while (rs.next()){
              oblist.add(new ModelTablejoin(rs.getString("player_name"),rs.getString("player_hscore"),rs.getString("online_status"))); 
          }
        } 
        catch (SQLException ex) {
            System.err.println(ex);
        }
        
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_hscore.setCellValueFactory(new PropertyValueFactory<>("hscore"));
        col_online.setCellValueFactory(new PropertyValueFactory<>("online"));
        
                
        Join_table.setItems(oblist);
    }
    @FXML
    private void btn_back2_clicked(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
            join_game.getChildren().setAll(pane);
 
        } catch (IOException e) {
        }
    }
    @FXML
    private void btn_refresh(ActionEvent event) {
        Join_table.refresh();
//        Connection con;
//        try {
//            con = DBConnector.getConnection();
//            ResultSet rs = con.createStatement().executeQuery("select * from MasterPool");
//          while (rs.next()){
//              oblist.add(new ModelTablejoin(rs.getString("player_name"),rs.getString("player_hscore"))); 
//          }
//        } 
//        catch (SQLException ex) {
//            System.err.println(ex);
//        }
//        
//        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        col_hscore.setCellValueFactory(new PropertyValueFactory<>("hscore"));
//                
//        Join_table.setItems(oblist);
    }    
    
    

}
