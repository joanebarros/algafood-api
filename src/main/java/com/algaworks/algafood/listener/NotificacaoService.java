package com.algaworks.algafood.listener;

import com.algaworks.algafood.api.notificacao.NivelUrgencia;
import com.algaworks.algafood.api.notificacao.Notificador;
import com.algaworks.algafood.api.notificacao.TipoDoNotificador;
import com.algaworks.algafood.api.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {
    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadrastro no sentema está ativo!");
    }
}
