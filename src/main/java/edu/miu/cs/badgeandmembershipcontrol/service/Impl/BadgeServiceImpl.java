package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import edu.miu.cs.badgeandmembershipcontrol.repository.BadgeRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;

public class BadgeServiceImpl implements BadgeService {

    private BadgeRepository badgeRepository;

    public BadgeServiceImpl(BadgeRepository badgeRepository){
        this.badgeRepository = badgeRepository;
    }
}
