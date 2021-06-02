import React from 'react';
import Container from '../components/container/Container';
import EventList from '../components/event_list/EventList';
import { NAV_LINKS } from '../components/header_banner/HeaderBanner';


function Events(props) {
	return (
		<Container {...props} currentNav={NAV_LINKS.EVENTS} >
			<EventList />
		</Container>
	);
}

export default Events;