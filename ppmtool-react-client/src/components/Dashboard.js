// note: {} necessary to import from a file, not {} means the export was default

// import React from 'react'

// note: default means no {} would be necessary to import it. only one default could
// be declared in a file

// note: following is a class based component
// write 'rcc' and tab
// it takes properties and uses 'lifecycle hooks' from React
// 
// note: jsx-> xml/html like syntax to write inside js

/* class Dashboard extends Component {
    render() {
        return (
            <h1>Welcome to Dashboard</h1>
        )
    } 
} */

import CreateProjectButton from './Project/CreateProjectButton';
import ProjectItem from './Project/ProjectItem';
import { connect } from "react-redux";
import { getProjects } from "../actions/projectActions";
import { Component } from 'react';
import PropTypes from "prop-types";

class Dashboard extends Component{

    componentDidMount(){
        /* note: calls getProjects() in projectAction.js on mount */
        this.props.getProjects();
    }

    render(){

        const {projects} = this.props.project;

        /* Dashboard Component (Project Item included) */
        return(

            <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Projects</h1>
                            <br />
                            <CreateProjectButton/>
                            <br />
                            <hr />
                            {
                                projects.map(project=>(
                                    <ProjectItem key={project.id} project={project}/>
                                ))
                            }
                            

                        </div>
                    </div>
                </div>
            </div>

    /* <!-- End of Dashboard Component --> */
            

        );
    }
}

Dashboard.propTypes={
    project:PropTypes.object.isRequired, /* note: means project prop must be object and required */
    getProjects:PropTypes.func.isRequired
}



const mapStateToProps = state =>({ 
    /* we are mapping state values to prop values -> the value those will be passed to childs */
    project : state.project,

})

export default connect(mapStateToProps, {getProjects})(Dashboard) 