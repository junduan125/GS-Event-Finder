import React from 'react';
import { useState } from 'react';
import './GSDropdown.css';

function GSDropdown({selectedValue, onSelect, values}) {
	const initValue = values.find( elem => elem.value === selectedValue) || {label: " "};
	const [selectedValueItem, setSelectedValueItem] = useState(initValue);
	const [showSelector, setShowSelector] = useState(false);
	return (
		<div className="gs_dropdown_container">
			<div className="gs_dropdown_label_container"
			  onClick={() => setShowSelector(!showSelector) }>
				<img className="gs_dropdown_icon" src="/assets/icons/chevron-down-icon.svg" />
				<span>{selectedValueItem.label}</span>
			</div>
			{showSelector && <div className="gs_dropdown_float_container">{
				values.map( (value, index) => 
					<div key={index} className="gs_dropdown_float_item" onClick={() => {
						setSelectedValueItem(values[index]);
						setShowSelector(false);
						onSelect(value.value);
					}}>
						{value.label}
					</div> )
			}</div>}
		</div>
	);
}

export default GSDropdown;