package edu.miu.cs.badgeandmembershipcontrol.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int capacity;

    @Enumerated
    private LocationType locationType;

    @OneToMany
    @JoinColumn(name = "location_id")
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();

}
