import React from 'react';
import {
  RelayEnvironmentProvider,
  loadQuery,
  usePreloadedQuery,
} from 'react-relay/hooks';
import RelayEnvironment from '../../RelayEnvironment';
import HeaderBanner from '../header_banner/HeaderBanner';
import Footer from '../footer/Footer';
import './Container.css';

const { Suspense } = React;

function Container(props) {
	return (
		<RelayEnvironmentProvider environment={RelayEnvironment}>
			<React.Suspense fallback={'Loading...'}>
				<div>
					<HeaderBanner />
					<video className="background_video" autoplay="autoplay" muted loop >
						<source src="/assets/genshin_background_vid.mp4" type="video/mp4" />
					</video>
					<div>
						{props.children}
					</div>
					<Footer />
				</div>
			</React.Suspense>
		</RelayEnvironmentProvider>
	);
}

export default Container