package BankApplication.ms_accounts.service;

import BankApplication.ms_accounts.exception.CustomerEmailException;
import BankApplication.ms_accounts.model.Account;
import BankApplication.ms_accounts.model.Customer;
import BankApplication.ms_accounts.model.CustomerFormDTO;
import BankApplication.ms_accounts.model.CustomerIdDTO;
import BankApplication.ms_accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountService accountService;

    public CustomerService(CustomerRepository customerRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
    }


    public Customer findCustomerById(CustomerIdDTO customerId){
        return customerRepository.findCustomerByCustomerId(customerId.getCustomerId()).get();
    }

    public Customer saveCustomer(CustomerFormDTO customerForm) {

        if(existsByEmail(customerForm.getEmail())){
            throw new CustomerEmailException("Customer email %s already exists", customerForm.getEmail());
        }

        Customer customer = new Customer();
        customer.setName(customerForm.getName());
        customer.setEmail(customerForm.getEmail());
        customer.setMobileNumber(customerForm.getMobileNumber());
        customer.setCreateDt(LocalDate.now());
        Customer customerSave = customerRepository.save(customer);
        accountService.createFirstAccount(customer);
        return customerSave;
    }

    private boolean existsByEmail(String email) {
       return customerRepository.existsByEmail(email);
    }

}
