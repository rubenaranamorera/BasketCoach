import React, {Component} from 'react';
import {Route} from 'react-router-dom';
import NavBar from './NavBar/NavBar';
import Home from './Home/Home';
import Team from './teams/Team';
import Login from "./Login/Login";

class App extends Component {

    render() {
        return (
            <div>
                <NavBar/>
                <Route exact path='/' component={Home}/>
                <Route exact path='/login' component={Login}/>
                <Route exact path='/teams/:teamId' component={Team}/>
            </div>
        );
    }
}

export default App;