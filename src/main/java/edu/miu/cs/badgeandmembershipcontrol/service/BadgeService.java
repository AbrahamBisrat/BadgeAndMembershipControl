package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BadgeService {

    List<Badge> getAllBadges();

    Badge getBadge(Long badgeId);

    List<Badge> getMemberBadges(Long memberId);

    Badge getActiveBadgeByMemberId(Long memberId);

    Badge deactivateBadge(Long memberId);

    Badge createBadge(Badge badge);

    Badge createBadge(Member member);

    Badge updateBadge(Long badgeId, Badge badge);

    boolean removeBadge(Long badgeId);

}
