package edu.miu.cs.badgeandmembershipcontrol.controller;



import java.util.List;



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
@RequestMapping("/api/v1/transactions")
public class TransactionController {
	private TransactionService transactionService;
	
	
	
	public TransactionController(TransactionService transactionService){
	this.transactionService = transactionService;
	}
	
	
	
	@GetMapping()
	public ResponseEntity<?> getTransactions(){
	List<Transaction> transactionList = transactionService.getAllTransactions();
	return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}
	
	
	
	@GetMapping(path = "/{transactionId}")
	public ResponseEntity<?> getTransaction(@PathVariable String transactionId){
	Transaction transaction = transactionService.getTransaction(Long.parseLong(transactionId));
	
	
	
	if(transaction == null){
	return new ResponseEntity<String>("No Transaction Found!", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	@GetMapping(path = "/badge/{badgeId}")
	public ResponseEntity<?> getBadgeTransactions(@PathVariable String badgeId){
	List<Transaction> transactionList = transactionService.getBadgeTransactions(Long.parseLong(badgeId));
	return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}

	@GetMapping(path = "/member/{memberId}")
	public ResponseEntity<?> getTransactionsByMemberId(@PathVariable String memberId){
		List<Transaction> transactionList = transactionService.findTransactionByMember(Long.parseLong(memberId),"Active");
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}
	
	
	
	@PostMapping()
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction){
		Transaction transaction1 = transactionService.createTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction1, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(path = "/{transactionId}")
	public ResponseEntity<?> removeTransaction(@PathVariable String transactionId){
		Boolean result = transactionService.removeTransaction(Long.parseLong(transactionId));
		if(!result){
			return new ResponseEntity<String>("No Transaction Found!", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>("Successful", HttpStatus.OK);
	}



}