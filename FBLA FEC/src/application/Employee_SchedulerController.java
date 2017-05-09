package application;

import java.awt.print.PageFormat;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;

public class Employee_SchedulerController implements Initializable {
	
	public Employee_Shift_SchedulerModel Scheduler_Table = new Employee_Shift_SchedulerModel();
	
	@FXML
	private JFXDatePicker dtSchedule;
	@FXML
	private JFXComboBox<String> cbEmployee;
	@FXML
	private JFXComboBox<String> cbDOW;
	@FXML
	private JFXCheckBox cbAM;
	@FXML
	private JFXCheckBox cbPM;
	@FXML
	private Button txtAdd;
	@FXML
	private Button txtDelete;
	
	
	@FXML
	private ListView<String> listSun;
	@FXML
	private ListView<String> listMon;
	@FXML
	private ListView<String> listTues;
	@FXML
	private ListView<String> listWed;
	@FXML
	private ListView<String> listThurs;
	@FXML
	private ListView<String> listFri;
	@FXML
	private ListView<String> listSat;
	@FXML
	private ListView<String> chosenlist;
	
	@FXML
	private Label lblSun;
	@FXML
	private Label lblMon;
	@FXML
	private Label lblTues;
	@FXML
	private Label lblWed;
	@FXML
	private Label lblThurs;
	@FXML
	private Label lblFri;
	@FXML
	private Label lblSat;
	
	
	
	@FXML
	private GridPane grSchedule;

	private Label chosen;
	Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PageFormat format;
    
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
	private AnchorPane root;
	
