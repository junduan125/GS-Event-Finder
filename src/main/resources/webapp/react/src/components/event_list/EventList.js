import React from 'react';
import { useState } from 'react';
import { graphql } from 'react-relay';
import { loadQuery, usePreloadedQuery } from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import EventItem from './EventItem';
import EventControls from './EventControls';
import './EventList.css';

const eventQuery = graphql`
	query EventListQuery {
		profile {
			events {
				...EventItem_event
			}
		}
	}
`;

const eventQueryRef = loadQuery(
  RelayEnvironment,
  eventQuery,{}
);

function EventList() {
	const eventProfile = usePreloadedQuery(eventQuery, eventQueryRef);
	const events = eventProfile.profile.events;

	return (
		<div className="event_list_container">
			<EventControls />
			{events.map( (event, index) => (
				<EventItem key={index} eventQueryRef={event} />
			))}
		</div>
	);
}

export default EventList;