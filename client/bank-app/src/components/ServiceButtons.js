import {Button, ToggleButton, ToggleButtonGroup} from "react-bootstrap";
import React, {Component} from 'react'
import axios from "axios/index";
import PropTypes from "prop-types";
import {Link} from "react-router-dom";
import {getBacklog} from "../actions/servicesActions";
import { Map, GoogleApiWrapper, Marker, InfoWindow} from 'google-maps-react';
import GoogleMapReact from 'google-map-react';
import handleApiLoaded from 'google-map-react';
import MapContainer from "./MapContainer";

const mapStyles = {
    width: '50%',
    height: '50%'
};


class ServiceButtons extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.onChange = this.onChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.updateMortgage = this.updateMortgage.bind(this);
        this.updateStudentLoan = this.updateStudentLoan.bind(this);
        this.updateChecking = this.updateChecking.bind(this);
        this.updateSavings = this.updateSavings.bind(this);
        this.updateHomeEquity = this.updateHomeEquity.bind(this);
        this.updateInvestmentAccount = this.updateInvestmentAccount.bind(this);
        this.updateCreditCard = this.updateCreditCard.bind(this);
        this.updateAutoLoan = this.updateAutoLoan.bind(this);
        this.updateStudentBanking = this.updateStudentBanking.bind(this);
        this.updateSelectedLocation = this.updateSelectedLocation.bind(this);

        // this.openModal = this.openModal.bind(this);
        // this.closeModal = this.closeModal.bind(this);
        // this.logChange = this.logChange.bind(this); // We capture the value and change state as user changes the value here.
        // this.handleEdit = this.handleEdit.bind(this); // Function where we submit data

        this.state = {
            services: [],
            locations: [],
            branches: [],

            selectedLocation: '',

            mortgage: false,
            studentLoans: false,
            checking: false,
            savings: false,
            autoLoan: false,
            studentBanking: false,
            creditCard: false,
            homeEquity: false,
            investmentAccount: false,
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/locations',{})
            .then((res) => {
                this.setState({locations: res.data})
            })
    }

    updateMortgage() {
        this.setState(prevState => ({
            mortgage: !prevState.mortgage,

        }));
    }

    updateStudentLoan() {
        this.setState(prevState => ({
            studentLoans: !prevState.studentLoans,
        }));
    }

    updateChecking() {
        this.setState(prevState => ({
            checking: !prevState.checking,
        }))
    }

    updateSavings() {
        this.setState(prevState => ({
            savings: !prevState.savings,
        }))
    }

    updateAutoLoan() {
        this.setState(prevState => ({
            autoLoan: !prevState.autoLoan,
        }))
    }

    updateStudentBanking() {
        this.setState(prevState => ({
            studentBanking: !prevState.studentBanking,
        }))
    }

    updateInvestmentAccount() {
        this.setState(prevState => ({
            investmentAccount: !prevState.investmentAccount,
        }))
    }

    updateHomeEquity() {
        this.setState(prevState => ({
            homeEquity: !prevState.homeEquity,
        }))
    }

    updateCreditCard() {
        this.setState(prevState => ({
            creditCard: !prevState.creditCard,
        }))
    }

    updateSelectedLocation() {
        this.setState(e => ({
            selectedLocation: "I was clicked",
        }))
    }


    onChange(value) {
        this.setState({ value });
    }

    // handleClick() {
    //     axios.get('http://localhost:8080/api/services', {
    //         params: {
    //             mortgage: this.state.mortgage,
    //             studentLoans: this.state.studentLoans,
    //             checking: this.state.checking,
    //             savings: this.state.savings,
    //             autoLoan: this.state.autoLoan,
    //             studentBanking: this.state.studentBanking,
    //             creditCard: this.state.creditCard,
    //             investmentAccount: this.state.investmentAccount,
    //             homeEquity: this.state.homeEquity
    //
    //         }
    //     })
    //         .then((res) => { this.setState({services: res.data})
    //         })
    // }

    handleClick() {
        axios.get('http://localhost:8080/api/branches', {
            params: {
                mortgage: this.state.mortgage,
                studentLoans: this.state.studentLoans,
                checking: this.state.checking,
                savings: this.state.savings,
                autoLoan: this.state.autoLoan,
                studentBanking: this.state.studentBanking,
                creditCard: this.state.creditCard,
                investmentAccount: this.state.investmentAccount,
                homeEquity: this.state.homeEquity

            }
        })
            .then((res) => { this.setState({branches: res.data})
            })
    }


    render() {
        return (
            <div className="container">
                    <div className="container">

                        <div className="row card">
                        <Button className='btn btn-success' onClick={this.updateMortgage} active={this.state.mortgage}>Mortgage</Button>
                        <Button className='btn btn-success' onClick={this.updateStudentLoan} active={this.state.studentLoans}>Student Loans</Button>
                        <Button className='btn btn-success' onClick={this.updateChecking} active={this.state.checking}>Checking</Button>
                        </div>

                        <br />

                        <div className="row card">
                        <Button className='btn btn-success' onClick={this.updateSavings} active={this.state.savings}>Savings</Button>
                        <Button className='btn btn-success' onClick={this.updateAutoLoan} active={this.state.autoLoan}>Auto Loan</Button>
                        <Button className='btn btn-success' onClick={this.updateCreditCard} active={this.state.creditCard}>Credit Card</Button>
                        </div>

                        <br />

                        <div className="row card">
                        <Button className='btn btn-success' onClick={this.updateStudentBanking} active={this.state.studentBanking}>Student Banking</Button>
                        <Button className='btn btn-success' onClick={this.updateInvestmentAccount} active={this.state.investmentAccount}>Investment Accounts</Button>
                        <Button className='btn btn-success' onClick={this.updateHomeEquity} active={this.state.homeEquity}>Home Equity</Button>
                        </div>

                        <br />

                    </div>
                    <br />

                        <div className="card">
                            <Button className='btn' onClick={this.handleClick}> SELECT SERVICES</Button>
                        </div>
            <br/>

                <div className="container">
                    <div className="panel panel-default p50 uth-panel">
                        <table className="table table-hover">
                            <thead>
                            <tr>
                                <th>Address</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Zipcode</th>
                                <th>Select</th>

                            </tr>
                            </thead>
                            <tbody>
                            {this.state.branches.map(b =>
                                <tr key={b.id}>
                                    <td>{b.address} </td>
                                    <td>{b.city}</td>
                                    <td>{b.state}</td>
                                    <td>{b.zipcode}</td>
                                    <td><a onClick={() => this.updateInvestmentAccount}>Edit</a>|<a>Delete</a></td>
                                </tr>
                            )}
                            </tbody>
                        </table>
                    </div>
                </div>





            </div>

        );
    }
}

export default  GoogleApiWrapper({
    apiKey: 'AIzaSyAFzSBj-bc-DyZx9NLLWY1fJxtXX1Wy80w'}) (ServiceButtons);