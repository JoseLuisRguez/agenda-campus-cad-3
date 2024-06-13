package Agenda.CampusCAD.Controladores;

import Agenda.CampusCAD.Entidades.Usuario;
import Agenda.CampusCAD.Servicios.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping("")
    public ResponseEntity<?> insertarUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.insertarUsuario(usuario)) {
            return new ResponseEntity<>(usuarioService.obtenerTodosLosUsuarios(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al insertar usuario", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        if (usuarioService.actualizarUsuario(usuario)) {
            return new ResponseEntity<>(usuarioService.obtenerTodosLosUsuarios(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al actualizar usuario", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        if (usuarioService.eliminarUsuario(usuario)) {
            return new ResponseEntity<>(usuarioService.obtenerTodosLosUsuarios(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al eliminar usuario", HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("")
    public List<Usuario> eliminarUsuario(@RequestBody Usuario notificacion) {
        if (usuarioService.eliminarUsuario(notificacion)) {
            return usuarioService.obtenerTodosLosUsuarios();
        } else {
            return null;
        }
    }
    
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        Usuario authenticatedUser = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getContrasena());
        if (authenticatedUser != null) {
            return authenticatedUser;
        }
        return null;
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> getUserProfile(@PathVariable Long id) {
        return usuarioService.getUserProfile(id);
    }

    @PutMapping("/update")
    public Usuario updateUserProfile(@RequestBody Usuario userProfile) {
        return usuarioService.updateUserProfile(userProfile);
    }
    
}
