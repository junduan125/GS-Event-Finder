package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	UserService userService;
	
	public Integer noop() {
		return 0;
	}
}
