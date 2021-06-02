import React from 'react';
import { Link } from "react-router-dom";
import { useState } from 'react';
import { useCookies } from "react-cookie";
import RegisterForm from "./RegisterForm";
import './Login.css';

const emptyUser = {username: '', password: ''};

const convertObjectToURLEncoded = (formData) => {
	let formBody = [];
	for (let property in formData) {
	  formBody.push(encodeURIComponent(property) + "=" + encodeURIComponent(formData[property]));
	}
	return formBody.join("&");
}

function LoginForm({params, onHide}) {
	const [showRegister, setShowRegister] = useState(false);
	const [user, setUser] = useState(emptyUser);
	const [loginErrors, setLoginErrors] = useState(false);

	const [csrfToken] = useCookies(['X-XSRF-TOKEN']);

	const handleSubmit = (event) => {
		event.preventDefault();
		fetch('/login', {
			method: 'POST',
			body: convertObjectToURLEncoded(user),
			headers: { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' },
		}).then( response => {
			setUser(emptyUser);
			if (response.status === 200) {
				onHide();
				window.location.reload();
			} else if (response.status === 201) {
				setLoginErrors(true);
			}
		});
	}

	return (
		<div>
			{ !showRegister &&
			<div className="login_container float_out">
				<div className="close_button" onClick={onHide}>x</div>
				<div className="login_disclaimer">
					<p>This site is not affliated with miHoyo and Genshin, login information is not tied to miHoyo in any way</p>
				</div>
				<div className="login_error">
					{ loginErrors ? <span>Invalid Username/password</span> : <span/>}
				</div>
				<form name="loginForm" onSubmit={handleSubmit}>
			        <div>
			        	<input type="text" placeholder="Username"
			        		 name="username" value={user.username}
			        		 onChange={e => setUser({ ...user, username: e.target.value})} />
			        	<input type="password" placeholder="Password"
			        		name="password" value={user.password}
			        		onChange={e => setUser({ ...user, password: e.target.value})} />
			        	<button className="login_button" type="submit">Log in</button>
			        </div>
				</form>
				<div className="additional_login_options">
					<Link to="">Forgot Password?</Link>
					<Link onClick={() => {setShowRegister(true)}}>Register Now</Link>
				</div>
			</div>}
			{showRegister && <RegisterForm />}
		</div>
	);
}

export default LoginForm;