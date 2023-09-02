package com.cafe;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/*
src/main/java: 패키지와 클래스 파일
src/main/resource
 - static: css/js 파일
 - templates: html 파일(표준)
 - application.properties: 환경 설정 파일
 - pom.xml: Maven 라이브러리 설정 파일
* */
@SpringBootApplication
public class CafePosBApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafePosBApplication.class, args);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource); // 의존성 주입 -servlet-context.xml에서 해주는 작업

        Resource[] res = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com.cafe.mapper/*.xml");

        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();

        // .xml 형태의 모든 파일을 받기 때문에 배열로 받음.
    }

}
