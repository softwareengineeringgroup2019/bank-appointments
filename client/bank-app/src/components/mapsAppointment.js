import React, { Component } from "react";
import  { Link } from "react-router-dom";
import { Map, GoogleApiWrapper, Marker, InfoWindow} from 'google-maps-react';
import '../index.css';
import '../App.css';

export class MapsAppointment extends Component {
    render() {
        return (

            <div className="mapsAppointment">
                <div style={{
                    backgroundColor:"#006948",
                    borderRadius: "15px",
                    margin: "0 auto"
                }}>
                    <div id="map" style={{paddingBottom: "15px", color: "white"}}>
                        Let's Find a time and place that works for you:
                    </div>


                    <Link to="/UserInformation" className="btn btn-success btn-lg">
                        Next Step
                    </Link>
                </div>
                <Map
                    tabIndex={0}
                    className="googleMap"
                    google={this.props.google}
                    zoom={9}
                    style={{height: "70%", width: "50%", backgroundColor: "#006948", borderRadius: "15px", margin: "0 auto"}}
                    initialCenter={{ lat: 38.91084, lng: -94.38217 }}

                >
                </Map>

            </div>

        );
    }
}

export default GoogleApiWrapper({
    apiKey: ('AIzaSyAumgHSSsDeSVUYXgI6gz5VKCNVvy0K_dM')
})(MapsAppointment)