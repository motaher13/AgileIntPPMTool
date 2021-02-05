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

import ProjectItem from './Project/ProjectItem';


const Dashboard=()=>{
    return(
        /* Dashboard Component (Project Item included) */

        <div className="projects">
            <div className="container">
                <div className="row">
                    <div className="col-md-12">
                        <h1 className="display-4 text-center">Projects</h1>
                        <br />
                        <a href="ProjectForm.html" className="btn btn-lg btn-info">
                            Create a Project
                        </a>
                        <br />
                        <hr />

                        <ProjectItem/>

                    </div>
                </div>
            </div>
        </div>

/* <!-- End of Dashboard Component --> */
        

    );
}

export default Dashboard