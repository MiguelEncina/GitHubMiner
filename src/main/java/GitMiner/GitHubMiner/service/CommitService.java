package GitMiner.GitHubMiner.service;

import GitMiner.GitHubMiner.model.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    
    @Autowired
    RestTemplate restTemplate;

    public List<Commit> findAllCommits(String projectAuthor, String projectName) {

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits";

        Commit[] commitArray = restTemplate.getForObject(uri, Commit[].class);
       
        return Arrays.stream(commitArray).toList();

    }

    public Commit findCommit(String projectAuthor, String projectName, String id){

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName + "/commits/" + id;
        Commit commit = restTemplate.getForObject(uri, Commit.class);
        return commit;
    }
}
