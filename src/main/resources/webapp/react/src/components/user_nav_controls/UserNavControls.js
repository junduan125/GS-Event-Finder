import React from 'react';
import { useState } from 'react';
import { Link } from "react-router-dom";
import './UserNavControls.css';

const SELECTED_LINKS = {
	NONE: 'NONE',
	PROFILE: 'PROFILE',
	LOGOUT: 'LOGOUT',
}

function UserNavControls({userProfile}) {
	if (userProfile === null || userProfile === undefined) return (<div />);
	const [hoveredButton, setHoveredButton] = useState(SELECTED_LINKS.NONE);

	const handleLogout = (event) => {
		event.preventDefault();
		fetch('/logout', { method: 'POST'}).then( response => {
			if (response.status === 200) {
				window.location.reload();
			}
		}).then(() => {
			window.location.replace("/");
		}).catch(() => {
			window.location.replace("/");
		});
	}

	return (
		<div className="user_nav_controls_container">
			<div className="user_nav_controls_button_container">
				<div className="user_nav_controls_button">
					<Link to="/user/profile">
						<button
							onMouseEnter={() => setHoveredButton(SELECTED_LINKS.PROFILE)}
							onMouseLeave={() => setHoveredButton(SELECTED_LINKS.NONE)}>
							<img src="/assets/icons/logout-icon.svg" alt="" />
						</button>
					</Link>
					{ hoveredButton === SELECTED_LINKS.PROFILE && 
						<div className="user_nav_controls_prompt_overlay">
							Characters
						</div>
					}
				</div>
			</div>
			<div className="user_nav_controls_logout_container">
				<button
					onClick={handleLogout}
					onMouseEnter={() => setHoveredButton(SELECTED_LINKS.LOGOUT)}
					onMouseLeave={() => setHoveredButton(SELECTED_LINKS.NONE)}>
					<img src="/assets/icons/logout-icon.svg" alt="" />
				</button>
				{ hoveredButton === SELECTED_LINKS.LOGOUT && 
					<div className="user_nav_controls_prompt_overlay">
						Logout
					</div>
				}
			</div>
		</div>
	);
}

export default UserNavControls;