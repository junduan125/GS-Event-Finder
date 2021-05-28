import React from 'react';
import HeaderBanner from '../header_banner/HeaderBanner';
import Footer from '../footer/Footer';
import './Container.css';

function Container(props) {
	return (
		<div>
			<HeaderBanner />
			<video className="background_video" autoplay="autoplay" muted loop >
				<source src="assets/genshin_background_vid.mp4" type="video/mp4" />
			</video>
			<div>
				{props.children}
			</div>
			<Footer />
		</div>
	);
}

export default Container