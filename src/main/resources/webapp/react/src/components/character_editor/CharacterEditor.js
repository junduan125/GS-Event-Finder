import React from 'react';
import { useState, useEffect } from 'react';
import { graphql } from 'react-relay';
import { loadQuery, usePreloadedQuery } from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import CharacterList from '../character_list/CharacterList';
import CharacterStats from '../character_stats/CharacterStats';
import './CharacterEditor.css';

const characterEditorQuery = graphql`
	query CharacterEditorQuery {
		profile {
			username
		}
		characters {
			characterTypeID
			level
		}
	}
`;

const loadedQuery = loadQuery(
  RelayEnvironment,
  characterEditorQuery,{}
);

async function fetchCharacterList() {
	const data = await fetch('/json/characters.json', {
		headers: {
			'Content-Type': 'application/json',
        	'Accept': 'application/json'
		}
	}).then(response => response.json());

	return data;
}

function CharacterEditor() {
	const [characters, setCharacters] = useState([]);
	const [selectedCharacter, setSelectedCharacter] = useState(0);

	const userProfile = usePreloadedQuery(characterEditorQuery, loadedQuery);
	console.log(userProfile.characters);

	useEffect(()=> {
		fetchCharacterList()
			.then(data => {
				console.log(data);
				setCharacters(data.characters);
			})
	}, [setCharacters]);

	return (
		<div>
			<div className="name_header">
				<h2>Character Editor</h2>
			</div>
			<div className="character_editor_content">
				<CharacterList
					characters={characters}
					selectedCharacter={selectedCharacter}
					userCharacters={userProfile.characters}
					onSelect={setSelectedCharacter} />
				<CharacterStats
					characters={characters}
					userCharacters={userProfile.characters}
					selectedCharacter={selectedCharacter} />
			</div>
		</div>
	)
}

export default CharacterEditor;