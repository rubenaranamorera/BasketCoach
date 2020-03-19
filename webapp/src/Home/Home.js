import React, {Component} from 'react';
import authClient from "../Authentication/Auth";
import Teams from "../teams/Teams";

class Home extends Component {
    render() {
        return (
            <div>
                {
                    !authClient.isAuthenticated() &&
                    <div> Unlogged HOME</div>
                }
                {
                    authClient.isAuthenticated() &&
                    <div>
                        Logged HOme
                        <Teams></Teams>
                    </div>
                }
            </div>
        )
    }
}

export default Home;



