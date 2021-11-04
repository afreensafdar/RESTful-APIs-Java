import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*To run our Spring Boot application, the main class.
This class will start embedded Tomcat server hosting our Spring Boot web application. */
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
//The tomcat server listens on port 8080 by default.
