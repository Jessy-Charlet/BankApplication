package BankApplication.ms_cards.Service;

import BankApplication.ms_cards.exception.CardNumberException;
import BankApplication.ms_cards.model.Card;
import BankApplication.ms_cards.model.CardFormDTO;
import BankApplication.ms_cards.model.CustomerIdDTO;
import BankApplication.ms_cards.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> findCardsById(CustomerIdDTO customerId){
        if(cardRepository.existsCardByCustomerId(customerId.getCustomerId()))
        {
            return cardRepository.findCardByCustomerId(customerId.getCustomerId()).get();
        }
        throw new RuntimeException();
    }

    public Card saveCard(CardFormDTO cardForm){
        if(existsByCardNumber(cardForm.getCardNumber())){
            throw new CardNumberException("Card with number %s already exists", cardForm.getCardNumber());
        }
        Card card = new Card();
        card.setCardNumber(cardForm.getCardNumber());
        card.setCustomerId(cardForm.getCustomerId());
        card.setCardType(cardForm.getCardType());
        card.setAmountUsed(0);
        card.setAvailableAmount(0);
        card.setTotalLimit(cardForm.getTotalLimit());
        card.setCreateDt(LocalDate.now());
        return cardRepository.save(card);
    }

    private boolean existsByCardNumber(String cardNumber) {
        return cardRepository.existsCardByCardNumber(cardNumber);
    }
}
