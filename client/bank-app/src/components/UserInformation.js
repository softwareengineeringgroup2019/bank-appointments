import React, { Component } from "react";
import  { Link } from "react-router-dom";
import '../App.css';
import '../index.css';

class UserInformation extends Component {
    render() {
        return (
            <div className="userInformation">
                <div style={{
                    backgroundColor:"#006948",
                    borderRadius: "15px",
                    margin: "0 auto"
                }}>
                    <h3 style={{}}>
                        Now we just need a few more details:
                    </h3>
                    <form>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="inputFirstName">First Name</label>
                                <input type="firstName" className="form-control" id="inputFirstName"
                                       placeholder="First Name"></input>
                            </div>
                            <div className="form-group col-md-6">
                                <label htmlFor="inputLastName">Last Name</label>
                                <input type="lastName" className="form-control" id="inputLastName"
                                       placeholder="Last Name"></input>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="inputEmail4">Email</label>
                                <input type="email" className="form-control" id="inputEmail4"
                                       placeholder="Email"></input>
                            </div>
                            <div className="form-group col-md-6">
                                <label htmlFor="inputPhoneNumber">Phone Number</label>
                                <input type="phoneNumber" className="form-control" id="inputPhoneNumber"
                                       placeholder="Phone Number"></input>
                            </div>
                        </div>
                    </form>
                    <Link to="/ReviewAppointment" className="btn btn-success btn-lg">
                        Next Step
                    </Link>
                </div>
            </div>
        );
    }
}

export default UserInformation;