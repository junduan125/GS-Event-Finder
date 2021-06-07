import React from 'react';
import { useState } from 'react';
import { graphql } from 'react-relay';
import { useFragment } from 'react-relay/hooks';
import EventItemProfile from '../event_item_profile/EventItemProfile';
import './EventItem.css';

const eventItemFragment = graphql`
	fragment EventItem_event on GSEvent {
		id
		eventType
		eventTime
		joinedUsers {
			...EventItemProfile_event
		}
	}
`


function EventItem({eventQueryRef}) {
	const event = useFragment(eventItemFragment, eventQueryRef);
	return (
		<div className="event_item_container">
			<EventItemProfile eventItemProfileQueryRef={event.joinedUsers} />
			<span>{event.eventType}</span>
			<span>{event.eventTime}</span>
		</div>
	);
}

export default EventItem;