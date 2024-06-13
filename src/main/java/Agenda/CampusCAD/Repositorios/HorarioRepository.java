package Agenda.CampusCAD.Repositorios;

import Agenda.CampusCAD.Entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    // Puedes agregar métodos adicionales de consulta si es necesario
}
