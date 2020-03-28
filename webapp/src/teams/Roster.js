import React from 'react';

function Roster(props) {
    return (
        <div className="card text-white bg-success mb-3">
            <div className="card-header">Players</div>
            <div className="card-body">
                {
                    props.players.map(player => (
                            <p className="card-text">{player.name}</p>
                        )
                    )
                }
            </div>
            <div className="card-footer">
                <button> Add player</button>
            </div>
        </div>
    )
}

export default Roster;