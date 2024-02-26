package br.com.sergiowink.ranking_api.modules.exceptions;

public class EventFoundException extends RuntimeException {
    public EventFoundException(){
        super("Já existe um evento para essa data e hora.");

    }
}
