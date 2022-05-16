package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    @Enumerated
    @ElementCollection
    @ToString.Include
    private Set<Role> roles = new HashSet<>();

    
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

}
