package com.algaworks.algafood.api.controller;


import com.algaworks.algafood.api.controller.model.RestauranteModel;
import com.algaworks.algafood.api.controller.model.input.RestauranteInput;
import com.algaworks.algafood.assembler.RestauranteInputDissasembler;
import com.algaworks.algafood.assembler.RestauranteModelAssembler;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private RestauranteModelAssembler restauranteModelAssembler;

    @Autowired
    private RestauranteInputDissasembler restauranteInputDissasembler;

    @GetMapping
    public List<RestauranteModel> listar() {
        return restauranteModelAssembler.toCollectionModel (restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteModel buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return restauranteModelAssembler.toModel(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {

        return restauranteModelAssembler.toModel(cadastroRestaurante.salvar(restauranteInputDissasembler
            .toDomainObject(restauranteInput)));
    }

    @PutMapping("/{restauranteId}")
    public RestauranteModel atualizar(@PathVariable Long restauranteId,
                                      @RequestBody @Valid RestauranteInput restauranteInput) {

        Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

        restauranteInputDissasembler.copyToDomainObject(restauranteInput, restauranteAtual);

        //Restaurante restaurante = restauranteInputDissasembler.toDomainObject(restauranteInput);

       // BeanUtils.copyProperties(restaurante, restauranteAtual,
               // "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

        return restauranteModelAssembler.toModel(cadastroRestaurante.salvar(restauranteAtual));
    }

}
