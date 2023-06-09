import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;

public class BasicCalulator extends Application {

    private Text firstNum, secondNum, result;
    private TextField firstNumField, secondNumField;

    public void start(Stage primaryStage) {
        // Create the top section of the UI
        firstNum = new Text("First Number: ");
        firstNumField = new TextField();
        firstNumField.setPrefWidth(50);
        secondNum = new Text("Second Number: ");
        secondNumField = new TextField();
        secondNumField.setPrefWidth(50);
        result = new Text("Answer:");

        // Create the bottom section of the UI
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        Button divideButton = new Button("Divide");

        // Register event handlers for buttons
        addButton.setOnAction(this::addRequest);

        subtractButton.setOnAction(this::subtractRequest);

        multiplyButton.setOnAction(this::multiplyRequest);

        divideButton.setOnAction(this::divideRequest);

        FlowPane fPane = new FlowPane(firstNum, firstNumField, secondNum, secondNumField, result, addButton, subtractButton, multiplyButton, divideButton);
        fPane.setAlignment(Pos.CENTER);
        fPane.setHgap(10);
        fPane.setVgap(20);
        fPane.setStyle("-fx-background-color:palevioletred");

        Scene scene = new Scene(fPane, 404, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Basic Calculator");
        primaryStage.show();
    }

    public void addRequest (ActionEvent event){
        double a = Double.parseDouble(firstNumField.getText());
        double b = Double.parseDouble(secondNumField.getText());
        result.setText("Answer: " + String.valueOf(a + b));
    }

    public void subtractRequest (ActionEvent event){
        double a = Double.parseDouble(firstNumField.getText());
        double b = Double.parseDouble(secondNumField.getText());
        result.setText("Answer: " + String.valueOf(a - b));
    }

    public void multiplyRequest (ActionEvent event){
        double a = Double.parseDouble(firstNumField.getText());
        double b = Double.parseDouble(secondNumField.getText());
        result.setText("Answer: " + String.valueOf(a * b));
    }

    public void divideRequest (ActionEvent event){
        double a = Double.parseDouble(firstNumField.getText());
        double b = Double.parseDouble(secondNumField.getText());
        result.setText(b == 0 ? "Answer: Error" : "Answer: " + String.valueOf(a / b));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
