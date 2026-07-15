package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "propiedad")
public class Propiedad {

    @Id
     @SequenceGenerator(name = "seq_propiedad", sequenceName = "seq_propiedad", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_propiedad")
    @Column(name = "prop_id")
    private Integer id;

    @Column(name = "prop_nombre")
    private String nombre;

    @Column(name = "prop_descripcion")
    private String descripcion;

    @Column(name = "prop_estado")
    private String estado;

    @Column(name = "prop_tipo")
    private String tipo;

    @Column(name = "prop_direccion")
    private String direccion;

    @Column(name = "prop_ciudad")
    private String ciudad;

    @Column(name = "prop_precio")
    private Double precio;
}
