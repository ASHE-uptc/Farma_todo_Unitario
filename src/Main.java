import javax.swing.SwingUtilities;
//AHOY
//Este es el main del proyecto.
// comentario Julian
import org.junit.Test;

import UI.FarmaTodoGUI;
import UI.FarmaceuticosMenu;
import UI.LoginGUI;
import model.Druggist;
import model.FilesLoader;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    
    public static void app(String[] args) throws Exception {
        //Comentario por julian
        //Comentario por Axel
        String pathfiledruggist="druggistList.txt";
        List<Druggist> druggList=FilesLoader.LoadDruggists(pathfiledruggist);
        SwingUtilities.invokeLater(()->{
        LoginGUI loginGUI = new LoginGUI();
        try {
            loginGUI.startLogin();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado Excepcion.");
            e.printStackTrace();
        }
             //COMENTARIO POR FELP
        });
}}

