import React, {Component} from 'react';
import {teamsService} from "./teamsService";
import Roster from "./Roster";

class Team extends Component {

    constructor(props) {
        super(props);
        this.state = {
            team: null
        };
    }

    async componentDidMount() {
        teamsService.getTeam(0)
            .then(team => {
                this.setState({
                    team,
                })
            });

    }

    render() {
        const {team} = this.state;
        if (team === null) return <p>Loading ...</p>;
        return (
            <div className="container">
                <div className="row">
                    <div className="col-sm-12">
                        <h1>{team.name} ({team.club})</h1>
                        <Roster players={team.players}/>
                    </div>
                </div>
            </div>
        )
    }
}

export default Team;