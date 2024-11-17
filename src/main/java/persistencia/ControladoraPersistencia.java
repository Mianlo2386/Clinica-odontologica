package persistencia;

import java.util.List;
import logica.Usuario;


public class ControladoraPersistencia {
    
    HorarioJpaController horaJPA; // = new HorarioJpaController();
    OdontologoJpaController odontoJPA; //= new OdontologoJpaController();
    PacienteJpaController pacJPA; //= new PacienteJpaController();
    PersonaJpaController persJPA; //= new PersonaJpaController();
    ResponsableJpaController respJPA; //= new ResponsableJpaController();
    SecretarioJpaController secreJPA;// = new SecretarioJpaController();
    TurnoJpaController turnJPA; //= new TurnoJpaController();
    UsuarioJpaController usuJPA;// = new UsuarioJpaController();
    
    public ControladoraPersistencia() {
        
     usuJPA = new UsuarioJpaController();
     horaJPA = new HorarioJpaController();
     odontoJPA = new OdontologoJpaController();
     pacJPA= new PacienteJpaController();
     persJPA = new PersonaJpaController();
     respJPA = new ResponsableJpaController();
     secreJPA = new SecretarioJpaController();
     turnJPA = new TurnoJpaController();
    }

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {
        return usuJPA.findUsuarioEntities();
    }
}
