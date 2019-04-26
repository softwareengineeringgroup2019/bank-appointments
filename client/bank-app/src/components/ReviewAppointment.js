import React, { Component } from "react";
import { Link } from "react-router-dom";
import "../App.css";
import "../index.css";

class ReviewAppointment extends Component {
    render() {
        return (
            <div className="reviewAppointment">
                <div style={{
                    backgroundColor:"#006948",
                    borderRadius: "15px",
                    margin: "0 auto"
                }}>
                    {/*Review Details Goes Here*/}

                    <Link to="/" className="btn btn-success btn-lg">
                        All Done!
                    </Link>
                </div>
            </div>
        );
    }
}

export default ReviewAppointment;