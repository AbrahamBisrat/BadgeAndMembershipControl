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
public class Logger {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long transactionId;

    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;

    public Logger(LocalDate now, LocalTime now1, String op, String pr) {
        date = now;
        time = now1;
        operation = op;
        principle = pr;
    }

}
