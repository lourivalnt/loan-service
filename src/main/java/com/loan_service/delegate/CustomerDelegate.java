package com.loan_service.delegate;

import com.loan_service.service.CustomerClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDelegate
        implements JavaDelegate {

    private final CustomerClient customerClient;

    public CustomerDelegate(CustomerClient customerClient) {

        this.customerClient = customerClient;

    }

    @Override
    public void execute(DelegateExecution execution){

        String cpf = execution.getVariable("cpf").toString();

        Boolean valido = customerClient.validarCliente(cpf);

        execution.setVariable(
                "clienteValido",
                valido
        );

    }

}
