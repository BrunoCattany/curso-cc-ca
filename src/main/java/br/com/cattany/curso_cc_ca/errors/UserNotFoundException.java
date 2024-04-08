package br.com.cattany.curso_cc_ca.errors;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super("Nenhuma conta encontrada para o email: (%s)".formatted(email));
    }
}
