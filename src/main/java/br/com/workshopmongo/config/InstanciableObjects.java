package br.com.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.repository.UserRepository;

@Configuration
public class InstanciableObjects implements CommandLineRunner {

	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();

		User user1 = new User(null, "Cristiano", "cris@gmail.com");
		User user2 = new User(null, "Patricia", "patricia@gmail.com");
		User user3 = new User(null, "Magda", "Magda@gmail.com");
		repo.saveAll(Arrays.asList(user1, user2, user3));
	}
}
