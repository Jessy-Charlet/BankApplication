package BankApplication.ms_accounts.repository;

import BankApplication.ms_accounts.model.Account;
import BankApplication.ms_accounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long> {
    @Query(value="SELECT u FROM Customer u WHERE u.customerId=:customerId")
    public Optional<Account> findCustomerByCustomerId(int customerId);

    boolean existsByEmail(String email);
}