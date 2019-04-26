import {ToggleButton, ToggleButtonGroup} from "react-bootstrap";
import React, {Component} from 'react'
import axios from "axios/index";

class ServiceButtons extends React.Component {
    constructor(props, context) {
        super(props, context);


        this.onChange = this.onChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.updateMortgage = this.updateMortgage.bind(this);
        this.updateStudentLoan = this.updateStudentLoan.bind(this);
        this.updateChecking = this.updateChecking.bind(this);

        // this.onSubmit = this.onSubmit.bind(this);
        this.state = {
            services: [],
            mortgage: true,
            studentLoans: true,
            checking: true,
            savings: true,
            autoLoan: true,
            studentBanking: true,
            creditCard: true,
            homeEquity: true,
            investmentAccount: true,
        };
    }

    // *******THIS WORKS!!!
    // handleClick() {
    //     this.setState(prevState => ({
    //         mortgage: !prevState.mortgage,
    //         studentLoans: !prevState.studentLoans
    //     }));
    //     axios.get('http://localhost:8080/api/services', {
    //         params: {
    //             mortgage: this.state.mortgage,
    //             studentLoans: this.state.studentLoans
    //         }
    //     })
    //         .then((res) => {
    //             this.setState({services: res.data})
    //         })
    //
    // }

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


    onChange(value) {
        this.setState({ value });
    }




    handleClick() {
        axios.get('http://localhost:8080/api/services', {
            params: {
                mortgage: this.state.mortgage,
                studentLoans: this.state.studentLoans,
                checking: this.state.checking
            }
        })
            .then((res) => { this.setState({services: res.data})
            })
    }


    render() {
        return (
            <div className="container">

                    <div className="container">
                        <button className='btn btn-success' onClick={this.updateMortgage}>Mortgage</button>
                        <button className='btn btn-success' onClick={this.updateStudentLoan}>Student Loans</button>
                        <button className='btn btn-success' onClick={this.updateChecking}>Checking</button>




                    </div>
                    <br />
                        <div>
                            <button onClick={this.handleClick}> Select</button>

                        </div>
                <div>
                    <ul>
                        {this.state.services.map(s => <li>
                            <p>ID: {s.id.toString()}, {s.checking.toString()}, {s.savings.toString()}, {s.creditCard.toString()}, {s.mortgage.toString()}
                            </p>
                        </li>)}
                    </ul>
                </div>


            </div>


        );
    }
}

export default ServiceButtons;