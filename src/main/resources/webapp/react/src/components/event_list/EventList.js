import React from 'react';
import { useState } from 'react';
import { graphql } from 'react-relay';
import { loadQuery, usePreloadedQuery, usePaginationFragment } from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import EventItem from './event_item/EventItem';
import EventControls from './event_controls/EventControls';
import './EventList.css';

const eventQuery = graphql`
	query EventListQuery($count: Int, $cursor: Int) {
		profile {
			id
			...EventList_events
		}
	}
`;

const eventFragment = graphql`
	fragment EventList_events on GSProfile
	@refetchable(queryName: "EventListQueryPagination") {
			events(first: $count, after: $cursor)
			@connection(key: "EventList_profile_events") {
				edges {
					node {
						...EventItem_event
					}
				}
			}
	}
`;

const eventQueryRef = loadQuery(
  RelayEnvironment,
  eventQuery,
  { count: 3, cursor: 0 }
);

function EventList() {
	const eventProfile = usePreloadedQuery(eventQuery, eventQueryRef);
	const {data, loadNext} = usePaginationFragment(
		eventFragment, eventProfile.profile
	);
	const events = data.events.edges;

	return (
		<div className="event_list_container">
			<EventControls />
			<div className="event_list_item_container">
				{events.map( (event, index) => (
					<EventItem key={index} eventQueryRef={event.node} />
				))}
			</div>
		</div>
	);
}

export default EventList;