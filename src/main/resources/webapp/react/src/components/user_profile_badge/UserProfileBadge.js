import React from 'react';
import './UserProfileBadge.css';

function UserProfileBadge({userProfile}) {
	if (userProfile == null) return (<div />);

	return (
		<div>
			<div className="user_profile_badge_container">
				<div>{userProfile.username}</div>
				<div className="user_profile_badge_uuid">
					<span className="user_profile_badge_uuid_prompt">UID: </span>
					<span><strong>{userProfile.uuid}</strong></span>
				</div>
			</div>
		</div>
	);
}

export default UserProfileBadge;