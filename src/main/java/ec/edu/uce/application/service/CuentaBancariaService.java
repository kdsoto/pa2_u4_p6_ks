package ec.edu.uce.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    public BigDecimal agregaMonto(String numeroCuenta, BigDecimal monto) {

        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo = saldo.add(monto);
        return saldo;
    }

    public BigDecimal restaMonto(String numeroCuenta, BigDecimal monto) {

        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BigDecimal saldo = BigDecimal.valueOf(2000);
        saldo = saldo.subtract(monto);
        return saldo;
    }

    public Uni<BigDecimal> agregaMontoPromesa(String numeroCuenta, BigDecimal monto) {

        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Uni.createFrom().item(this.agregaMonto(numeroCuenta, monto));
    }

    public Uni<BigDecimal> restaMontoPromesa(String numeroCuenta, BigDecimal monto) {

        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Uni.createFrom().item(() -> { 
            return this.restaMonto(numeroCuenta, monto); 
        });
    }
}
