import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';

class Teams extends Component {
    constructor(props) {
        super(props);

        this.state = {
            teams: null,
        };
    }

    async componentDidMount() {
        const teams = (await axios.get('http://localhost:8081/teams')).data;
        this.setState({
            teams: teams,
        });
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    {this.state.teams === null && <p>Loading teams...</p>}
                    {
                        this.state.teams && this.state.teams.map(team => (
                            <div key={team.id} className="col-sm-12 col-md-4 col-lg-3">
                                <Link to={`/teams/${team.id}`}>
                                    <div className="card text-white bg-success mb-3">
                                        <div className="card-header">Players: {team.players[0].name}</div>
                                        <div className="card-body">
                                            <h4 className="card-title">{team.name}</h4>
                                            <p className="card-text">{team.club}</p>
                                        </div>
                                    </div>
                                </Link>
                            </div>
                        ))
                    }
                </div>
            </div>
        )
    }
}

export default Teams;