package com.algaworks.algafood.api.notificacao;


import com.algaworks.algafood.api.modelo.Cliente;
import org.springframework.stereotype.Component;

/* @Qualifier("normal")
   Essa anotação é usada para qualificar um componente, e nessa qualificação
   colocamos um identificador
 */
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {


    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}