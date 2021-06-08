import React from 'react';
import { graphql } from 'react-relay';
import { useFragment } from 'react-relay/hooks';
import EventItemProfile from '../event_item_profile/EventItemProfile';
import './EventItemProfileList.css';

const eventItemProfileListFragment = graphql`
	fragment EventItemProfileList_event on GSEventUser
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

function EventItemProfileList({eventItemProfileQueryRef}) {
	const eventItemProfiles = useFragment(eventItemProfileListFragment, eventItemProfileQueryRef);
	return (
		<div className="event_item_profile_list_container">
		{
			eventItemProfiles.map( (eventItemProfile, index) => 
				<EventItemProfile key={index} eventItemProfile={eventItemProfile} />
			)
		}
		</div>
	);
}

export default EventItemProfileList;