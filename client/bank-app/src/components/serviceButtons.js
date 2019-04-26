import {ToggleButton, ToggleButtonGroup} from "react-bootstrap";
import React, {Component} from 'react'
import {Link} from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCreditCard, faMoneyBillWave, faCar, faGraduationCap, faHome, faChartBar, faPiggyBank, faWallet, faBriefcase} from '@fortawesome/free-solid-svg-icons';

class ServiceButtons extends Component {
    constructor(props, context) {
        super(props, context);

        this.onChange = this.onChange.bind(this);
        // this.onSubmit = this.onSubmit.bind(this);

        this.state = {
            value: [0, 10],
        };
    }

    onS

    onChange(value, event) {
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
            <div>
            <div className="container card">
                <ToggleButtonGroup vertical
                                   type="checkbox"
                                   value={this.state.value}
                                   onChange={this.onChange}
                                   size = "lg"

                >
                    <ToggleButton variant="success" value={1}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faMoneyBillWave}/><br></br>Checking</ToggleButton>
                    <ToggleButton variant="success" value={2}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faPiggyBank}/><br></br>Savings</ToggleButton>
                    <ToggleButton variant="success" value={3}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faCreditCard}/><br></br>Credit Card</ToggleButton>
                    <ToggleButton variant="success" value={4}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faCar}/><br></br>Auto Loan</ToggleButton>
                    <ToggleButton variant="success" value={5}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faHome}/><br></br>Mortgage</ToggleButton>
                    <ToggleButton variant="success" value={6}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faGraduationCap}/><br></br>Student Loans</ToggleButton>
                    <ToggleButton variant="success" value={7}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faChartBar}/><br></br>Home Equity</ToggleButton>
                    <ToggleButton variant="success" value={8}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faWallet}/><br></br>Student Banking</ToggleButton>
                    <ToggleButton variant="success" value={9}>
                        <FontAwesomeIcon size='2x' color="white" onClick={this.handleClick}
                                         icon={faBriefcase}/><br></br>Investment Accounts</ToggleButton>

                </ToggleButtonGroup>

                {/*<form onSubmit={this.onSubmit}>*/}
                {/*<label>*/}
                {/*City:<input type="text" value={this.state.city} onChange={this.onChange} name="city" />*/}
                {/*</label>*/}
                {/*<input type="submit" value="Submit"/>*/}

                {/*</form>*/}


            </div>
                <Link to="/MapsAppointment" className="btn btn-success btn-lg">
                    Next Step
                </Link>
            </div>


        );
    }
}

export default ServiceButtons;