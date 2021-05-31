import React from 'react';
import {graphql} from 'react-relay';
import { loadQuery } from 'react-relay/hooks';
import RelayEnvironment from '../RelayEnvironment';
import Container from '../components/container/Container';
import { NAV_LINKS } from '../components/header_banner/HeaderBanner';

const eventQuery = graphql`
	query EventsQuery {
		profile {
			user {
				username
			}
			events {
				eventTime
				eventType
			}
		}
	}
`;

const profileQueryRef = loadQuery(
  RelayEnvironment,
  eventQuery,{}
);


function Events(props) {
	return (
		<Container {...props} currentNav={NAV_LINKS.EVENTS} >
			<div />
		</Container>
	);
}

export default Events