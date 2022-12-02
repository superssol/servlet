package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    public MemberRepository() {
    }

    //save
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //id로 찾기
    public Member findById(Long id) {
        return store.get(id);
    }

    //전체 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //store 값 날리기
    public void clearStore() {
        store.clear();
    }
}
