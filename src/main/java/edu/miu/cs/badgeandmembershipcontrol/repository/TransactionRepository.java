package edu.miu.cs.badgeandmembershipcontrol.repository;

import java.util.List;
import java.util.Optional;
import edu.miu.cs.badgeandmembershipcontrol.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	@Query("select t from Transaction t JOIN t.badge b where b.id=?1 and b.stateCode=?2")
	Optional<List<Transaction>> findTransactionByMember_Id(Long memberId,String stateCode);
	Optional<List<Transaction>> findTransactionsByBadge_Id(Long badgelocationId);
}
