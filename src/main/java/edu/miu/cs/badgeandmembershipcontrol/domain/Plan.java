package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    @Enumerated
    @ElementCollection
    private Set<Role> roles = new HashSet<>();

    
    @ManyToOne
    @JoinColumn(name="membership_id")
    private Membership membership;
    
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Plan plan = (Plan) o;
        return id != null && Objects.equals(id, plan.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
