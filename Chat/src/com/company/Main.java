package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static final String IP_ADDRESS = "192.168.114.1";
    public static final int PORT = 14564;
    private final String USER_NAME = "Maayan";
    private Stage window;
    private double width = 500;
    private double height = 500;
    private Button sendMessageButton;
    private TextField messageInput;
    private TextArea chatView;
    private ArrayList<String> messagesList;

    @Override
    public void start(Stage primaryStage) throws Exception {
        messagesList = new ArrayList<>();
        window = primaryStage;
        createUI();
        addActions();
    }

    private void sendMessage() {
        if (messageInput.getText().trim().length() > 0) {
            //System.out.println(messageInput.getText());
            String message = USER_NAME + " : " + messageInput.getText();
            //chatView.setText(message);
            messagesList.add(message);
            SendMessageThread sendMessageThread = new SendMessageThread(message);
            sendMessageThread.start();
            updateChatView();
        } else {
            System.out.println("cant send empty message...");
        }
        messageInput.setText("");
        messageInput.requestFocus();
    }

    private void updateChatView() {
        String s = "";
        for (String message : messagesList) {
            s += message + "\n";
        }
        chatView.setText(s);
        chatView.positionCaret(chatView.getLength());
    }

    private void addActions() {
        sendMessageButton.setOnAction(e -> sendMessage());
        /*
        sendMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendMessage();
            }
        });
        */
        messageInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    sendMessage();
                }
            }
        });

        chatView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                messageInput.requestFocus();
            }
        });
    }

    private void createUI() {
        VBox mainLayout = new VBox();
        chatView = new TextArea();
        chatView.setStyle("-fx-text-fill:blue");
        chatView.setPrefSize(width, height - 100);
        HBox userActionView = new HBox();
        messageInput = new TextField();
        messageInput.setPrefSize(width - 100, 100);
        sendMessageButton = new Button("SEND");
        sendMessageButton.setPrefSize(100, 100);
        userActionView.getChildren().addAll(messageInput, sendMessageButton);
        mainLayout.getChildren().addAll(chatView, userActionView);
        Scene mainScene = new Scene(mainLayout, width, height);
        window.setScene(mainScene);
        window.setTitle("CHAT!!!");
        window.show();
        messageInput.requestFocus();
    }


    public static void main(String[] args) {
        launch(null);
    }


}
