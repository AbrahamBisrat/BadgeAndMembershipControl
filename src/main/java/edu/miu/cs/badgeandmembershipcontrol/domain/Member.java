package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

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

    @OneToMany(mappedBy = "member")
    private List<Badge> badges = new ArrayList<Badge>();

}
