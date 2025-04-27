import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {

    private Map<String, Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuarios.get(nombre);
    }

    public boolean existeUsuario(String nombre) {
        return usuarios.containsKey(nombre);
    }
}