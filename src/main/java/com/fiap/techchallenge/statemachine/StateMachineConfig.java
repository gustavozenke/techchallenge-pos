package com.fiap.techchallenge.statemachine;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Log4j2
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<EstadoPedido, EventoPedido> {

    //Startup automatico + incluir listener
    @Override
    public void configure(StateMachineConfigurationConfigurer<EstadoPedido, EventoPedido> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }
    //Configurar o estado inicial e carregar os outros estados
//    @Override
//    public void configure(StateMachineStateConfigurer<EstadoPedido, EventoPedido> states) throws Exception {
//        states
//                .withStates()
//                .initial(EstadoPedido.A_PAGAR)
//                .states(EnumSet.allOf(EstadoPedido.class));
//    }

    //Definir as transicoes
    //de .source para .target apos .event
    @Override
    public void configure(StateMachineTransitionConfigurer<EstadoPedido, EventoPedido> transitions) throws Exception {
        transitions
                .withExternal()
                .source(EstadoPedido.A_PAGAR).target(EstadoPedido.PAGO).event(EventoPedido.PEDIDO_PAGO)
                .and().withExternal()
                .source(EstadoPedido.PAGO).target(EstadoPedido.RECEBIDO).event(EventoPedido.PEDIDO_ENVIADO)
                .and().withExternal()
                .source(EstadoPedido.RECEBIDO).target(EstadoPedido.EM_PREPARACAO).event(EventoPedido.A_PREPARA)
                .and().withExternal()
                .source(EstadoPedido.EM_PREPARACAO).target(EstadoPedido.PRONTO).event(EventoPedido.EM_SEPRARACAO)
                .and().withExternal()
                .source(EstadoPedido.PRONTO).target(EstadoPedido.FINALIZADO).event(EventoPedido.ENTREGAR);
    }

    //implementar o listener
    @Bean
    public StateMachineListener<EstadoPedido, EventoPedido> listener() {
        return new StateMachineListenerAdapter<EstadoPedido, EventoPedido>() {
            @Override
            public void stateChanged(State<EstadoPedido, EventoPedido> from, State<EstadoPedido, EventoPedido> to) {
                log.info("Estado do pedido mudou de " + from.getId() + " para " + to.getId());
            }
        };
    }

    //https://medium.com/nstech/spring-state-machine-como-op%C3%A7%C3%A3o-97144586bf48
}

