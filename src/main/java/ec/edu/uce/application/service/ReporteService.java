package ec.edu.uce.application.service;
import java.util.List;

import ec.edu.uce.application.interceptor.interceptor.Auditoria;
import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    @Auditoria
    public void guardarReporte(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReporteService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        this.reporteRepositoryImpl.persist(reporte);

    }

    public void eliminarReporte(Integer id) {
        this.reporteRepositoryImpl.deleteById(this.reporteRepositoryImpl.findById(id).getId());
    }

    public void actualizarReporte(Reporte reporte, Integer id) {

        Reporte reporteBase = this.buscarPorId(id);
        reporteBase.setDescripcion(reporte.getDescripcion());
        reporteBase.setEstado(reporte.getEstado());
        reporteBase.setFecha(reporte.getFecha());
        reporteBase.setNombre(reporte.getNombre());
        reporteBase.setTipo(reporte.getTipo());


    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);
    }

    public List<Reporte> buscarTodos() {
        return this.reporteRepositoryImpl.findAll().list();
    }

    //////////////////////

    @Auditoria
    public void guardarListaReportes(List<Reporte> lista) {
        for (ec.edu.uce.domain.model.Reporte repo : lista) {
            this.reporteRepositoryImpl.persist(repo);
        }

    }

    public Reporte buscarPorTitulo(String titulo) {
        return this.reporteRepositoryImpl.buscarPorTitulo(titulo);
    }

}