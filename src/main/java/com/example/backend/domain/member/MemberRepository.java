package com.example.backend.domain.member;

import com.example.backend.entity.member.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmail(String email);

    
    @Query("select u from Member u where u.id in (select f.friendId from FriendRelationship f where f.userId = :userId)")
    List<Member> findFriendsByUserId(@Param("userId") String userId);

    //Optional<Member> findById(String id);

    @Query("select u.memberIdx from Member u where u.memberIdx = :userId")
    Optional<Member> findById(@Param("userId")Long Idx);

    Optional<Member> findMemberById(@Param("userId")String userId);


}
