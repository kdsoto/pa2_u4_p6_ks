package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.application.interceptor.interceptor.Auditoria;
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

    @Auditoria
    public void guardarPropiedad(Propiedad propiedad) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo PropiedadService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        this.propiedadRepository.persist(propiedad);
    }

    public void eliminarPropiedad(Integer id) {
        this.propiedadRepository.deleteById(this.propiedadRepository.findById(id).getId());
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

    public Propiedad buscarPorId(Integer id) {
        return this.propiedadRepository.findById(id);
    }

    public List<Propiedad> buscarTodos() {
        return this.propiedadRepository.findAll().list();
    }

    @Auditoria
    public void guardarListaPropiedades(List<Propiedad> lista) {
        for (Propiedad prop : lista) {
            this.propiedadRepository.persist(prop);
        }
    }

    public Propiedad buscarPorNombre(String nombre) {
        return this.propiedadRepository.buscarPorNombre(nombre);
    }

}
