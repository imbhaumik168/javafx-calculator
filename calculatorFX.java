//package javafx; include your package 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class calculatorFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField input1 = new TextField();
        TextField input2 = new TextField();

        HBox inputs = new HBox(10, input1, input2);
        inputs.setTranslateX(100);
        inputs.setTranslateY(50);
        inputs.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        Button add = new Button("Add");
        Button sub = new Button("Sub");
        Button mul = new Button("Mul");
        Button div = new Button("Div");
        Text result = new Text("Answer");

        // Event Handler
        EventHandler<ActionEvent> eventHandler = event -> {
            try {
                int text1 = Integer.parseInt(input1.getText());
                int text2 = Integer.parseInt(input2.getText());

                int output = 0;

                if (event.getSource() == add) output = text1 + text2;
                else if (event.getSource() == sub) output = text1 - text2;
                else if (event.getSource() == mul) output = text1 * text2;
                else if (event.getSource() == div) {
                    if (text2 == 0) {
                        result.setText("Cannot divide by zero");
                        return;
                    }
                    output = text1 / text2;
                }

                result.setText(String.valueOf(output));

            } catch (NumberFormatException e) {
                result.setText("Invalid Input");
            }
        };

        add.setOnAction(eventHandler);
        sub.setOnAction(eventHandler);
        mul.setOnAction(eventHandler);
        div.setOnAction(eventHandler);

        HBox buttons = new HBox(10, add, sub, mul, div);
        buttons.setTranslateX(100);
        buttons.setTranslateY(50);
        buttons.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        result.setTranslateX(200);
        result.setTranslateY(80);
        result.setFill(Color.WHITE);
        result.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));

        VBox root = new VBox(10, inputs, buttons, result);
        root.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        Scene scene = new Scene(root, 500, 400, Color.web("080808"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
