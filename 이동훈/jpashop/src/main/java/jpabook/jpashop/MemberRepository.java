package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) { // 커맨드랑 쿼리를 분리해라, 저장하면 보통 리턴값을 안만드는데 id를 조회하는 건 정도는 괜찮다고 판단.
        return em.find(Member.class, id);
    }
}

