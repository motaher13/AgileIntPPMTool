import React, { Component } from 'react'

class AddProject extends Component {
    constructor(){
        /* note: */
        super();
        this.state={
            projectName: "",
            projectIdentifier: "",
            description: "",
            start_date:"",
            end_date:"" 
        };

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
        console.log(newProject);
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

export default AddProject;