import React, {Component} from 'react';
import axios from 'axios';

class Team extends Component {
    constructor(props) {
        super(props);
        this.state = {
            team: null,
        };
    }

    async componentDidMount() {
        const {match: {params}} = this.props;
        const team = (await axios.get(`http://localhost:8081/teams/${params.teamId}`)).data;
        this.setState({
            team,
        });
    }

    render() {
        const {team} = this.state;
        if (team === null) return <p>Loading ...</p>;
        return (
            <div className="container">
                <div className="row">
                    <div className="jumbotron col-12">
                        <h1 className="display-3">{team.name}</h1>
                        <p className="lead">{team.club}</p>
                        <hr className="my-4"/>
                        <p>Answers:</p>
                        {
                            team.players.map((player, idx) => (
                                <p className="lead" key={idx}>{player.name}</p>
                            ))
                        }
                    </div>
                </div>
            </div>
        )
    }
}

export default Team;