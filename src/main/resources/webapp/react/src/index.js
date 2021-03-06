import React from 'react';
import ReactDOM from 'react-dom';
import {
	  BrowserRouter as Router,
	  Switch,
	  Route
	} from "react-router-dom";
import Home from './page/Home';
import Profile from './page/Profile';
import Events from './page/Events';


function App() {
	const params = new URLSearchParams(window.location.search)
	return(
  		<Router>
			<Switch>
				<Route path="/user/profile" component={Profile} />
				<Route path="/user/events" component={Events} />
				<Route path="/" component={Home} />
			</Switch>
  		</Router>
	);
}

ReactDOM.render(
    <App />,
  document.getElementById("root")
);