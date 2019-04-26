import React, { Component } from 'react'
import { Link } from "react-router-dom"

class FindService extends Component {

    constructor() {
        super()
        this.state = {
            summary: "",
            acceptanceCriteria: "",
            status: "",
            checking: "",

        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);



    }

    onChange(e){
        this.setState({[e.target.name]: e.target.value})
    }

    onSubmit(e){
        e.preventDefault()
        const newProjectTask = {
            summary: this.state.summary,
            acceptanceCriteria: this.state.acceptanceCriteria,
            status: this.state.status,
            checking: this.state.checking,

        };
        console.log(newProjectTask);
    }

    render() {
        return(
            <div className="addProjectTask">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <Link to="/" className="btn btn-light">
                                Back to Board
                            </Link>
                            <h4 className="display-4 text-center">Add /Update Project Task</h4>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <select className="form-control form-control-lg" name="checking" value={this.state.checking} onChange={this.onChange}>
                                        <option value="">Select Status</option>
                                        <option value="true">true</option>
                                        <option value="false">false</option>

                                    </select>
                                </div>
                                <input type="submit" className="btn btn-primary btn-block mt-4"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default FindService;