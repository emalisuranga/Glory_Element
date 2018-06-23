/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import java.io.IOException;
import static java.lang.System.exit;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hashan Perera
 */
public class FXMLCreateGameController implements Initializable {

    @FXML
    private AnchorPane create_game;
    @FXML
    private TableView<ModelTableCreate> table_creategame;
    @FXML
    private TableColumn<ModelTableCreate, String> col_p_name;
    @FXML
    private TableColumn<ModelTableCreate, String> col_p_hscore;
    @FXML
    private TableColumn<ModelTableCreate, String> col_p_online;
    @FXML
    private Button btn_back1;
    @FXML
    private Button btn_refresh;

    ObservableList<ModelTableCreate> oblist1 = FXCollections.observableArrayList();
    @FXML
    private TableView<?> selected_players;
    @FXML
    private Button btn_request;
    @FXML
    private TextField field_name;
    public String pname;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //String pname = field_name.getText();

    }

    @FXML
    private void btn_back1_clicked(ActionEvent event) throws IOException, SQLException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHostMenu.fxml"));
            create_game.getChildren().setAll(pane);
        } catch (IOException e) {
        }
    }

    @FXML
    private void btn_refresh(ActionEvent event) {
        Connection con;
        // User ID acquired from a textbox called txt_user_id
//        String user_id =Label_name.getText();
        try {
            con = DBConnector.getConnection();
            pname = FXMLPlayerNameController.pname;

            ResultSet rs = con.createStatement().executeQuery("select * from MasterPool where online_status = 1 AND player_name NOT LIKE '" + pname + "'");
            while (rs.next()) {
                oblist1.add(new ModelTableCreate(rs.getString("player_name"), rs.getString("player_hscore"), rs.getString("online_status")));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        col_p_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_p_hscore.setCellValueFactory(new PropertyValueFactory<>("hscore"));
        col_p_online.setCellValueFactory(new PropertyValueFactory<>("online"));

        table_creategame.setItems(oblist1);
    }

        public void close(){
            
        System.exit(0);
        }

//    @FXML
//    private void sel_row(MouseEvent event) {
//        try {
//           
//            
//        } catch (Exception e) {
//            System.err.println(e);
//        }

    @FXML
    private void btn_reqsend(ActionEvent event) {
    }

}