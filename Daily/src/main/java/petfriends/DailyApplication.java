package petfriends;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import petfriends.config.KafkaProcessor;


@SpringBootApplication
//@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class DailyApplication {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(DailyApplication.class, args);
    }
}