import axios from "axios";
import authClient from "../Authentication/Auth";

export const teamsService = {
    getAll,
    getTeam
};


async function getAll() {
    return (await axios.get('http://localhost:8081/teams', {
        headers: {'Authorization': `Bearer ${authClient.getJwtToken()}`}
    })).data;
}

function getTeam(teamId) {
    return axios.get('http://localhost:8081/teams/' + teamId, {
        headers: {'Authorization': `Bearer ${authClient.getJwtToken()}`}
    }).then(response => {
        return response.data
    });
}
