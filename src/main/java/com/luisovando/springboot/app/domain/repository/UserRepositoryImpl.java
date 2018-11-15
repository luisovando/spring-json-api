package com.luisovando.springboot.app.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.luisovando.springboot.app.domain.model.User;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

@Component
public class UserRepositoryImpl extends ResourceRepositoryBase<User, Long> {

	private Map<Long, User> users = new HashMap<>();

	protected UserRepositoryImpl() {
		super(User.class);
		User userTest = new User("Luis", "A.", "luis@example.com");
		users.put(1L, userTest);
	}

	@Override
	public synchronized ResourceList<User> findAll(QuerySpec querySpec) {
		return querySpec.apply(users.values());
	}
}
