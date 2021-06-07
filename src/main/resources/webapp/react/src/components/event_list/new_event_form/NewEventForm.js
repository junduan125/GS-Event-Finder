import React from 'react';
import { useState } from 'react';
import { graphql, commitMutation } from 'react-relay';
import RelayEnvironment from '../../../RelayEnvironment';
import GSTextInput from '../../../widgets/gs_text_input/GSTextInput';
import GSDropdown from '../../../widgets/gs_dropdown/GSDropdown';
import GSDateSelector from '../../../widgets/gs_date_selector/GSDateSelector';
import './NewEventForm.css';

const createEventMutation = graphql`
	mutation NewEventFormCreateMutation($eventTime: Int!, $eventType: Int!, $characterType: Int, $minWorldLevel: Int) {
		createEvent(eventTime: $eventTime, eventType: $eventType, characterType: $characterType, minWorldLevel: $minWorldLevel) {
			eventType
			eventTime
		}
	}
`

const emptyEvent = { eventType: 0, eventTime: 0, characterType: 0, minWorldLevel: 0 };
const eventTypes = [
	{value: 1, label: "Social"},
	{value: 2, label: "Mining"},
	{value: 3, label: "Mob Hunting"},
];
const worldLevels = [
	{value: 1, label: "WL 1"},
	{value: 2, label: "WL 2"},
	{value: 3, label: "WL 3"},
	{value: 4, label: "WL 4"},
	{value: 5, label: "WL 5"},
	{value: 6, label: "WL 6"},
	{value: 7, label: "WL 7"},
	{value: 8, label: "WL 8"},
];
const characterTypes = [
	{value: 1, label: "Albedo"},
	{value: 2, label: "Amber"},
	{value: 3, label: "Barbara"},
	{value: 4, label: "Beido"},
	{value: 5, label: "Bennet"},
	{value: 6, label: "Chongyun"},
]

function NewEventForm({showModal, onHide}) {
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
		<div>
			{showModal && <div className="new_event_form_modal"
								onClick={onHide}>
			</div>}
			{showModal && <div className="new_event_form_container">
				<div>
					<div className="new_event_form_container_fields">
						<GSDropdown
							placeholder="Event Type"
							selectedValue={newEvent.eventType}
				    		onSelect={value => setNewEvent({ ...newEvent, eventType: value})}
							values={eventTypes} />
						<GSDateSelector
							placeholder="Time"
							selectedValue={newEvent.eventTime}
				    		onSelect={value => setNewEvent({ ...newEvent, eventTime: value})} />
			    	</div>
			    	<div className="new_event_form_container_fields">
			    		<GSDropdown
							placeholder="Character"
							selectedValue={newEvent.characterType}
				    		onSelect={value => setNewEvent({ ...newEvent, characterType: value})}
							values={characterTypes} />
				    	<GSDropdown
				    		width={130}
							placeholder="Min WL"
							selectedValue={newEvent.minWL}
				    		onSelect={value => setNewEvent({ ...newEvent, minWorldLevel: value})}
							values={worldLevels} />
					</div>
				</div>
		    	<button className="new_event_form_button" type="button"
		    		onClick={() => onCreateEvent(newEvent)}>Create</button>
	    	</div>}
		</div>
	);
}

export default NewEventForm;