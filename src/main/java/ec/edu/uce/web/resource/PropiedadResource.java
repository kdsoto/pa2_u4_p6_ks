package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.PropiedadService;
import ec.edu.uce.domain.model.Propiedad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/propiedades")
public class PropiedadResource {

    @Inject
    private PropiedadService propiedadService;

    public Propiedad buscarPorId(Integer id) {
        return this.propiedadService.buscarPorId(id);
    }

    public void guardar(Propiedad propiedad) {
        this.propiedadService.guardar(propiedad);
    }

    public void eliminar(Integer id) {
        this.propiedadService.eliminar(id);
    }

    public void actualizar(Propiedad propiedad, Integer id) {
        this.propiedadService.actualizar(propiedad, id);
    }

}
