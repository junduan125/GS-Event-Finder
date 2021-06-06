import React from 'react';
import { useState } from 'react';
import DatePicker from "react-datepicker";
import './GSDateSelector.css';
import "react-datepicker/dist/react-datepicker.css";

function GSDateSelector({selectedValue, onSelect, placeholder}) {
  	const [selectedDate, setSelectedDate] = useState(null);
	return (
		<div className="gs_date_selector_container">
			<img className="gs_date_selector_icon" src="/assets/icons/calendar-icon.svg" />
    		<DatePicker
    			selected={selectedDate}
    			onChange={(date) => {
    				setSelectedDate(date);
    				onSelect(date.getTime() / 1000);
    			}} />
			{selectedDate === null && <span className="gs_date_selector_placeholder"><i>{placeholder}</i></span>}
		</div>
	);
}

export default GSDateSelector;