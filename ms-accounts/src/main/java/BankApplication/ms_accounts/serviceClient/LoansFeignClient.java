package BankApplication.ms_accounts.serviceClient;

import BankApplication.ms_accounts.model.CustomerIdDTO;
import BankApplication.ms_accounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ms-loans")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "loan/me", consumes = "application/json")
    List<Loan> getLoansDetails(CustomerIdDTO customerId);
}
