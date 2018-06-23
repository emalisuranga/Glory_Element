///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package glory_game_multiplayer;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.layout.AnchorPane;
//
///**
// *
// * @author Hashan
// */
//public class UserStatus {
//
//    Connection connection;
//
//    public Boolean ValidateUser(String userName) {
//
//        Boolean status = false;
//        int rows = 0;
//        try {
//            connection = DBConnector.getConnection();
//            if (connection != null) {
//                System.out.println("Connected");
//
//                Statement stmt = connection.createStatement();
//                String selectQuery = "select player_name from MasterPool where player_name='" + userName + "'";
//                System.out.println(selectQuery);
//                ResultSet rs = stmt.executeQuery(selectQuery);
//                rs.first();// rs.next(); rs.last();
//                String name = rs.getString("player_name");
//                if (name != null) //Check value is ex or not
//                {
//                    System.out.println(rs.getString(1));
//                    stmt = connection.createStatement();
//                    String sql = "update MasterPool set online_status = 1  where `player_name` = '" + userName + "'";
//                    rows = stmt.executeUpdate(sql);
//                    System.out.println("player online");
//
//                } else {
//
//                    rows = stmt.executeUpdate("insert into MasterPool(player_name) values('" + userName + "')");
//                    System.out.println("Rows inserted = " + rows);
//                }
//            }
//            
//            status 
//
//        } catch (Exception e) {
//        }
//
//        return status;
//
//    }
//
//}
