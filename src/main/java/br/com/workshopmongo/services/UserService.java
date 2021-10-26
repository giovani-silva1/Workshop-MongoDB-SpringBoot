package br.com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.dto.UserDto;
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

	public User create(UserDto user) {
		User userCreate = dtoFromUser(user);
		return repo.insert(userCreate);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public void update(UserDto dto) {
		User userUpdate = repo.findById(dto.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		User userUpdateNow = updateUser(dto, userUpdate);
		repo.save(userUpdateNow);
	}

	public User updateUser(UserDto user, User userUpdate) {
		userUpdate.setName(user.getName());
		userUpdate.setEmail(user.getEmail());
		return userUpdate;
	}

	public User dtoFromUser(UserDto dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}

}
