package edu.miu.cs.badgeandmembershipcontrol;

import edu.miu.cs.badgeandmembershipcontrol.controller.BadgeController;
import edu.miu.cs.badgeandmembershipcontrol.controller.LocationController;
import edu.miu.cs.badgeandmembershipcontrol.controller.MemberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class smokeTest {

    @Autowired BadgeController badgeController;
    @Autowired LocationController locationController;
    @Autowired MemberController memberController;

    @Test public void badgeContext() throws Exception {
        assertThat(badgeController).isNotNull();
    }

    @Test public void controllerContext() throws  Exception {
        assertThat(locationController).isNotNull();
    }

    @Test public void memberController() throws  Exception {
        assertThat(memberController).isNotNull();
    }

}
