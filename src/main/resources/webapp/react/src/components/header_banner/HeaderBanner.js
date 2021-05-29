import React from 'react';
import { Link } from "react-router-dom";
import {useState} from 'react';
import LoginForm from '../login/LoginForm'
import './HeaderBanner.css';

export const NAV_LINKS = {
	HOME: 'selected_nav_home',
	PROFILE: 'selected_nav_profile',
	EVENTS: 'selected_nav_events',
}

function HeaderBanner(props) {
	const [selectedNavClass, setSelectedNavClass] = useState(props.currentNav);
	const [showSignin, setShowSignin] = useState(false);

	const onSelectNavLink = (selected_link) => {
		setSelectedNavClass(selected_link);
	};

	return (
		<div className="header">
			<div className="header_logo">
				<img src="/assets/genshin_impact_logo_no_outline.png" width="173" height="66" />
			</div>
			<div className="header_nav">
				<div id="navSelector" className={'nav_selector ' + selectedNavClass} />
				<Link className="nav_link selected_nav_link" to="/" 
					onMouseEnter={() => onSelectNavLink(NAV_LINKS.HOME)}
					onMouseLeave={() => onSelectNavLink(props.currentNav)}>HOME</Link>
				<Link className="nav_link" to="/user/profile" 
					onMouseEnter={() => onSelectNavLink(NAV_LINKS.PROFILE)}
					onMouseLeave={() => onSelectNavLink(props.currentNav)}>PROFILE</Link>
				<Link className="nav_link" to="/user/events" 
					onMouseEnter={() => onSelectNavLink(NAV_LINKS.EVENTS)}
					onMouseLeave={() => onSelectNavLink(props.currentNav)}>EVENTS</Link>
			</div>
			<div className="header_signin">
				<span to="/signin" onClick={() => setShowSignin(!showSignin)}>Sign in</span>
			</div>
			{showSignin && <LoginForm {...props} onHide={() => {setShowSignin(false)}} />}
		</div>
	);
}

export default HeaderBanner