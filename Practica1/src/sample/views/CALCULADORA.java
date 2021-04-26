package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class CALCULADORA extends Stage implements EventHandler {

    private Scene esena;
    private TextField txtOperacion;
    private HBox[] hBoxes;
    private Button[] arBtn;
    private VBox vBox;
    private  char[] arNumeros = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','=','+'};
    private String cadencon ="";
    private String operador = "";
    private String num = "";
    private double operacion;

    public CALCULADORA() {

        CrearUI();

        this.setTitle("Calculadora");
        this.setScene(esena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arBtn = new Button[16];
        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        txtOperacion.setPrefHeight(50);
        txtOperacion.setText("0");

        int pos = 0;
        for (int i = 0; i < hBoxes.length; i++ ){//iterarme para el arreglo de HBox
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding( new Insets(7));

            for (int j = 0; j < 4; j++) {//ciclo para crear y cargar 4 botones
                arBtn[pos] = new Button(arNumeros[pos]+"");
                arBtn[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventCalcu(arNumeros[pos]));
                arBtn[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //System.out.println("Tercer Evento UwU:");
                        String caract = "" + event.getSource();

                        if(!String.valueOf(btnPresionado(caract)).equals("=")){
                            cadencon += btnPresionado(caract);
                            if(!String.valueOf(btnPresionado(caract)).equals("+") && !String.valueOf(btnPresionado(caract)).equals("-")
                                    && !String.valueOf(btnPresionado(caract)).equals("*") && !String.valueOf(btnPresionado(caract)).equals("/")){
                                num += btnPresionado(caract);
                                //txtOperacion.setText("" + btnPresionado(caract));
                                txtOperacion.setText(cadencon);
                            } else if(String.valueOf(btnPresionado(caract)).equals("+") || String.valueOf(btnPresionado(caract)).equals("-")
                                    || String.valueOf(btnPresionado(caract)).equals("*") || String.valueOf(btnPresionado(caract)).equals("/")){
                                txtOperacion.setText("");
                                cadencon = "";
                                operacion++;
                                num += "-";
                                if(operacion == 1){
                                    operador += btnPresionado(caract);
                                } else{
                                    operador += " " + btnPresionado(caract);
                                }
                            }
                        } else{
                            txtOperacion.setText(String.valueOf(soloPrueba(num, operador)));
                            cadencon = "";
                            operador = "";
                            num = "";
                        }
                    }
                });
                //txtOperacion.addEventHandler(MouseEvent.MOUSE_CLICKED);
                arBtn[pos].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arBtn[pos]);
                pos++;//contador de botones creados
            }
        }
        arBtn[pos-1].setId("font-button");

        vBox.setStyle(" -fx-background-color: #757272");
        vBox.getChildren().addAll(txtOperacion,hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));

        esena = new Scene(vBox, 250, 250);
        esena.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../assets/css/StylesCalcu.css")).toExternalForm());
    }//cearUI

    @Override
    public void handle(Event event) {
        // System.out.println("Primer Evento UwU");
    }
    private char btnPresionado(String entrada){
        char caracter = Character.MIN_VALUE;
        caracter = entrada.charAt(entrada.length()-2);
        return caracter;
    }
    public double soloPrueba (String entrada, String operandos){
        double resultado = 0;
        String partCadena[] = entrada.split("-");
        switch (operandos){
            case "+":
                resultado = Double.parseDouble(partCadena[0]) + Double.parseDouble(partCadena[1]);
                break;
            case "-":
                resultado = Double.parseDouble(partCadena[0]) - Double.parseDouble(partCadena[1]);
                break;
            case "*":
                resultado = Double.parseDouble(partCadena[0]) * Double.parseDouble(partCadena[1]);
                break;
            case "/":
                resultado = Double.parseDouble(partCadena[0]) / Double.parseDouble(partCadena[1]);
                break;
        }
        return resultado;
    }
} //class
class EventCalcu implements EventHandler{

    char tecla;
    public EventCalcu(char tecla){
        this.tecla=tecla;
    }

    @Override
    public void handle(Event event) {

        System.out.println(tecla);
    }
}