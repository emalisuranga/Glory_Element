/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hashan Perera
 */
public class DBConnector {
    public static Connection getConnection() throws SQLException
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://glorydbase.czf6425elolu.ap-south-1.rds.amazonaws.com:3306/DBGlory?zeroDateTimeBehavior=convertToNull","glory","glory123");
    
      return connection;
    }
}
