import React, {Component} from 'react';
import {withRouter} from 'react-router-dom';
import authClient from "../Authentication/Auth";

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            disabled: false,
            username: '',
            password: '',
        };
    }

    updateUsername(value) {
        this.setState({
            username: value,
        });
    }

    updatePassword(value) {
        this.setState({
            password: value,
        });
    }

    async submit() {
        this.setState({
            disabled: true,
        });

        authClient.signIn(this.state.username, this.state.password)
            .then(() => this.props.history.push('/'));
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <div className="card border-primary">
                            <div className="card-header">Sign In:</div>
                            <div className="card-body text-left">
                                <div className="form-group">
                                    <label htmlFor="exampleInputEmail1">Username:</label>
                                    <input
                                        disabled={this.state.disabled}
                                        type="text"
                                        onBlur={(e) => {
                                            this.updateUsername(e.target.value)
                                        }}
                                        className="form-control"
                                        placeholder="Username"
                                    />
                                </div>
                                <div className="form-group">
                                    <label htmlFor="exampleInputEmail1">Password:</label>
                                    <input
                                        disabled={this.state.disabled}
                                        type="text"
                                        onBlur={(e) => {
                                            this.updatePassword(e.target.value)
                                        }}
                                        className="form-control"
                                        placeholder="Password"
                                    />
                                </div>
                                <button
                                    disabled={this.state.disabled}
                                    className="btn btn-primary"
                                    onClick={() => {
                                        this.submit()
                                    }}>
                                    Submit
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default withRouter(Login);