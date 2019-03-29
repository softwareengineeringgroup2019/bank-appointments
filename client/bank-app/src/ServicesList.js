import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';


class ServicesList extends Component {

    constructor(props) {
        super(props);
        this.state = {services: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/services')
            .then(response => response.json())
            .then(data => this.setState({services: data, isLoading: false}));
    }

}