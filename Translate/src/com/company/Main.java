package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application implements EventHandler, ChangeDisplayListener {

    private Button btn, btn2;
    private boolean isWorking = false;
    private TextField input;
    private TextArea output;
    private TranslateThread translate;
    private int counter = 0;
    Word[] words = {
            new Word("hello", "שלום"),
            new Word("bye", "להתראות"),
            new Word("dog", "כלב"),
            new Word("cat", "חתול"),
            new Word("sun", "שמש")
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        createUI(primaryStage);
        addActions();


    }

    public void changeDisplay(){
        if (counter == words.length){
            counter = 0;
        }
        //System.out.println(words[counter++]);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Word word = words[counter];
                input.setText(word.getEnglish());
                output.setText(word.getHebrew());
                counter++;
            }
        });
    }

    private void addActions() {
        btn.setOnAction(this);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*
                String in = input.getText();
                String translate = search(in);
                output.setText(translate);
                */
                output.setText(search(input.getText()));
            }
        });

    }

    private String search(String input){
        try {
            URL url = new URL("http://www.morfix.co.il/" + input);
            InputStreamReader in = new InputStreamReader(url.openStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                if (line.contains("heTrans")){
                    System.out.println(line);
                    break;
                }
            }
            if (line != null){
                String translate = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                return translate;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No translate";
    }

    private void createUI(Stage primaryStage) {
        VBox layout = new VBox();
        input = new TextField();
        output = new TextArea();
        btn = new Button("START");
        btn.setDisable(true);
        btn2 = new Button("TRANSLATE FROM MORFIX");
        layout.getChildren().addAll(input, output, btn, btn2);
        Scene mainScene = new Scene(layout, 500, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("WOW");
            }
        });
    }

    public static void main(String[] args) {
	    launch(args);
    }


    @Override
    public void handle(Event event) {
        if (!isWorking){
            btn.setText("STOP");
            translate = new TranslateThread(this);
            translate.start();
        }else{
            btn.setText("START");
            translate.setWorking(false);
        }
        isWorking = !isWorking;
    }
}
