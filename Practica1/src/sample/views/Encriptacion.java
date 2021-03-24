package sample.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Encriptacion extends Stage implements EventHandler<KeyEvent> {
    private Scene scene;
    private HBox hBox;
    private VBox vBox;
    private ToolBar toolMenu;
    private TextArea textEntrada;
    private TextArea textSalida;
    private Button btnEncript;
    private Button btnAbrir;
    private FileChooser fileChooser;

    public Encriptacion(){
        CrearUI();
        //vBox = new VBox();
        this.setTitle("Funcion de encriptar con HASH");
        this.setScene(scene);
        this.show();

    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setStyle(" -fx-background-color: #767179");
        toolMenu = new ToolBar();
        toolMenu.setStyle(" -fx-background-color: #767179");
        btnAbrir = new Button();

        ImageView imv = new ImageView("sample/assets/icono.png");
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);

        btnAbrir.setGraphic(imv);
        btnAbrir.setOnAction(event -> abrirArchivo());
        toolMenu.getItems().add(btnAbrir);

        hBox = new HBox();
        textEntrada = new TextArea();
        textEntrada.setOnKeyPressed(this);
        textEntrada.setStyle(" -fx-backgroud-color: #A4A0A6");

        textSalida = new TextArea();
        textSalida.setEditable(false);

        hBox.getChildren().addAll(textEntrada,textSalida);
        hBox.setStyle(" -fx-backgroud-color: #A4A0A6");
        btnEncript = new Button("Encriptar");
        btnEncript.setOnAction(event -> abrirArchivo());
        vBox.getChildren().addAll(toolMenu,hBox,btnEncript);

        scene = new Scene(vBox,600,400);
    }
    private void abrirArchivo(){
        fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo para encriptar");
        fileChooser.showOpenDialog(this);
    }

    @Override
    public void handle(KeyEvent event) {
        //textSalida.appendText(event.getCode().ordinal()+"");
        //System.out.println(event.getCode().toString());
        switch (event.getCode().toString()){
            case "A":
                textSalida.appendText("a");
                /*int codigo = event.getCode().ordinal();
                textSalida.appendText();*/
                break;
            case "B":
                textSalida.appendText("b");
        }
    }
}
