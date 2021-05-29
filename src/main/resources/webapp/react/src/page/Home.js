import React from 'react';
import Container from '../components/container/Container';
import { NAV_LINKS } from '../components/header_banner/HeaderBanner';

function Home(props) {
	return (
		<Container {...props} currentNav={NAV_LINKS.HOME} >
			<div />
		</Container>
	);
}

export default Home