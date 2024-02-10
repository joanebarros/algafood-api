package com.algaworks.algafood.api;

import com.algaworks.algafood.api.modelo.Cliente;
import com.algaworks.algafood.api.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;

        System.out.println("MeuPrimeiroController: " + ativacaoClienteService);
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "9998765432");

        ativacaoClienteService.ativar(joao);


        return "Hello!";
    }
}
