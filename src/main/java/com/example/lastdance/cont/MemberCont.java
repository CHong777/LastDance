package com.example.lastdance.cont;

import com.example.lastdance.annotation.CommonLog;
import com.example.lastdance.domain.dto.Member;
import com.example.lastdance.domain.header.CommonRequestHeader;
import com.example.lastdance.domain.req.RootReq;
import com.example.lastdance.domain.res.TestRes;
import com.example.lastdance.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@CommonLog
public class MemberCont {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/hello2",  method = RequestMethod.POST)
    public Object hello2(CommonRequestHeader reqHeader) {
        Member member = memberService.hello2(1);
        log.info("M : " + member);
        return member;
    }

    @RequestMapping(value = "/test",  method = RequestMethod.POST)
    public Object test(CommonRequestHeader reqHeader, @Valid @RequestBody RootReq rootReq, BindingResult bindingResult, TestRes testRes)  {
        int a = rootReq.getTest();
        return memberService.test(a, testRes);
    }
}