package edu.miu.cs.badgeandmembershipcontrol.domain;



import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
  
}
