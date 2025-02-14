package BankApplication.ms_cards.repository;

import BankApplication.ms_cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>, CrudRepository<Card, Long> {
    @Query(value="SELECT u FROM Card u WHERE u.customerId=:customerId")
    public Optional<List<Card>> findCardByCustomerId(int customerId);

    boolean existsCardByCustomerId(int customerId);

    boolean existsCardByCardNumber(String cardNumber);
}
