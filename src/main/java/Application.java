package dev.bijansaudcontentcalender.contentcalender;

import dev.bijansaudcontentcalender.contentcalender.Repository.ContentRepository;
import dev.bijansaudcontentcalender.contentcalender.config.ContentCalendarProperties;
import dev.bijansaudcontentcalender.contentcalender.model.Content;
import dev.bijansaudcontentcalender.contentcalender.model.Status;
import dev.bijansaudcontentcalender.contentcalender.model.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


// PROGRAMITACALLY INSERT  SOME DATA TO THE DATABASE
//    @Bean
//    CommandLineRunner commandLineRunner(ContentRepository repository){
//        return args -> {
//            // insert all the data in this place to the database
//            Content content = new Content(null,
//                    "today is the day",
//                    "All about my day",
//                    Status.IDEA,
//                    Type.VIDEO,
//                    LocalDateTime.now(),
//                    null,
//                    "");
//            repository.save(content);
//        };

   // }

}
// --- to define a bean on a class

//
//@SpringBootApplication
//public class Application {
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        // this gives all the beans that are running by the spring while running in the application;
//        //with our application in this as well
//        RestTemplate restTemplate =(RestTemplate) context.getBean("restTemplate");
//        System.out.println(restTemplate);
//    }
//
//    // you can write more code
//
//}


// This the way to pring out all the beans that the spring is taking
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        // this gives all the beans that are running by the spring while running in the application;
//        //with our application in this as well
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//    }

