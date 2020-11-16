import javafx.application.Application;//for the application
import static javafx.application.Application.launch;//for the application launch
import javafx.geometry.Insets;//to insert the geometry
import javafx.scene.Scene;//to show the scene
import javafx.scene.control.Alert;//for alert scene
import javafx.scene.control.Button;//for control botton scene
import javafx.scene.control.Label;//for the label scene control 
import javafx.scene.control.TextField;// for scene textfield 
import javafx.scene.layout.GridPane;//for the scene layout and gridpane
import javafx.stage.Stage;// for the stage
public class GradeCalculator extends Application 
   {
      //declaring User Interface elements
      private TextField hw_txt, test1_txt, test2_txt, test3_txt, final_txt;
      private Label weighted_grade_txt, letter_grade_txt;
      public void start(Stage primaryStage) //declaring public variable
    {
      GridPane root = new GridPane();//gridepane
      root.setHgap(20);
      root.setVgap(20);
      root.setPadding(new Insets(20));
      //adding the root pane by column and row numbers
      root.add(new Label("Practice Problem Total:"), 0, 0); //adding into column 0, row 0
      hw_txt = new TextField();
      root.add(hw_txt, 1, 0);
      root.add(new Label("Test 1:"), 2, 0);//adding into column 2, row 0
      test1_txt = new TextField();
      root.add(test1_txt, 3, 0);
      root.add(new Label("Test 2:"), 2, 1);//adding into column 2, row 1
      test2_txt = new TextField();
      root.add(test2_txt, 3, 1);
      root.add(new Label("Test 3:"), 2, 2);//adding into column 2, row 2
      test3_txt = new TextField();
      root.add(test3_txt, 3, 2);
      root.add(new Label("Final:"), 4, 0);//adding into column 4, row 0
      final_txt = new TextField();
      root.add(final_txt, 5, 0);
      weighted_grade_txt = new Label("Weighted Grade: ");//for weighted grade
      root.add(weighted_grade_txt, 0, 3, 2, 1); //adding to column 0, row 3, with column span=2, rowspan=1
      letter_grade_txt = new Label("Letter Grade: ");//for letter grade
      root.add(letter_grade_txt, 0, 4);
      Button calculate = new Button("Calculate Grades");//for calculating grade
      calculate.setOnAction(e -> calculate());//for action listener
      root.add(calculate, 5, 4); 
      //for displaying the scene
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Data Structure Graded Calculator");
      primaryStage.show();
   }
public void calculate() //event handling method
   {
      try 
      {
         //displayed for reading and parsing input values
         double hw = Double.parseDouble(hw_txt.getText());
         double test1 = Double.parseDouble(test1_txt.getText());
         double test2 = Double.parseDouble(test2_txt.getText());
         double test3 = Double.parseDouble(test3_txt.getText());
         double fin = Double.parseDouble(final_txt.getText());
         //finding weighted average (18% of homework, 19% of each test score, 25% of final)
         double weighted_grade_txt = ((hw * 0.18) + (test1 * 0.19) + (test2 * 0.19) + (test2 * 0.19) + (fin * 0.25));
         char letter = letterGrade(weighted_grade_txt);//finds letter grade
         //displaying the result in appropriate labels in proper format
         letter_grade_txt.setText(String.format("Weighted Grade: %.2f",weighted_grade_txt));
         letter_grade_txt.setText("Letter Grade: " + letter);
        } 
        catch (Exception e) 
        {
         //if any exceptions occurred, displaying an error message inside an Alert box
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setHeaderText("Oops!");
         alert.setContentText("Incomplete forms or Invalid input, please input valid values only.");
         alert.show();
        }
    }
public char letterGrade(double avg) //finds letter garde to display the average
    {
      if (avg >= 90) 
    {
         return 'A';
    }
      if (avg >= 80) 
    {
         return 'B';
    }
      if (avg >= 70) 
    {
         return 'C';
    }
      if (avg >= 60) 
    {
         return 'D';
    }
         return 'F';
    }
public static void main(String[] args) //main class
    {
      launch(args);
    }
}