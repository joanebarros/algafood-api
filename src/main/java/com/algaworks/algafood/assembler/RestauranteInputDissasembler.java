package com.algaworks.algafood.assembler;

import com.algaworks.algafood.api.controller.model.input.RestauranteInput;
import com.algaworks.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDissasembler {

  @Autowired
  private ModelMapper modelMapper;


  public Restaurante toDomainObject(RestauranteInput restauranteInput) {
    return modelMapper.map(restauranteInput, Restaurante.class);
  }

  public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
    // Para evitar org.hibernate.HibernateException: identifier of an instance of
    // com.algaworks.algafood.domain.model.Cozinha was altered from 1 to 2
    restaurante.setCozinha(new Restaurante().getCozinha());

       modelMapper.map(restauranteInput, restaurante);
  }

}
