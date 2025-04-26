import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class CatalogoTest {

    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "Demian", "Hermann Hesse");
        libro2 = new Libro("978-0-13-235088-4", "Mujercitas", "Jane Austen");
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testBuscarPorIsbn() {
        Libro libro = catalogo.buscarLibroPorIsbn("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("Demian", libro.getTitulo());
    }

    @Test
    void testBuscarPorIsbnNull() {
        Libro libro = catalogo.buscarLibroPorIsbn("978-3-16-148410-3");
        assertNull(libro);
    }

}