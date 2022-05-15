package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

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
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    private List<Badge> badges = new ArrayList<Badge>();
  
}
