package com.algaworks.algafood.core.validation;

import jakarta.validation.ConstraintValidator;

import java.math.BigDecimal;

public class MultiploValidador implements ConstraintValidator<Multiplo, Number> {

  private int numeroMultiplo;


  @Override
  public void initialize(Multiplo constraintAnnotation) {
    this.numeroMultiplo = constraintAnnotation.numero();
  }

  @Override
  public boolean isValid(Number value, jakarta.validation.ConstraintValidatorContext context) {
    boolean valido = true;

    if (value != null) {
      var valorDecimal = BigDecimal.valueOf(value.doubleValue());
      var multiploDecimal = BigDecimal.valueOf(this.numeroMultiplo);
      var resto = valorDecimal.remainder(multiploDecimal);

      valido = BigDecimal.ZERO.compareTo(resto) == 0;
    }

    return valido;
  }


}
