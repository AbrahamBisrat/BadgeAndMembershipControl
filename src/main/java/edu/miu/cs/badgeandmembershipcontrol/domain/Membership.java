package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Plan plan;

}
