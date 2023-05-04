package GitMiner.GitHubMiner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.model.Issue;
import GitMiner.GitHubMiner.model.Project;
import GitMiner.GitHubMiner.repository.IssueRepository;
import GitMiner.GitHubMiner.repository.ProjectRepository;
import GitMiner.GitHubMiner.repository.UserRepository;

@RestController
@RequestMapping("/github/issues")
public class IssueController {
    
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueRepository issueRepository;

    // GET http://localhost:8080/github/issues
    @GetMapping
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    // GET http://localhost:8080/projects/{projectId}/issues
    @GetMapping("/projects/{projectId}/commits")
    public List<Issue> getAllCommitByProjectId(@PathVariable(value="projectId") long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        List<Issue> issues = new ArrayList<>(project.get().getIssues());
        return issues;
    }



}
