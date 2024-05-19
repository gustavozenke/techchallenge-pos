package com.fiap.techchallenge.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<EstadosPedido, EventosPedido> {

    //Startup automatico + incluir listener
    @Override
    public void configure(StateMachineConfigurationConfigurer<EstadosPedido, EventosPedido> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }
    //Configurar o estado inicial e carregar os outros estados
    @Override
    public void configure(StateMachineStateConfigurer<EstadosPedido, EventosPedido> states) throws Exception {
        states
                .withStates()
                .initial(EstadosPedido.A_PAGAR)
                .states(EnumSet.allOf(EstadosPedido.class));
    }

    //Definir as transicoes
    //de .source para .target apos .event
    @Override
    public void configure(StateMachineTransitionConfigurer<EstadosPedido, EventosPedido> transitions) throws Exception {
        transitions
                .withExternal()
                .source(EstadosPedido.A_PAGAR).target(EstadosPedido.PAGO).event(EventosPedido.PEDIDO_PAGO)
                .and().withExternal()
                .source(EstadosPedido.PAGO).target(EstadosPedido.RECEBIDO).event(EventosPedido.PEDIDO_ENVIADO)
                .and().withExternal()
                .source(EstadosPedido.RECEBIDO).target(EstadosPedido.EM_PREPARACAO).event(EventosPedido.A_PREPARA)
                .and().withExternal()
                .source(EstadosPedido.EM_PREPARACAO).target(EstadosPedido.PRONTO).event(EventosPedido.EM_SEPRARACAO)
                .and().withExternal()
                .source(EstadosPedido.PRONTO).target(EstadosPedido.FINALIZADO).event(EventosPedido.ENTREGAR);
    }

    //implementar o listener
    @Bean
    public StateMachineListener<EstadosPedido, EventosPedido> listener() {
        return new StateMachineListenerAdapter<EstadosPedido, EventosPedido>() {
            @Override
            public void stateChanged(State<EstadosPedido, EventosPedido> from, State<EstadosPedido, EventosPedido> to) {
                System.out.println("OrderState change from " + from.getId() + " to " + to.getId());
            }
        };
    }
}

