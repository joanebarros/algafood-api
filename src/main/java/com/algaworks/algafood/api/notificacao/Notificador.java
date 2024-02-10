package com.algaworks.algafood.api.notificacao;

import com.algaworks.algafood.api.modelo.Cliente;

public interface Notificador {

    void notificar(Cliente cliente, String mensagem);
}
