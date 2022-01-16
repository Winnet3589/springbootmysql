package com.springbootmysql.controllers;

import com.springbootmysql.entity.AccountEntity;
import com.springbootmysql.services.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @PostMapping(value = "/register")
  public AccountEntity register(@RequestBody AccountEntity account){
    accountService.register(account);
    return account;
  }

  @GetMapping(value = "/getUserName")
  public List<AccountEntity> getUserName(@RequestParam String firstName) {
    return accountService.getUserName(firstName);
  }
}
