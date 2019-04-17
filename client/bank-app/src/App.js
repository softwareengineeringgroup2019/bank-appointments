import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';
import {Button, ButtonDropdown, ButtonToolbar, Container, Row, Col} from 'reactstrap';

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



class App extends Component {

    constructor(props) {
        super(props)
        this.state = {
            locations: []

        };
        // fetch('http://localhost:8080/api/locations')
        //     .then(response => response.json())
        //     .then(locations => (this.setState({locations})))
    }


    componentDidMount() {
        axios.get('http://localhost:8080/api/locations',{})
            .then((res) => {
                this.setState({locations: res.data})

            })

    }
    


  render() {
    return ( <div>
            <ul>
                {this.state.locations.map(loc => <li>
                    <p>{loc.address}, {loc.city}, {loc.state}, {loc.zipcode}</p>
                </li>)}
            </ul>

            <div>
                <form action = findCity>

                <input type="text" id="chooseCity"/><br/>

                <button className="btn btn-primary" onClick="findCity()">Get City</button>
                </form>
            </div>



        </div>






    );
  }
}

export default App;
