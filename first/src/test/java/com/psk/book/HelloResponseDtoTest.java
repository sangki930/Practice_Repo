package com.psk.book;

import com.psk.book.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        //assertj라는 테스트 검증라이버리의 검증 메소드
        //검증하고 싶은 대상은 메소드 인자로 받는다.
        //메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있음
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertj의 동등 비교 메소드이다.
        //assertThat에 있는 값과 isEqualTo에 있는 값이 같을 때만 성공합니다.
    }
}
