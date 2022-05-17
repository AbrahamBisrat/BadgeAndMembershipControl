package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

//    @JsonBackReference(value = "location")


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="location_id")
    private Location location;
    @Column(columnDefinition = "integer default 90")
    private int counter = 90;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return name.equals(plan.name) && description.equals(plan.description) && roles.equals(plan.roles) && location.equals(plan.location);
    }

    @Override public int hashCode() {
        return Objects.hash(name, description, roles, location);
    }
    
}
