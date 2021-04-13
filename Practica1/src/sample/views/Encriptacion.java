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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import java.io.File;

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
    private File archivo;
    private String text ="";


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
        archivo = fileChooser.showOpenDialog(this);
        leerArchivo();
        //fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt"));
        //fileChooser = fileChooser.showOpenDialog(handle();
    }
    private void leerArchivo() {

        if (archivo != null) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;

            try {
                fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);
                String linea = bufferedReader.readLine();
                while (linea != null) {
                    text = text + linea + "\n";
                    linea = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //txtEncriptado.appendText(e.toString());
                System.out.println(e.toString());
            } finally {
                try {
                    fileReader.close();
                } catch (Exception e2) {
                    //txtEncriptado.appendText(e2.toString());
                    System.out.println(e2.toString());
                }
            }
            textEntrada.appendText(text);
            encriptarArchivo(text);
        }
    }
    public void encriptarArchivo(String texto){
        System.out.println(texto);

        char[] caracteres = texto.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            //ASCII
            switch (caracteres[i]) {
                case 'A':
                case 'a':
                    textSalida.appendText("97");
                    break;
                case 'B':
                case 'b':
                    textSalida.appendText("98");
                    break;
                case 'C':
                case 'c':
                    textSalida.appendText("99");
                    break;
                case 'D':
                case 'd':
                    textSalida.appendText("100");
                    break;
                case 'E':
                case 'e':
                    textSalida.appendText("101");
                    break;
                case 'F':
                case 'f':
                    textSalida.appendText("102");
                    break;
                case 'G':
                case 'g':
                    textSalida.appendText("104");
                    break;
                case 'H':
                case 'h':
                    textSalida.appendText("105");
                    break;
                case 'I':
                case 'i':
                    textSalida.appendText("106");
                    break;
                case 'J':
                case 'j':
                    textSalida.appendText("107");
                    break;
                case 'K':
                case 'k':
                    textSalida.appendText("108");
                    break;
                case 'N':
                case 'n':
                    textSalida.appendText("109");
                    break;
                case 'M':
                case 'm':
                    textSalida.appendText("110");
                    break;
                case 'Ñ':
                case 'ñ':
                    textSalida.appendText("164");
                    break;
                case 'O':
                case 'o':
                    textSalida.appendText("111");
                    break;
                case 'P':
                case 'p':
                    textSalida.appendText("112");
                    break;
                case 'Q':
                case 'q':
                    textSalida.appendText("113");
                    break;
                case 'R':
                case 'r':
                    textSalida.appendText("114");
                    break;
                case 'S':
                case 's':
                    textSalida.appendText("115");
                    break;
                case 'T':
                case 't':
                    textSalida.appendText("116");
                    break;
                case 'U':
                case 'u':
                    textSalida.appendText("117");
                    break;
                case 'V':
                case 'v':
                    textSalida.appendText("118");
                    break;
                case 'W':
                case 'w':
                    textSalida.appendText("119");
                    break;
                case 'X':
                case 'x':
                    textSalida.appendText("120");
                    break;
                case 'Y':
                case 'y':
                    textSalida.appendText("121");
                    break;
                case 'Z':
                case 'z':
                    textSalida.appendText("122");
                    break;
                case ' ':
                    textSalida.appendText("\t");
                    break;
                case '\n':
                    textSalida.appendText("\n");
                    break;
            }
            //binario
            /*switch (caracteres[i]) {
                case 'A':
                case 'a':
                    textSalida.appendText("97");
                    break;
                case 'B':
                case 'b':
                    textSalida.appendText("98");
                    break;
                case 'C':
                case 'c':
                    textSalida.appendText("99");
                    break;
                case 'D':
                case 'd':
                    textSalida.appendText("100");
                    break;
                case 'E':
                case 'e':
                    textSalida.appendText("101");
                    break;
                case 'F':
                case 'f':
                    textSalida.appendText("102");
                    break;
                case 'G':
                case 'g':
                    textSalida.appendText("104");
                    break;
                case 'H':
                case 'h':
                    textSalida.appendText("105");
                    break;
                case 'I':
                case 'i':
                    textSalida.appendText("106");
                    break;
                case 'J':
                case 'j':
                    textSalida.appendText("107");
                    break;
                case 'K':
                case 'k':
                    textSalida.appendText("108");
                    break;
                case 'N':
                case 'n':
                    textSalida.appendText("109");
                    break;
                case 'M':
                case 'm':
                    textSalida.appendText("110");
                    break;
                case 'Ñ':
                case 'ñ':
                    textSalida.appendText("164");
                    break;
                case 'O':
                case 'o':
                    textSalida.appendText("111");
                    break;
                case 'P':
                case 'p':
                    textSalida.appendText("112");
                    break;
                case 'Q':
                case 'q':
                    textSalida.appendText("113");
                    break;
                case 'R':
                case 'r':
                    textSalida.appendText("114");
                    break;
                case 'S':
                case 's':
                    textSalida.appendText("115");
                    break;
                case 'T':
                case 't':
                    textSalida.appendText("116");
                    break;
                case 'U':
                case 'u':
                    textSalida.appendText("117");
                    break;
                case 'V':
                case 'v':
                    textSalida.appendText("118");
                    break;
                case 'W':
                case 'w':
                    textSalida.appendText("119");
                    break;
                case 'X':
                case 'x':
                    textSalida.appendText("120");
                    break;
                case 'Y':
                case 'y':
                    textSalida.appendText("121");
                    break;
                case 'Z':
                case 'z':
                    textSalida.appendText("122");
                    break;
                case ' ':
                    textSalida.appendText("\t");
                    break;
                case '\n':
                    textSalida.appendText("\n");
                    break;
            }*/
        }
    }
    @Override
    public void handle(KeyEvent event) {
        //textSalida.appendText(event.getCode().ordinal()+"");
        //System.out.println(event.getCode().toString());

        //ASCII
        /*switch (event.getCode().toString()){
            case "A":
                textSalida.appendText("97");
                /*int codigo = event.getCode().ordinal();
                textSalida.appendText();
                break;
            case "B":
                textSalida.appendText("98");
                break;
            case "C":
                textSalida.appendText("99");
                break;
                case "D":
                textSalida.appendText("100");
                break;
                case "E":
                textSalida.appendText("101");
                break;
                case "F":
                textSalida.appendText("102");
                break;
                case "G":
                textSalida.appendText("103");
                break;
                case "H":
                textSalida.appendText("104");
                break;
                case "I":
                textSalida.appendText("105");
                break;
                case "J":
                textSalida.appendText("106");
                break;
                case "K":
                textSalida.appendText("107");
                break;
                case "L":
                textSalida.appendText("108");
                break;
                ///////
                case "M":
                textSalida.appendText("109");
                break;
                case "N":
                textSalida.appendText("110");
                break;
                case "Ñ":
                textSalida.appendText("164");
                break;
                case "O":
                textSalida.appendText("111");
                break;
                case "P":
                textSalida.appendText("112");
                break;
                case "Q":
                textSalida.appendText("113");
                break;
                case "R":
                textSalida.appendText("114");
                break;
                case "S":
                textSalida.appendText("115");
                break;
                case "T":
                textSalida.appendText("116");
                break;
                case "U":
                textSalida.appendText("117");
                break;
                case "V":
                textSalida.appendText("118");
                break;
                case "W":
                textSalida.appendText("119");
                break;
                case "X":
                textSalida.appendText("120");
                break;
                case "Y":
                textSalida.appendText("121");
                break;
            case "Z":
                textSalida.appendText("122");
                break;
        }*/
        //binario
        /*switch (event.getCode().toString()){
            case "A":
                textSalida.appendText("01100001");
                //int codigo = event.getCode().ordinal();
                //textSalida.appendText();
                break;
            case "B":
                textSalida.appendText("01100010");
                break;
            case "C":
                textSalida.appendText("01100011");
                break;
            case "D":
                textSalida.appendText("01100100");
                break;
            case "E":
                textSalida.appendText("01100101");
                break;
            case "F":
                textSalida.appendText("01100110");
                break;
            case "G":
                textSalida.appendText("01100111");
                break;
            case "H":
                textSalida.appendText("01101000");
                break;
            case "I":
                textSalida.appendText("01101001");
                break;
            case "J":
                textSalida.appendText("01101010");
                break;
            case "K":
                textSalida.appendText("01101011");
                break;
            case "L":
                textSalida.appendText("01101100");
                break;
            case "M":
                textSalida.appendText("01101101");
                break;
            case "N":
                textSalida.appendText("01101110");
                break;
            case "Ñ":
                textSalida.appendText("01101001");
                break;
            case "O":
                textSalida.appendText("01101111");
                break;
            case "P":
                textSalida.appendText("01110000");
                break;
            case "Q":
                textSalida.appendText("01110001");
                break;
            case "R":
                textSalida.appendText("01110010");
                break;
            case "S":
                textSalida.appendText("01110011");
                break;
            case "T":
                textSalida.appendText("01110100");
                break;
            case "U":
                textSalida.appendText("01110101");
                break;
            case "V":
                textSalida.appendText("01110110");
                break;
            case "W":
                textSalida.appendText("01110111");
                break;
            case "X":
                textSalida.appendText("01111000");
                break;
            case "Y":
                textSalida.appendText("01111001");
                break;
            case "Z":
                textSalida.appendText("01111010");
                break;
        }*/
    }
}
