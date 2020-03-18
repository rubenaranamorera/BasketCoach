import React from 'react';
import {Link} from 'react-router-dom';
import {AuthenticationService} from "../Authentication/Authentication";

function NavBar() {

    const signOut = () => {
        AuthenticationService.logout();
       // history.replace("/")
    };

    return (
        <nav className="navbar navbar-dark bg-primary fixed-top">
            <Link className="navbar-brand" to="/">
                BasketCoach
            </Link>
            {
                !AuthenticationService.isAuthenticated &&
                <Link className="btn btn-dark" to={"/login"}>Sign In</Link>
            }
            {
                AuthenticationService.isAuthenticated &&
                <div>
                    <label className="mr-2 text-white">{AuthenticationService.currentUserValue().name}</label>
                    <Link className="btn btn-dark" onClick={() => {
                        signOut()
                    }}>Sign Out
                    </Link>
                </div>
            }
        </nav>
    );
}

export default NavBar;