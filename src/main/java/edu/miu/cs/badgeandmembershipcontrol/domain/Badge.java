package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @OneToMany(mappedBy = "badge")
    private List<Transaction> transactions = new ArrayList<Transaction>();
  
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}
