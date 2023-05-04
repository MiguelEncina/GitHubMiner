package GitMiner.GitHubMiner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitMiner.GitHubMiner.repository.CommentRepository;
import GitMiner.GitHubMiner.repository.IssueRepository;
import GitMiner.GitHubMiner.repository.UserRepository;

@RestController
@RequestMapping("")
public class CommentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    CommentRepository commentRepository;

    // GET http://localhost:8080/ ...


    // GET http://localhost:8080/ ...


    // POST http://localhost:8080/ ...


    // POST http://localhost:8080/ ...


    // DELETE http://localhost:8080/ ...


}
