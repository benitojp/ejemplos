package ejemplo1.tools;

import java.util.HashMap;

import ejemplo1.fxmls.menus.MenuUIController;

public class Vistas 
{
    private static HashMap<String, Object> datos;

    public static HashMap<String,Object> principal() 
    {

        datos = Vars.rutas();
        datos.put("fxml",           "menu.fxml");
        datos.put("ruta",           Vars.getRuta("ruta") + "/menus/");
        datos.put("controller",     new MenuUIController());
        datos.put("stage",          Vars.stage);
        datos.put("bundle",         Vars.getRuta("bundle"));

        Vars.setBundle();

        return datos;
    }    

}