package sample;
import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.views.CALCULADORA;

public class Main extends Application {

    private VBox vBox;
    private MenuBar mnbarPrincipal;
    private Menu menComp1, menComp2, menCerrar;
    private MenuItem miCalc, miSalir;
    private Scene escena;


    /*
    private HBox hBox;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private FlowPane flowpane = new FlowPane();
    */


    @Override
    public void start(Stage primaryStage) throws Exception{

        CrearUi();

        primaryStage.setTitle("clase 3");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    private void CrearUi() {
        vBox = new VBox();

        mnbarPrincipal = new MenuBar();
        menComp1 = new Menu("Competencia 1");
        menComp2 = new Menu("Competencia 1");
        menCerrar = new Menu("Cerrar ");
        mnbarPrincipal.getMenus().addAll( menComp1, menComp2, menCerrar);

        miCalc = new MenuItem("Calculadora");
        miCalc.setOnAction(event -> opcionesMenu(1));
        menComp1.getItems().add(miCalc);

        miSalir = new MenuItem("Salir");
        miSalir.setOnAction( event -> { System.exit(0);});

        menCerrar.getItems().add(miSalir);
        vBox.getChildren().add(mnbarPrincipal);

        escena = new Scene(vBox, 300,100);

    }

    private void opcionesMenu(int opc) {
        switch (opc){
            case 1: new CALCULADORA();
            break;
        }
    }

    public static void main(String[] args) {

        launch(args);
    }

}