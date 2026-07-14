package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "reporte")
public class Reporte {

    @Id
    @SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_reporte_generador")
    @Column(name = "rep_id")
    private Integer id;

    @Column(name = "rep_nombre")
    private String nombre;

    @Column(name = "rep_descripcion")
    private String descripcion;

    @Column(name = "rep_fecha")
    private LocalDate fecha;

    @Column(name = "rep_estado")
    private String estado;

    @Column(name = "rep_tipo")
    private String tipo;

    
}
