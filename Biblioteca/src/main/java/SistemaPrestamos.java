import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaPrestamos {

    private List<Prestamo> prestamos;

    public SistemaPrestamos() {
        prestamos = new ArrayList<>();
    }

    public boolean prestarLibro(Libro libro) {
        if (libro.getEstado() == Libro.Estado.DISPONIBLE) {
            libro.setEstado(Libro.Estado.PRESTADO);
            Prestamo prestamo = new Prestamo(LocalDate.now(), libro);
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        if (libro.getEstado() == Libro.Estado.PRESTADO) {
            libro.setEstado(Libro.Estado.DISPONIBLE);
            prestamos.removeIf(p -> p.getLibro().equals(libro));
            return true;
        }
        return false;
    }

    public List<Prestamo> obtenerPrestamos() {
        return new ArrayList<>(prestamos);
    }
}
