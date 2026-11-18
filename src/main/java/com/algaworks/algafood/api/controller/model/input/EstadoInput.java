package com.algaworks.algafood.api.controller.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoInput {

  @NotBlank
  private String nome;
}
