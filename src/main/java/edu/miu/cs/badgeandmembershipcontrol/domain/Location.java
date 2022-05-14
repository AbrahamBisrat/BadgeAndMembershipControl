package edu.miu.cs.badgeandmembershipcontrol.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int capacity;

    // TODO Location type from and Enum
    @Enumerated(EnumType.STRING)
    private List<LocationType> roles = new ArrayList<LocationType>();
}
