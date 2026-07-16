package ec.edu.uce.application.interceptor.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Auditoria
@Priority(Interceptor.Priority.APPLICATION)
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object medirTiempoGuardar(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();

        Object result = context.proceed();

        long fin = System.currentTimeMillis();

        long tiempoTotal = fin - inicio;

        System.out.println("Tiempo de ejecución: " + (tiempoTotal / 1000) + " s");

        return result;
    }
}
