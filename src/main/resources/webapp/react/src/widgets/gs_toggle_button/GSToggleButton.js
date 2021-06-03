import React from 'react';
import './GSToggleButton.css';

function GSToggleButton({selectedValue, onSelect, label}) {
	return (
		<div className="gs_toggle_button_container">
			<span className = "gs_toggle_button_label">{label}</span>
			<label className="gs_toggle_button_switch">
				<input type="checkbox"
					value={selectedValue}
					onChange={() => {onSelect(!selectedValue)}} />
				<span className="gs_toggle_button_slider"></span>
			</label>
		</div>
	);
}

export default GSToggleButton;