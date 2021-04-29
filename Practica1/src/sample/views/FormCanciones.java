package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.models.CancionesDAO;

public class FormCanciones extends Stage {
    private TableView<CancionesDAO> tableVCansiones;
    private Scene scene;
    
    public FormCanciones(){
        CrearUI();
        this.setTitle("Gestion de canciones");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        tableVCansiones = new TableView<>();
        scene = new Scene(tableVCansiones, 300,250);

    }
}
