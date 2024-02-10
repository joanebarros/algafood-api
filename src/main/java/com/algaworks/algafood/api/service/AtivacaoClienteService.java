package com.algaworks.algafood.api.service;

import com.algaworks.algafood.api.modelo.Cliente;
import com.algaworks.algafood.api.notificacao.Notificador;


public class AtivacaoClienteService {

    private Notificador notificador;
    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;

        System.out.println(" AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente) {
            cliente.ativar();
            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        }

}
