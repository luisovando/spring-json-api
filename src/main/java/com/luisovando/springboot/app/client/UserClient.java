package com.luisovando.springboot.app.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.luisovando.springboot.app.domain.model.User;

import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;

public class UserClient {
	
	@Value("${katharsis.domainName}")
	private String DOMAIN_NAME;
	
	@Value("${katharsis.pathPrefix}")
	private String PATH_PREFIX;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserClient.class);
	
	private KatharsisClient kClient = new KatharsisClient(this.DOMAIN_NAME + this.PATH_PREFIX);
	
	private ResourceRepositoryV2<User, Long> userRepository;
	
	@PostConstruct
	public void init() {
		this.userRepository = kClient.getRepositoryForType(User.class);
	}
	
	public User findOne(long userId) {
		User user = userRepository.findOne(userId, new QuerySpec(User.class));
		
		LOGGER.info("found {}", user.toString());
		
		return user;
	}
}
