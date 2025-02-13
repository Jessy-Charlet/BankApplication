package BankApplication.ms_accounts.controller;

import BankApplication.ms_accounts.model.Account;
import BankApplication.ms_accounts.model.Customer;
import BankApplication.ms_accounts.model.CustomerIdDTO;
import BankApplication.ms_accounts.repository.AccountRepository;
import BankApplication.ms_accounts.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
    }

    @PostMapping("/me")
    public List<Account> findMyAccount(@RequestBody CustomerIdDTO customerId) {
        return accountService.findAccountById(customerId);
    }

    @PostMapping("/add")
    public String addAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return "Account added successfully";
    }
}
