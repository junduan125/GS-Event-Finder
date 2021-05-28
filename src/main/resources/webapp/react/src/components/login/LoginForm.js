import React from 'react';
import { Link } from "react-router-dom";
import { useState } from 'react';
import { useCookies } from "react-cookie";
import RegisterForm from "./RegisterForm";
import './Login.css';

function LoginForm({params}) {
	const [showRegister, setShowRegister] = useState(false);
	const [csrfToken] = useCookies(['X-XSRF-TOKEN']);

	return (
		<div>
			{ !showRegister &&
			<div className="login_container float_out">
				<div className="login_disclaimer">
					<p>This site is not affliated with miHoyo and Genshin, login information is not tied to miHoyo in any way</p>
				</div>
				<form name="loginForm" action="login" method="POST">
			        <div>
			        	<input type="text" id="username" name="username" placeholder="Username" />
			        	<input type="password" id="password" name="password" placeholder="Password" />
		        		<input type="hidden" name="_csrf" value={csrfToken} />
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