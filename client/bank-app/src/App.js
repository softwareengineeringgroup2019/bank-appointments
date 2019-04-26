import React, { Component } from 'react';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import './index.css'
import {BrowserRouter as Router, Route} from "react-router-dom";
import ServiceButtons from './components/ServiceButtons';
import MapsAppointment from './components/MapsAppointment';
import UserInformation from './components/UserInformation';
import ReviewAppointment from './components/ReviewAppointment';

class App extends Component {

    constructor() {
        super();
        this.state = {showMessage: false }
    }

    showButton = (bool) => {
        this.setState({
            showButton: bool
        });
    }

    componentDidMount() {
        this.delayedShowMarker()
    }

    delayedShowMarker = () => {
        setTimeout(() => {
            this.setState({ isMarkerShown: true })
        }, 3000)
    }

    componentWillMount() {
        axios.get('api/services')
            .then((res) => {
                this.setState({services: res.data})

            })
        axios.get('api/locations')
            .then((res) => {
                this.setState({locations: res.data})

            })

        axios.get('api/hours')
            .then((res) => {
                this.setState({hours: res.data})

            })
    }

    static defaultProps = {
        center: {
            lat: 38.77292942970709,
            lng: -93.73864749446513
        },
        zoom: 11
    };

  render() {
    return (
        <Router>
            <div className="App">
                <div style={{marginTop: "20px",
                    margin: "3%",
                }}>
                    <h1 style={{ maxWidth:"100%",
                        height:"auto",
                        width:"auto/9",
                        paddingBottom: "20px",
                        marginBottom:"20px",
                        backgroundColor: "white",
                        display: "flex",
                        justifyContent: "center"}} >
                        <img src="commerce-bank-logo.png"/>
                    </h1>
                </div>
                    <Route exact path="/" component={ServiceButtons} />
                    <Route exact path="/MapsAppointment" component={MapsAppointment} />
                    <Route exact path="/UserInformation" component={UserInformation} />
                    <Route exact path="/ReviewAppointment" component={ReviewAppointment} />


            </div>
        </Router>

    );
  }
}

export default App;
