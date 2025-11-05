import static org.junit.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import model.Druggist;
import model.FilesLoader;
import model.WriteFiles;

public class WriteFilesTest {
     @Test
    public void TestArchivoNoEncontradoFarmaceutico(){
            Exception exception= assertThrows(FileNotFoundException.class, ()->{
            List<Druggist> listDruggist = FilesLoader.LoadDruggists("druggistList.txt");
            WriteFiles.SaveFiles("C:\\IDK\\TodoEstoParaUnTest\\ArchivoInextistente.txt",listDruggist);
        });
    }
}
