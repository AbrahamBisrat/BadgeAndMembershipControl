package edu.miu.cs.badgeandmembershipcontrol;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BadgeAndMembershipControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadgeAndMembershipControlApplication.class, args);
    }

}
// develop test