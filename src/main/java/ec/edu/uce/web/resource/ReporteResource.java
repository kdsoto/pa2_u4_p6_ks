package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.ReporteService;
import ec.edu.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    public Reporte buscarPorId(Integer id) {
        return this.reporteService.buscarPorId(id);
    }

}
