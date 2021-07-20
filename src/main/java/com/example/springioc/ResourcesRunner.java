package com.example.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ResourcesRunner implements ApplicationRunner {
    @Autowired // 가장 구체적인 인터페이스로 코딩하는 것이 좋음
    ResourceLoader resourceLoader;
    // ApplicationContext 실험
    @Autowired
    ApplicationContext context;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // var ctx  = new FileSystemXmlApplicationContext() // file system 기준 application context 찾는 것
        // var ctx = new ClassPathXmlApplicationContext() // classpath 기준 application context 찾는 것
        //문자열 복잡
        // resource 디렉토리 build할때 target 디렉토리 밑에있는 classes(classpath)에 들어감 classpath가 root
        // classpath를 붙이면 ClassPathResource 리솔빙(빈을 찾아내거나 빈 주입 완료)
        // ServletContextResource 가장 많이 사용 그 이유 Resource type이  Application Context에 따라 결정
        // Spring boot ApplicationContext default는 서블릿 기반 WebApplicationContext라서 ServletContextResource
        // * file 경로 root 시 /// 3개 사용
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("resource test " + resource.exists());
        // 풀패키지 이름
        System.out.println(resource.getDescription());
        System.out.println(resource.getURI().toString());
        // java 11 readString 메소드
        System.out.println(Files.readString(Path.of(resource.getURI())));

        // Applicationcontext resource 실험
        // default이므로 webapplication context가 나와야함
        System.out.println(context.getClass());
        // 위에 classpath를 사용했으므로 classpath resource가 나와야함
        System.out.println(resource.getClass());
        /*
        application context는 context root 부터 사용 context path 부터 찾는다
        하지만 spring boot의 기본적인 내장 톰켓에는 context path 지정 되지 않음
         */
    }
}
