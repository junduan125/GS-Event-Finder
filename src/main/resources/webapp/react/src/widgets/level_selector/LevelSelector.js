import React from 'react';
import { useState } from 'react';
import './LevelSelector.css';

function LevelSelector({maxValue, label, selectedValue, onChange}) {
	const [showSelector, setShowSelector] = useState(false);

	return (
		<div class="level_selector">
			{showSelector && <div className="level_selector_float_container">
				{[...Array(maxValue).keys()].map( value => 
					<div className="level_selector_item" key={value} 
						onClick={() => {
							onChange(value + 1);
							setShowSelector(false);
						}
					}>
						{value + 1}
					</div>
				)}
			</div>}
			<div className="level_selector_label_container">
				<span>{label}</span>
			</div>
			<div className="level_selector_main"
				onClick={() => {
					setShowSelector(!showSelector)
				}
			}>
				<span><strong>{selectedValue}</strong></span>
			</div>
		</div>
	);
}

export default LevelSelector;