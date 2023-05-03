package GitMiner.GitHubMiner.service;

import GitMiner.GitHubMiner.model.Commit;
import GitMiner.GitHubMiner.model.IssueSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueService {
    
    @Autowired
    RestTemplate restTemplate;

    public List<IssueSearch> findAllIssues(String projectAuthor, String projectName) {

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits";

        IssueSearch[] commitArray = restTemplate.getForObject(uri, IssueSearch[].class);
       
        return Arrays.stream(commitArray).toList();

    }

    public Commit findIssueById(String projectAuthor, String projectName, String id){

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits/" + id;
        Commit commit = restTemplate.getForObject(uri, Commit.class);
        return commit;
    }
}
