package com.psk.book;

import com.psk.book.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        System.out.println(hello);
        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을한다.
                .andExpect(status().isOk())//mvc.perform의 결과 검증, HTTP 헤더의 검증
                .andExpect(content().string(hello));//응답 본문의 내용 검증, Controller에서 "hello"를 리턴
        //하기 때문에 이 값이 맞는지 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        //given
        String name = "hello";
        int amount = 1000;

        /*
        * param : API 테스트할 때 사용될 요청 파라미터를 설정한다.
        * 값은 String만 허용된다.
        * 따라서, 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변셩해야한다.
        *
        * jsonPath
        * JSON 응답값을 필드별로 검증할 수 있는 메소드이다.
        * $를 기준으로 필드명을 명시
        * */

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.
                        valueOf(amount)))
                .andExpect(jsonPath("$.name",is(name)))
                        .andExpect(jsonPath("$.amount",is(amount)));

    }
}
