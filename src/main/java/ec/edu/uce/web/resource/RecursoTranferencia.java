package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/transferencia")
public class RecursoTranferencia {

    @Inject
    private TransferenciaService servicio;

    @Path("/realizar")
    @POST
    public String realizarTransferencia(TransferenciaResource transferencia) {
        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());

        return this.servicio.realizarTransferencia(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());
    }

    @Path("/realizarReactiva")
    @POST
    public String realizarTransferenciaReactiva(TransferenciaResource transferencia) {
        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());

        return this.servicio.realizarTransferenciaReactiva(transferencia.getCuentaOrigen(), transferencia.getCuentaDestino(), transferencia.getMonto());
    }
}
