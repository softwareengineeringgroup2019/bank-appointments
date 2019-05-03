import React, { Component } from 'react';
import {Map, GoogleApiWrapper} from 'google-maps-react';


const mapStyles = {
    width: '50%',
    height: '50%'
};

export class MapContainer extends Component {
    render() {
        return (
            <Map
                google={this.props.google}
                zoom={14}
                style={mapStyles}
                initialCenter={{
                    lat: 38.760280,
                    lng: -93.735819
                }}
            />
        );
    }
}

export default GoogleApiWrapper({
    apiKey: 'AIzaSyAFzSBj-bc-DyZx9NLLWY1fJxtXX1Wy80w'
})(MapContainer);