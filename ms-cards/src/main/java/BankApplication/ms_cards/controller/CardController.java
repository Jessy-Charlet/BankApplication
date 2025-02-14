package BankApplication.ms_cards.controller;

import BankApplication.ms_cards.Service.CardService;
import BankApplication.ms_cards.model.CustomerIdDTO;
import BankApplication.ms_cards.model.CardFormDTO;
import BankApplication.ms_cards.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import BankApplication.ms_cards.model.Card;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
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

}
