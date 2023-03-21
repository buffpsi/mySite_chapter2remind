package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
/*@EnableJpaAuditing는 스프링 데이터 JPA에서 제공하는 기능 중 하나로,
JPA Entity의 생성일자와 수정일자를 자동으로 관리하기 위한 기능을 활성화하는 어노테이션입니다.*/
public class SbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}

}
