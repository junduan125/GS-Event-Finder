import React from 'react';
import { graphql } from 'react-relay';
import { loadQuery } from 'react-relay/hooks';
import RelayEnvironment from '../RelayEnvironment';
import Container from '../components/container/Container';
import { NAV_LINKS } from '../components/header_banner/HeaderBanner';
import CharacterEditor from '../components/character_editor/CharacterEditor';

const profileQuery = graphql`
	query ProfileQuery {
		profile {
			username
		}
		...CharacterEditor_characters
	}
`;

const profileQueryRef = loadQuery(
  RelayEnvironment,
  profileQuery,{}
);

function Profile(props) {
	return (
		<Container {...props} currentNav={NAV_LINKS.PROFILE} >
			<CharacterEditor charactersRef={profileQueryRef} />
		</Container>
	);
}

export default Profile