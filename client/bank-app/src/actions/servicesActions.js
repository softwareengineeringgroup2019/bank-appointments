import axios from "axios";
import {GET_SERVICES} from "./types";

// export const addServices = (services, history) => async dispatch => {
//     await axios.post("http://localhost:8080/api/services", services)
//     history.push("/");
// }

export const getBacklog = () => async dispatch => {
    dispatch({
        type:GET_SERVICES
    })

}