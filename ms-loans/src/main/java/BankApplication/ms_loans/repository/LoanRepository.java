package BankApplication.ms_loans.repository;

import BankApplication.ms_loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>, CrudRepository<Loan, Long> {
    @Query(value="SELECT u FROM Loan u WHERE u.customerId=:customerId")
    public Optional<List<Loan>> findLoanByCustomerId(int customerId);

    boolean existsLoansByCustomerId(int customerId);
}