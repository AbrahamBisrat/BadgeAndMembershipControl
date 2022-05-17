package edu.miu.cs.badgeandmembershipcontrol.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.ToString;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
public class Membership implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String membershipStatus = "Active";

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Member member;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Plan plan;


    public void deActivateMembership(){
        this.membershipStatus = "InActive";
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return startDate.equals(that.startDate) && endDate.equals(that.endDate)
                && member.equals(that.member) && plan.equals(that.plan);
    }

    @Override public int hashCode() {
        return Objects.hash(startDate, endDate, member, plan);
    }

}
