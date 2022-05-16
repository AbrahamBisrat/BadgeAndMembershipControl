package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
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

    private String name;
    private String description;
    private int capacity;

    @Enumerated
    private LocationType locationType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @ToString.Exclude
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();

}
