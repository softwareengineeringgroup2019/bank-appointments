import {combineReducers} from "redux"
import errorsReducer from "./errorsReducer";
import servicesReducer from "./servicesReducer";


export default combineReducers({
    //
    errors: errorsReducer,
    services: servicesReducer
});