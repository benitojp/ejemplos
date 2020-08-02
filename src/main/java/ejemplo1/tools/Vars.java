package ejemplo1.tools;

import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.javafx.win.AppHandler;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Vars 
{

    public static Stage stage;    
    public static ResourceBundle bundle;
    public static AppHandler apph;

    private static final HashMap<String,Object> RUTAS = new HashMap<>();
    static 
    {
        RUTAS.put("fxml"            , "");
        RUTAS.put("ruta"            , "out/resources/fxmls/");
        RUTAS.put("site"            , "main");
        RUTAS.put("template"        , "mainTemplate");
        RUTAS.put("modal"           , Boolean.TRUE);
        RUTAS.put("ruta_template"   , "out/resources/templates/");
        RUTAS.put("css"             , "out/resources/css/");
        RUTAS.put("imgs"            , "out/resources/imgs/");
        RUTAS.put("bundle"          , "resources/resources/appResources");
        RUTAS.put("controller"      , null);
        RUTAS.put("rb"              , null);
    }
    
    public static Object getRuta(String key)
    {
        return (RUTAS.keySet().contains(key) ? RUTAS.get(key) : "");
    }

    public static HashMap<String,Object> rutas()
    {
        return RUTAS;
    }

    //<editor-fold defaultstate="collapsed" desc="Gestión valores resource properties with ResourceBundle">
    public static void setBundle()
    {
        /*
        Vars.RUTAS.put("rb", ResourceBundle.getBundle(
                                cambiarBarra((String)getRuta("bundle"), true), 
                                Locale.getDefault()));
        */
        Vars.RUTAS.put("rb", ResourceBundle.getBundle((String)Vars.getRuta("bundle"),Locale.getDefault()));
    }

    public static ResourceBundle bundle()
    { 
        /*
        return ResourceBundle.getBundle(cambiarBarra((String)getRuta("bundle"), 
                                                    true), 
                                                    Locale.getDefault());
        */
        String rbundle = (String)Vars.getRuta("bundle");
        Locale local   = Locale.getDefault();
        System.out.println("Bundle: " + rbundle);
        System.out.println("Locale: " + local);
        return ResourceBundle.getBundle((String)Vars.getRuta("bundle"), Locale.getDefault());
    }
    
    public static String getKeyBundle(String k)
    { 
        String ruta = (String)Vars.getRuta("bundle");
        String valor= Vars.bundle.getString(k);
        System.out.println(String.format(" ruta: %s", ruta));
        System.out.println(String.format("valor: %s", valor));
        return Vars.bundle.getString(k); 
    }

    public static String getTextBundle(String k) 
    {
        return ((ResourceBundle)Vars.getRuta("rb")).getString(k);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="caracteres ruta ficheros o directorios">
    /** 
     * cambia los puntos de separación de una ruta pora la barra inclinada
     * derecha o izquierda
     * @param s
     * @param derecha
     * @return 
     */
    public static String cambiarPuntosABarra(String s, boolean derecha)
    {
        return s.replace('.', (derecha ? '/' : '\\'));
    }
    
    public static String cambiarBarraAPuntos(String s)
    {
        return (s.contains("\\")) 
                    ? s.replace("\\", ".")
                    : s.replace("/", "." );
        
    }
    
    /**
     * cambia la dirección de las barras
     * @param s
     * @param derecha
     * @return 
     */
    public static String cambiarBarra(String s, boolean derecha)
    {
        return (derecha ? s.replace('\\', '/') : s.replace('/', '\\'));
    }
    // </editor-fold>

    public static ImageView imagenBoton(String ibt, int[] tamagno)
    {
        int default_height = 35;
        int default_width = 35;
        
        if (tamagno.length > 1) 
        {
            default_height = tamagno[0];
            default_width  = tamagno[1];
        } 
        else 
        {
            default_height = tamagno[0];
        }
        return crearImagenBoton(ibt, default_height, default_width);
    }
    
    public static ImageView imagenBoton(String ibt)
    {
        int default_height = 35;
        int default_width = 35;
        return crearImagenBoton(ibt, default_height, default_width);
    }
    
    private static ImageView crearImagenBoton(String ibt, int alto, int ancho) 
    {
        try 
        {
            String nameImg = ((ResourceBundle)Vars.getRuta("rb")).getString(ibt);
            String rutaImg = (String)Vars.getRuta("imgs");
            // An image file on the hard drive.
            File file = new File(rutaImg + nameImg);
    
            // --> file:/C:/MyImages/myphoto.jpg
            String localUrl = file.toURI().toURL().toString();
            
            //String rutaImg = (String)Vars.getRuta("imgs");
            Image img = new Image(localUrl);
            ImageView view = new ImageView(img);
            
            view.setFitHeight(alto);
            view.setFitWidth(ancho);
            view.setPreserveRatio(true);
            return view;

        } catch (MalformedURLException mur){}
        return null;
    }


}