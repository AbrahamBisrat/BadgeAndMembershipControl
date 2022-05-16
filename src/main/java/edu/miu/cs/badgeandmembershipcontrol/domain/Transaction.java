package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime accessTime;
    
    @ManyToOne
    @JoinColumn(name="badge_id")
    private Badge badge;
    
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location transactionLoc;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return accessTime.equals(that.accessTime) && badge.equals(that.badge) && transactionLoc.equals(that.transactionLoc);
    }

    @Override public int hashCode() {
        return Objects.hash(accessTime, badge, transactionLoc);
    }
}
