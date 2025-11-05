import static org.junit.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import model.Client;
import model.Druggist;
import model.FilesLoader;
import model.Product;

public class LoaderFilesTest {
    /**Método para probar que el programa si este tomando la excepción
     * 
     */
    @Test
    public void TestArchivoNoEncontradoFarmaceutico(){
            Exception exception= assertThrows(FileNotFoundException.class, ()->{
            FilesLoader.LoadDruggists("ArchivoInexistente.txt");
        });
    }
    @Test
    public void TestArchivoNoEncontradoProductos(){
        Exception exception= assertThrows(FileNotFoundException.class, ()->{
            List<Product>productList = FilesLoader.LoadProducts("ArchivoInexistente.txt");
        });
    }

    @Test
    public void TestArchivoFormatoNúmericoInválidoProductos(){
        Exception exception= assertThrows(NumberFormatException.class, ()->{
            List<Product>productList = FilesLoader.LoadProducts("Corrupted_file.txt");
        });
    }

    @Test
    public void TestArchivoDatosIncompletosFarmaceutico(){
            Exception exception= assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            FilesLoader.LoadDruggists("Corrupted_file.txt");
        });
    }
}
