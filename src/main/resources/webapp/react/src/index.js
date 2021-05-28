import React from 'react';
import ReactDOM from 'react-dom';
import {
	  BrowserRouter as Router,
	  Switch,
	  Route
	} from "react-router-dom";
import Home from './page/Home';
import Profile from './page/Profile';


function App() {
	const params = new URLSearchParams(window.location.search)
	return(
  		<Router>
			<Switch>
				<Route path="/user/profile" component={() => <Profile params={params} />} />
				<Route path="/" component={() => <Home params={params} />} />
			</Switch>
  		</Router>
	);
}

ReactDOM.render(
    <App />,
  document.getElementById("root")
);