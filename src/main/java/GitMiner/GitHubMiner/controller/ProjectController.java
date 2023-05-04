package GitMiner.GitHubMiner.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import GitMiner.GitHubMiner.repository.ProjectRepository;
import GitMiner.GitHubMiner.model.Project;

@RestController
@RequestMapping("/github/projects")
public class ProjectController {
    
    @Autowired
    ProjectRepository repository;

    // GET http://localhost:8080/github/projects
    @GetMapping
    public List<Project> findAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/github/projects/{id}
    @GetMapping("/{id}")
    public Project findOne(@PathVariable long id) {
        Optional<Project> project = repository.findById(id);
        return project.get();
    }

    // POST http://localhost:8080/github/projects
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@Valid @RequestBody Project project) {
        Project _project = repository
            .save(new Project(null, project.getName(), null, null, null));
        return _project;
    }

}
