package br.com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.repository.UserRepository;
import br.com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> userFind = repo.findById(id);
		return userFind.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
