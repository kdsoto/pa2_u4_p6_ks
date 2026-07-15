package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Propiedad;
import ec.edu.uce.infraestructure.repository.PropiedadRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PropiedadService {

    @Inject
    private PropiedadRepositoryImpl propiedadRepository;

    public List<Propiedad> buscarTodos() {
        return (List<Propiedad>) this.propiedadRepository.findAll();
    }

    public Propiedad buscarPorId(Integer id) {
        return this.propiedadRepository.findById(id);
    }

    public void guardar(Propiedad propiedad) {
        this.propiedadRepository.persist(propiedad);
    }

    public void eliminar(Integer id) {
        this.propiedadRepository.delete(this.buscarPorId(id));
    }

    public void actualizar(Propiedad propiedadActualizado, Integer id) {

        Propiedad propiedadBase = this.buscarPorId(id);
        propiedadBase.setNombre(propiedadActualizado.getNombre());
        propiedadBase.setDescripcion(propiedadActualizado.getDescripcion());
        propiedadBase.setEstado(propiedadActualizado.getEstado());
        propiedadBase.setTipo(propiedadActualizado.getTipo());
        propiedadBase.setDireccion(propiedadActualizado.getDireccion());
        propiedadBase.setCiudad(propiedadActualizado.getCiudad());
        propiedadBase.setPrecio(propiedadActualizado.getPrecio());

    }

}
