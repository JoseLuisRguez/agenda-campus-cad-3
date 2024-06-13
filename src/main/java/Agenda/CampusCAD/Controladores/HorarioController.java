package Agenda.CampusCAD.Controladores;

import Agenda.CampusCAD.Entidades.Horario;
import Agenda.CampusCAD.Servicios.HorarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    
    @Autowired
    private HorarioService horarioService;

    @GetMapping("")
    public List<Horario> obtenerTodosLosHorarios() {
        return horarioService.obtenerTodosLosHorarios();
    }

    @PostMapping("")
    public List<Horario> insertarHorario(@RequestBody Horario horario) {
        if (horarioService.insertarHorario(horario)) {
            return horarioService.obtenerTodosLosHorarios();
        } else {
            return null;
        }
    }

    @PutMapping("")
    public List<Horario> actualizarHorario(@RequestBody Horario horario) {
        if (horarioService.actualizarHorario(horario)) {
            return horarioService.obtenerTodosLosHorarios();
        } else {
            return null;
        }
    }

    @DeleteMapping("")
    public List<Horario> eliminarHorario(@RequestBody Horario horario) {
        if (horarioService.eliminarHorario(horario)) {
            return horarioService.obtenerTodosLosHorarios();
        } else {
            return null;
        }
    }
    
}
