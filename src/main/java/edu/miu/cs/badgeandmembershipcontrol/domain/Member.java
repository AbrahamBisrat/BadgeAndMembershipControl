package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @ToString.Include
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Collection<Role> roles;


    @ToString.Exclude
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Badge> badges = new ArrayList<Badge>();

    public void addBadge(Badge badge){
        this.badges.add(badge);
    }
  
}
