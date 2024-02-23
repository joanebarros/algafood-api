package com.algaworks.algafood.api;

import com.algaworks.algafood.api.modelo.Cliente;
import com.algaworks.algafood.api.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MeuPrimeiroController {

    @Autowired
    private AtivacaoClienteService ativacaoClienteService;


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "9998765432");
        ativacaoClienteService.ativar(joao);
        return "Hello!";
    }
}
