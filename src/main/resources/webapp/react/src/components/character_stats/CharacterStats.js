import React from 'react';
import { useState } from 'react';
import { graphql, commitMutation } from 'react-relay';
import RelayEnvironment from '../../RelayEnvironment';
import LevelSelector from '../../widgets/level_selector/LevelSelector';
import './CharacterStats.css';

const profilePicSrc = '/assets/characters/';

const addCharacterMutation = graphql`
	mutation CharacterStatsAddMutation($characterType: Int!, $level: Int) {
		addUserCharacter(characterType: $characterType, level: $level) {
			characterTypeID
			level
		}
	}
`

function CharacterStats({characters, userCharacters, selectedCharacter, updateUserCharacters}) {
	const selectedCharacterData = characters.find( character => character.id === selectedCharacter);
	const [level, setLevel] = useState(0);

	const onAddCharacter = () => {
		commitMutation(RelayEnvironment, {
			mutation: addCharacterMutation,
			variables: {characterType: selectedCharacter, level},
			onCompleted: response => {
				const userChars = (response.addUserCharacter || [])
						.reduce( (map, char) => map.set(char.characterTypeID, char), new Map());
				updateUserCharacters(userChars);
			}
		});
	}

	return (
		<div class="character_container">
			{selectedCharacterData && <div className="character_portrait">
				<img src={profilePicSrc + selectedCharacterData.name + '.png'} alt="" />
			</div>}
			<div className="character_controls">
				{userCharacters.has(selectedCharacter) ?
					<LevelSelector
						maxValue={90}
						label="Lv."
						selectedValue={level}
						onChange={setLevel}
				 	/> :
				 	<button onClick={onAddCharacter} type="button" className="charcter_stats_button">
				 		I own this
				 	</button>
				}
			</div>
		</div>
	)
}

export default CharacterStats;