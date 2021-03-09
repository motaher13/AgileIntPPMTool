package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.domain.User;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import io.agileintelligence.ppmtool.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private BacklogRepository backlogRepository;
    private UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, BacklogRepository backlogRepository,UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.backlogRepository=backlogRepository;
        this.userRepository=userRepository;
    }

    public Project saveOrUpdateProject(Project project, String username){
        try {

            User user= userRepository.findByUsername(username);

            project.setUser(user);
            project.setProjectLeader(username);
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if(project.getId()==null){
                Backlog backlog=new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }else {
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return this.projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException(" Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId){
        return projectRepository.findByProjectIdentifier(projectId);
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project=projectRepository.findByProjectIdentifier(projectId);
        if(project==null){
            throw new ProjectIdException("cannot find project with id:"+projectId);
        }

        projectRepository.delete(project);
    }
}
