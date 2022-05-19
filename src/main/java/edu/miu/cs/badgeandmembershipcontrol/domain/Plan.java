package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;
    private String description;

    @Enumerated
    @ElementCollection
    @ToString.Include
    private Set<Role> roles = new HashSet<>();

//    @JsonBackReference(value = "location")
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="plan_location", joinColumns = {@JoinColumn(name="plan_id")},inverseJoinColumns = {@JoinColumn(name="location_id")})
    private List<Location> locations = new ArrayList<>();

    public Plan(long id, String name, String description, List<Location> locationList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locations = locationList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id) && Objects.equals(name, plan.name) && Objects.equals(description, plan.description) && Objects.equals(roles, plan.roles) && Objects.equals(locations, plan.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, roles, locations);
    }
}
