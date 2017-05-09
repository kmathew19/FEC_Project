package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.sun.prism.paint.Color;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class AboutScreenController implements Initializable {
	
	public Main_Menu_EmployeeModel Employee_Table_Screen = new Main_Menu_EmployeeModel();
	
    private int temp;
    
    @FXML
	private TreeTableView<String> treeTableMenu;
	@FXML
	private TreeTableColumn<String, String> treeTableMenuColumn;
	@FXML
	private JFXDrawer topDrawer;
	@FXML
	private JFXButton buttonDetails;
	@FXML
	private JFXButton buttonSchedule;
	@FXML
	private JFXButton buttonCustomer;
	@FXML
	private JFXButton buttonReports;
	@FXML
	private JFXButton buttonAbout;
	@FXML
	private JFXButton buttonExit;
	@FXML
	private HBox hbMenu;
	
	
	@FXML
	private BorderPane root;
	
	public static BorderPane rootP;
	
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
        buttonDetails.setGraphic(new ImageView("application/ic_perm_identity_white_48pt.png"));
        buttonSchedule.setGraphic(new ImageView("application/ic_date_range_white_48pt.png"));
        buttonCustomer.setGraphic(new ImageView("application/ic_group_white_2x.png"));
        buttonReports.setGraphic(new ImageView("application/ic_insert_chart_white_2x.png"));
        buttonAbout.setGraphic(new ImageView("application/ic_info_outline_white_48pt.png"));
        buttonExit.setGraphic(new ImageView("application/ic_clear_white_48pt.png"));
       
        for(Node node: hbMenu.getChildren()){
    		if(node.getAccessibleText()!=null){
    			node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
    				switch(node.getAccessibleText()){
    				case "Employee Details":
    					BorderPane pane;
    					try {
    						pane = FXMLLoader.load(getClass().getResource("Main_Menu_Employee.fxml"));
    						root.getChildren().setAll(pane);
    					} catch (IOException e3) {
    						// TODO Auto-generated catch block
    						e3.printStackTrace();
    					}
    					break;
    				case "Schedule Employee":
    					AnchorPane pane1;
    					try {
    						pane1 = FXMLLoader.load(getClass().getResource("Employee_Scheduler.fxml"));
    						root.getChildren().setAll(pane1);
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					break;
    				case "Customer Attendance":
    					AnchorPane pane2;
    					try {
    						pane2 = FXMLLoader.load(getClass().getResource("Menu_Customer_Attendance.fxml"));
    						root.getChildren().setAll(pane2);
    					} catch (IOException e2) {
    						// TODO Auto-generated catch block
    						e2.printStackTrace();
    					}
    					break;
    				case "Reports":
    					BorderPane pane3;
    					try {
    						pane3 = FXMLLoader.load(getClass().getResource("ReportScreen.fxml"));
    						root.getChildren().setAll(pane3);
    					} catch (IOException e4) {
    						// TODO Auto-generated catch block
    						e4.printStackTrace();
    					}
    					break;
    				case "About":
    					BorderPane pane4;
    					try {
    						pane4 = FXMLLoader.load(getClass().getResource("About.fxml"));
    						root.getChildren().setAll(pane4);
    					} catch (IOException e5) {
    						// TODO Auto-generated catch block
    						e5.printStackTrace();
    						break;
    					}
    				case "Exit":
    					System.exit(0);
    				}
    			});
    		}
    	}
    	
    }	
    
}


	

