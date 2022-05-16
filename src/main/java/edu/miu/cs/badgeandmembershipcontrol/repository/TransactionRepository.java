package edu.miu.cs.badgeandmembershipcontrol.repository;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	Optional<List<Transaction>> findTransactionsByBadge_Id(Long badgelocationId);
	Optional<Location> findTransactionLocationBy_Id(Long transactionId);
}
