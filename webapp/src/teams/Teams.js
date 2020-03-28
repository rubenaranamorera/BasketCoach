import React, {Component} from 'react';

import {teamsService} from "./teamsService";
import {Link} from "react-router-dom";

class Teams extends Component {
    constructor(props) {
        super(props);

        this.state = {
            teams: null,
        };
    }

    async componentDidMount() {
        teamsService.getAll().then(teams => this.setState({teams: teams}));
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    {this.state.teams === null && <p>Loading teams...</p>}
                    {
                        this.state.teams && this.state.teams.map(team => (
                                <div key={team.id} className="col-sm-12">
                                    <Link to={`/teams/${team.id}`}>
                                        <div className="card text-white bg-success mb-3">
                                            <div className="card-header">{team.name} ({team.club})</div>
                                            <div className="card-body">

                                            {
                                                team.players.map(player => (

                                                        <p className="card-text">{player.name}</p>
                                                    )
                                                )
                                            }
                                            </div>

                                        </div>
                                    </Link>
                                </div>
                            )
                        )
                    }
                </div>
            </div>
        )
    }
}

export default Teams;



