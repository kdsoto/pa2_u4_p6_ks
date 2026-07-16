package ec.edu.uce.infraestructure.repository;


import ec.edu.uce.domain.model.Reporte;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteRepositoryImpl implements PanacheRepositoryBase<Reporte, Integer> {

    @Inject
    private EntityManager entityManager;

    public Reporte buscarPorTitulo(String titulo) {
        return find("titulo", titulo).firstResult();
    }

    public void actualizarReporte(Reporte reporte) {
        this.entityManager.merge(reporte);
    }
}