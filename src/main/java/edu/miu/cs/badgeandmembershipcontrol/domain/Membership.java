package edu.miu.cs.badgeandmembershipcontrol.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

import java.util.Objects;

@Data
@Entity
@ToString
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Plan plan;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return startDate.equals(that.startDate) && endDate.equals(that.endDate) && member.equals(that.member) && plan.equals(that.plan);
    }

    @Override public int hashCode() {
        return Objects.hash(startDate, endDate, member, plan);
    }

}
