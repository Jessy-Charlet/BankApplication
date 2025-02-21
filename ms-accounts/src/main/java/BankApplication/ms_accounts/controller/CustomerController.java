package BankApplication.ms_accounts.controller;

import BankApplication.ms_accounts.model.Customer;
import BankApplication.ms_accounts.model.CustomerAllDTO;
import BankApplication.ms_accounts.model.CustomerFormDTO;
import BankApplication.ms_accounts.model.CustomerIdDTO;
import BankApplication.ms_accounts.service.CustomerService;
import BankApplication.ms_accounts.serviceClient.CardsFeignClient;
import BankApplication.ms_accounts.serviceClient.LoansFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    public CustomerController(CustomerService customerService, CardsFeignClient cardsFeignClient, LoansFeignClient loansFeignClient) {
        this.customerService = customerService;
        this.cardsFeignClient = cardsFeignClient;
        this.loansFeignClient = loansFeignClient;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerFormDTO request) {
        if(request.getEmail() == null || request.getName() == null || request.getMobileNumber() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.saveCustomer(request);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/me")
    public ResponseEntity<CustomerAllDTO> meCustomer(@RequestBody CustomerIdDTO request) {
        CustomerAllDTO result = new CustomerAllDTO();
        result.setCustomer(customerService.findCustomerById(request));
        result.setCards(cardsFeignClient.getCardsDetails(request));
        result.setLoans(loansFeignClient.getLoansDetails(request));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
