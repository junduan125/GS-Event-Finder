import React from 'react';
import { useState } from 'react';
import './CharacterList.css';

const profilePicSrc = 'https://rerollcdn.com/GENSHIN/Characters/';

function CharacterList({characters, selectedCharacter, onSelect}) {
	return (
		<div className="list_container">
			{
				characters.map( character => {
					let backgroundStyle;
					switch(character.stars) {
						case '5': backgroundStyle = 'gold_item ';
							break;
						default: backgroundStyle = 'purple_item ';
					}
					let selectedStyle = selectedCharacter === character.id ? 'selected_item ' : 'unselected_item ';
					return (
						<div key={character.id} className={"list_item " + backgroundStyle + selectedStyle} onClick={() => onSelect(character.id)}>
							<img src={profilePicSrc + character.name + '.png'} alt={character.name} />
							<div className="level_indicator">
								<strong><span>Lv. </span><span></span></strong>
							</div>
							{<div className="locked_overlay" />}
						</div>
					)}
				)
			}
		</div>
	);
}

export default CharacterList;