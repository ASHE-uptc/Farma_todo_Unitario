import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.time.LocalDate;
import org.junit.Test;
import model.Product;

public class ProductTest {
    @Test
    public void ConstructorProductoInvalidoPrecio(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", -14000, 4,LocalDate.parse("2025-12-31"));
        });
        
    }

     @Test
    public void ConstructorProductoInvalidoStock(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, -20,LocalDate.parse("2025-12-31"));
        });
        
    }

     @Test
    public void ConstructorProductoInvalidoFecha(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-01-31"));
        });
        
    }

    @Test
    public void TestCálculoInvalidoPrecioPorUnidadesNegativas(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.calculatrPrice(-5);
        });
        
    }

    @Test
    public void TestRestarStockInválidoUnidadesMayoraStock(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.removeUnids(10);
        });
        
    }
    @Test
    public void TestRestarStockInválidoUnidadesNegativas(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.removeUnids(-10);
        });
    }
    @Test
    public void TestCálculoVálidoPrecio(){
        Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
        double totalPrice=product.calculatrPrice(2);
        assertEquals(28000.0,totalPrice,0.001);
    }

    @Test
    public void TestRestarUnidades(){
        Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
        product.removeUnids(1);
        assertEquals(3,product.getPro_stock());
    }

    @Test 
    public void TestSetStockNegativo(){
       Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.setPro_stock(-5);
        }); 
    }
    @Test 
    public void TestSetPrecioNegativo(){
       Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.setPro_price(-4000);
        }); 
    }
    @Test 
    public void TestSetFechaExpiraciónInválida(){
       Exception exception= assertThrows(IllegalArgumentException.class, ()->{
           Product product=new Product(1987, "Producto prueba", 14000, 4,LocalDate.parse("2025-12-31"));
           product.setPro_expirarion(LocalDate.parse("2025-01-31"));;
        }); 
    }
}
