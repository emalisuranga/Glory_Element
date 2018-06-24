/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer.GameBoard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    
        @FXML
    private TextArea txtTimer;
    
    String letters ="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void checkText()
    {
        if (txtTypedWord.getText().length() <= 11 && txtTypedWord.getText().length()!= 0 ) {
            Label[] labels ={constant1,constant2,constant3,letter4,letter5,letter6,letter7,letter8,letter9,letter10,letter11};
            for (Label label : labels) {
                letters+=label.getText();
            }
            System.out.print(txtTypedWord.getText());
//            String x = txtTypedWord.getText();
//            String y= "AABHMDCG";
            char[] first = txtTypedWord.getText().toCharArray();
            char[] second = letters.toCharArray();
            for (int i = 0; i < first.length; i++) {
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
            for (int i = 0; i < 10; i++) {
                
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
    
    private void clockStart() {            
		//final CountDownClock clock = new CountDownClock();
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception { 
                            int countDownTime = 300;
				while (countDownTime > 0) {
					Platform.runLater(new Runnable() {
						public void run() {
							//txtTimer.setText(clock.getTimeLeft(countDownTime).toString());                                                       
						}
					});
					countDownTime--;
					/**
					 * Check auto submit details
					 */
					//autoSubmit();
					Thread.sleep(1000);
				}
				return null;
			}
		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}

    private static class CountDownClock {

        public CountDownClock() {
        }
    }
}
