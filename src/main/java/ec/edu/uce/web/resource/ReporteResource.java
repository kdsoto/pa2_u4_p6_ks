package ec.edu.uce.web.resource;

import java.util.List;

import ec.edu.uce.application.service.ReporteService;
import ec.edu.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    // http://localhost:8080/reportes/porId/1
    @Path("/porId/{id}")
    @GET
    public Reporte buscarPorId(@PathParam("id") Integer id) {

        return reporteService.buscarPorId(id);

    }

    @Path("/todos")
    @GET
    public List<Reporte> buscarTodos() {

        return this.reporteService.buscarTodos();

    }

    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte) {

        this.reporteService.guardarReporte(reporte);

    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizarReporte(Reporte reporte, @PathParam("id") Integer id) {
        this.reporteService.actualizarReporte(reporte, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminarReporte(@PathParam("id") Integer id) {
        this.reporteService.eliminarReporte(id);
    }

}