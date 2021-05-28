import React from 'react';

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
		<button onClick={loadData}>Register</button>
	);
}

export default RegisterForm;