import React from 'react';
import { useState } from 'react';
import { graphql } from 'react-relay';
import { useFragment } from 'react-relay/hooks';
import EventItemProfileList from '../event_item_profile_list/EventItemProfileList';
import GSButton from '../../../widgets/gs_button/GSButton';
import './EventItem.css';

const eventItemFragment = graphql`
	fragment EventItem_event on GSEvent {
		id
		eventType
		eventTime
		joinedUsers {
			...EventItemProfileList_event
		}
	}
`


function EventItem({eventQueryRef}) {
	const event = useFragment(eventItemFragment, eventQueryRef);
	const dateTime = new Date(event.eventTime * 1000);
	return (
		<div className="event_item_container">
			<EventItemProfileList eventItemProfileQueryRef={event.joinedUsers} />
			<div className="event_item_info">
				<div>
					<span>{Intl.DateTimeFormat('en-US', 
						{ 
						  month: 'short',
						  year: 'numeric',
						  day: 'numeric',
						  hour: 'numeric',
						  minute: 'numeric',
						}).format(dateTime)}</span>
				</div>
				<div>
					<span>{event.joinedUsers.length}/4</span>
				</div>
				<GSButton
	    			className="event_item_join_button"
					label="Request to Join"
	    			onClick={() => {}} />
			</div>
		</div>
	);
}

export default EventItem;