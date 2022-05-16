package edu.miu.cs.badgeandmembershipcontrol.service;

import java.util.List;

import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;

public interface TransactionService {
	List<Transaction> getAllTransactions();

	List<Transaction> findTransactionByMember(Long member_id, String status);

	Transaction getTransaction(Long transactionId);



	List<Transaction> getBadgeTransactions(Long badgeId);

	Transaction createTransaction(Transaction transaction);

	boolean removeTransaction(Long transactionId);
}
