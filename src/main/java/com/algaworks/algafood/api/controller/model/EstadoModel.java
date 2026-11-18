package com.algaworks.algafood.api.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoModel {

  @NotNull
  private Long id;
}
