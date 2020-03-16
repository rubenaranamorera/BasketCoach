import React, { Component } from 'react';
import NavBar from './NavBar/NavBar';
import Teams from './Teams/Teams';

class App extends Component {
    render() {
        return (
            <div>
                <NavBar/>
                <Teams/>
                <p>Work in progress.</p>
            </div>
        );
    }
}

export default App;