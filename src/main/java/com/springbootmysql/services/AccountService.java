package com.springbootmysql.services;

import com.springbootmysql.entity.AccountEntity;
import com.springbootmysql.repositories.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountEntity register(AccountEntity account) {
    account = accountRepository.save(account);
    return account;
  }

  public List<AccountEntity> getUserName(String firstName) {
    return accountRepository.findByFirstNameStartsWith(firstName);
  }
}
