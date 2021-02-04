package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domain.Project;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.repository.CrudRepository;

@Reference
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectId);


}
