package GitMiner.GitHubMiner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import GitMiner.GitHubMiner.service.ProjectService;
import GitMiner.GitHubMiner.model.Project;

@RestController
@RequestMapping("/github")
public class ProjectController {
    
    @Autowired
    ProjectService service;

    // GET http://localhost:8082/github/{projectAuthor}/{projectName}
    @GetMapping("/{projectAuthor}/{projectName}")
    public Project findProject(@PathVariable String projectAuthor, @PathVariable String projectName, @RequestParam(defaultValue = "2") String sinceCommits, @RequestParam(defaultValue = "20") String sinceIssues, @RequestParam(defaultValue = "2") String maxPages) {
        return service.findProject(projectAuthor, projectName, sinceCommits, sinceIssues, maxPages);
    }

    // POST http://localhost:8082/github/projects
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{projectAuthor}/{projectName}")
    public Project postProject(@PathVariable String projectAuthor, @PathVariable String projectName, @RequestParam(defaultValue = "2") String sinceCommits, @RequestParam(defaultValue = "20") String sinceIssues, @RequestParam(defaultValue = "2") String maxPages) {
        return service.loadProject(projectAuthor, projectName, sinceCommits, sinceIssues, maxPages);
    }

}
