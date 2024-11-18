package logica;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(String nombreUsuario, String contrasenia, String rol){
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        // Encriptar la contraseña antes de guardarla
        String hashed = BCrypt.hashpw(contrasenia, BCrypt.gensalt());
        usu.setContrasenia(hashed);
        usu.setRol(rol);
        
        controlPersis.crearUsuario(usu);
    }

    public List<Usuario> getUsuarios() {
        return controlPersis.getUsuarios();
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
    
        boolean ingreso = false;
    
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
    
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                // Comparar la contraseña encriptada
                if (BCrypt.checkpw(contrasenia, usu.getContrasenia())) {
                    ingreso = true;
                    break;  // Salir del bucle una vez que se encuentra un usuario válido
                }
            }
        }
    
        return ingreso; 
    }
}
