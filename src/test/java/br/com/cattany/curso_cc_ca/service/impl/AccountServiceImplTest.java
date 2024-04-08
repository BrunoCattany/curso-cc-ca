package br.com.cattany.curso_cc_ca.service.impl;

import br.com.cattany.curso_cc_ca.errors.UserNotFoundException;
import br.com.cattany.curso_cc_ca.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Teste unitário para a implementação -> AccountServiceImpl")
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    private AccountServiceImpl sut;
    @Mock
    private AccountRepository repositoryMock;

    @BeforeEach
    void setUp() {
        sut = new AccountServiceImpl(repositoryMock);
    }

    @DisplayName("""
            Dado email
             quando email já existir
             deve lançar exceção
            """)
    @Test
    void dadoEmail_QuandoEmailJaExistir_DeveLancarExcecao() {
        var email = "bruno@gmail.com";
        UserNotFoundException sut = assertThrows(UserNotFoundException.class, () -> this.sut.signUp(email));
        assertEquals("Nenhuma conta encontrada para o email: (%s)".formatted(email), sut.getMessage());
    }
}