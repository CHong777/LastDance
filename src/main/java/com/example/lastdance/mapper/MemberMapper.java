package com.example.lastdance.mapper;

import com.example.lastdance.domain.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberMapper {
    @Insert("insert into Member(user_id, name, password) values(#{userId},#{name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "memberId")
    public int save(Member member);

    @Select("select * from Member where member_id = #{memberId}")
    // @Results({
    // @Result(property = "memberId", column = "member_id"),
    // @Result(property = "userId", column = "user_id")
    // })
    public Member findOneById(Long memberId);

    @Select("select * from Member LIMIT #{a}")
    public Member findAll(int a);
}