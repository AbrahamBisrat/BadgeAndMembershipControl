package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime accessTime = LocalDateTime.now();
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="badge_id")
    private Badge badge;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="location_id")
    private Location transactionLoc;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="membership_id")
    private Membership membership;

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
