package xxx.petmanbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaAuditing
@SpringBootApplication
public class PetManBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetManBeApplication.class, args);
    }

}
