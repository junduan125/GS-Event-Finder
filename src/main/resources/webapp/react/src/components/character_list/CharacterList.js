import React from 'react';
import CharacterListItem from '../character_list_item/CharacterListItem';
import './CharacterList.css';

function CharacterList({characters, selectedCharacter, userCharacters, onSelect}) {
	return (
		<div className="character_list_container">
			{characters.map( character => {
				const userCharacter = userCharacters.get(character.id);
				const userCharacterObject = {...userCharacter, ...character };
				const hasCharacter = userCharacters.has(character.id);
				return (
					<CharacterListItem
						key={character.id}
						hasCharacter={hasCharacter}
						isSelected={selectedCharacter === character.id}
						character={userCharacterObject}
						onSelect={onSelect} />
					)
				})
			}
		</div>
	);
}

export default CharacterList;