package BankApplication.ms_accounts.controller;

import BankApplication.ms_accounts.model.Customer;
import BankApplication.ms_accounts.model.CustomerFormDTO;
import BankApplication.ms_accounts.repository.CustomerRepository;
import BankApplication.ms_accounts.service.CustomerService;
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

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


//    @PostMapping("/add")
//    public String addCustomer(@RequestBody CustomerFormDTO customer) {
//        customerService.saveCustomer(customer);
//        return "Customer added successfully";
//    }
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

}
