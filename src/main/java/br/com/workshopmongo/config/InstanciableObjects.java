package br.com.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.dto.AuthorDto;
import br.com.workshopmongo.repository.PostRepository;
import br.com.workshopmongo.repository.UserRepository;

@Configuration
public class InstanciableObjects implements CommandLineRunner {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PostRepository post;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		repo.deleteAll();
		post.deleteAll();

		User user1 = new User(null, "Cristiano", "cris@gmail.com");
		User user2 = new User(null, "Patricia", "patricia@gmail.com");
		User user3 = new User(null, "Magda", "Magda@gmail.com");

		repo.saveAll(Arrays.asList(user1, user2, user3));

		Post post1 = new Post(null, sdf1.parse("21/09/1992"), "Viagem para o RJ", "Foi bom demais ver meu amigo",
				new AuthorDto(user1));
		Post post2 = new Post(null, sdf1.parse("21/09/1992"), "Viagem para o SC",
				"Estava muito frio porem foi maravilhoso meu FND", new AuthorDto(user1));

		post.saveAll(Arrays.asList(post1, post2));
	}
}
