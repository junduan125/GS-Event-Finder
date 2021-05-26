import React from 'react';
import LoginForm from '../components/LoginForm'

function Login(props) {
	return (
		<div>
			<LoginForm params={props.params} />
		</div>
	);
}

export default Login