package Agenda.CampusCAD.Servicios;

import Agenda.CampusCAD.Entidades.Usuario;
import Agenda.CampusCAD.Repositorios.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public boolean insertarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return false; // El usuario ya existe
        }
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getId()).isPresent()) {
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getId()).isPresent()) {
            usuarioRepository.delete(usuario);
            return true;
        }
        return false;
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena);
    }
    
     public Optional<Usuario> getUserProfile(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUserProfile(Usuario userProfile) {
        return usuarioRepository.save(userProfile);
    }
    
}
