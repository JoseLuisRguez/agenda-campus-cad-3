package Agenda.CampusCAD.Servicios;

import Agenda.CampusCAD.Entidades.Horario;
import Agenda.CampusCAD.Repositorios.HorarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    
    @Autowired
    private HorarioRepository horarioRepository;

    //Ahora ejecutamos los metodos
    public List<Horario> obtenerTodosLosHorarios() {
        return horarioRepository.findAll();
    }
    
    public boolean insertarHorario(Horario horario) {
        try {
            horarioRepository.save(horario);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean actualizarHorario(Horario horario) {
        try {
            horarioRepository.save(horario);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean eliminarHorario(Horario horario) {
        try {
            horarioRepository.delete(horario);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
