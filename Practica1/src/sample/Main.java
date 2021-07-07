package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.models.CancionesDAO;
import sample.models.Conexion;
import sample.views.*;

import java.util.Objects;

public class Main extends Application implements EventHandler<WindowEvent> {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu, miCabeza, miEncriptacion,mitBDCASETE,mitRunners,mitSocket, miSalir;
    private Scene escena;

    /*
    private HBox hBox;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private FlowPane flowpane = new FlowPane();
    */  //codigo de la tarea

    @Override
    public void start(Stage primaryStage) throws Exception{

        CrearUi();

        //primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, this);
        primaryStage.setTitle("Proyecto de Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
//base ded datos, abrir conexcion global
       Conexion.getConexion();
        //Runner
        /*new Runner("Homero").start();
        new Runner("Flash").start();
        new Runner("Quick Silver").start();
        new Runner("Bob Toronja").start();
        new Runner("Chuerk").start();*/
    }

    private void CrearUi() {
        vBox = new VBox();

        mnbPrincipal = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        menCerrar = new Menu("Cerrar ");
        mnbPrincipal.getMenus().addAll(menCompetencia1, menCompetencia2, menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        //mitCalcu.setStyle(" -fx-background-color: #D5BBE1");

        miCabeza = new MenuItem("Rompecabezas");//se agrega el item rompecabeza
        miCabeza.setOnAction(event -> opcionesMenu(2));

        miEncriptacion = new MenuItem("Encriptar");
        miEncriptacion.setOnAction(event -> opcionesMenu(3));


        //mnbPrincipal.setStyle(" -fx-background-color: #078A98");

        mitBDCASETE = new MenuItem("BDMicasete");
        mitBDCASETE.setOnAction(event -> opcionesMenu(4));

        menCompetencia1.getItems().addAll(mitCalcu, miCabeza, miEncriptacion,mitBDCASETE);//se agrega item calc y rompecabez

        mitRunners = new MenuItem("Ejecucion de hilos");
        mitRunners.setOnAction(event-> opcionesMenu(5));

        mitSocket = new MenuItem("Manejo de Socket");
        mitSocket.setOnAction(event -> opcionesMenu(6));

        menCompetencia2.getItems().addAll(mitRunners, mitSocket);
        miSalir = new MenuItem("Salir");
        miSalir.setOnAction( event -> { System.exit(0);});

        menCerrar.getItems().add(miSalir);
        vBox.setStyle(" -fx-background-color: #043F60");
        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox, 300,100);
        escena.getStylesheets().add(Objects.requireNonNull(getClass().getResource("assets/css/styles.css")).toExternalForm());

    /*
        GridPane grid = new GridPane();
        btn1 = new Button("Boton 1" );
        btn2 = new Button("Boton 2" );
        btn3 = new Button("Boton 3" );
        btn4 = new Button("Boton 4" );
        btn5 = new Button("Boton 5" );
        btn6 = new Button("Boton 6" );
        btn7 = new Button("Boton 7" );
        btn1.setStyle("-fx-background-color: #DCD429; -fx-font-size: 2em; ");
        btn2.setStyle("-fx-background-color: #43CD1E; -fx-font-size: 1.5em;  ");
        btn3.setStyle("-fx-background-color: #759FD8; -fx-font-size: 2em; -fx-border-width: 15px;");
        btn4.setStyle("-fx-background-color: #D153D5; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn5.setStyle("-fx-background-color: #F66724; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn6.setStyle("-fx-background-color: #E9F31C; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn7.setStyle("-fx-background-color: #F794CA; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        hBox = new HBox();
        vBox = new VBox();
        BorderPane pane = new BorderPane();
        Label lbl = new Label("Esta es una etiqueta");
        lbl.setStyle("-fx-background-color: #B5EEDB;");
        pane.setCenter(lbl);
        AnchorPane anchor= new AnchorPane();
        AnchorPane.setTopAnchor(btn6,7.0);
        AnchorPane.setRightAnchor(btn6,15.0);
        AnchorPane.setBottomAnchor(btn7,300.0);
        AnchorPane.setLeftAnchor(btn7,200.0);
        anchor.getChildren().addAll(btn6, btn7,new Button("botoncito"));
        hBox.getChildren().addAll(btn6,btn7,anchor );
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20,20,20,20));
        flowpane.getChildren().addAll(btn1,btn2, btn3,lbl,grid, anchor, btn6, btn7 );
        flowpane.setHgap(10);
        flowpane.setVgap(10);
        flowpane.setPadding(new Insets(20));
        grid.add(btn4, 0, 1, 1, 1);
        grid.add(btn5, 1, 1, 1, 1);
*/  //codigo de la tarea
    }

    private void opcionesMenu(int opc) {
        switch (opc){
            case 1: new CALCULADORA();
                break;
            case 2: new RompeHD();
                break;
            case 3: new Encriptacion();
            break;
            case 4: new FormCanciones();
            break;
            case 5: new Pista();
            break;
            case 6: new ClienteSocket().connectToServer();
            break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("MSM :v");
        alert.setHeaderText("Gracias por usar la APP");
        alert.setContentText("Lo esperamos pronto!");
        alert.showAndWait();
    }
}