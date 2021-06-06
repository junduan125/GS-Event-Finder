import React from 'react';
import { useState } from 'react';
import NewEventForm from './NewEventForm';
import GSToggleButton from '../../widgets/gs_toggle_button/GSToggleButton';
import GSDropdown from '../../widgets/gs_dropdown/GSDropdown';
import GSDateSelector from '../../widgets/gs_date_selector/GSDateSelector';
import GSButton from '../../widgets/gs_button/GSButton';
import './EventControls.css';

const eventTypes = [
	{value: 1, label: "Social"},
	{value: 2, label: "Mining"},
	{value: 3, label: "Mob Hunting"},
];

function EventControls() {
	const [showCreateEvent, setShowCreateEvent] = useState(false);
	const [filterShowFull, setFilterShowFull] = useState(false);
	const [filterEventType, setFilterEventType] = useState(null);
	const [filterEventFromTime, setFilterEventFromTime] = useState(null);
	const [filterEventToTime, setFilterEventToTime] = useState(null);

	return (
		<div className="event_controls_container">
			<div className="event_controls_filters">
				<GSToggleButton label="Show Full"
					selectedValue={filterShowFull}
					onSelect={setFilterShowFull} />
				<GSDropdown
					placeholder="Event Type"
					selectedValue={filterEventType}
	    			onSelect={setFilterEventType}
					values={eventTypes} />
				<GSDateSelector
					placeholder="From"
					selectedValue={filterEventFromTime}
	    			onSelect={setFilterEventFromTime} />
	    		<GSDateSelector
					placeholder="To"
					selectedValue={filterEventToTime}
	    			onSelect={setFilterEventToTime} />
	    		<GSButton
	    			label="Search"
	    			onClick={() => {}} />
			</div>
			<div>
				<button className="event_controls_button"
					onClick={() => setShowCreateEvent(!showCreateEvent)}>New</button>
			</div>
			{showCreateEvent && <NewEventForm />}
		</div>
	);
}

export default EventControls;