import React from 'react';
import { useState } from 'react';
import ClipLoader from "react-spinners/ClipLoader";
import './LevelSelector.css';

function LevelSelector({maxValue, label, selectedValue, onChange, loading}) {
	const [showSelector, setShowSelector] = useState(false);

	return (
		<div className="level_selector">
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
				{loading ?
					<div className="level_selector_loader">
						<ClipLoader color="#fff" loading={loading} size={42} />
					</div> :
					<span><strong>{selectedValue}</strong></span>
				}
			</div>
		</div>
	);
}

export default LevelSelector;