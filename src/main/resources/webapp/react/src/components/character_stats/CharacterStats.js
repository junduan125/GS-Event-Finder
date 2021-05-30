import React from 'react';
import { useState } from 'react';
import LevelSelector from '../../widgets/level_selector/LevelSelector';
import './CharacterStats.css';


const profilePicSrc = '/assets/characters/';

function CharacterStats({characters, selectedCharacter}) {
	const selectedCharacterData = characters.find( character => character.id === selectedCharacter);
	const [selectedLevel, setSelectedLevel] = useState(0);

	return (
		<div class="character_container">
			{selectedCharacterData && <div className="character_portrait">
				<img src={profilePicSrc + selectedCharacterData.name + '.png'} />
			</div>}
			<div className="character_controls">
				<LevelSelector
					maxValue={90}
					label="Lv."
					selectedValue={selectedLevel}
					onChange={setSelectedLevel}
				 />
			</div>
		</div>
	)
}

export default CharacterStats;