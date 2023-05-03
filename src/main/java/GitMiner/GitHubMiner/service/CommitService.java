package GitMiner.GitHubMiner.service;

import GitMiner.GitHubMiner.model.CommitSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    
    @Autowired
    RestTemplate restTemplate;

    public List<CommitSearch> findAllCommits(String projectAuthor, String projectName) {

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits";

        CommitSearch[] commitArray = restTemplate.getForObject(uri, CommitSearch[].class);
       
        return Arrays.stream(commitArray).toList();

    }

    public CommitSearch findCommit(String projectAuthor, String projectName, String id){

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits/" + id;
        CommitSearch commit = restTemplate.getForObject(uri, CommitSearch.class);
        return commit;
    }
}
