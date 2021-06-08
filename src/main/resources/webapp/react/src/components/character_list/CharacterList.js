import React from 'react';
import CharacterListItem from '../character_list_item/CharacterListItem';
import './CharacterList.css';

function CharacterList({characters, selectedCharacter, userCharacters, onSelect}) {
	return (
		<div className="character_list_container">
			{characters.map( character => {
				let userCharacterObject;
				if (userCharacters.has(character.id)) {
					const userCharacter = userCharacters.get(character.id);
					userCharacterObject = {...userCharacter, hasCharacter: true};
				} else {
					userCharacterObject = {
						level: 0,
						hasCharacter: false,
						characterID: character.id,
						character
					};
				}
				return (
					<CharacterListItem
						key={character.id}
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