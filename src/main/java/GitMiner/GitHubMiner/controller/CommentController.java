package GitMiner.GitHubMiner.controller;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.model.Comment;
import GitMiner.GitHubMiner.model.Issue;
import GitMiner.GitHubMiner.repository.CommentRepository;
import GitMiner.GitHubMiner.repository.IssueRepository;
import GitMiner.GitHubMiner.repository.UserRepository;

@RestController
@RequestMapping("/github/comments")
public class CommentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    CommentRepository commentRepository;

    // GET http://localhost:8080/github/comments
    @GetMapping
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    // GET http://localhost:8080/project/issue/{issueId}/commets
    @GetMapping("/issue/{projectId}/commits")
    public List<Comment> getAllCommitByProjectId(@PathVariable(value="projectId") long projectId) {
        Optional<Issue> issue = issueRepository.findById(projectId);
        // List<Comment> comments = new ArrayList<>(issue.get().getComments());
        List<Comment> comments = issue.get().getCommentList();
        return comments;
    }


}
