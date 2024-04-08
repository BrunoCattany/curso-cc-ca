package br.com.cattany.curso_cc_ca.service.impl;

import br.com.cattany.curso_cc_ca.errors.UserNotFoundException;
import br.com.cattany.curso_cc_ca.model.Account;
import br.com.cattany.curso_cc_ca.repository.AccountRepository;
import br.com.cattany.curso_cc_ca.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public UUID signUp(String email) {
        return repository.findByEmail(email)
                .map(Account::getId)
                .orElseThrow(() -> new UserNotFoundException(email));
    }
}
