package edu.miu.cs.badgeandmembershipcontrol.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailAddress;

    // TODO Roles from an Enum
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<Role>();
    
    @OneToMany(mappedBy = "member")
    private List<Badge> badges = new ArrayList<Badge>();
    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;
}
