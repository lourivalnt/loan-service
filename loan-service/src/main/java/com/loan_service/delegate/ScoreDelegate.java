package com.loan_service.delegate;

import com.loan_service.service.ScoreService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ScoreDelegate implements JavaDelegate {

    private final ScoreService scoreService;

    public ScoreDelegate(ScoreService scoreService){
        this.scoreService = scoreService;
    }

    @Override
    public void execute(DelegateExecution execution){

        String cpf = execution.getVariable("cpf").toString();

        Integer score = scoreService.consultarScore(cpf);

        execution.setVariable(
                "score",
                score
        );
    }

}
