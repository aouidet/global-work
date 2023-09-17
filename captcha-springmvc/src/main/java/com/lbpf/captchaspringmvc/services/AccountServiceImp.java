package com.lbpf.captchaspringmvc.services;

import com.lbpf.captchaspringmvc.entity.Account;
import com.lbpf.captchaspringmvc.entity.AccountRepository;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImp implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }
}
