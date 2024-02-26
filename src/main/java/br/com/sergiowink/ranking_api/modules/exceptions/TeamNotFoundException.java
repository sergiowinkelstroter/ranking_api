package br.com.sergiowink.ranking_api.modules.exceptions;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(){
        super("Essa equipe não existe!");
    }
}
