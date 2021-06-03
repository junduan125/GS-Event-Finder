import React from 'react';
import { useState } from 'react';
import NewEventForm from './NewEventForm';
import GSToggleButton from '../../widgets/gs_toggle_button/GSToggleButton';
import './EventControls.css';

function EventControls() {
	const [showCreateEvent, setShowCreateEvent] = useState(false);
	const [filterAsdf, setFilterAsdf] = useState(false);
	return (
		<div className="event_controls_container">
			<div>
				<GSToggleButton label="asdf"
					selectedValue={filterAsdf}
					onSelect={setFilterAsdf} />
			</div>
			<div>
			</div>
			{showCreateEvent && <NewEventForm />}
		</div>
	);
}

export default EventControls;