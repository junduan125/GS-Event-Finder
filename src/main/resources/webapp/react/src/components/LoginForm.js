import React from 'react';
import { useCookies } from "react-cookie";
import RegisterForm from "./RegisterForm";

function LoginForm({params}) {
	const [csrfToken] = useCookies(['X-XSRF-TOKEN']);
	const data = {
		username: 'test',
		password: 'password'
	}
	fetch('/login', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(data)})
	.then(response => {
		console.log('response', response)
	});

	return (
	    <fieldset>
	        <legend>Please Login</legend>
			<form name="loginForm" action="login" method="POST">
		        <label for="username">Username</label>
		        <input type="text" id="username" name="username"/>
		        <label for="password">Password</label>
		        <input type="password" id="password" name="password"/>
	        	<input type="hidden" name="_csrf" value={csrfToken} />
		        <div>
		            <button type="submit">Log in</button>
		        </div>
			</form>
			<RegisterForm />
		</fieldset>
	);
}

export default LoginForm;