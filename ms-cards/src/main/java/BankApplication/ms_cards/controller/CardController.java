package BankApplication.ms_cards.controller;

import BankApplication.ms_cards.Service.CardService;
import BankApplication.ms_cards.config.CardConfig;
import BankApplication.ms_cards.model.CustomerIdDTO;
import BankApplication.ms_cards.model.CardFormDTO;
import BankApplication.ms_cards.model.Properties;
import BankApplication.ms_cards.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import BankApplication.ms_cards.model.Card;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    private final CardConfig cardConfig;

    public CardController(CardService cardService, CardConfig cardConfig) {
        this.cardService = cardService;
        this.cardConfig = cardConfig;
    }

    @PostMapping("/me")
    public List<Card> findMyCards(@RequestBody CustomerIdDTO customerId) {
        return cardService.findCardsById(customerId);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCustomer(@RequestBody CardFormDTO request) {
//        if(request.getEmail() == null || request.getName() == null || request.getMobileNumber() == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Card card = cardService.saveCard(request);
        if(card == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }


    @GetMapping("/details/properties")
    public ResponseEntity<Properties> getPropertiesDetails(){
        Properties properties = new Properties();
        properties.setMsg(cardConfig.getMsg());
        properties.setMailDetails(cardConfig.getMailDetails());
        properties.setBuildVersion(cardConfig.getBuildVersion());
        properties.setActiveBranches(cardConfig.getActiveBranches());
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
}
