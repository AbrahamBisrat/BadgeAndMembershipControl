package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;

import java.util.List;

public interface BadgeService {

    List<Badge> getAllBadges();

    Badge getBadge(Long badgeId);

    List<Badge> getMemberBadges(Long memberId);

    Badge createBadge(Badge badge);

    Badge updateBadge(Long badgeId, Badge badge);

    boolean removeBadge(Long badgeId);

}
