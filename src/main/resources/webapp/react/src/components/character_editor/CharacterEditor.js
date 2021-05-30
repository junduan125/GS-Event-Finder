import React from 'react';
import { useState, useEffect } from 'react';
import { graphql, commitMutation } from 'react-relay';
import { loadQuery } from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import CharacterList from '../character_list/CharacterList';
import CharacterStats from '../character_stats/CharacterStats';
import './CharacterEditor.css';

const addCharacterMutation = graphql`
	mutation CharacterEditorAddMutation($characterType: Int!, $level: Int) {
		addUserCharacter(characterType: $characterType, level: $level) {
			username
		}
	}
`

const characterEditorFragment = graphql`
	fragment CharacterEditor_characters on Query {
		characters {
			characterTypeID
			level
		}
	}
`

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
			<div className="content">
				<CharacterList
					characters={characters}
					selectedCharacter={selectedCharacter}
					onSelect={setSelectedCharacter} />
				<CharacterStats
					characters={characters}
					selectedCharacter={selectedCharacter} />
			</div>
		</div>
	)
}

export default CharacterEditor;