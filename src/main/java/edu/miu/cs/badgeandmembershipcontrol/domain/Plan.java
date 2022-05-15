package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated
    @ElementCollection
    private Collection<Role> roles;

    
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

}
