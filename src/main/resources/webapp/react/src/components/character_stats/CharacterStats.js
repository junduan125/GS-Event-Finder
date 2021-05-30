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

function CharacterStats({characters, userCharacters, selectedCharacter}) {
	const selectedCharacterData = characters.find( character => character.id === selectedCharacter);
	const [level, setLevel] = useState(0);
	const userHasCharacter = (userCharacters || []).some( c => c.id === selectedCharacter);

	const onAddCharacter = () => {
		commitMutation(RelayEnvironment, {
			mutation: addCharacterMutation,
			variables: {characterType: selectedCharacter, level},
			onCompleted: response => {
				console.log('res', response);
			}
		});
	}

	return (
		<div class="character_container">
			{selectedCharacterData && <div className="character_portrait">
				<img src={profilePicSrc + selectedCharacterData.name + '.png'} alt="" />
			</div>}
			<div className="character_controls">
				{userHasCharacter ?
					<LevelSelector
						maxValue={90}
						label="Lv."
						selectedValue={level}
						onChange={setLevel}
				 	/> :
				 	<div onClick={onAddCharacter}>
				 		Add
				 	</div>
				}
			</div>
		</div>
	)
}

export default CharacterStats;