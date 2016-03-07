package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        VBox layout = new VBox();
        Label label = new Label("welcome to first scene");
        Label label2 = new Label("welcome to first scene");
        Button btn = new Button("Send");
        StackPane layout2 = new StackPane();
        Label l = new Label("Welcome to second scene");
        Button b = new Button("back");
        layout2.getChildren().addAll(l, b);

        Scene SecondScene = new Scene(layout2, 200, 200);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(SecondScene);
            }
        });

        //btn.setOnAction(e -> window.setScene(SecondScene));
        layout.getChildren().addAll(label, label2, btn);

        Scene mainScene = new Scene(layout, 300, 300);
        b.setOnAction(e -> window.setScene(mainScene));
        window.setScene(mainScene);

        window.setTitle("FX tutorial title...");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
