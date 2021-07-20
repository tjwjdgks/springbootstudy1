package com.example.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ResourcesRunner implements ApplicationRunner {
    @Autowired // 가장 구체적인 인터페이스로 코딩하는 것이 좋음
    ResourceLoader resourceLoader;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //문자열 복잡
        // resource 디렉토리 build할때 target 디렉토리 밑에있는 classes(classpath)에 들어감 classpath가 root
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("resource test " + resource.exists());
        // 풀패키지 이름
        System.out.println(resource.getDescription());
        System.out.println(resource.getURI().toString());
        // java 11 readString 메소드
        System.out.println(Files.readString(Path.of(resource.getURI())));
    }
}
