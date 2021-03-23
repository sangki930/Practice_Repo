package com.sample.demo.config;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.sample.demo.domain.Pay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class JdbcCursorItemReaderJobConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource; // DataSource DI
	
    private static final int chunkSize = 10;
    
    @Bean
    public Job jdbcCursorItemReaderJob() {
    	return jobBuilderFactory.get("jdbcCursorItemReaderJob")
    				.start(jdbcCursorItemReaderStep())
    				.build();
    }

	

	@Bean
	//데이터를 Streaming 할 수 있음
	public ItemReader<? extends Pay>  jdbcCursorItemReader() {
		// TODO Auto-generated method stub
		return new JdbcCursorItemReaderBuilder<Pay>()
                .fetchSize(chunkSize)
                //Database에서 한번에 가져올 데이터 양을 나타냄
                //Paging과는 다른 것이, Paging은 실제 쿼리를 limit, offset을 이용해서 분할 처리하는 반면
                //Cursor는 쿼리는 분할 처리 없이 실행되나 내부적으로 가져오는 데이터는
                //FetchSize만큼 가져와 read()를 통해서 하나씩 가져옴
                .dataSource(dataSource)
                //Database에 접근하기 위해 사용할 Datasource 객체를 할당합니다.
                .rowMapper(new BeanPropertyRowMapper<>(Pay.class))
                //쿼리 결과를 Java인스턴스로 매핑하기 위한 Mapper
                /*사용자 정의로 생성해서 사용할 수 도 잇지만, 이렇게 될 경우 매번 Mapper 클래스를 생성해야되서
                 * 보편적으로는 Spring에서 공식적으로 지원하는 BeanPropertyRowMapper.class를 많이 사용함
                 * */
                .sql("SELECT id, amount, tx_name, tx_date_time FROM pay")
                //Reader로 사용할 쿼리문을 사용
                .name("jdbcCursorItemReader")
                //reader의 이름을 지정(단, Bean의 이름이 아니라, Spring Batch의 ExecutionContext에서 저장될 이름)
                .build();
	}

	@Bean
	public Step jdbcCursorItemReaderStep() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("jdbcCursorItemReaderStep")
                .<Pay, Pay>chunk(chunkSize)
                //첫번째 Pay는 Reader에서 반환할 타입이며, 두번째 Pay는 Writer에 파라미터로 넘어올 타입을 말함
                //ChunkSize로 인자값을 넣은 경우는 Reader & Writer가 묶일 Chunk 트랜잭션 범위임
                .reader(jdbcCursorItemReader())
                .writer(jdbcCursorItemWriter())
                .build();
	}
	
	private ItemWriter<Pay> jdbcCursorItemWriter() {
		// TODO Auto-generated method stub
		return list -> {
            for (Pay pay: list) {
                log.info("Current Pay={}", pay);
            }
        };
	}
}
