package br.com.josepaulo.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("usário já existe");
    }
}
