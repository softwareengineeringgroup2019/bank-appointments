import React, { Component } from 'react';
import GoogleMapReact from 'google-map-react';
import './App.css';
import {Button, Container, Row, Col} from 'reactstrap';
import axios from "axios";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCreditCard, faMoneyBillWave, faCar, faGraduationCap, faHome, faChartBar, faPiggyBank, faWallet, faBriefcase} from '@fortawesome/free-solid-svg-icons'


function findCity() {
    var resultElement = document.getElementById('findByCity');
    var choosenCity = document.getElementById('chooseCity').value;
    resultElement.innerHTML = '';

    axios.get('http://localhost:8080/api/locations', {
        params: {
            city: choosenCity
        }
    })

}

const AnyReactComponent = ({ text }) => <div>{text}</div>;

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
        axios.get('/services')
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

            <div style={{marginTop: "20px",
                marginBottom: "20px",
                backgroundColor:"#006948"
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
                <Button a href="#map" style={{display: "none"}}>map</Button>
                <Container style={{
                    maxWidth: "100%",
                    height:"auto",
                    width:"auto",
                    fontSize: "20px",
                    paddingBottom: "20px",
                    margin: "10px",
                    flex: 1,
                    display: "inline-block",
                    justifyContent: "center",
                    textAlign: "center",}}>
                    <Row>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs >
                                <input
                                    id={"check"}
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faMoneyBillWave} />
                                Checking
                            </Col>
                        </label>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faPiggyBank} />
                                Savings
                            </Col>
                        </label>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faGraduationCap} />
                                Student Loans
                            </Col>
                        </label>
                    </Row>
                    <Row>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faChartBar} />
                                Home Equity
                            </Col>
                        </label>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faHome} />
                                Mortgage
                            </Col>
                        </label>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faCar} />
                                Auto Loans
                            </Col>
                        </label>
                    </Row>
                    <Row>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faBriefcase} />
                                Investment Accounts
                            </Col>
                        </label>
                        <label style={{flex: 1}}>
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faWallet} />
                                Student Banking
                            </Col>
                        </label>
                        <label style={{flex: 1}} onClick={this.showButton} >
                            <Col sm={4} xs>
                                <input
                                    type={"checkbox"}
                                    name={"savings"}
                                />
                                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faCreditCard} />
                                Credit Card
                            </Col>
                        </label>
                    </Row>
                </Container>
                { this.state.showButton && (<div>
                        <Button>ok</Button>
                    </div>
                )}
                <h3><div id="map">
                    Let's Find a time and place that works for you:
                </div>
                    <div style={{ height: '75vh', width: '50%' }}>
                        <GoogleMapReact
                            bootstrapURLKeys={{ key: "AIzaSyAumgHSSsDeSVUYXgI6gz5VKCNVvy0K_dM" }}
                            defaultCenter={this.props.center}
                            defaultZoom={this.props.zoom}
                        >
                            <AnyReactComponent
                                lat={59.955413}
                                lng={30.337844}
                                text="My Marker"
                            />
                        </GoogleMapReact>
                    </div>

                </h3>
                <h3>
                    Now we just need a few more details:
                </h3>

                <form>
                    <label>
                        First Name:
                        <input type="text" name="first" />
                    </label>
                    <label>
                        Last Name:
                        <input type="text" name="last" />
                    </label>
                    <label>
                        Email:
                        <input type="text" name="email" />
                    </label>
                    <label>
                        Phone Number:
                        <input type="text" name="phone" />
                    </label>
                </form>
                <h3>
                    Here's your appointment!
                </h3>

            </div>




        );
    }
}

export default App;
