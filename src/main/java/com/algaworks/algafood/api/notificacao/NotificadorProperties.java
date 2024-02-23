package com.algaworks.algafood.api.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
   A anotação @ConfigurationProperties é usada para dizer que essa classe reperesenta
    um arquivo de configuração de propriedades
 */
@ConfigurationProperties("notificador.email")
@Component
public class NotificadorProperties {

    /*
       Host do servidor de E-mail
     */
    private String hostServidor;

    /*
       Porta do servidor de E-mail
     */
    private Integer portaServidor = 28;

    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }
}
