import React from 'react';
import {graphql} from 'react-relay';
import { loadQuery } from 'react-relay/hooks';
import RelayEnvironment from '../RelayEnvironment';
import Container from '../components/container/Container';

const profileQuery = graphql`
	query ProfileQuery {
		profile {
			username
		}
	}
`;

const profileQueryRef = loadQuery(
  RelayEnvironment,
  profileQuery,{}
);

function Profile(props) {
	return (
		<Container {...props}>
		</Container>
	);
}

export default Profile