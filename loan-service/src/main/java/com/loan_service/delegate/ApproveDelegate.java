package com.loan_service.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ApproveDelegate implements JavaDelegate {

    @Override
    public void execute(
            DelegateExecution execution){

        System.out.println(
                "EMPRÉSTIMO APROVADO"
        );

    }

}