	public static AnchorPane rootP;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		cbDOW.setValue("Sunday");
		dtSchedule.setValue(LocalDate.now());
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
    					}
    					break;
    				
    				case "Exit":
    					System.exit(0);
    				}
    			});
    		}
        }
        
        //loading the employee information into the table 
        cbEmployee.setItems(Scheduler_Table.getDataFromSqlAndAddToObservableList("SELECT * FROM EMPLOYEES"));
        
        ObservableList<String> options = 
        	    FXCollections.observableArrayList(
        	        "Sunday",
        	        "Monday",
        	        "Tuesday",
        	        "Wednesday",
        	        "Thursday",
        	        "Friday",
        	        "Saturday"      
        	    );
        cbDOW.getItems().addAll(options);
        dtSchedule.setEditable(false);
        dtSchedule.setDisable(false);
        
        //checking what day it is today and loading the respective schedule
        String now = LocalDate.now().getDayOfWeek().toString();
        if(now == "SUNDAY"){
			
			lblSun.setText(LocalDate.now().toString());
			lblMon.setText(LocalDate.now().plusDays(1).toString());
			lblTues.setText(LocalDate.now().plusDays(2).toString());
			lblWed.setText(LocalDate.now().plusDays(3).toString());
			lblThurs.setText(LocalDate.now().plusDays(4).toString());
			lblFri.setText(LocalDate.now().plusDays(5).toString());
			lblSat.setText(LocalDate.now().plusDays(6).toString());

		}
		else if(now == "MONDAY"){
			
			lblMon.setText(LocalDate.now().toString());
			lblTues.setText(LocalDate.now().plusDays(1).toString());
			lblWed.setText(LocalDate.now().plusDays(2).toString());
			lblThurs.setText(LocalDate.now().plusDays(3).toString());
			lblFri.setText(LocalDate.now().plusDays(4).toString());
			lblSat.setText(LocalDate.now().plusDays(5).toString());
			lblSun.setText(LocalDate.now().minusDays(1).toString());

		}
		else if(now == "TUESDAY"){
			
			lblTues.setText(LocalDate.now().toString());
			lblWed.setText(LocalDate.now().plusDays(1).toString());
			lblThurs.setText(LocalDate.now().plusDays(2).toString());
			lblFri.setText(LocalDate.now().plusDays(3).toString());
			lblSat.setText(LocalDate.now().plusDays(4).toString());
			lblSun.setText(LocalDate.now().minusDays(2).toString());
			lblMon.setText(LocalDate.now().minusDays(1).toString());

		}
		else if(now == "WEDNESDAY"){
			
			lblWed.setText(LocalDate.now().toString());
			lblThurs.setText(LocalDate.now().plusDays(1).toString());
			lblFri.setText(LocalDate.now().plusDays(2).toString());
			lblSat.setText(LocalDate.now().plusDays(3).toString());
			lblSun.setText(LocalDate.now().minusDays(3).toString());
			lblMon.setText(LocalDate.now().minusDays(2).toString());
			lblTues.setText(LocalDate.now().minusDays(1).toString());

		}
		else if(now == "THURSDAY"){
			
			lblThurs.setText(LocalDate.now().toString());
			lblFri.setText(LocalDate.now().plusDays(1).toString());
			lblSat.setText(LocalDate.now().plusDays(2).toString());
			lblSun.setText(LocalDate.now().minusDays(4).toString());
			lblMon.setText(LocalDate.now().minusDays(3).toString());
			lblTues.setText(LocalDate.now().minusDays(2).toString());
			lblWed.setText(LocalDate.now().minusDays(1).toString());

		}
		else if(now == "FRIDAY"){
			
			lblFri.setText(LocalDate.now().toString());
			lblSat.setText(LocalDate.now().plusDays(1).toString());
			lblSun.setText(LocalDate.now().minusDays(5).toString());
			lblMon.setText(LocalDate.now().minusDays(4).toString());
			lblTues.setText(LocalDate.now().minusDays(3).toString());
			lblWed.setText(LocalDate.now().minusDays(2).toString());
			lblThurs.setText(LocalDate.now().minusDays(1).toString());

		}
		else if(now == "SATURDAY"){
			
			lblSat.setText(LocalDate.now().toString());
			lblSun.setText(LocalDate.now().minusDays(6).toString());
			lblMon.setText(LocalDate.now().minusDays(5).toString());
			lblTues.setText(LocalDate.now().minusDays(4).toString());
			lblWed.setText(LocalDate.now().minusDays(3).toString());
			lblThurs.setText(LocalDate.now().minusDays(2).toString());
			lblFri.setText(LocalDate.now().minusDays(1).toString());
		}
        
        //Loading each of the days with the employees scheduled that day
        setLoadListSun();
        setLoadListMon();
        setLoadListTues();
        setLoadListWed();
        setLoadListThurs();
        setLoadListFri();
        setLoadListSat();
    		
        }
	
	//Method that is run when a date is chosen on the date picker
	@FXML
	public void setOnDatePickerChosen(Event event)
	{
		if(dtSchedule.getValue()!= null){
			if(validateDate()){
				String day_of_week = dtSchedule.getValue().getDayOfWeek().toString();
				if(day_of_week == "SUNDAY"){
					
					lblSun.setText(dtSchedule.getValue().toString());
					lblMon.setText(dtSchedule.getValue().plusDays(1).toString());
					lblTues.setText(dtSchedule.getValue().plusDays(2).toString());
					lblWed.setText(dtSchedule.getValue().plusDays(3).toString());
					lblThurs.setText(dtSchedule.getValue().plusDays(4).toString());
					lblFri.setText(dtSchedule.getValue().plusDays(5).toString());
					lblSat.setText(dtSchedule.getValue().plusDays(6).toString());

				}
				else if(day_of_week == "MONDAY"){
					
					lblMon.setText(dtSchedule.getValue().toString());
					lblTues.setText(dtSchedule.getValue().plusDays(1).toString());
					lblWed.setText(dtSchedule.getValue().plusDays(2).toString());
					lblThurs.setText(dtSchedule.getValue().plusDays(3).toString());
					lblFri.setText(dtSchedule.getValue().plusDays(4).toString());
					lblSat.setText(dtSchedule.getValue().plusDays(5).toString());
					lblSun.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				else if(day_of_week == "TUESDAY"){
					
					lblTues.setText(dtSchedule.getValue().toString());
					lblWed.setText(dtSchedule.getValue().plusDays(1).toString());
					lblThurs.setText(dtSchedule.getValue().plusDays(2).toString());
					lblFri.setText(dtSchedule.getValue().plusDays(3).toString());
					lblSat.setText(dtSchedule.getValue().plusDays(4).toString());
					lblSun.setText(dtSchedule.getValue().minusDays(2).toString());
					lblMon.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				else if(day_of_week == "WEDNESDAY"){
					
					lblWed.setText(dtSchedule.getValue().toString());
					lblThurs.setText(dtSchedule.getValue().plusDays(1).toString());
					lblFri.setText(dtSchedule.getValue().plusDays(2).toString());
					lblSat.setText(dtSchedule.getValue().plusDays(3).toString());
					lblSun.setText(dtSchedule.getValue().minusDays(3).toString());
					lblMon.setText(dtSchedule.getValue().minusDays(2).toString());
					lblTues.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				else if(day_of_week == "THURSDAY"){
					
					lblThurs.setText(dtSchedule.getValue().toString());
					lblFri.setText(dtSchedule.getValue().plusDays(1).toString());
					lblSat.setText(dtSchedule.getValue().plusDays(2).toString());
					lblSun.setText(dtSchedule.getValue().minusDays(4).toString());
					lblMon.setText(dtSchedule.getValue().minusDays(3).toString());
					lblTues.setText(dtSchedule.getValue().minusDays(2).toString());
					lblWed.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				else if(day_of_week == "FRIDAY"){
					
					lblFri.setText(dtSchedule.getValue().toString());
					lblSat.setText(dtSchedule.getValue().plusDays(1).toString());
					lblSun.setText(dtSchedule.getValue().minusDays(5).toString());
					lblMon.setText(dtSchedule.getValue().minusDays(4).toString());
					lblTues.setText(dtSchedule.getValue().minusDays(3).toString());
					lblWed.setText(dtSchedule.getValue().minusDays(2).toString());
					lblThurs.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				else if(day_of_week == "SATURDAY"){
					
					lblSat.setText(dtSchedule.getValue().toString());
					lblSun.setText(dtSchedule.getValue().minusDays(6).toString());
					lblMon.setText(dtSchedule.getValue().minusDays(5).toString());
					lblTues.setText(dtSchedule.getValue().minusDays(4).toString());
					lblWed.setText(dtSchedule.getValue().minusDays(3).toString());
					lblThurs.setText(dtSchedule.getValue().minusDays(2).toString());
					lblFri.setText(dtSchedule.getValue().minusDays(1).toString());

				}
				
				 //Loads in employee information based on given date
				
				 setLoadListSun();
		         setLoadListMon();
		         setLoadListTues();
		         setLoadListWed();
		         setLoadListThurs();
		         setLoadListFri();
		         setLoadListSat();
			}
		}		
	}
	
	
	
	//Based on what day is chosen, the respective chooseEmp__ is called which shows to the user that the day is selected to schedule
	@FXML 
	private void chooseEmpSun(){
		 	chosen = lblSun;
		 	chosenlist = listSun;
	
			
	}
	
	@FXML 
	private void chooseEmpMon(){
		 	chosen = lblMon;
		 	chosenlist = listMon;
		 	
	}
	
	@FXML 
	private void chooseEmpTues(){
		 	chosen = lblTues;
		 	chosenlist = listTues;
		 	
	}
	
	@FXML 
	private void chooseEmpWed(){
		 	chosen = lblWed;
		 	chosenlist = listWed;
		 	
	}
	
	@FXML 
	private void chooseEmpThurs(){
		 	chosen = lblThurs;
		 	chosenlist = listThurs;
		 	
	}
	
	@FXML 
	private void chooseEmpFri(){
		 	chosen = lblFri;
		 	chosenlist = listFri;
		 	
	}
	
	@FXML 
	private void chooseEmpSat(){
		 	chosen = lblSat;
		 	chosenlist = listSat;
		 	
	}
	
	//Adds an employee to the schedule if it was selected from bottom table
	@FXML 
	private void addEmployeeClicked(Event event){
		
        if(cbEmployee.getValue()!=null && cbDOW.getValue() != null && validateDate() && validateAMPM()) {
        		if(cbDOW.getValue().toString() == "Sunday"){
        			chooseEmpSun();
        		}
        		else if(cbDOW.getValue().toString() == "Monday"){
        			chooseEmpMon();
        		}
        		else if(cbDOW.getValue().toString() == "Tuesday"){
        			chooseEmpMon();
        		}
        		else if(cbDOW.getValue().toString() == "Wednesday"){
        			chooseEmpMon();
        		}
        		else if(cbDOW.getValue().toString() == "Thursday"){
        			chooseEmpMon();
        		}
        		else if(cbDOW.getValue().toString() == "Friday"){
        			chooseEmpMon();
        		}
        		else if(cbDOW.getValue().toString() == "Saturday"){
        			chooseEmpMon();
        		}
        		int count = 0;
        		String str = cbEmployee.getValue().toString();
        		int pos = str.indexOf(":");
        		String id = str.substring(pos + 1);
        		
	        	String sqlQuery = "select * FROM Employees_Schedule where ID = "+id+" AND Date = '"+chosen.getText()+"';";
	        	//String sqlQuery1 = "select * FROM Employees where ID = "+id+";";
	        	 
	        	try{
	        		connection = SqliteConnection.Connector();
			        statement = connection.createStatement();
		            resultSet = statement.executeQuery(sqlQuery);
		            
		            while(resultSet.next()){
		            	count++;
		            }
		            //resultSet.close();
		            //resultSet = statement.executeQuery(sqlQuery1);

		            if(count == 0){
		            	 int rowsAffected = statement.executeUpdate("insert into `Employees_Schedule` " +
		            	
	                     "(`ID`,`Date`, `Shift`)"+
	                     "values ("+id+",'"+chosen.getText()+"','" + AMPM() + "'"
	                    
	                     +");");
		            }
		            else{
		            	NotificationType notificationType = NotificationType.ERROR;
			            TrayNotification tray = new TrayNotification();
			            tray.setTitle("Employee Repeat");
			            tray.setMessage("This employee is already working this day");
			            tray.setNotificationType(notificationType);
			            tray.showAndDismiss(Duration.millis(5000));
		            }
		            
		            
		            statement.close();
		            resultSet.close();
		            connection.close();
		        
	        	}
	        	catch (SQLException e) {
		            e.printStackTrace();
		            
		        }
	               	 
	             setLoadListSun();
	             setLoadListMon();
	             setLoadListTues();
	             setLoadListWed();
	             setLoadListThurs();
	             setLoadListFri();
	             setLoadListSat();
        }
        else if(validateAMPM()){
        	    NotificationType notificationType = NotificationType.ERROR;
	            TrayNotification tray = new TrayNotification();
	            tray.setTitle("No Employee Selected");
	            tray.setMessage("Please select an Employee");
	            tray.setNotificationType(notificationType);
	            tray.showAndDismiss(Duration.millis(5000));
        }
        
        
	}
	
	public String AMPM(){
		if(cbAM.isSelected() && cbPM.isSelected())
		{
			return "AM/PM";
		}
		else if(cbAM.isSelected()){
			return "AM";
		}
		else if(cbPM.isSelected()){
			return "PM";
		}
		else{
			return "";
		}
	}
	
	
	//Methods to load the employees into the schedule
    private void setLoadListSun(){
    	listSun.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblSun.getText()+"';")));
    }
    
    private void setLoadListMon(){
    	listMon.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblMon.getText()+"';")));
    }
    
    private void setLoadListTues(){
    	listTues.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblTues.getText()+"';")));
    }
    
    private void setLoadListWed(){
    	listWed.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblWed.getText()+"';")));
    }
    
    private void setLoadListThurs(){
    	listThurs.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblThurs.getText()+"';")));
    }
    
    private void setLoadListFri(){
    	listFri.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblFri.getText()+"';")));
    }
    
    private void setLoadListSat(){
    	listSat.setItems((Scheduler_Table.getDataFromSqlAndAddToObservableListSchedule("SELECT Employees_Schedule.*, Employees.ID, Employees.First_Name, Employees.Last_Name FROM"
        		+ " Employees_Schedule INNER JOIN Employees ON Employees_Schedule.ID=Employees.ID WHERE Employees_Schedule.Date = '" +lblSat.getText()+"';")));
    }
    
    //Method to print the schedule
    @FXML  
    private void doPrint(Event event) throws InvocationTargetException{
	   Printer printer = Printer.getDefaultPrinter();
	   PrinterJob job = PrinterJob.createPrinterJob();
	   
	   if(printer != null){
		   PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
		   double scaleX
	       = pageLayout.getPrintableWidth() / grSchedule.getBoundsInParent().getWidth();
		   double scaleY
	       = pageLayout.getPrintableHeight() / grSchedule.getBoundsInParent().getHeight();
		   Scale scale = new Scale(scaleX, scaleY);
	  	   grSchedule.getTransforms().add(scale);
	  	   
	  	 if(job.printPage(pageLayout, grSchedule)){
	        	job.endJob();
	        	grSchedule.getTransforms().remove(scale);        	
	    	}
	    	else{
	    		NotificationType notificationType = NotificationType.ERROR;
	            TrayNotification tray = new TrayNotification();
	            tray.setTitle("Printing error");
	            tray.setMessage("Try turning on your printers");
	            tray.setNotificationType(notificationType);
	            tray.showAndDismiss(Duration.millis(10000));
	    	}
	   }
	   else if(printer == null){
    		//tray notification printer not found
    		NotificationType notificationType = NotificationType.ERROR;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Printer not found");
            tray.setMessage("Please set default printer/turn printer on");
            tray.setNotificationType(notificationType);
            tray.showAndDismiss(Duration.millis(10000));
    		
    	}
    	
    }
   
   //Method called when user wants to delete an employee schedule on a certain day
   @FXML
   private void schedulerDelete(Event event){
	 	if(chosenlist.getSelectionModel().getSelectedItem()!=null){
	 		String getSelectedRow = chosenlist.getSelectionModel().getSelectedItem().substring(0,1);
	 		String sqlQuery = "delete FROM Employees_Schedule where ID = "+getSelectedRow+" AND Date = '"+chosen.getText()+"';";
	        try {
	        	connection = SqliteConnection.Connector();
		        statement = connection.createStatement();
	             
	             statement.executeUpdate(sqlQuery);
	             
	        	 
	             setLoadListSun();
	             setLoadListMon();
	             setLoadListTues();
	             setLoadListWed();
	             setLoadListThurs();
	             setLoadListFri();
	             setLoadListSat();
	            
	             statement.close();
	             connection.close();

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }


	        
	 	}
	 	else{
	 		NotificationType notificationType = NotificationType.ERROR;
	 		TrayNotification tray = new TrayNotification();
	 		tray.setTitle("No Date Selected");
	 		tray.setMessage("To delete, please select from weekly schedule list");
	 		tray.setNotificationType(notificationType);
	 		tray.showAndDismiss(Duration.millis(25000));
	 	}        
   }
    
    //Following methods launch the other screens for various parts of the program
   	@FXML
	private void launchEmployeeMainMenu(Event event) throws IOException{
	   ((Node)event.getSource()).getScene().getWindow().hide();
	   Parent Main_Menu = FXMLLoader.load(getClass().getResource("Main_Menu_Employee.fxml"));
	   Scene MainMenu = new Scene(Main_Menu);
	   Stage mainMenu = (Stage) ((Node) event.getSource()).getScene().getWindow();
	   mainMenu.hide();
	   mainMenu.setScene(MainMenu);
	   mainMenu.setTitle("Main Menu");
	   mainMenu.show();
   	}


   	@FXML
   	private void launchCustomerScreen(Event event) throws IOException{
	 	((Node)event.getSource()).getScene().getWindow().hide();
	 	Parent CustomerScreen = FXMLLoader.load(getClass().getResource("Menu_Customer.fxml"));
	 	Scene customer_screen = new Scene(CustomerScreen);
	 	Stage Customer_Screen = (Stage) ((Node) event.getSource()).getScene().getWindow();
	 	Customer_Screen.hide();
	 	Customer_Screen.setScene(customer_screen);
	 	Customer_Screen.setTitle("Customer Screen");
	 	Customer_Screen.show();
   	}

   	@FXML
   	private void launchBarChart(Event event) throws IOException{
	 	FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("AMPM_Bar_Chart.fxml"));
       loader.load();
       Parent p = loader.getRoot();
       Stage stage = new Stage();
       stage.setScene(new Scene(p));
       stage.setTitle("All Customer Attendance Data");
       stage.show();
   }

   @FXML
   	private void launchLineChart(Event event) throws IOException{
	 	FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("Customer_Attendance_Line_Chart.fxml"));
       loader.load();
       Parent p = loader.getRoot();
       Stage stage = new Stage();
       stage.setScene(new Scene(p));
       stage.setTitle("Week Customer Attendance Data");
       stage.show();
   }
   
   //Gives an alert if a user tries to schedule without selecting a date
   private boolean validateDate(){
		 if(dtSchedule.getValue() != null){
			 return true;
		 }
		 else{
			 NotificationType notificationType = NotificationType.ERROR;
		 		TrayNotification tray = new TrayNotification();
		 		tray.setTitle("Validate Date");
		 		tray.setMessage("Please select a valid date");
		 		tray.setNotificationType(notificationType);
		 		tray.showAndDismiss(Duration.millis(25000));
			 
			 return false;
		 }
		 
	 }  
   
   private boolean validateAMPM(){
		 if(AMPM() != ""){
			 return true;
		 }
		 else{
			 NotificationType notificationType = NotificationType.ERROR;
		 		TrayNotification tray = new TrayNotification();
		 		tray.setTitle("Validate Shift");
		 		tray.setMessage("Please select a valid shift (AM, PM)");
		 		tray.setNotificationType(notificationType);
		 		tray.showAndDismiss(Duration.millis(25000));
			 
			 return false;
		 }
		 
	 }  
}