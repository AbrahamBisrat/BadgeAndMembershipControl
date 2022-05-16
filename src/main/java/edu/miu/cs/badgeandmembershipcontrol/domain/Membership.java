package edu.miu.cs.badgeandmembershipcontrol.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @JsonBackReference(value="member")
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Member member;

    @JsonBackReference(value="member")
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
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
