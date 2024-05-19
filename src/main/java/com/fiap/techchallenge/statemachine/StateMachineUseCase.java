package com.fiap.techchallenge.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

@Configuration
public class StateMachineUseCase extends StateMachineConfigurerAdapter<EstadoPedido, EventoPedido> {

    //Configurar o estado inicial e carregar os outros estados
    @Override
    public void configure(StateMachineStateConfigurer<EstadoPedido, EventoPedido> states) throws Exception {
        states
                .withStates()
                .initial(EstadoPedido.A_PAGAR)
                .state();
    }
    //todo implmentar estados
    //https://docs.spring.io/spring-statemachine/docs/1.0.3.RELEASE/reference/html/sm-actions.html
}
