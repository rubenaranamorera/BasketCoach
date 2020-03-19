import axios from "axios";
import {withRouter} from 'react-router-dom';

class Auth {
    constructor() {
        this.getProfile = this.getProfile.bind(this);
        this.isAuthenticated = this.isAuthenticated.bind(this);
        this.signIn = this.signIn.bind(this);
        this.signOut = this.signOut.bind(this);
        this.getJwtToken = this.getJwtToken.bind(this);
    }

    getProfile() {
        return localStorage.getItem('userProfile');
    }

    getJwtToken() {
        return localStorage.getItem('jwtToken');
    }

    isAuthenticated() {
        return localStorage.getItem('jwtToken') !== null
        //return new Date().getTime() < this.expiresAt;
    }

    signIn(username, password) {
        return axios.post('http://localhost:8081/authenticate', {
            username: username,
            password: password
        }).then(response => {
            localStorage.setItem('userProfile', response.data.userProfile);
            localStorage.setItem('jwtToken', response.data.jwtToken);
            //this.expiresAt = authResult.idTokenPayload.exp * 1000;
        });
    }

    signOut() {
        localStorage.clear()
    }
}

const authClient = new Auth();

export default withRouter(authClient);