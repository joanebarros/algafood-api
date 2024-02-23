package com.algaworks.algafood.api.service;

import com.algaworks.algafood.api.modelo.Cliente;

public class ClienteAtivadoEvent {

    private Cliente cliente;


    public ClienteAtivadoEvent(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
