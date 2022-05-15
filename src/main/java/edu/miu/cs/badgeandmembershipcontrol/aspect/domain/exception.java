package edu.miu.cs.badgeandmembershipcontrol.aspect.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class exception {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private LocalDate date;
    private LocalTime time;
    private String operation;
    private String exceptionType;
    private String exceptionMessage;

}
