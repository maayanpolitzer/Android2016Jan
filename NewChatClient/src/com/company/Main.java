package com.company;

import com.company.interfaces.SyncListener;
import com.company.threads.GetMessagesThread;
import com.company.threads.SendMessageThread;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application implements SyncListener {

    public static final String IP_ADDRESS = "192.168.1.101";
    public static final int PORT = 14564;
    public static final byte SEND_MESSAGE = 1;
    public static final byte GET_MESSAGES = 2;
    private final String USER_NAME = "Irit";
    private Stage window;
    private Scene mainScene;
    private VBox mainLayout;
    private HBox userActionView;
    private TextArea chatView;      // view the chat history.
    private TextField messageInput; // where the user write his message.
    private Button sendMessageBtn;  // the button to post the message.
    private double width = 500;
    private double height = 500;
    private GetMessagesThread getMessagesThread;
    private int counter = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        createUI();
        addActionsToButton();
        getMessagesThread = new GetMessagesThread(this);
        getMessagesThread.start();
    }

    private void addActionsToButton(){
        /*
        sendMessageBtn.setOnAction(e -> sendMessage());
        window.setOnCloseRequest(e -> getMessagesThread.shutDown());
        */
        sendMessageBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendMessage();
            }
        });
        messageInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    sendMessage();
                }
            }
        });
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                getMessagesThread.shutDown();
                System.out.println("closing program");
            }
        });
    }

    private void sendMessage(){
        String input = messageInput.getText().trim();
        if (!input.equals("")){
            String message = USER_NAME + " : " + input;
            SendMessageThread sendMessageThread = new SendMessageThread(message);
            sendMessageThread.start();
            messageInput.setText("");
            messageInput.requestFocus();
        }else{
            System.out.println("Your message is empty");
        }

    }

    private void createUI() {
        mainLayout = new VBox();
        chatView = new TextArea();
        chatView.setPrefSize(width, height - 100);
        userActionView = new HBox();
        messageInput = new TextField();
        messageInput.setPrefSize(width - 100, 100);
        sendMessageBtn = new Button("Send");
        sendMessageBtn.setPrefSize(100, 100);
        userActionView.getChildren().addAll(messageInput, sendMessageBtn);
        mainLayout.getChildren().addAll(chatView, userActionView);
        mainScene = new Scene(mainLayout, width, height);
        window.setScene(mainScene);
        window.setTitle("Classroom chat");
        window.show();
        messageInput.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handleNewMessages(String[] newMessages) {
        System.out.println("updating chat view...");
        StringBuilder sb = new StringBuilder();
        for (String message : newMessages){
            sb.append(message);
        }
        chatView.setText(chatView.getText() + sb.toString());
        chatView.positionCaret(chatView.getLength());   // scroll chatView to the bottom.
    }
}
