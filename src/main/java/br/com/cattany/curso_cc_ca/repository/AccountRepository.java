package br.com.cattany.curso_cc_ca.repository;


import br.com.cattany.curso_cc_ca.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByEmail(String email);
}
