package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;

import java.util.List;

public interface BadgeService {

    abstract List<Badge> getAllBadges();

    abstract Badge getBadge(Long badgeId);

    abstract List<Badge> getMemberBadges(Long memberId);

    abstract Badge createBadge(Badge badge);

    abstract Badge updateBadge(Long badgeId, Badge badge);

    abstract boolean removeBadge(Long badgeId);

}
