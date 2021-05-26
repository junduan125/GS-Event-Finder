import React from 'react';
import { Button } from 'react-bootstrap';

function RegisterForm() {

	const loadData = () => {
		const data = {
			username: 'test',
			password: 'password',
			uuid: '000000',
			worldLevel: 1,
		}
		fetch('/register', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(data)})
			.then(response => {
				console.log('response', response)
			});
	}

	return (
		<Button variant="success" onClick={loadData}>Register</Button>
	);
}

export default RegisterForm;