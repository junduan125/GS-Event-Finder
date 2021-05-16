package org.gsef.eventfinder.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver  {

	public GSUser getProfile() {
		return null;
	}
	
	public List<UserCharacter> getCharacters() {
		return new ArrayList<>();
	}
	
	public List<GSEvent> getEvents() {
		return new ArrayList<>();
	}
}
