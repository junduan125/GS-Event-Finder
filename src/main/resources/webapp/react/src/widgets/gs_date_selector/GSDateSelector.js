import React from 'react';
import { useState } from 'react';
import DatePicker from "react-datepicker";
import './GSDateSelector.css';
import "react-datepicker/dist/react-datepicker.css";

function GSDateSelector({selectedValue, onSelect}) {
  	const [selectedDate, setSelectedDate] = useState(new Date());
	return (
		<div className="gs_date_selector_container">
			<img className="gs_date_selector_icon" src="/assets/icons/calendar-icon.svg" />
    		<DatePicker
    			selected={selectedDate}
    			onChange={(date) => {
    				setSelectedDate(date);
    				onSelect(date.getTime() / 1000);
    			}} />
		</div>
	);
}

export default GSDateSelector;