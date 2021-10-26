package br.com.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

	
}
