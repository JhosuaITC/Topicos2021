package sample.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CALCULADORA extends Stage {

    private Scene escena;
    private TextField txtOperacion;
    private HBox[] hBoxes ;
    private Button[] arbotones;
    private VBox vBox;
    private char[] arNumero = {'7','8','9','/','4','5','6','*','1','2','3','-','0','=','+'};

    public CALCULADORA (){

        CrearUI();

        this.setTitle("Calculadora");
        this.setScene(escena);;
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arbotones = new Button[16];
        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        txtOperacion.setPrefHeight(50);
        txtOperacion.setText("0");
        txtOperacion.setAlignment(Pos.BASELINE_RIGHT);

        int post = 0;

        for (int i = 0; i < hBoxes.length ; i++){// Itegrarme sobre el arreglo de hbox
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding(new Insets(5));

            for (int j = 0; j < 4; j++){//Ciclo para crear y cargr 4 botones
                arbotones[post] = new Button(arNumero[post]+"");
                arbotones[post].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arbotones[post]);
                post++; //Contador de los botones creados
            }

        }
        vBox.getChildren().addAll(txtOperacion, hBoxes[0], hBoxes[1], hBoxes[2], hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));
        escena = new Scene(vBox, 250,250);
    }

}
