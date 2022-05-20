package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	@Query("select t from Transaction t JOIN t.badge b where b.id=?1 and b.stateCode=?2")
	Optional<List<Transaction>> findTransactionByMember_Id(Long memberId,String stateCode);

	@Query("select t from Transaction t  inner JOIN t.transactionLoc l join TimeSlot ts on ts.id =?1" )
	Optional<List<Transaction>> findTransactionByTimeSlot(Long timeSlotId);

	Optional<List<Transaction>> findTransactionsByBadge_Id(Long badgelocationId);


	@Query("select t from Transaction t JOIN t.membership m Join Plan p on p.id=?1")
	Transaction findTransactionByPlan(Long planId);

	@Query("select t.transactionLoc from Transaction t where t.id=?1")
	Optional<Location> findTransactionLocationBy_Id(Long transactionId);



}
