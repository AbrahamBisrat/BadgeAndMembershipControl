package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.repository.BadgeRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BadgeServiceImpl implements BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> getBadgeByStudent(){


    }









}
