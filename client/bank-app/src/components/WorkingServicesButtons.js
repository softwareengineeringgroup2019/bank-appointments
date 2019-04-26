import {ToggleButton, ToggleButtonGroup} from "react-bootstrap";
import React, {Component} from 'react'
import axios from "axios/index";

class ServiceButtons extends React.Component {
    constructor(props, context) {
        super(props, context);


        this.onChange = this.onChange.bind(this);
        this.handleClick = this.handleClick.bind(this);

        // this.onSubmit = this.onSubmit.bind(this);
        this.state = {
            services: [],
            mortgage: true,

        };
    }

    // componentDidMount() {
    //     axios.get('http://localhost:8080/api/services?mortgage=true', {})
    //         .then((res) => {
    //             this.setState({services: res.data})
    //         })
    // }

    handleClick() {
        this.setState(prevState => ({
            mortgage: !prevState.mortgage
        }));
        axios.get('http://localhost:8080/api/services?mortgage=' + this.state.mortgage, {})
            .then((res) => {
                this.setState({services: res.data})
            })

    }

    handleArrayClick() {
        axios.post('http://localhost:8080/api/services', {
            array: this.props.rows
        })
    }




    onChange(value) {
        this.setState({ value });
    }



    //
    // onSubmit(e) {
    //     e.preventDefault()
    //     axios.post('localhost8080')
    //
    // }


    render() {
        return (
            <div className="container card">
                <ToggleButtonGroup vertical
                                   type="checkbox"
                                   value={this.state.value}
                                   onChange={this.onChange}
                                   size = "lg"

                >
                    <ToggleButton variant="success" value={"checking"}><i className="fas fa-piggy-bank"> Checking</i> </ToggleButton>
                    <ToggleButton variant="success" value={"savings"}>Savings</ToggleButton>
                    <ToggleButton variant="success" value={"credit_card"}>Credit Card</ToggleButton>
                    <ToggleButton variant="success" value={"auto_loan"}>Auto Loan</ToggleButton>
                    <ToggleButton variant="success" value={"mortgage"}>Mortgage</ToggleButton>
                    <ToggleButton variant="success" value={"student_loans"}>Student Loans</ToggleButton>
                    <ToggleButton variant="success" value={"home_equity"}>Home Equity</ToggleButton>
                    <ToggleButton variant="success" value={"student_banking"}>Student Banking</ToggleButton>
                    <ToggleButton variant="success" value={"investment_accounts"}>Investment Accounts</ToggleButton>

                </ToggleButtonGroup>

                <div>
                    <div>
                        <button onClick={this.handleClick}>Mortgage</button>
                    </div>

                    <br />

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