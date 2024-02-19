package com.algaworks.algafood.api.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
   Essa anotação é usada para dizer quando tempo essa anotação "TipoDoNotificador"
   deve permanecer onde ela foi usada e é necessario expecificar atraves de uma parametro
    o tempo que ela deve ser usada, assim ela ira funcionar
 */
@Retention(RetentionPolicy.RUNTIME) // Deve ser lida em tempo de execução
@Qualifier
public @interface TipoDoNotificador {

    NivelUrgencia value();


}
