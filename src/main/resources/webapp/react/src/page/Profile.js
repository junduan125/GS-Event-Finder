import React from 'react';
import Container from '../components/container/Container';
import { NAV_LINKS } from '../components/header_banner/HeaderBanner';
import CharacterEditor from '../components/character_editor/CharacterEditor';

function Profile(props) {
	return (
		<Container {...props} currentNav={NAV_LINKS.PROFILE} >
			<CharacterEditor />
		</Container>
	);
}

export default Profile