import org.junit.*;

import UI.LoginGUI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import model.Druggist;
import model.FilesLoader;
import UI.*;

/**
 * @author Axel
 * @version 1.01
 * Esta es la clase TestLoginGUI, encargada de probar el correcto funcionamiento de sus métodos implementando las librerías de JUnit.
 * 
 */

public class TestLoginGUI{

    /**
     * <p>El siguiente método: TeststartLoginCorrecto contiene los parámetros esperados al momento de la ejecucion del método startLogin
     * de la clase LoginGUI. Con ayuda de las funciones assertNotNUll se comprueba que la lista de usuarios, la contraseña ingresada y
     * el usuario ingresado sno sean nulos. La función assertEquals se encarga de comprobar que, efectivamente, la ruta de la lista de 
     * farmacéuticos "druggistList.txt" esté bien ingresada y que el FilesLoade pueda recorrer el archivo .txt.<p>
     *
     * <p>Para este test se espera que hayan resultados positivos, ya que los datos están bien ingresados.
     * En otras palabras, si los datos están bien ingresados y no son nulos, este método mostrará resultado positivo.
     * Describe lo que este método en específico si debe leer o hacer.<p>
    * @throws FileNotFoundException 
     * 
     * */ 
    @Test
    public void TeststartLoginCorrecto() throws FileNotFoundException{
       LoginGUI testLoginGUI=new LoginGUI();
       List<Druggist>druggList=new ArrayList<>();
       String log_user="";
       String pass="";
       
    
       assertEquals("La ruta de la lista de Farmaceuticos es incorrecta. ","druggistList.txt", testLoginGUI.getPathfiledruggist());
       System.out.println(testLoginGUI.getPathfiledruggist());
       assertNotNull("La lista de Usuarios es Nula. ",druggList);
       assertNotNull("La contraseña no puede ser nula.",pass);
       assertNotNull("El Usuario no puede ser nulo.",log_user);
       
    }


    /** 
     * <p>Para este test se espera que hayan resultados negativos, ya que los datos están mal ingresados a propósito.
     * En otras palabras, si los datos están mal ingresados o son nulos, este método mostrará resultados negativos, indicando los fallos.
     * que tenga el método.<p>
     * 
     * <p>Describe lo que este método en específico no debe leer o hacer, y si detecta la excepcion, comprueba que esta se lance
     * correctamente.<p>
     * 
     * */ 

    @Test
    public void TeststartLoginIncorrecto(){
      String pathfiledruggist="rutaincorrecta";
      Exception excepcion=assertThrows(FileNotFoundException.class, ()->{
       LoginGUI testLoginGUI=new LoginGUI();
       
       List<Druggist>druggList=FilesLoader.LoadDruggists(pathfiledruggist);
       
       try {
         testLoginGUI.setPathfiledruggist("RUTAINCORRECTA");
         testLoginGUI.comprobarPathFile();
       } catch (FileNotFoundException e) {
         throw new FileNotFoundException("Archivo no encontrado Exception");
       };
    
       assertEquals("La ruta de la lista de Farmaceuticos es incorrecta. ","druggistList.txt", testLoginGUI.getPathfiledruggist());
       System.out.println(testLoginGUI.getPathfiledruggist());
       assertNotNull("La lista de Usuarios es Nula. ",druggList);
       });
    }
}
