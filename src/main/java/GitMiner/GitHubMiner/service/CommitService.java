package GitMiner.GitHubMiner.service;

import GitMiner.GitHubMiner.model.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommitService {
    
    @Autowired
    RestTemplate restTemplate;

    public List<Commit> findAllCommits(String projectAuthor, String projectName) {

        List<Commit> commits = new ArrayList<>();
        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName;

        Commit commit = restTemplate.getForObject(uri, Commit.class);
       
        commits.add(commit);

        return commits;

    }
}
