import React, {Component} from 'react';
import {AuthenticationService} from "../Authentication/Authentication";

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    Enter username
                </div>
                <div className="row">
                    Enter password
                </div>
                <button className="btn btn-dark" onClick={() => {
                    AuthenticationService.login('username', 'password')
                    console.log(AuthenticationService.currentUserValue)
                }}>
                    Sign In
                </button>

            </div>
        )
    }
}

export default Login;



