import React from 'react'
import {Link} from "react-router-dom"


/* note: type rfc and tab to get functional component */
const CreateProjectButton = () => {
    return (
        /* note: all elements must be wrapped with a html element, which Link is not. but without
            adding another div, we could use React.Fragment, which is invisible, but do the trick */
        <React.Fragment>
        {/* note: cant use <a> in jsx. use <Link>  */}
        <Link to="/addProject" className="btn btn-lg btn-info">
                            Create a Project
                        </Link>
        </React.Fragment>
        
    )
}

export default CreateProjectButton;