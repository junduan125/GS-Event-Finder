import React from 'react';
import { Link } from "react-router-dom";
import { useState, useEffect } from 'react';
import UserProfileBadge from '../user_profile_badge/UserProfileBadge';
import UserNavControls from '../user_nav_controls/UserNavControls';
import LoginForm from '../login/LoginForm';
import './HeaderBanner.css';

export const NAV_LINKS = {
	HOME: 'selected_nav_home',
	EVENTS: 'selected_nav_events',
}

async function fetchUserProfile() {
	const userProfileRequest = fetch('/profile', {
			method: 'GET',
			headers: { 
				'Content-Type': 'application/json',
        		'Accept': 'application/json'
        	},
		}).then( response => response.json());
	return userProfileRequest;
}

const hasProfile = (userProfile) => {
	return userProfile !== null && userProfile !== undefined && userProfile.username && userProfile.username !== "";
}

function HeaderBanner(props) {
	const [selectedNavClass, setSelectedNavClass] = useState(props.currentNav);
	const [showSignin, setShowSignin] = useState(false);
	const [userProfile, setUserProfile] = useState(null);

	useEffect(()=> {
		fetchUserProfile().then(data => setUserProfile(data));
	}, [setUserProfile]);

	const onSelectNavLink = (selected_link) => {
		setSelectedNavClass(selected_link);
	};

	return (
		<div className="header">
			<div className="header_logo">
				<img src="/assets/genshin_impact_logo_no_outline.png" alt="" width="173" height="66" />
			</div>
			<div className="header_nav">
				<div id="navSelector" className={'nav_selector ' + selectedNavClass} />
				<Link className="nav_link selected_nav_link" to="/" 
					onMouseEnter={() => onSelectNavLink(NAV_LINKS.HOME)}
					onMouseLeave={() => onSelectNavLink(props.currentNav)}>HOME</Link>
				<Link className="nav_link" to="/user/events" 
					onMouseEnter={() => onSelectNavLink(NAV_LINKS.EVENTS)}
					onMouseLeave={() => onSelectNavLink(props.currentNav)}>EVENTS</Link>
			</div>
			<div className="header_signin">
				{!hasProfile(userProfile) && <span onClick={() => setShowSignin(!showSignin)}>Sign in</span>}
				{hasProfile(userProfile) && <UserProfileBadge userProfile={userProfile} />}
			</div>
			{hasProfile(userProfile) && <UserNavControls userProfile={userProfile} />}
			{showSignin && <LoginForm {...props} onHide={() => {setShowSignin(false)}} />}
		</div>
	);
}

export default HeaderBanner;