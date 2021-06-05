import React from 'react';
import { useState } from 'react';
import { graphql } from 'react-relay';
import { useFragment } from 'react-relay/hooks';
import './EventItem.css';

const eventItemFragment = graphql`
	fragment EventItem_event on GSEvent {
		id
		eventType
		eventTime
	}
`


function EventItem({eventQueryRef}) {
	const event = useFragment(eventItemFragment, eventQueryRef);
	return (
		<div>
			<span>{event.eventType}</span>
			<span>{event.eventTime}</span>
		</div>
	);
}

export default EventItem;