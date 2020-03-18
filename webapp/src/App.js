import React, {Component} from 'react';
import {Route} from 'react-router-dom';
import NavBar from './NavBar/NavBar';
import Teams from './Teams/Teams';
import Team from './Team/Team';
import Login from "./Login/Login";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            checkingSession: true,
        }
    }

    render() {
        return (
            <div>
                <NavBar/>
                <Route exact path='/' component={Teams}/>
                <Route exact path='/login' component={Login}/>
                <Route exact path='/teams/:teamId' component={Team}/>
                <p>Work in progress.</p>
            </div>
        );
    }
}

export default App;