package com.algaworks.algafood.api.notificacao;


import com.algaworks.algafood.api.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* @Qualifier("normal")
   Essa anotação é usada para qualificar um componente, e nessa qualificação
   colocamos um identificador
 */
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {
    @Autowired
    private NotificadorProperties properties;

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Host: " + properties.getHostServidor());
        System.out.println("Porta: " + properties.getPortaServidor());

        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);

    }

}