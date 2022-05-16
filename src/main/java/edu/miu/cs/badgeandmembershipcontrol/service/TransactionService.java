package edu.miu.cs.badgeandmembershipcontrol.service;

import java.util.List;

import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

	List<Transaction> getAllTransactions();

	Transaction getTransaction(Long transactionId);

	List<Transaction> getBadgeTransactions(Long badgeId);

	Transaction createTransaction(Transaction transaction);

	boolean removeTransaction(Long transactionId);

	Location getTransactionLocation(Long transactionId);

}
