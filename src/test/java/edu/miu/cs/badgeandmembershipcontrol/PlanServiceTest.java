package edu.miu.cs.badgeandmembershipcontrol;


import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.repository.PlanRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.Impl.LocationServiceImpl;
import edu.miu.cs.badgeandmembershipcontrol.service.Impl.PlanServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PlanServiceTest {
    @Mock
    private PlanRepository planRepository;
    @Autowired
    @InjectMocks
    private PlanServiceImpl planService;


    @Autowired
    private LocationServiceImpl locationService;

    private Plan plan1;
    private Plan plan2;
    private Location location1;
    List<Location> locationList;
    List<Plan> planList;
    @BeforeEach
    public void setUp() {
        planList = new ArrayList<>();
        locationList = new ArrayList<>();
        location1 = new Location(1L,"Building 150","Girl's Dorm",15);
        locationList.add(location1);
        plan1 = new Plan(1L, "food","dinning",locationList);
        plan2 = new Plan(2L, "studying","attending classes",locationList);
        planList.add(plan1);
        planList.add(plan2);
    }
    @AfterEach
    public void tearDown() {
        planList.contains(plan1);
    }
    @Test
    void addPlanAndReturningIt(){
        when(planRepository.save(ArgumentMatchers.any())).thenReturn(plan1);
        planService.createPlan(plan1);
        verify(planRepository,times(1)).save(any());
    }

    @Test
    void retreivingPlanById(){
        Mockito.when(planRepository.findById(1L)).thenReturn(Optional.ofNullable(plan1));
        assertThat(planService.getPlan(plan1.getId())).isEqualTo(plan1);
    }

    @Test
    void retreivingAllPlans(){
        planRepository.save(plan1);
        //stubbing mock to return specific data
        when(planRepository.findAll()).thenReturn(planList);
        List<Plan> productList1 =planService.getAllPlans();
        assertEquals(productList1,planList);
        verify(planRepository,times(1)).save(plan1);
        verify(planRepository,times(1)).findAll();
    }
    /*@Test
    void deletePlanById(){
        when(planService.removePlan(plan1.getId())).thenReturn(true);
        verify(planRepository,times(1)).findAll();
    }*/
}