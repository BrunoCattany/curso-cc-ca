package br.com.cattany.curso_cc_ca.web;

import br.com.cattany.curso_cc_ca.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(SignUpDTORequest dto) {
        Integer result;

        try {
            service.signUp(dto.getEmail());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
