package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private HBox hBox;
    private VBox vBox;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        CrearUI();

        primaryStage.setTitle("Semaforo-Botones");
        primaryStage.setScene(new Scene(vBox,300,300));
        primaryStage.setScene(new Scene(hBox,300,300));
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private void CrearUI(){

        btn1 = new Button("Luz1");
        btn2 = new Button("Luz2");
        btn3 = new Button("Luz3");
        btn4 = new Button("Luz4");
        btn5 = new Button("Luz5");
        btn6 = new Button("Luz6");

        hBox = new HBox();
        vBox = new VBox();

        hBox.getChildren().addAll(btn1,btn2,btn3);
        //hBox.setBackground(java.awt.color.green);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(30,30,30,30));
        //btn1.setStyle(" -fx-padding: 20px;");
        btn1.setStyle(" -fx-background-color: #FF3633; -fx-padding: 20px;");
        btn2.setStyle(" -fx-background-color: #FFFE33;");
        btn3.setStyle(" -fx-background-color: #5AFF33; -fx-padding: 20px;");


        vBox.getChildren().addAll(btn4,btn5,btn6);
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(20));
        btn4.setStyle(" -fx-background-color: #FF3633; -fx-padding: 20px;");
        btn5.setStyle(" -fx-background-color: #FFFE33;");
        btn6.setStyle(" -fx-background-color: #5AFF33; -fx-padding: 20px;");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
