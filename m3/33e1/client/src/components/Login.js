import React from 'react';
import axios from 'axios';
import styled from 'styled-components';

class Login extends React.Component {
	state = {
		credentials: {
			username: '',
			password: ''
		}
	};

	handleChange = e => {
		this.setState({
			credentials: {
				...this.state.credentials,
				[e.target.name]: e.target.value
			}
		});
	};

	login = e => {
		e.preventDefault();
		axios
			.post('http://localhost:5000/api/login', this.state.credentials)
			.then(res => {
				localStorage.setItem('token', res.data.payload);
				this.props.history.push('/protected');
			})
			.catch(err => console.log(err));
	};

	render() {
		return (
			<Div>
				<H3>Log In To View Color List: </H3>
				<Form onSubmit={this.login}>
					<Input
						type="text"
						name="username"
						value={this.state.credentials.username}
						onChange={this.handleChange}
					/>
					<Input
						type="password"
						name="password"
						value={this.state.credentials.password}
						onChange={this.handleChange}
					/>
					<button>Log in</button>
				</Form>
			</Div>
		);
	}
}

export default Login;
