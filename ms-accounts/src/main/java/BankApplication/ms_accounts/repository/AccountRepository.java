package BankApplication.ms_accounts.repository;

import BankApplication.ms_accounts.model.Account;
import BankApplication.ms_accounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, CrudRepository<Account, Long> {
    @Query(value="SELECT u FROM Account u WHERE u.customerId=:customerId")
    public Optional<List<Account>> findAccountByCustomerId(int customerId);

    boolean existsAccountByAccountNumber(long accountNumber);

    boolean existsAccountByCustomerId(int customerId);
}