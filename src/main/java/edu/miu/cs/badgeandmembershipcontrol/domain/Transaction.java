package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
@Data
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
  
}
