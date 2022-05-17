package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import edu.miu.cs.badgeandmembershipcontrol.repository.MembershipRepository;
import edu.miu.cs.badgeandmembershipcontrol.repository.TransactionRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import edu.miu.cs.badgeandmembershipcontrol.service.LocationService;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import edu.miu.cs.badgeandmembershipcontrol.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import static edu.miu.cs.badgeandmembershipcontrol.domain.MembershipType.LIMITED;


@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private MembershipRepository membershipRepository;

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
		Badge badge = badgeService.getBadge(transaction.getBadge().getId());
		Location location = locationService.getLocation(transaction.getTransactionLoc().getId());
		Membership membership = membershipService.getMemberShip(transaction.getMembership().getId());

		if(badge == null || location == null || membership == null) return null;

		transaction.setTransactionLoc(location);
		transaction.setBadge(badge);
		transaction.setMembership(membership);
		transactionRepository.save(transaction);
		long count = transaction.getMembership().getCounter();
		count --;
		if(membership.getMembershipType() == LIMITED){
		membership.setCounter(count);
		membershipRepository.save(membership);}
		return transaction;

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