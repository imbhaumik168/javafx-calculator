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
/* public void start(Stage primaryStage) throws Exception {
        TextField input1 = new TextField();
        TextField input2 = new TextField();

        HBox inputs = new HBox();
        inputs.getChildren().addAll(input1, input2);

        inputs.setTranslateX(100);
        inputs.setTranslateY(50);
        inputs.setSpacing(10);
        inputs.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        Button add = new Button("add");
        Button sub = new Button("sub");
        Button mul = new Button("mul");
        Button div = new Button("div");
        Text result = new Text();

        String input1Text = input1.getText();
        String input2Text = input2.getText();

        Integer numObj = new Integer(input1Text);
        int text1 = numObj;

        Integer numOBJ2 = new Integer(input2Text);
        int text2 = numOBJ2;

        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int i = text1 + text2;
                String sum = String.valueOf(i);
                result.setText(sum);
            }
        });
        sub.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int i = text1 - text2;
                String substraction = String.valueOf(i);
                result.setText(substraction);
            }
        });
        mul.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int i = text1 * text2;
                String multi = String.valueOf(i);
                result.setText(multi);
            }
        });
        div.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int i = text1 / text2;
                String divide = String.valueOf(i);
                result.setText(divide);
            }
        });

        HBox buttons = new HBox();
        buttons.getChildren().addAll(add, mul, sub, div);

        buttons.setTranslateX(100);
        buttons.setTranslateY(50);
        buttons.setSpacing(10);
        buttons.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        result.setTranslateX(200);
        result.setTranslateY(80);
        result.setX(100);
        result.setY(20);
        result.setFill(Color.web("ffffff"));
        result.setFont(Font.font("italic", FontWeight.BOLD, FontPosture.REGULAR, 20));
        result.setText("answer");

        VBox root = new VBox();
        root.getChildren().addAll(inputs, buttons, result);
        root.setSpacing(10);
        root.setBackground(new Background(new BackgroundFill(Color.web("080808"), null, null)));

        Scene scene = new Scene(root, 500, 400, Color.web("080808"));
        primaryStage.setTitle("cal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
*/
    public static void main(String[] args) {
        launch(args);
    }
}
