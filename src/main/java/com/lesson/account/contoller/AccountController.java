package com.lesson.account.contoller;

import com.lesson.account.dto.AccountDto;
import com.lesson.account.dto.CreateAccountRequest;
import com.lesson.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
@ControllerAdvice
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto>createAccount(@Valid @RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.creatAccount(request));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}























