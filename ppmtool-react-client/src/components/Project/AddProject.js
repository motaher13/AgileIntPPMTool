import React, { Component } from 'react'
import PropTypes from 'prop-types'
import {connect} from 'react-redux'
import {createProject} from '../../actions/projectActions';


class AddProject extends Component {
    constructor(){
        super();
        /* note what is state, how works -> https://blog.logrocket.com/a-guide-to-usestate-in-react-ecb9952e406c/ */
        this.state={
            projectName: "",
            projectIdentifier: "",
            description: "",
            start_date:"",
            end_date:"" 
        };

        /* note: why need to bind -> https://www.freecodecamp.org/news/this-is-why-we-need-to-bind-event-handlers-in-class-components-in-react-f7ea1a6f93eb/ */
        /* note: how to convert -> https://medium.com/swlh/building-controlled-forms-using-functional-components-in-react-965d033a89bd */
        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
    }

    /* note: */
    onChange(e){
        this.setState({[e.target.name]:e.target.value});
    }

    onSubmit(e){
        e.preventDefault();
        const newProject={
            projectName: this.state.projectName,
            projectIdentifier: this.state.projectIdentifier,
            description: this.state.description,
            start_date:this.state.start_date,
            end_date:this.state.end_date 
        }
        this.props.createProject(newProject, this.props.history)
    }
    
    render(){
    return (
        
        <div>
            {/* 
                1. check name attribute input fields
                2. create constructor
                3. set state
                4. set value on input fields
                5. create onChange function
                6. set onChange on each input field
                7. bind on constructor
                8. check state change in the react extension 

             */}

            {/* Start of Project FORM */}
            <div className="project">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Create Project form</h5>
                            <hr />
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                {/* note: */}
                                    <input type="text" name="projectName" value={this.state.projectName}  onChange={this.onChange} className="form-control form-control-lg " placeholder="Project Name" />
                                </div>
                                <div className="form-group">
                                    <input type="text" name="projectIdentifier" value={this.state.projectIdentifier} onChange={this.onChange} className="form-control form-control-lg" placeholder="Unique Project ID"
                                        />
                                </div>
                                {/*  disabled for Edit Only!! remove "disabled" for the Create operation  */}
                                <div className="form-group">
                                    <textarea  name="description" value={this.state.description} onChange={this.onChange} className="form-control form-control-lg" placeholder="Project Description"></textarea>
                                </div>
                                <h6>Start Date</h6>
                                <div className="form-group">
                                    <input type="date" name="start_date"  value={this.state.start_date} onChange={this.onChange} className="form-control form-control-lg" />
                                </div>
                                <h6>Estimated End Date</h6>
                                <div className="form-group">
                                    <input type="date" name="end_date" value={this.state.end_date} onChange={this.onChange} className="form-control form-control-lg" />
                                </div>

                                <input type="submit" className="btn btn-primary btn-block mt-4" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>

             {/* END OF PROJECT FORM  */}
        </div>
        
    )}
}

/* this one is a contrains. just saying tha createProject is rquired proptype for AddProject to work properly */
AddProject.propTypes={
    createProject:PropTypes.func.isRequired
}


export default connect(null, {createProject}) (AddProject);