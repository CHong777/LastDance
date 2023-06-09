package com.example.lastdance.service;

import com.example.lastdance.domain.dto.Member;
import com.example.lastdance.domain.res.TestRes;
import com.example.lastdance.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    public Member hello2(int a){
        return memberMapper.findAll(a);
    }

    public TestRes test(int a, TestRes res){
        Member member = memberMapper.findAll(a);
        res.setMember(member);
        return res;
    }
}