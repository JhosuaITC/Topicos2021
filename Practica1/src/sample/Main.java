package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.views.CALCULADORA;
import sample.views.RompeHD;

public class Main extends Application {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu,mitCabeza,mitSalir;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        CrearMenu();

        primaryStage.setTitle("Proyecto de Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void CrearMenu() {
        vBox = new VBox();

        mnbPrincipal    = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Compentencia 2");
        menCerrar       = new Menu("Cerrar");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2,menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitCalcu.setStyle(" -fx-background-color: #D5BBE1");

        mitCabeza = new MenuItem("RompeCabezas");
        mitCabeza.setOnAction(event -> opcionesMenu(2));

        menCompetencia1.getItems().addAll(mitCalcu,mitCabeza);

        mnbPrincipal.setStyle(" -fx-background-color: #B0C438");

        mitSalir  = new MenuItem("Salir");
        mitSalir.setOnAction(event -> { System.exit(0);});

        menCerrar.getItems().add(mitSalir);

        vBox.setStyle(" -fx-background-color: #52A508");
        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox, 300, 70);

    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new CALCULADORA();
            break;
            case 2: new RompeHD();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}