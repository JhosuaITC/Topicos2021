package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RompeHD extends Stage implements EventHandler {

    private String[] arIMagenes = {"fila-1-col-1.jpg","fila-1-col-2.jpg","fila-1-col-3.jpg","fila-1-col-4.jpg","fila-1-col-5.jpg","fila-2-col-1.jpg"
            ,"fila-2-col-2.jpg","fila-2-col-3.jpg","fila-2-col-4.jpg","fila-2-col-5.jpg","fila-3-col-1.jpg","fila-3-col-2.jpg","fila-3-col-3.jpg"
            ,"fila-3-col-4.jpg","fila-4-col-1.jpg","fila-4-col-2.jpg","fila-4-col-3.jpg","fila-4-col-4.jpg"};
    private  String[][]arAsignacion;
    private BorderPane borderpane;
    private GridPane tablero;
    private Button[][]btnTarjet;
    private HBox hBox;
    private Label lbtarjet;
    private TextField txtTarjet;
    private Button btnMix;
    private Scene escena;
    private int noPz;
    private boolean NumSelect =false; //indica si ya se selecciono una carta para el intercambio

    private int Xtemp,ytemp =0;

    public RompeHD(){

        CrearUI();
        this.setTitle("RompeCabezas");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        borderpane = new BorderPane();

        lbtarjet = new Label("Cantidad Pz");
        txtTarjet = new TextField();
        btnMix = new Button("Mezclar Pz");
        btnMix.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        hBox = new HBox();
        hBox.getChildren().addAll(lbtarjet,txtTarjet,btnMix);

        borderpane.setTop(hBox);

        tablero = new GridPane();
        borderpane.setCenter(tablero);

        escena = new Scene(borderpane, 820,600);


    }

    @Override
    public void handle(Event event) {
        noPz = Integer.parseInt(txtTarjet.getText());
        btnTarjet = new Button[noPz][noPz];
        arAsignacion = new String[5][5];
        revolver();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Image img =new Image("sample/assets/" + arAsignacion[i][j]);
                ImageView imv = new ImageView(img);
                imv.setFitHeight(80);
                imv.setPreserveRatio(true);


                btnTarjet[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                btnTarjet[i][j].setOnAction(event1 -> intercambio(finalI, finalJ));
                btnTarjet[i][j].setGraphic(imv);
                btnTarjet[i][j].setPrefSize(50,50);
                tablero.add(btnTarjet[i][j], j,i);
            }
        }
    }
    private void intercambio(int i, int j){
        //System.out.println("Posicion : "+i+" - "+j);
        if (!NumSelect){
            NumSelect = !NumSelect;
            Xtemp=i;
            ytemp=j;
        }else {
            Image img =new Image("sample/assets/" + arAsignacion[i][j]);
            ImageView imv = new ImageView(img);
            imv.setFitHeight(80);
            imv.setPreserveRatio(true);

            Image img2 =new Image("sample/assets/" + arAsignacion[Xtemp][ytemp]);
            ImageView imv2 = new ImageView(img2);
            imv2.setFitHeight(80);
            imv2.setPreserveRatio(true);

            btnTarjet[Xtemp][ytemp].setGraphic(imv);
            btnTarjet[i][j].setGraphic(imv2);

            NumSelect = false;
        }
    }

    private void revolver(){
        //Definir objetos String y llenando el arreglo bidimencional
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arAsignacion[i][j] = new String();
            }

        }
        int posx, posy =0;
        for (int i = 0; i < arIMagenes.length;) {
            posx = (int) (Math.random() * 4);
            posy = (int) (Math.random() *4);
            if (arAsignacion[posx][posy].equals("")){
                arAsignacion[posx][posy] = arIMagenes[i];
                i++;
            }
        }
    }
}
