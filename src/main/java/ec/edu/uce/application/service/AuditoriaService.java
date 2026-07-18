package ec.edu.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    public void guardar(String auditoria) {
        //impirmir el ID del hilo
        System.out.println("ID del hilo: " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Se registra la auditoria: " + auditoria);
    }
}
