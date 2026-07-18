package ec.edu.uce.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {

    @Inject
    private CuentaBancariaService cuentaBancariaService;

    @Inject
    private MailService mailService;

    @Inject
    private AuditoriaService auditoriaService;

    public String realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {

        // impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());

        long tiempoInicio = System.currentTimeMillis();
        BigDecimal saldoDestino = this.cuentaBancariaService.agregaMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen = this.cuentaBancariaService.restaMonto(cuentaOrigen, monto);

        this.mailService.enviarCorreo("kdsoto@uce.edu.ec", "Asunto", "Se ha realizado una transferencia de "
                + monto + " de la cuenta " + cuentaOrigen + " a la cuenta " + cuentaDestino);
        this.auditoriaService.guardar("Auditoria");

        String mensaje = "Se realizo con exito, su saldo destino es " + saldoDestino + " y su saldo origen es "
                + saldoOrigen;

        long tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo demora: " + (tiempoFin - tiempoInicio) + " ms");
        return mensaje;
    }

    public String realizarTransferenciaReactiva(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {

        // impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());

        long tiempoInicio = System.currentTimeMillis();
        Uni<BigDecimal> saldoDestino = this.cuentaBancariaService.agregaMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.cuentaBancariaService.restaMontoPromesa(cuentaOrigen, monto);

        this.mailService.enviarCorreo("kdsoto@uce.edu.ec", "Asunto", "Se ha realizado una transferencia de "
                + monto + " de la cuenta " + cuentaOrigen + " a la cuenta " + cuentaDestino);
        this.auditoriaService.guardar("Auditoria");

        
        Uni.combine().all().unis(saldoDestino, saldoOrigen).asTuple().map(resul -> {
            String mensaje = "Se realizo con exito, su saldo destino es " + resul.getItem1() + " y su saldo origen es "
                + resul.getItem2();
            return mensaje;
        }).toString();

        

        long tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo demora: " + (tiempoFin - tiempoInicio) + " ms");
        return "Finalizado";
    }
}
