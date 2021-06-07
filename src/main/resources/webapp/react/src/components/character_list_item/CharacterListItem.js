import React from 'react';
import './CharacterListItem.css';

const profilePicSrc = 'https://rerollcdn.com/GENSHIN/Characters/';

function CharacterListItem({character, onSelect = () => {}, isSelected = false, hasCharacter = true}) {
	let backgroundStyle;
	switch(character.stars) {
		case '5': backgroundStyle = 'character_list_item_gold ';
			break;
		default: backgroundStyle = 'character_list_item_purple ';
	}
	const selectedStyle = isSelected ? 'character_list_item_selected ' : 'character_list_item_unselected ';
	return (
		<div key={character.id} className={"character_list_item " + backgroundStyle + selectedStyle} onClick={() => onSelect(character.id)}>
			<img src={profilePicSrc + character.name + '.png'} alt={character.name} />
			<div className="character_list_item_level_indicator">
				<strong><span>Lv. </span><span>{(character || {level: 0}).level }</span></strong>
			</div>
			{!hasCharacter && <div className="character_list_item_locked_overlay" />}
		</div>
	);
}

export default CharacterListItem;