package ejemplo1;

import ejemplo1.tools.Vars;
import ejemplo1.tools.Vistas;

import javafx.application.Application;
import javafx.stage.Stage;

import org.javafx.win.AppHandler;

public class Main 
        extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }    

    @Override 
    public void start(Stage s)
                throws Exception
    {
        Vars.bundle = null;
        Vars.stage  = s;
        Vars.apph   = new AppHandler(Vistas.principal());
        Vars.apph.launchWindow();
    }
}