package sample.assets.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.CancionesDAO;

public class CellCustom extends TableCell<CancionesDAO,String> {

    private Button btnCelda;
    public CellCustom(){
        btnCelda = new Button("Edit");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            setGraphic(btnCelda);
        }
    }
}
