package ec.edu.uce.web.resource;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaResource {

    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal monto;
}
