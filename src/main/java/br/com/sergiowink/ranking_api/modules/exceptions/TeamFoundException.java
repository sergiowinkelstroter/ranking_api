package br.com.sergiowink.ranking_api.modules.exceptions;

public class TeamFoundException extends RuntimeException{
    public TeamFoundException(){
        super("Essa equipe já existe!");
    }
    
}
