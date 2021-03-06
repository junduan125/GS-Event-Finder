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
			user {
				username
			}
			characters {
				level
				characterID
				character {
					name
					stars
					elementType
				}
			}
		}
	}
`;

const characterQueryRef = loadQuery(
  RelayEnvironment,
  characterEditorQuery,{}
);

export async function fetchCharacterList() {
	const data = await fetch('/json/characters', {
		headers: {
			'Content-Type': 'application/json',
      'Accept': 'application/json'
		}
	}).then(response => response.json());

	return data;
}

function CharacterEditor() {
	const userProfile = usePreloadedQuery(characterEditorQuery, characterQueryRef);
	const userChars = (userProfile.profile.characters || [])
						.reduce( (map, char) => map.set(char.characterID, char), new Map());

	const [characters, setCharacters] = useState([]);
	const [selectedCharacter, setSelectedCharacter] = useState(-1);
	const [userCharacters, setUserCharacters] = useState(userChars);


	useEffect(()=> {
		fetchCharacterList()
			.then(data => {
				setCharacters(data);
			})
	}, [setCharacters]);

	return (
		<div>
			<div className="haracter_editor_name_header">
				<h2>Character Editor</h2>
			</div>
			<div className="character_editor_content">
				<CharacterList
					characters={characters}
					selectedCharacter={selectedCharacter}
					userCharacters={userCharacters}
					onSelect={setSelectedCharacter} />
				{selectedCharacter >= 0 &&
				<CharacterStats
					characters={characters}
					userCharacters={userCharacters}
					updateUserCharacters={setUserCharacters}
					selectedCharacter={selectedCharacter} />}
			</div>
		</div>
	)
}

export default CharacterEditor;