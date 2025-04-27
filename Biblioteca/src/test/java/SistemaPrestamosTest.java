import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    public SistemaPrestamosTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPrestarLibro() {

        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        when(catalogo.buscarLibroPorIsbn("978-3-16-148410-0")).thenReturn(libro);

        Libro libroEncontrado = catalogo.buscarLibroPorIsbn("978-3-16-148410-0");
        boolean prestado = sistemaPrestamos.prestarLibro(libroEncontrado);

        assertTrue(prestado);
        verify(catalogo).buscarLibroPorIsbn("978-3-16-148410-0");
        assertEquals(Libro.Estado.PRESTADO, libro.getEstado());
    }
}
