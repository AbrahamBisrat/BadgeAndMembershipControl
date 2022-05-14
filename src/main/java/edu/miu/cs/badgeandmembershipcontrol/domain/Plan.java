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
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    // TODO list of allowed roles via Enums
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<Role>();
}
