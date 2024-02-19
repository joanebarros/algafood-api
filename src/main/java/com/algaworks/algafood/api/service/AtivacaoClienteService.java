package com.algaworks.algafood.api.service;

import com.algaworks.algafood.api.modelo.Cliente;
import com.algaworks.algafood.api.notificacao.NivelUrgencia;
import com.algaworks.algafood.api.notificacao.Notificador;
import com.algaworks.algafood.api.notificacao.TipoDoNotificador;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;


//@Component
public class AtivacaoClienteService {
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

   // @PostConstruct
    public void init() {
        System.out.println("INIT " + notificador);
    }

    //	@PreDestroy
    public void destroy() {
        System.out.println("DESTROY");
    }

    public void ativar(Cliente cliente) {
            cliente.ativar();

                notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");

        }

}
