package BankApplication.ms_accounts.serviceClient;

import BankApplication.ms_accounts.model.Card;
import BankApplication.ms_accounts.model.CustomerIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ms-cards")
public interface CardsFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "card/me", consumes = "application/json")
    List<Card> getCardsDetails(CustomerIdDTO customerId);
}
