package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import edu.miu.cs.badgeandmembershipcontrol.repository.TransactionRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import edu.miu.cs.badgeandmembershipcontrol.service.LocationService;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import edu.miu.cs.badgeandmembershipcontrol.service.TransactionService;
<<<<<<< HEAD

=======
>>>>>>> 84c2834fb695c9bc29dbe6aeb7d0558ead15ae4f
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	@NotNull private TransactionRepository transactionRepository;

	@NotNull private BadgeService badgeService;

	@NotNull private MembershipService membershipService;

	@NotNull private LocationService locationService;
	
	@Override public List<Transaction> getAllTransactions() {
	return transactionRepository.findAll();
	}


	@Override
	public List<Transaction> findTransactionByMember(Long member_id, String status) {
		Optional<List<Transaction>> TransactionByMemberOptional = transactionRepository.findTransactionByMember_Id(member_id,"Active");
		if(TransactionByMemberOptional.isPresent()){
			return TransactionByMemberOptional.get();
		}
		return null;
	}


	@Override
	public Transaction getTransaction(Long transactionId) {
		Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
		if (transactionOptional.isPresent()) {
			return transactionOptional.get();
		}
		return null;
	}
	
	@Override public List<Transaction> getBadgeTransactions(Long badgeId) {
		Optional<List<Transaction>> badgeTransactrionsOptional = transactionRepository.findTransactionsByBadge_Id(badgeId);
		return badgeTransactrionsOptional.orElse(null);
	}
	
	
	@Override public Transaction createTransaction(Transaction transaction) {

		transactionRepository.save(transaction);
		long count = transaction.getMembership().getCounter();
		count --;
		Membership membership = transaction.getMembership();
		membership.setCounter(count);
		System.out.println(transaction.getMembership().getCounter());
		return transaction;

		Badge badge = badgeService.getBadge(transaction.getBadge().getId());
		Location location = locationService.getLocation(transaction.getTransactionLoc().getId());
		Membership membership = membershipService.getMemberShip(transaction.getMembership().getId());
>>>>>>> 84c2834fb695c9bc29dbe6aeb7d0558ead15ae4f

		if(badge == null || location == null || membership == null) return null;

		transaction.setTransactionLoc(location);
		transaction.setBadge(badge);
		transaction.setMembership(membership);

//		long count = transaction.getMembership().getPlan().getCounter();
//		count --;
//		transaction.getMembership().getPlan().setCounter(count);
//		System.out.println(transaction.getMembership().getPlan().getCounter());
//		entityManager.flush();

		return transactionRepository.save(transaction);
	}
	
	@Override
		public boolean removeTransaction(Long transactionId) {
			Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
			if(transactionOptional.isPresent()){
				transactionRepository.deleteById(transactionId);
			return true;
		}
		return false;
	}

	@Override
	public List<Transaction> findTransactionByTimeSlot(Long timeSlotId) {
		Optional<List<Transaction>> TransactionByMemberOptional = transactionRepository.findTransactionByTimeSlot(timeSlotId);
		if(TransactionByMemberOptional.isPresent()){
			return TransactionByMemberOptional.get();
		}
		return null;
	}


	@Override
	public Transaction findTransactionByPlan(Long planId) {
		Optional<Transaction> transactionOptional = Optional.ofNullable(transactionRepository.findTransactionByPlan(planId));
		if (transactionOptional.isPresent()) {
			return transactionOptional.get();
		}
		return null;
	}

	@Override public Location getTransactionLocation(Long transactionId) {
//		Optional<Location> transactionLocationOptional = transactionRepository.findTransactionLocationBy_Id(transactionId);
//		return transactionLocationOptional.orElse(null);
		return new Location();
	}

}