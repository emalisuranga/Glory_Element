/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer.gameboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Pulasthi Thejan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtRound1;

    @FXML
    private TextField txtRound4;

    @FXML
    private TextField txtRound3;

    @FXML
    private TextField txtRound2;

//    @FXML
//    private Label sLetter1;
//
//    @FXML
//    private Label sLetter2;
//
//    @FXML
//    private Label sLetter3;
//
//    @FXML
//    private Label sLetter4;
//
//    @FXML
//    private Label sLetter5;
//
//    @FXML
//    private Label sLetter8;
//
//    @FXML
//    private Label sLetter6;
//
//    @FXML
//    private Label sLetter7;
//
//    @FXML
//    private Label sLetter9;
//
//    @FXML
//    private Label sLetter11;

    @FXML
    private Label sLetter12;

    @FXML
    private Label constant1;

    @FXML
    private Label constant2;

    @FXML
    private Label constant3;

    @FXML
    private Label letter4;

    @FXML
    private Label letter5;

    @FXML
    private Label letter6;

    @FXML
    private Label letter7;

    @FXML
    private Label letter8;

    @FXML
    private Label letter9;

    @FXML
    private Label letter10;

    @FXML
    private Label letter11;

    @FXML
    private TextField txtTypedWord;
    
    String letters ="";

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    public void checkText()
    {
        Dictionary d = new Dictionary();
        if (txtTypedWord.getText().length() <= 11 && txtTypedWord.getText().length()!= 0 ) {
            Label[] labels ={constant1,constant2,constant3,letter4,letter5,letter6,letter7,letter8,letter9,letter10,letter11};
            for (Label label : labels) {
                letters+=label.getText();
            }

            int flag=0;
            char[] first = txtTypedWord.getText().toUpperCase().toCharArray();
            char[] second = letters.toUpperCase().toCharArray();
            for (int i = 0; i < first.length; i++) {    //Check if the word is created using the given letters
                for (int j = 0; j < second.length; j++) {
                    if (second[j]!=42) {
                        if (first[i]==second[j]) {
                            second[j]=42;
                            first[i]=42;
                            break;
                        }
                    }
                }
            }
            System.out.println(first);
            
            for (int i = 0; i < first.length; i++) {
                if (first[i]!=42) {
                    flag=1;
                }
            }
            if (flag==0) {  //Check if the word is created using the given letters
                System.out.println("Correct word");
                String s = d.checkDictionaryWord(txtTypedWord.getText());
                if (s==null) {  //check if the input word is a correct english word
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Word Error");
                    alert.setHeaderText("Please Enter a valid English word");
                    alert.showAndWait();
                    txtTypedWord.setText("");
                }
                else
                {
                    //word is correct, calling for scoring algorithm
                    System.out.print("Send to Score");
                }
            }
            else
            {
                System.out.println("InCorrect word");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Word Mismatch");
                alert.setHeaderText("Word must be created from given words");
                alert.showAndWait();
                txtTypedWord.setText("");
            }
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("length Error");
            alert.setHeaderText("Word must be less than or equal to 11 and cannot be Empty");
            alert.showAndWait();
            txtTypedWord.setText("");
        }
        
    }
}
