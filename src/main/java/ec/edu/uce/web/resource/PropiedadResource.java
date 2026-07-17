package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.PropiedadService;
import ec.edu.uce.domain.model.Propiedad;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/propiedades")
public class PropiedadResource {

    @Inject
    private PropiedadService propiedadService;

    @Path("/porId/{id}")
    @GET
    public Propiedad buscarPorId(@PathParam("id") Integer id) {
        return this.propiedadService.buscarPorId(id);
    }

    @Path("/todos")
    @GET
    public java.util.List<Propiedad> buscarTodos() {
        return this.propiedadService.buscarTodos();
    }

    @Path("/guardar")
    @POST
    public void guardar(Propiedad propiedad) {
        this.propiedadService.guardarPropiedad(propiedad);
    }

    @Path("/eliminar/{id}")
    @POST
    public void eliminar(@PathParam("id") Integer id) {
        this.propiedadService.eliminarPropiedad(id);
    }

    @Path("/actualizar/{id}")
    @POST
    public void actualizar(Propiedad propiedad, @PathParam("id") Integer id) {
        this.propiedadService.actualizar(propiedad, id);
    }

}
