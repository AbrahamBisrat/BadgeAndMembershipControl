package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
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

    @ManyToMany(mappedBy = "locations")
    private List<Plan> plans = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    @ToString.Exclude
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();

    public boolean checkTimeSlot(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        boolean isValid = false;
        for (int i = 0; i<timeSlots.size(); i++){
            if(currentDateTime.isAfter(this.timeSlots.get(i).getStartTime()) && currentDateTime.isBefore(this.timeSlots.get(i).getEndTime()))
            {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

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
