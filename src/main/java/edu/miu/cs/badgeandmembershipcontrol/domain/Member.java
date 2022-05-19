package edu.miu.cs.badgeandmembershipcontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members") // reserved word conflict when migrating to MSSQL
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    private String emailAddress;

    @ToString.Include
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Collection<Role> roles;

//    @JsonBackReference(value="badges")
    @ToString.Exclude
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Badge> badges = new ArrayList<>();

    public void addBadge(Badge badge){
        this.badges.add(badge);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return emailAddress.equals(member.emailAddress);
    }

    @Override public int hashCode() {
        return Objects.hash(emailAddress);
    }

}
