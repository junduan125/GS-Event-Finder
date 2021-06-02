import React from 'react';
import './CharacterList.css';

const profilePicSrc = 'https://rerollcdn.com/GENSHIN/Characters/';

function CharacterList({characters, selectedCharacter, userCharacters, onSelect}) {
	return (
		<div className="character_list_container">
			{
				characters.map( character => {
					let backgroundStyle;
					switch(character.stars) {
						case '5': backgroundStyle = 'character_list_gold_item ';
							break;
						default: backgroundStyle = 'character_list_purple_item ';
					}
					const selectedStyle = selectedCharacter === character.id ? 'character_list_selected_item ' : 'character_list_unselected_item ';
					return (
						<div key={character.id} className={"character_list_item " + backgroundStyle + selectedStyle} onClick={() => onSelect(character.id)}>
							<img src={profilePicSrc + character.name + '.png'} alt={character.name} />
							<div className="character_list_level_indicator">
								<strong><span>Lv. </span><span>{(userCharacters.get(character.id) || {level: 0}).level }</span></strong>
							</div>
							{!userCharacters.has(character.id) && <div className="character_list_locked_overlay" />}
						</div>
					)}
				)
			}
		</div>
	);
}

export default CharacterList;