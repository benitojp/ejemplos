package ejemplo1.fxmls.menus;

import org.javafx.win.abstracts.AbstractController;
import org.javafx.win.interfaces.ViewHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ejemplo1.tools.Vars;

public class MenuUIController 
        extends AbstractController 
        implements Initializable 
{

    @FXML private Menu      lblUsuarios;
    @FXML private MenuItem  itemInternos;
    @FXML private MenuItem  itemModulos;
    @FXML private MenuItem  cerrarApp;

    public MenuUIController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        cargarEtiquetas();
        crearAcciones();
    }   

    private void crearAcciones() 
    {
        itemInternos.setOnAction((event) -> {procesar("internos");});
        itemModulos.setOnAction((event) -> {procesar("modulos");});
        cerrarApp.setOnAction((event) -> {procesar("salir");});
    }

    private void procesar(String proceso) 
    {
        switch (proceso.toLowerCase())
        {
            case "internos":
                //try 
                //{
                //    
                //} catch (java.io.IOException io){}
                break;
            case "modulos":
                break;
            case "salir":
                javafx.application.Platform.exit();
            default:
                break;
        }
    }

    private void cargarEtiquetas() 
    {
        lblUsuarios.setText(Vars.getTextBundle("menu.mant"));
        itemInternos.setText(Vars.getTextBundle("menu.mant.internos"));
        itemModulos.setText(Vars.getTextBundle("menu.mant.modulos"));
        cerrarApp.setText(Vars.getTextBundle("menu.exit"));
    }
}