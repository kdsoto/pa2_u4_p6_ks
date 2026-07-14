package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepository;

    public List<Reporte> buscarTodos() {
        return (List<Reporte>) this.reporteRepository.findAll();
    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepository.findById(id);
    }

    public void guardar(Reporte reporte) {
        this.reporteRepository.persist(reporte);
    }

    public void eliminar(Integer id) {
        this.reporteRepository.delete(this.buscarPorId(id));
    }

    public void actualizar(Reporte reporteActualizado, Integer id) {
        // this.reporteRepository.getEntityManager().merge(reporte);
        Reporte reporteBase = this.buscarPorId(id);
        reporteBase.setNombre(reporteActualizado.getNombre());
        reporteBase.setDescripcion(reporteActualizado.getDescripcion());
        reporteBase.setFecha(reporteActualizado.getFecha());
        reporteBase.setEstado(reporteActualizado.getEstado());
        reporteBase.setTipo(reporteActualizado.getTipo());

        // NO hace falta realizar explicitamente un update
    }

    public void actualizar2(Reporte reporte) {
        // this.reporteRepository.getEntityManager().merge(reporte);
        Reporte reporteBase = this.buscarPorId(reporte.getId());
    }

}
