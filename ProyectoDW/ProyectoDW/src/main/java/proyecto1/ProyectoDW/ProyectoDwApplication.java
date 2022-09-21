package proyecto1.ProyectoDW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto1.ProyectoDW.model.Book;
import proyecto1.ProyectoDW.repository.BookRepository;

@SpringBootApplication
public class ProyectoDwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwApplication.class, args);
	}



}
