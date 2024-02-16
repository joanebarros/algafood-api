package com.algaworks.algafood.api.notificacao;


import com.algaworks.algafood.api.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: usando SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}