package com.loan_service.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerClient {

    public boolean validarCliente(String cpf){

        System.out.println("--------------------------------");
        System.out.println("CustomerService");
        System.out.println("Validando CPF: " + cpf);
        System.out.println("--------------------------------");

        /*
            Aqui poderia existir:

            Banco

            Receita Federal

            Serasa

            Outro microsserviço
         */

        return true;

    }

}
