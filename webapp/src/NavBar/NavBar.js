import React from 'react';
import {Link, withRouter} from 'react-router-dom';
import authClient from "../Authentication/Auth";


function NavBar(props) {

    const signOut = () => {
        authClient.signOut();
        props.history.replace('/');
    };

    const signIn = () => {
        props.history.replace('/login');
    };

    return (
        <nav className="navbar navbar-dark bg-primary fixed-top">
            <Link className="navbar-brand" to="/">
                BasketCoach
            </Link>
            {
                !authClient.isAuthenticated() &&
                <button className="btn btn-dark" onClick={() => signIn()}>Sign In</button>
            }
            {
                authClient.isAuthenticated() &&
                <div>
                    <label className="mr-2 text-white">{authClient.getProfile()}</label>
                    <button className="btn btn-dark" onClick={() => {
                        signOut()
                    }}>Sign Out
                    </button>
                </div>
            }
        </nav>
    );

}

export default withRouter(NavBar);
