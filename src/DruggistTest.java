import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import model.Druggist;

public class DruggistTest {
    //Testeo de casos exitosos
    @Test
    public void TestConstructorDruggistExitoso(){
        //Se crea un objeto druggist
        Druggist druggist= new Druggist("Pepe", 'C', "23453", "Pepeps", "JULIAN");
        // el assert verifica que el objeto creado no sea nulo
        assertNotNull(druggist);
        assertEquals("Pepe", druggist.getName());
        assertEquals('C', druggist.getDoc_type());
        assertEquals("23453", druggist.getDoc_num());
        assertEquals("Pepeps", druggist.getDruggist_user());
        assertEquals("JULIAN", druggist.getDruggist_password());
    }
    @Test
    public void TestSetDruggistUserExitoso(){
        Druggist druggist= new Druggist("Pepe", 'C', "23453", "Pepeps", "JULIAN");
        druggist.setDruggist_user("Pedro");
        assertEquals("Pedro", druggist.getDruggist_user());
    }
    //Teste de casos de excepciones
    @Test
    public void TestConstructorDruggistNameInvalido(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Druggist druggist= new Druggist(null, 'C', "23453", "Pepeps", "JULIAN");
        });
    }
    @Test
    public void TestConstructorDruggistPasswordInvalido(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Druggist druggist= new Druggist("Pepe", 'C', "23453", "Pepeps", null);
        });
    }
    @Test
    public void TestConstructorDruggistUserInvalido(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Druggist druggist= new Druggist("Pepe", 'C', "23453", null, "JULIAN");
        });
    }
    @Test
    public void TestSetDruggistUserInvalido(){
        Exception exception=assertThrows(IllegalArgumentException.class, ()->{
            Druggist druggist= new Druggist("Pepe", 'C', "23453", "Pepeps", "JULIAN");
            druggist.setDruggist_user(null);
        });
    }
    @Test
    public void TestSetDruggistPasswordInvalido(){
        Exception exception=assertThrows(IllegalArgumentException.class, ()->{
            Druggist druggist= new Druggist("Pepe", 'C', "23453", "Pepeps", "JULIAN");
            druggist.setDruggist_password(null);
        });
    }
    
}