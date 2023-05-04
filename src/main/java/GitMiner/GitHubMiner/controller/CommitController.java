package GitMiner.GitHubMiner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.model.Commit;
import GitMiner.GitHubMiner.model.Project;
import GitMiner.GitHubMiner.repository.CommitRepository;
import GitMiner.GitHubMiner.repository.ProjectRepository;

@RestController
@RequestMapping("/github/commits")
public class CommitController {
    
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CommitRepository commitRepository;

    // GET http://localhost:8080/github/commits
    @GetMapping
    public List<Commit> findAll() {
        return commitRepository.findAll();
    }

    // GET http://localhost:8080/projects/{projectId}/commits
    @GetMapping("/projects/{projectId}/commits")
    public List<Commit> getAllCommitByProjectId(@PathVariable(value="projectId") long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        List<Commit> commits = new ArrayList<>(project.get().getCommits());
        return commits;
    }

}
