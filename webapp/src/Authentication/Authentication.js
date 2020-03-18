import {BehaviorSubject} from 'rxjs';
import axios from "axios";


console.log(localStorage.getItem('currentUser'));
//const currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
//const currentUserSubject = new BehaviorSubject('hi');


export const AuthenticationService = {
    login,
    logout,
    currentUser: 'user', // currentUserSubject.asObservable(),
    get currentUserValue() {
        return 'user'
        //return currentUserSubject.value
    },
    get isAuthenticated() {
        return false
        //return currentUserSubject.value != null
    }
};

function login(username, password) {
    console.log("get");
    console.log( axios.get('http://localhost:8081/getauth').data);
    console.log("post");

    const userData = axios.post('http://localhost:8081/authenticate', {
        username: username,
        password: password
    }).data;

    console.log(userData)
//    localStorage.setItem('currentUser', JSON.stringify(userData))

    return userData
}

function logout() {
    localStorage.removeItem('currentUser');
    //currentUserSubject.next(null);
}