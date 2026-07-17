package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Propiedad;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PropiedadRepositoryImpl implements PanacheRepositoryBase<Propiedad, Integer> {

    @Inject
    private EntityManager entityManager;
    
    public Propiedad buscarPorNombre(String nombre) {
        return find("nombre", nombre).firstResult();
    }

    public void actualizarPropiedad(Propiedad propiedad) {
        this.entityManager.merge(propiedad);
    }
}
