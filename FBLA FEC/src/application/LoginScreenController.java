package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController implements Initializable {
		public LoginModel loginModel = new LoginModel();
		
		@FXML
		private TextField txtUsername;
		
		@FXML 
		private PasswordField txtPassword;
		
		@Override
		public void initialize(URL location, ResourceBundle resources){
			
		}
		
		public void Login (ActionEvent event)
		{
			try{
				if(loginModel.isLogin(txtUsername.getText(), txtPassword.getText())){
					System.out.println("Good");
				} 
				else {
					System.out.println("Bad");
				}
			} 
			catch (SQLException e){
				e.printStackTrace();
			}		
		}	
}

