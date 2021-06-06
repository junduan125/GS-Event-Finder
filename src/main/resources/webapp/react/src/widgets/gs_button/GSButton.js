import React from 'react';
import './GSButton.css';


function GSButton({label, onClick}) {
	return (
		<div className="gs_button_container">
			<button className="gs_button" onClick={onClick}>{label}</button>
		</div>
	);
}

export default GSButton;