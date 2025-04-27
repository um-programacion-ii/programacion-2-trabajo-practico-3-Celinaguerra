import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;

public class GestionUsuariosTest {

    @Mock
    private Usuario usuarioMock;

    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios = new GestionUsuarios();
    }

    @Test
    void testRegistrarUsuario() {
        String nombreUsuario = "juan";
        when(usuarioMock.getNombre()).thenReturn(nombreUsuario);

        gestionUsuarios.registrarUsuario(usuarioMock);

        assertTrue(gestionUsuarios.existeUsuario(nombreUsuario)); // Verifica que el usuario haya sido registrado
    }

    @Test
    void testBuscarUsuarioExistente() {

        Usuario usuario = new Usuario("maria");
        gestionUsuarios.registrarUsuario(usuario);

        Usuario usuarioEncontrado = gestionUsuarios.buscarUsuarioPorNombre("maria");

        assertNotNull(usuarioEncontrado);
        assertEquals("maria", usuarioEncontrado.getNombre());
    }

    @Test
    void testRegistrarYBuscarUsuario() {
        String nombreUsuario = "pedro";
        when(usuarioMock.getNombre()).thenReturn(nombreUsuario);

        gestionUsuarios.registrarUsuario(usuarioMock);

        verify(usuarioMock).getNombre();
        assertTrue(gestionUsuarios.existeUsuario(nombreUsuario));
    }
}
