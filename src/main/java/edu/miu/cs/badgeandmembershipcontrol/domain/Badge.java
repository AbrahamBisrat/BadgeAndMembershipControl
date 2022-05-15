package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stateCode = "Active";

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
