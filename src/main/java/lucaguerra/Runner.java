package lucaguerra;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import lucaguerra.security.AuthController;
import lucaguerra.user.UserRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	AuthController ac;

	@Autowired
	UserRepository ur;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));

//		String name = faker.name().firstName();
//		String surname = faker.name().lastName();
//		String username = name.toLowerCase() + "_" + surname.toLowerCase() + "@email.com";
//		String email = name.toLowerCase() + "." + surname.toLowerCase();
//		String password = "1234";
//		NewUserPayload user = new NewUserPayload(username, name, surname, email, password);
//		ac.saveUser(user);
//
	}
}
