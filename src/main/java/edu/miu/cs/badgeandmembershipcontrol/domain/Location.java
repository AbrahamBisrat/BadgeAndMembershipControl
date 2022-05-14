package edu.miu.cs.badgeandmembershipcontrol.domain;


import java.util.ArrayList;
import java.util.List;

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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private int capacity;

    // TODO Location type from and Enum
    @Enumerated(EnumType.STRING)
    private List<LocationType> roles = new ArrayList<LocationType>();
    
    @OneToMany(mappedBy = "location")
    private List<Plan> plans = new ArrayList<Plan>();
    
    @OneToMany(mappedBy = "timeSlotsLoc")
    private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
    
    @OneToMany(mappedBy = "transactionLoc")
    private List<Transaction> transactions = new ArrayList<Transaction>();
}
