package io.agileintelligence.ppmtool.web;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    /* note:
    ResponseEntity helps to control json and response code
    */
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
        }
        Project project1=projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);

    }
}
