package store.account;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account", url = "${store.account.url:http://account:8080}")
public interface AccountController {

    @PostMapping("/accounts")
    ResponseEntity<Void> create(@RequestBody AccountIn in);

    @GetMapping("/accounts")
    ResponseEntity<List<AccountOut>> findAll();

    @DeleteMapping("/accounts/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);

    @GetMapping("/accounts/health-check")
    ResponseEntity<Void> healthCheck();

    @GetMapping("/accounts/{id}")
    ResponseEntity<AccountOut> findById(@PathVariable String id);

    // usado pelo auth-service para validar email + senha
    @PostMapping("/accounts/login")
    ResponseEntity<AccountOut> login(@RequestBody AccountIn in);

}
