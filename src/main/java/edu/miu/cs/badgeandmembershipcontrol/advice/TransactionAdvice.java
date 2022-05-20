package edu.miu.cs.badgeandmembershipcontrol.advice;
import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.LocationType;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionAdvice {

    private final MemberService memberService;

    @After("execution(* edu.miu.cs.badgeandmembershipcontrol.service.Impl.MembershipServiceImpl.checkAccess(..)) " +
            "&& args(memberId,locationId,locationType)")
    public void saveTransactionLog(JoinPoint joinPoint, Long memberId, Long locationId, LocationType locationType){
        System.out.println("Method = "+joinPoint.getSignature().getName());
        System.out.println("kashdfjhsdjfhasdkfhaskfhaskhfjsdhfksjdhfkjasdhf-------------------- "+ memberId);
        Member member = memberService.getMember(memberId);
        System.out.println("kashdfjhsdjfhasdkfhaskfhaskhfjsdhfksjdhfkjasdhf-------------------- "+ member);
    }

}
