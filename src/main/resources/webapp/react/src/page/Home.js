import React from 'react';
import {
  Link
} from "react-router-dom";

function Home() {
	return (
		<div >
			<Link to="/signin">Sign in</Link>
		</div>
	);
}

export default Home