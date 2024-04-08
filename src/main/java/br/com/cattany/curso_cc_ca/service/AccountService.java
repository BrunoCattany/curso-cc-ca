package br.com.cattany.curso_cc_ca.service;

import br.com.cattany.curso_cc_ca.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    UUID signUp(String email);
}
