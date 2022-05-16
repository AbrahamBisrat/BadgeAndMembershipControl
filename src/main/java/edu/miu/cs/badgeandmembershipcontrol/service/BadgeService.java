package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;

import java.util.List;

public interface BadgeService {

    List<Badge> getAllBadges();

    Badge getBadge(Long badgeId);

    List<Badge> getMemberBadges(Long memberId);

    Badge createBadge(Badge badge);

    Badge createBadge(Member member);

    Badge updateBadge(Long badgeId, Badge badge);

    boolean removeBadge(Long badgeId);

}
