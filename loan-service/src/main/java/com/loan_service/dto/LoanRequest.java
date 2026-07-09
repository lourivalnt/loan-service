package com.loan_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoanRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private String placa;

    private Double valor;

}
