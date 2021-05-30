import React from 'react';
import './CharacterStats.css';


const profilePicSrc = '/assets/characters/';

function CharacterStats({characters, selectedCharacter}) {
	const selectedCharacterData = characters.find( character => character.id === selectedCharacter);

	return (
		<div class="character_container">
			{selectedCharacterData && <div className="character_portrait">
				<img src={profilePicSrc + selectedCharacterData.name + '.png'} />
			</div>}
			<div className="character_controls">
			</div>
		</div>
	)
}

export default CharacterStats;