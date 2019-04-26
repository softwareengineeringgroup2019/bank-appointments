import React, { Component } from 'react';
import './App.css';
import "react-router-dom"
import "bootstrap/dist/css/bootstrap.min.css"
import axios from "axios";
import Navbar from "./components/Navbar";
import ProjectBoard from "./components/ProjectBoard";
import {BrowserRouter as Router, Route} from "react-router-dom"
import AddProjectTask from "./components/ProjectTask/AddProjectTask";
import Services from "./components/Services";
import Locations from "./components/Locations";





class App extends Component {

    render() {
        return (
            <Router>
            <div className="App">
                <Navbar />
                <Route exact path="/" component={Services}/>
                <Route exact path="/locations" component={Locations}/>
                {/*<Route exact path="/" component={ProjectBoard} />*/}
                {/*<Route exact path="/addProjectTask" component={AddProjectTask} />*/}
            </div>
            </Router>






        );
    }
}

export default App;
