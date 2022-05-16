package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@Entity
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String name;
    private String description;
    private int capacity;

    @Enumerated
    private LocationType locationType;

    @JsonBackReference(value = "timeSlots")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @ToString.Exclude
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return name.equals(location.name) && description.equals(location.description);
    }

    @Override public int hashCode() {
        return Objects.hash(name, description);
    }

}
