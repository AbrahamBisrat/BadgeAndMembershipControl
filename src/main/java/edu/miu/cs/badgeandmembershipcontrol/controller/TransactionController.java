package edu.miu.cs.badgeandmembershipcontrol.controller;

import java.util.List;


import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import edu.miu.cs.badgeandmembershipcontrol.service.TransactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {

	private final TransactionService transactionService;
	
	@GetMapping()
	public ResponseEntity<?> getTransactions(){
		return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
	}

	@GetMapping(path = "/{transactionId}")
	public ResponseEntity<?> getTransaction(@PathVariable String transactionId){
		Transaction transaction = transactionService.getTransaction(Long.parseLong(transactionId));

		if(transaction == null){
			return new ResponseEntity<>("No Transaction Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
	
	@GetMapping(path = "/badge/{badgeId}")
	public ResponseEntity<?> getBadgeTransactions(@PathVariable String badgeId){
		List<Transaction> transactionList = transactionService.getBadgeTransactions(Long.parseLong(badgeId));
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

	@GetMapping(path = "/transaction/{transactionId}")
	public ResponseEntity<?> getTransactionLocation(@PathVariable String transactionId){
		Location location = transactionService.getTransactionLocation(Long.parseLong(transactionId));
		return new ResponseEntity<>(location, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
		Transaction newTransaction = transactionService.createTransaction(transaction);
		return new ResponseEntity<>(newTransaction, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{transactionId}")
	public ResponseEntity<?> removeTransaction(@PathVariable String transactionId){
		if(!transactionService.removeTransaction(Long.parseLong(transactionId))){
			return new ResponseEntity<String>("No Transaction Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successful", HttpStatus.OK);
	}

}