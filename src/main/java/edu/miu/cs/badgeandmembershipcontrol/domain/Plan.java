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

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="membership_id")
    private Membership membership;
    
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

}
