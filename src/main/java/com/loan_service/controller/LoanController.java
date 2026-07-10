package com.loan_service.controller;

import com.loan_service.dto.LoanRequest;
import jakarta.validation.Valid;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

//    O RuntimeService é a API do Camunda responsável por trabalhar com instâncias de processos em execução
    private final RuntimeService runtimeService;

    public LoanController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping
    public String solicitar(@RequestBody @Valid LoanRequest request) {

        runtimeService.startProcessInstanceByKey(
                "loan-process",
                Variables.createVariables()
                        .putValue("cpf", request.getCpf())
                        .putValue("placa", request.getPlaca())
                        .putValue("valor", request.getValor())
        );

        return "Processo iniciado com sucesso.";

    }
}