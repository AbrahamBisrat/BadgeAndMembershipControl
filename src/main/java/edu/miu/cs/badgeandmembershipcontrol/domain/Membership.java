package edu.miu.cs.badgeandmembershipcontrol.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // TODO make the relationships happen here
    @OneToMany(mappedBy = "membership")
//    Member member;
    private List<Member> members = new ArrayList<Member>();
//    Plan plan;
    @OneToMany(mappedBy = "mship")
    private List<Plan> plan = new ArrayList<Plan>();
}
