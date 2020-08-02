module ejemplo
{
    requires libviews;
    requires javafx.controls; 
    requires javafx.fxml;
    requires javafx.graphics;   
    
    uses org.javafx.win.AppHandler;
    uses org.javafx.win.ConfWindows;

    uses org.javafx.win.abstracts.AbstractController;
    uses org.javafx.win.interfaces.ViewHandler;


    exports ejemplo1 to javafx.graphics;

    opens ejemplo1.fxmls.menus;
}