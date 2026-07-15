package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Propiedad;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PropiedadRepositoryImpl implements PanacheRepositoryBase<Propiedad, Integer> {

}
