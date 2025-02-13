package BankApplication.ms_accounts.service;

import BankApplication.ms_accounts.model.Account;
import BankApplication.ms_accounts.model.Customer;
import BankApplication.ms_accounts.model.CustomerIdDTO;
import BankApplication.ms_accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAccountById(CustomerIdDTO customerId){
        if(accountRepository.existsAccountByCustomerId(customerId.getCustomerId())){
        return accountRepository.findAccountByCustomerId(customerId.getCustomerId()).get();
        }
        throw new RuntimeException();
    }

    public void saveAccount(Account account) {
        long accountNumber = randomAccountNumber();
        while(accountRepository.existsAccountByAccountNumber(accountNumber))
        {
            accountNumber = randomAccountNumber();
        }
        account.setAccountNumber(accountNumber);
        account.setCreateDt(LocalDate.now());
        accountRepository.save(account);
    }
    public void createFirstAccount(Customer customer) {
        long accountNumber = randomAccountNumber();
        while(accountRepository.existsAccountByAccountNumber(accountNumber))
        {
            accountNumber = randomAccountNumber();
        }
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountType("Current");
        account.setCustomerId(customer.getCustomerId());
        account.setBranchAddress("Pas loin d'ici");
        account.setCreateDt(LocalDate.now());
        accountRepository.save(account);
    }

    private long randomAccountNumber() {
        return (long) (1000000000 + Math.random() * 1000000000);
    }

}
