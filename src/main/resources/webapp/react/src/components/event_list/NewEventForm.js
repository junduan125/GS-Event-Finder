import React from 'react';
import { useState } from 'react';
import { graphql, commitMutation } from 'react-relay';
import RelayEnvironment from '../../RelayEnvironment';
import GSTextInput from '../../widgets/gs_text_input/GSTextInput';
import GSDropdown from '../../widgets/gs_dropdown/GSDropdown';
import GSDateSelector from '../../widgets/gs_date_selector/GSDateSelector';
import './NewEventForm.css';

const createEventMutation = graphql`
	mutation NewEventFormCreateMutation($eventTime: Int!, $eventType: Int!) {
		createEvent(eventTime: $eventTime, eventType: $eventType) {
			eventType
			eventTimeSeconds
		}
	}
`

const emptyEvent = { eventType: 0, eventTime: 0 };
const eventTypes = [
	{value: 1, label: "Social"},
	{value: 2, label: "Mining"},
	{value: 3, label: "Mob Hunting"},
];

function NewEventForm() {
	const [newEvent, setNewEvent] = useState(emptyEvent);

	const onCreateEvent = (newEvent) => {
		commitMutation(RelayEnvironment, {
			mutation: createEventMutation,
			variables: newEvent,
			onCompleted: response => {
				window.location.reload();
			}
		});
	}

	return (
		<div className="">
			<GSDropdown
				selectedValue={newEvent.eventType}
	    		onSelect={value => setNewEvent({ ...newEvent, eventType: value})}
				values={eventTypes} />
			<GSDateSelector
				selectedValue={newEvent.eventTime}
	    		onSelect={value => setNewEvent({ ...newEvent, eventTime: value})}
				/>
	    	<button className="new_event_form_button" type="button"
	    		onClick={() => onCreateEvent(newEvent)}>Create</button>
		</div>
	);
}

export default NewEventForm;