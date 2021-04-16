package com.psk.book;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class FirstApplicationTests {

	@Autowired//스프링 빈을 주입받음
	private MockMvc mvc;//스프링 MVC의 시작점, 웹 API를 테스트 할 때 사용한다.

	@Test
	void contextLoads() {
	}

	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";
		System.out.println(hello);
		mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을한다.
				.andExpect(status().isOk())//mvc.perform의 결과 검증, HTTP 헤더의 검증
				.andExpect(content().string(hello));//응답 본문의 내용 검증, Controller에서 "hello"를 리턴
		//하기 때문에 이 값이 맞는지 검증한다.
	}
}
