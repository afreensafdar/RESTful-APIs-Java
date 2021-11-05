import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*To run our Spring Boot application, the main class.
This class will start embedded Tomcat server hosting our Spring Boot web application. */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.product.ProductApplication"})
@EnableAutoConfiguration

public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}

