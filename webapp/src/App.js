import React, {Component} from 'react';
import {Route} from 'react-router-dom';
import NavBar from './NavBar/NavBar';
import Teams from './Teams/Teams';
import Team from './Team/Team';

class App extends Component {
    render() {
        return (
            <div>
                <NavBar/>
                <Route exact path='/' component={Teams}/>
                <Route exact path='/teams/:teamId' component={Team}/>
                <p>Work in progress.</p>
            </div>
        );
    }
}

export default App;