import React from 'react';
import CharacterListItem from '../../character_list_item/CharacterListItem';
import './EventItemProfile.css';

function EventItemProfile({eventItemProfile}) {
	const userProfile = eventItemProfile.user;
	const userCharacter = eventItemProfile.userCharacter;
	const userCharacterObject = {...userCharacter, hasCharacter: true}
	console.log('eventItemProfile', eventItemProfile);
	return (
		<div className="event_item_profile_container">
			<div className="event_item_profile_character">
				<CharacterListItem character={userCharacterObject} />
			</div>
			<div className="event_item_profile_user">
				<div><strong>{userProfile.uuid}</strong></div>
				<div>WL <i>{userProfile.worldLevel}</i></div>
			</div>
		</div>
	);
}

export default EventItemProfile;