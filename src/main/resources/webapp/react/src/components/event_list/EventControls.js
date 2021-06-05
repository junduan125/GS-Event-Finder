import React from 'react';
import { useState } from 'react';
import NewEventForm from './NewEventForm';
import GSToggleButton from '../../widgets/gs_toggle_button/GSToggleButton';
import GSDropdown from '../../widgets/gs_dropdown/GSDropdown';
import './EventControls.css';

const eventTypes = [
	{value: 1, label: "Social"},
	{value: 2, label: "Mining"},
	{value: 3, label: "Mob Hunting"},
];

function EventControls() {
	const [showCreateEvent, setShowCreateEvent] = useState(false);
	const [filterAsdf, setFilterAsdf] = useState(false);
	const [filterEventType, setFilterEventType] = useState(null);

	return (
		<div className="event_controls_container">
			<div className="event_controls_filters">
				<GSToggleButton label="Show Full"
					selectedValue={filterAsdf}
					onSelect={setFilterAsdf} />
				<GSDropdown
					selectedValue={filterEventType}
	    			onSelect={setFilterEventType}
					values={eventTypes} />
			</div>
			<div>
				<button className="event_controls_button"
					onClick={() => setShowCreateEvent(!showCreateEvent)}>Create Event</button>
			</div>
			{showCreateEvent && <NewEventForm />}
		</div>
	);
}

export default EventControls;