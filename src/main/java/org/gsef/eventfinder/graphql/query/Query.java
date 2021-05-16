package org.gsef.eventfinder.graphql.query;

import org.gsef.eventfinder.jpa.model.GSUser;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver  {

	public GSUser getProfile() {
		return null;
	}
}
