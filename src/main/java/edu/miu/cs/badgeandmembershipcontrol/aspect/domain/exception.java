package edu.miu.cs.badgeandmembershipcontrol.aspect.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class exception {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private LocalDate date;
    private LocalTime time;
    private String operation;
    private String exceptionType;
    private String exceptionMessage;

    public exception(LocalDate d, LocalTime t, String op, String eT, String eM) {
        date = d;
        time = t;
        operation = op;
        exceptionType = eT;
        exceptionMessage = eM;
    }

}
