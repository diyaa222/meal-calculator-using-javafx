import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;  
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;  
public class Main extends Application{  
	double total_bazar = 0;
	int total_meal = 0;
	List<Member> member_list = new ArrayList<Member>();
    @Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  
    	Stage window = primaryStage;
        Button log_in_btn = new Button("Log in"); 
        Label label,  welcome, namelabel, bazarlabel, meallabel, monthname; 
        TextField mealratefield, namefield, bazarfield, mealfield, monthnamefield;
    	Button add, delete, update, calculate, Print, Save, Load, save_as_pdf;
    	
        
        GridPane login_pane = new GridPane(); 
        login_pane.setAlignment(Pos.CENTER);
        login_pane.setHgap(10);
        login_pane.setVgap(10);
        login_pane.setPadding(new Insets(10));
        
        Label user_label = new Label("User Name:");
        login_pane.add(user_label, 0, 1);
        TextField user_name = new TextField();
        user_name.setPromptText("User Name");
        login_pane.add(user_name, 1, 1);
        Label password_label = new Label("Password :");
        login_pane.add(password_label, 0, 2);
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        login_pane.add(password, 1, 2);
        login_pane.add(log_in_btn, 1, 3);
        
        
        Pane pane = new Pane();
        Scene main_scene = new Scene (pane, 1200,600);
        
        Scene login_scene = new Scene(login_pane,1200,600);      
        window.setTitle("Meal Calculator"); 
        window.setResizable(false);
        window.setScene(login_scene);  
        window.show();  
        
        log_in_btn.setOnAction((event) -> {
            window.setScene(main_scene);
        }); 
        
        // After Login
        monthname = new Label("Month: ");
        monthname.setLayoutX(980);
        monthname.setLayoutY(25);
        pane.getChildren().add(monthname);
        monthnamefield = new TextField();
        monthnamefield.setLayoutX(1040);
        monthnamefield.setLayoutY(25);
        pane.getChildren().add(monthnamefield);
        
        
        namelabel = new Label("Name: ");
        namelabel.setLayoutX(40);
        namelabel.setLayoutY(120);
        pane.getChildren().add(namelabel);
        namefield = new TextField();
        namefield.setLayoutX(90);
        namefield.setLayoutY(120);
        pane.getChildren().add(namefield);
        
        
        bazarlabel = new Label("Bazar: ");
        bazarlabel.setLayoutX(40);
        bazarlabel.setLayoutY(150);
        pane.getChildren().add(bazarlabel);
        bazarfield = new TextField();
        bazarfield.setLayoutX(90);
        bazarfield.setLayoutY(150);
        pane.getChildren().add(bazarfield);
        
        
        meallabel = new Label("Meal: ");
        meallabel.setLayoutX(40);
        meallabel.setLayoutY(180);
        pane.getChildren().add(meallabel);
        mealfield = new TextField();
        mealfield.setLayoutX(90);
        mealfield.setLayoutY(180);
        pane.getChildren().add(mealfield);
        
        
        add = new Button ("Add");
        add.setLayoutX(70);
        add.setLayoutY(240);
        add.setPrefWidth(80);
        pane.getChildren().add(add);
        
        
        delete = new Button ("Delete");
        delete.setLayoutX(170);
        delete.setLayoutY(240);
        delete.setPrefWidth(90);
        pane.getChildren().add(delete);
        
        update = new Button ("Update");
        update.setLayoutX(90);
        update.setLayoutY(280);
        update.setPrefWidth(150);
        pane.getChildren().add(update);
        
        save_as_pdf = new Button ("Save as PDF");
        save_as_pdf .setLayoutX(90);
        save_as_pdf .setLayoutY(320);
        save_as_pdf .setPrefWidth(150);
        pane.getChildren().add(save_as_pdf);
        
        calculate  = new Button ("Calculate");
        calculate.setLayoutX(300);
        calculate.setLayoutY(520);
        calculate.setPrefWidth(100);
        pane.getChildren().add(calculate);
        
        Print = new Button ("Print");
        Print.setLayoutX(900);
        Print.setLayoutY(520);
        Print.setPrefWidth(100);
        pane.getChildren().add(Print);

        Save = new Button ("Save");
        Save.setLayoutX(540);
        Save.setLayoutY(520);
        Save.setPrefWidth(80);
        pane.getChildren().add(Save);

        Load = new Button ("Load");
        Load.setLayoutX(430);
        Load.setLayoutY(520);
        Load.setPrefWidth(80);
        pane.getChildren().add(Load);

        label = new Label("Meal Rate: ");
        label.setLayoutX(700);
        label.setLayoutY(520);
        label.setPrefWidth(80);
        pane.getChildren().add(label);
        mealratefield = new TextField();
        mealratefield.setLayoutX(790);
        mealratefield.setLayoutY(520);
        mealratefield.setPrefWidth(100);
        mealratefield.setEditable(false);
        pane.getChildren().add(mealratefield);
        
        
        TableView tableView = new TableView();

        TableColumn column1 = new TableColumn("Name"); 
        column1.setCellValueFactory(
                new PropertyValueFactory("name"));
 
        TableColumn column2 = new TableColumn("Bazar");
        column2.setCellValueFactory(
                new PropertyValueFactory("bazar"));
 
        TableColumn column3 = new TableColumn("Meal");
        column3.setCellValueFactory(
                new PropertyValueFactory("meal"));
        
        TableColumn column4 = new TableColumn("Will Pay");
        column4.setCellValueFactory(
                new PropertyValueFactory("will_pay"));
        
        TableColumn column5 = new TableColumn("Will Get");
        column5.setCellValueFactory(
                new PropertyValueFactory("will_get"));
        
        column1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        column2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        column3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        column4.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        column5.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        
        tableView.setMinWidth(400);

        ScrollPane sp = new ScrollPane(tableView);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        sp.setLayoutX(300);
        sp.setLayoutY(100);
        sp.setPrefWidth(700);
        sp.setPrefHeight(400);
        pane.getChildren().add(sp);
        
        ObservableList<Member> data =
                FXCollections.observableArrayList();
        
        tableView.setItems(data);
        
        add.setOnAction((event) -> {
            String name = namefield.getText().toString();
            double bazar = Double.parseDouble(bazarfield.getText().toString());
            int meal = Integer.parseInt(mealfield.getText().toString());
            total_bazar = total_bazar + bazar;
            total_meal = total_meal + meal;
            namefield.setText("");
            bazarfield.setText("");
            mealfield.setText("");
            data.add(new Member(name, bazar, meal));
            
        });
        
        delete.setOnAction((event) -> {
        	
        });
        
		calculate.setOnAction((event) -> {
			for(int i = 0; i < data.size(); i++) {
		    	data.get(i).calculateMealRate(total_bazar, total_meal);
		    	data.get(i).calculatePayOrGet();
		    	System.out.println(data.get(i).toString());		    	
		    }
		    
		    tableView.refresh();
		    mealratefield.setText(data.get(0).getMealRate());
		        });
        
    }  
    public static void main (String[] args)  
    {  
        launch(args);  
    }  
  
}  
