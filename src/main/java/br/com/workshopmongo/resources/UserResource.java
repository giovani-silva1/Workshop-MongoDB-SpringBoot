package br.com.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User(1,"Maria Silva","maria@gmai.com");
		User joao = new User(2,"Joao","joao@gmai.com");
		List<User> findUsers = Arrays.asList(maria,joao);
		return ResponseEntity.ok().body(findUsers);
	}
	
}
