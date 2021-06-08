import React from 'react';
import './CharacterListItem.css';

const profilePicSrc = 'https://rerollcdn.com/GENSHIN/Characters/';

function CharacterListItem({
		character,
		onSelect = () => {},
		isSelected = false
	}) {
	let backgroundStyle;
	switch(character.character.stars) {
		case '5': backgroundStyle = 'character_list_item_gold ';
			break;
		default: backgroundStyle = 'character_list_item_purple ';
	}
	const selectedStyle = isSelected ? 'character_list_item_selected ' : 'character_list_item_unselected ';
	return (
		<div key={character.characterID} 
				className={"character_list_item " + backgroundStyle + selectedStyle}
				onClick={() => onSelect(character.characterID)}>
			<img src={profilePicSrc + character.character.name + '.png'} alt={character.character.name} />
			<div className="character_list_item_level_indicator">
				<strong><span>Lv. </span><span>{(character.character || {level: 0}).level }</span></strong>
			</div>
			{!character.hasCharacter && <div className="character_list_item_locked_overlay" />}
		</div>
	);
}

export default CharacterListItem;