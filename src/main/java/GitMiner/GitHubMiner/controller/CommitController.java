package GitMiner.GitHubMiner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.repository.CommitRepository;
import GitMiner.GitHubMiner.repository.ProjectRepository;

@RestController
@RequestMapping("")
public class CommitController {
    
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CommitRepository commitRepository;

    // GET http://localhost:8080/ ...


    // GET http://localhost:8080/ ...


    // POST http://localhost:8080/ ...


    // POST http://localhost:8080/ ...


    // DELETE http://localhost:8080/ ...


}
