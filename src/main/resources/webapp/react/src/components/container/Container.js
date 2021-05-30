import React from 'react';
import { RelayEnvironmentProvider } from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import HeaderBanner from '../header_banner/HeaderBanner';
import Footer from '../footer/Footer';
import './Container.css';

const { Suspense } = React;

function Container(props) {
	return (
		<RelayEnvironmentProvider environment={RelayEnvironment}>
			<Suspense fallback={'Loading...'}>
				<div>
					<HeaderBanner currentNav={props.currentNav} />
					<video className="background_video" autoPlay="autoplay" muted loop >
						<source src="/assets/genshin_background_vid.mp4" type="video/mp4" />
					</video>
					<div className="container_content">
						{props.children}
					</div>
					<Footer />
				</div>
			</Suspense>
		</RelayEnvironmentProvider>
	);
}

export default Container