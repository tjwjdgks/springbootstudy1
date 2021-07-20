package com.example.springioc;

import com.example.springioc.book.BookService;
import com.example.springioc.book.MyBookRepository;
import com.example.springioc.book.TestBookRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

// spring ioc container bean 설정파일 필요
@SpringBootApplication // 어노테이션 가능
@PropertySource("classpath:/app.properties")
//@EnableAsync // 비동기 실행
public class SpringiocApplication /*implements ExitCodeGenerator*/ {

    public static void main(String[] args) {
        /*
        // class 파일 방식
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        */

        /*
        xml 방식
        ApplicationContext context = new ClassPathXmlApplicationContext("application.txt");
         */
        /*
        // test
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.bookRepository!=null);
         */

        // spring 구동 방식
        // commponet scan 범위 밖에도 가능
        /*
        // 성능 상의 이점이 있다 reflection 이나 proxy 쓰지 않음
        var app = new SpringApplication(SpringiocApplication.class);
        app.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
            @Override
            public void initialize(GenericApplicationContext ctx) {
                ctx.registerBean(MyBookRepository.class);
            }
        });
        app.run(args)

         */

        // profile test인 testbookrepo
        SpringApplication.run(SpringiocApplication.class,args);
    }
    /*
    @Bean
    public MessageSource messageSource(){
        var messageSource  = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        //한글 깨질 경우
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        return messageSource;

    }

     */

    // ContextClosedEvent 보기 위해 exit System.exit(130);
    // or ContextClosedEvent 보기
    // 디버그 모드에서 가능
    /*
    @Override
    public int getExitCode() {
        return 130;
    }

     */
}
