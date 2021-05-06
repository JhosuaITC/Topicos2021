package sample.views;

import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.assets.components.CellCustom;
import sample.models.CancionesDAO;

public class FormCanciones extends Stage {
    private TableView<CancionesDAO> tableVCansiones;
    private Button btnAdd;
    private VBox vBox;
    private Scene scene;

    private CancionesDAO objcanDAO;
    
    public FormCanciones(){

        objcanDAO = new CancionesDAO();
        CrearUI();
        this.setTitle("Gestion de canciones");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tableVCansiones = new TableView<>();
        btnAdd = new Button("+ Add");
        vBox.getChildren().addAll(tableVCansiones,btnAdd);
        CreaTabla();
        scene = new Scene(vBox, 500,250);

    }

    private void CreaTabla() {
        TableColumn<CancionesDAO, Integer> tbcIdCancion = new TableColumn<>("ID");
        tbcIdCancion.setCellValueFactory(new PropertyValueFactory<>("id_cancion"));

        TableColumn<CancionesDAO,String> tbcNombreCancion = new TableColumn<>("Cancion");
        tbcNombreCancion.setCellValueFactory(new PropertyValueFactory<>("nombre_cancion"));

        TableColumn<CancionesDAO, Integer> tbcDuracion = new TableColumn<>("Duracion");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn<CancionesDAO, String> tbcPortada = new TableColumn<>("Portada");
        tbcPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));

        TableColumn<CancionesDAO,Integer> tbcYear = new TableColumn<>("Year");
        tbcYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<CancionesDAO, String> tbcLetra = new TableColumn<>("Letra");
        tbcLetra.setCellValueFactory(new PropertyValueFactory<>("letra"));

        TableColumn<CancionesDAO, String> tblEdit = new TableColumn<>("Edit");
        tblEdit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CancionesDAO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CancionesDAO, String> param) {
                return null;
            }
        });
        TableColumn<CancionesDAO, String> tblDelet = new TableColumn<>("Deleted");
        tblEdit.setCellFactory(new Callback<TableColumn<CancionesDAO, String>, TableCell<CancionesDAO,String>>() {
            @Override
            public TableCell<CancionesDAO,String> call(TableColumn<CancionesDAO, String> param) {
                return new CellCustom();
            }
        });
        tableVCansiones.getColumns().addAll(tbcIdCancion,tbcNombreCancion,tbcDuracion,tbcPortada,tbcYear,tbcLetra,tblEdit,tblDelet);
        tableVCansiones.setItems(objcanDAO.SELECT());
    }
}
