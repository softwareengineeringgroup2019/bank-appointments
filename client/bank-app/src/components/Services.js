import React, {Component} from 'react'
import {Link} from "react-router-dom"
import ProjectTaskItem from "./ProjectTask/ProjectTaskItem";
import {ToggleButton, ToggleButtonGroup} from "react-bootstrap";
import ServiceButtons from "./ServiceButtons";
import FindService from "./ProjectTask/FindService";
import {Button, ButtonToolbar, ButtonGroup} from "react-bootstrap";
import axios from "axios/index";

class Services extends Component {

    render() {
        return (
            <div className="container">
                <h3><i className="text-success">What can we help you with?</i></h3>

                <br/>
                <hr/>

                <div className="container">
                    <div className="container">

                        <ServiceButtons/>

                    </div>
                </div>

                <br/>
                <hr/>

                <div className="text-center mb-2 ml-auto">
                    <Link to="/Locations" className="btn btn-success mb-3">
                        <i className="fas fa-map-pin"> Select Location</i>
                    </Link>
                </div>

                <br/>
                <hr/>
                {/*<FindService/>*/}
                <br/>
                <hr/>


            </div>


        )
    }
}

export default Services;