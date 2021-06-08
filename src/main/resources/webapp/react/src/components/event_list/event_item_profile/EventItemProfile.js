import React from 'react';
import { graphql } from 'react-relay';
import { useFragment } from 'react-relay/hooks';
import CharacterListItem from '../../character_list_item/CharacterListItem';
import './EventItemProfile.js';

const eventItemProfileFragment = graphql`
	fragment EventItemProfile_event on GSEventUser
	@relay(plural: true) {
		userCharacter {
			level
			characterID
			character {
				name
				stars
				elementType
			}
		}
		user {
			username
			uuid
			worldLevel
		}
	}
`

function EventItemProfile({eventItemProfileQueryRef}) {
	const eventItemProfile = useFragment(eventItemProfileFragment, eventItemProfileQueryRef);
	return (
		<div>
		</div>
	);
}

export default EventItemProfile;