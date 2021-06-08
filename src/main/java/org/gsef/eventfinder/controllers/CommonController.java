package org.gsef.eventfinder.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.gsef.eventfinder.jpa.model.GSCharacter;
import org.gsef.eventfinder.jpa.repo.GSCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	
	@Autowired
	GSCharacterRepo gsCharacterRepo;

	@ResponseBody
	@GetMapping(value = "/json/characters", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GSCharacter> getGSCharacters() {
		return StreamSupport.stream(gsCharacterRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
