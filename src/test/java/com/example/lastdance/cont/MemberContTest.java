package com.example.lastdance.cont;

import com.example.lastdance.domain.req.RootReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class MemberContTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("updateTodo_To-Do 수정")
    @Test
    public void testMyApi() {
        String url = "/hello2";

        // RestAPI 호출
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, HttpEntity.EMPTY, Object.class);
        Object responseBody = responseEntity.getBody();
        log.info("Test : " + responseBody);

        // 응답 확인
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // 추가적인 응답 검증 로직 작성
    }

    @DisplayName("22")
    @Test
    public void hihi() {
        String url = "/test";


        // 요청 매개변수 설정
        RootReq request = new RootReq(1);
        // request 객체에 필요한 데이터 설정

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("authKey", "1");
        // 필요한 헤더 설정

        // HttpEntity에 요청 매개변수와 헤더 설정
        HttpEntity<RootReq> requestEntity = new HttpEntity<>(request, headers);

        // RestAPI 호출
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
        Object responseBody = responseEntity.getBody();
        log.info("Test: " + responseBody);

        // 응답 확인
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // 추가적인 응답 검증 로직 작성
    }
}