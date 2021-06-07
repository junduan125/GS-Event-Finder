import React from 'react';
import './GSButton.css';


function GSButton({label, onClick, className}) {
	return (
		<div className="gs_button_container">
			<button className={"gs_button " + className} onClick={onClick}>{label}</button>
		</div>
	);
}

export default GSButton;