package GitMiner.GitHubMiner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.repository.ProjectRepository;

@RestController
@RequestMapping("")
public class ProjectController {
    
    @Autowired
    ProjectRepository repository;

    // GET http://localhost:8080/ ...


    // GET http://localhost:8080/ ... /{id}


    // POST http://localhost:8080/ ...


    // POST http://localhost:8080/ ... /{id}


    // DELETE http://localhost:8080/ ... /{id}


}
