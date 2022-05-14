package edu.miu.cs.badgeandmembershipcontrol.Repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction extends JpaRepository<Transaction,Long> {
}
