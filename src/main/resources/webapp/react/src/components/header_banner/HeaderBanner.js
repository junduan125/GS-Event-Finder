import React from 'react';
import {
  Link
} from "react-router-dom";
import {useState} from 'react';
import './HeaderBanner.css';

const NAV_LINKS = {
	HOME: 'selected_nav_home',
	PROFILE: 'selected_nav_profile',
	EVENTS: 'selected_nav_events',
}

function HeaderBanner() {
	const [selectedNavClass, setSelectedNavClass] = useState(NAV_LINKS.HOME);

	const onSelectNavLink = (selected_link) => {
		setSelectedNavClass(selected_link);
	};

	return (
		<div className="header">
			<div className="header_logo">
				<img src="assets/genshin_impact_logo_no_outline.png" width="173" height="66" />
			</div>
			<div className="header_nav">
				<div id="navSelector" className={'nav_selector ' + selectedNavClass} />
				<Link className="nav_link selected_nav_link" to="/" onMouseEnter={() => onSelectNavLink(NAV_LINKS.HOME)}>HOME</Link>
				<Link className="nav_link" to="/user/profile" onMouseEnter={() => onSelectNavLink(NAV_LINKS.PROFILE)}>PROFILE</Link>
				<Link className="nav_link" to="/user/events" onMouseEnter={() => onSelectNavLink(NAV_LINKS.EVENTS)}>EVENTS</Link>
			</div>
			<div className="header_signin">
				<Link to="/signin">Sign in</Link>
			</div>
		</div>
	);
}

export default HeaderBanner