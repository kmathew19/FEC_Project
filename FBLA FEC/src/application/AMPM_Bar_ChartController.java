package application;

//importing all packages needed for this class
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

 
public class AMPM_Bar_ChartController implements Initializable{
	
	//This is an instance of the AMPM_Bar_ChartModel Class which will perform the actual calculations for the chart
	AMPM_Bar_ChartModel barchart = new AMPM_Bar_ChartModel();
	
	//This is the bar chart of the total AM Customers vs. the total PM Customers
	@FXML
	private BarChart<String,Integer> barChartAttendance;
	
	//This is what will be loaded when the screen is opened
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
		//The x axis, AM or PM, are strings, while the y axis, the number of customers, is an integer
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		
		//Calculates number of AM Customer Attendances vs PM Customer Attendances from Database
		barchart.calcNumAMPM();
		
		//Adding the data to the XYChart, series, based on the calculations from the AMPM_Bar_ChartModel class
		series.getData().add(new XYChart.Data<>("AM", barchart.getnumAM()));
		series.getData().add(new XYChart.Data<>("PM", barchart.getnumPM()));
		
		//This, essentially, displays the data on the barChartAttendance to be viewed by the User
		barChartAttendance.getData().addAll(series);   
	}
}
