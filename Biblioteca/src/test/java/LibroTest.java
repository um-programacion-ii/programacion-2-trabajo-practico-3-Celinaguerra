import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibroTest {

    @Test
    void testCrearLibroValido() {
        Libro libro = new Libro("978-3-16-148210-0", "Ensayo sobre la ceguera", "José Saramago");
        assertEquals("978-3-16-148210-0", libro.getIsbn());
        assertEquals("Ensayo sobre la ceguera", libro.getTitulo());
        assertEquals("José Saramago", libro.getAutor());
        assertEquals(Libro.Estado.DISPONIBLE, libro.getEstado());
    }

    @Test
    void testCambioEstado() {
        Libro libro = new Libro("988-3-16-148210-0", "Ensayo sobre la ceguera", "José Saramago");
        assertEquals(Libro.Estado.DISPONIBLE, libro.getEstado());
        libro.setEstado(Libro.Estado.PRESTADO);
        assertEquals(Libro.Estado.PRESTADO, libro.getEstado());
        libro.setEstado(Libro.Estado.DISPONIBLE);
        assertEquals(Libro.Estado.DISPONIBLE, libro.getEstado());
    }
}
