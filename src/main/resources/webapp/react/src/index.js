import React from 'react';
import ReactDOM from 'react-dom';
import {
	  BrowserRouter as Router,
	  Switch,
	  Route
	} from "react-router-dom";
import Home from './page/Home';
import Login from './page/Login';
import Profile from './page/Profile';


function App() {
	const params = new URLSearchParams(window.location.search)
	return(
  		<Router>
			<Switch>
				<Route path="/signin" component={() => <Login params={params} />} />
				<Route path="/user/profile" component={() => <Profile params={params} />} />
				<Route path="/" component={Home} />
			</Switch>
  		</Router>
	);
}

ReactDOM.render(
    <App />,
  document.getElementById("root")
);