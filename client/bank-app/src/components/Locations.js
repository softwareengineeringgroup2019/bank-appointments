import React, { Component } from 'react'
import { Link } from "react-router-dom"
import axios from "axios/index";

class Locations extends Component {

    constructor(props) {
        super(props)
        this.state = {
            locations: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/locations',{})
            .then((res) => {
                this.setState({locations: res.data})
            })
    }


    render() {
        return (
            <div className="container">
                <h3><i className="text-success">Please Select a Branch </i></h3>
                <br />
                <hr />

                <div className="container">
                    <div className="row">
                        <div className="col-md">

                            <div className="card text-center">
                                <div className="card-header bg-success text-white">
                                    <h3>Branches</h3>
                                </div>
                                <br />
                                <ul>
                                    {this.state.locations.map(loc => <li>
                                        <p>{loc.address}, {loc.city}, {loc.state}, {loc.zipcode}</p>
                                    </li>)}
                                </ul>
                            </div>


                        </div>
                    </div>
                </div>
                <br />
                <hr />

                <div className="col">


                    <div className="container">
                        <div className="row">

                                <div className="text-center mb-2 mb-auto">
                                 <Link to="/" className="btn btn-success mb-3">
                                     <i className="fas fa-arrow-left">   Back to Services</i>
                                </Link>
                                </div>

                                <div className="text-center mb-2 ml-auto">
                                    <Link to="/" className="btn btn-success mb-3">
                                        <i className="fas fa-calendar-check">   Choose a Time</i>
                                    </Link>
                                </div>

                        </div>
                    </div>



                </div>
            </div>

        )
    }
}
export default Locations