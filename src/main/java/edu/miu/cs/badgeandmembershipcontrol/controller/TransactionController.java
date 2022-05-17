package edu.miu.cs.badgeandmembershipcontrol.controller;

import java.util.List;


import lombok.NonNull;
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

	@NonNull
	private final TransactionService transactionService;
	
	@GetMapping()
	public ResponseEntity<?> getTransactions(){
		return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
	}

	@GetMapping(path = "/{transactionId}")
	public ResponseEntity<?> getTransaction(@PathVariable Long transactionId){
		Transaction transaction = transactionService.getTransaction(transactionId);

		if(transaction == null){
			return new ResponseEntity<>("No Transaction Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
	
	@GetMapping(path = "/badge/{badgeId}")
	public ResponseEntity<?> getBadgeTransactions(@PathVariable Long badgeId){
		List<Transaction> transactionList = transactionService.getBadgeTransactions(badgeId);
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

	@GetMapping(path = "/member/{memberId}")
	public ResponseEntity<?> getTransactionsByMemberId(@PathVariable Long memberId){
		List<Transaction> transactionList = transactionService.findTransactionByMember(memberId ,"Active");
		if(transactionList == null){
			return new ResponseEntity<>("Member have no active badge!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

	@GetMapping(path = "/timeslot/{timeslotId}")
	public ResponseEntity<?> getTransactionsByTimeslotId(@PathVariable Long timeslotId){
		List<Transaction> transactionList = transactionService.findTransactionByTimeSlot(timeslotId);
		if(transactionList == null){
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

	@GetMapping(path = "/plan/{planId}")
	public ResponseEntity<?> getTransactionsByPlanId(@PathVariable Long planId){
		Transaction transactionList = transactionService.findTransactionByPlan(planId);
		if(transactionList == null){
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}
	
	@GetMapping(path = "/location/{transactionId}")
	public ResponseEntity<?> getTransactionLocation(@PathVariable Long transactionId){
		Location location = transactionService.getTransactionLocation(transactionId);
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
  
	@PostMapping()
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
		Transaction transaction1 = transactionService.createTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction1, HttpStatus.OK);

	}
	
	@DeleteMapping(path = "/{transactionId}")
	public ResponseEntity<?> removeTransaction(@PathVariable Long transactionId) {

		Boolean result = transactionService.removeTransaction(transactionId);
		if (!result) {
			return new ResponseEntity<String>("No Transaction Found!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>("Successful", HttpStatus.OK);
	}

}
