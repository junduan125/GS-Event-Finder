import React from 'react';
import {graphql} from 'react-relay';
import {
  RelayEnvironmentProvider,
  loadQuery,
  usePreloadedQuery,
} from 'react-relay/hooks';
import RelayEnvironment from '../RelayEnvironment';

const { Suspense } = React;

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
		<RelayEnvironmentProvider environment={RelayEnvironment}>
			<React.Suspense fallback={'Loading...'}>
			<div />
		</React.Suspense>
		</RelayEnvironmentProvider>
	);
}

export default Profile