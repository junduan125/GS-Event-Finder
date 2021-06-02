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

const removeCharacterMutation = graphql`
	mutation CharacterStatsRemoveMutation($characterType: Int!) {
		removeUserCharacter(characterType: $characterType) {
			characterTypeID
			level
		}
	}
`

const editCharacterMutation = graphql`
	mutation CharacterStatsEditMutation($characterType: Int!, $level: Int) {
		editUserCharacter(characterType: $characterType, level: $level) {
			characterTypeID
			level
		}
	}
`

function CharacterStats({characters, userCharacters, selectedCharacter, updateUserCharacters}) {
	const selectedCharacterData = characters.find( character => character.id === selectedCharacter);
	const [loading, setLoading] = useState(false);

	const onAddCharacter = () => {
		const level = 0;
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

	const onRemoveCharacter = () => {
		commitMutation(RelayEnvironment, {
			mutation: removeCharacterMutation,
			variables: {characterType: selectedCharacter},
			onCompleted: response => {
				const userChars = (response.removeUserCharacter || [])
						.reduce( (map, char) => map.set(char.characterTypeID, char), new Map());
				updateUserCharacters(userChars);
			}
		});
	}

	const onEditCharacter = (level) => {
		setLoading(true);
		commitMutation(RelayEnvironment, {
			mutation: editCharacterMutation,
			variables: {characterType: selectedCharacter, level},
			onCompleted: response => {
				const character = response.editUserCharacter;
				userCharacters.set(character.characterTypeID, character);
				updateUserCharacters(new Map(userCharacters));
				setLoading(false);
			}
		});
	}

	return (
		<div className="character_stats_container">
			{selectedCharacterData && <div className="character_stats_portrait">
				<img src={profilePicSrc + selectedCharacterData.name + '.png'} alt="" />
			</div>}
			<div className="character_stats_controls">
				{userCharacters.has(selectedCharacter) ?
					<div>
						<LevelSelector
							maxValue={90}
							label="Lv."
							loading={loading}
							selectedValue={userCharacters.get(selectedCharacter).level}
							onChange={(value) => {
								onEditCharacter(value);
							}}
					 	/>
					 	<button className="character_stats_remove_button" type="button"
					 		onClick={onRemoveCharacter} />
				 	</div> :
				 	<button type="button" className="character_stats_add_button"
				 		onClick={onAddCharacter} >
				 		I own this
				 	</button>
				}
			</div>
		</div>
	)
}

export default CharacterStats;