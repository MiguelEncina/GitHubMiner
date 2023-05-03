package GitMiner.GitHubMiner.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import GitMiner.GitHubMiner.model.Commit;
import GitMiner.GitHubMiner.model.Issue;
import GitMiner.GitHubMiner.model.Project;
import GitMiner.GitHubMiner.model.Comment;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    public Project findProject(String projectAuthor, String projectName) {

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName;

        Project project = restTemplate.getForObject(uri, Project.class);

        Issue[] issuesArray = restTemplate.getForObject(uri + "/issues", Issue[].class);

        List<Issue> issues = Arrays.stream(issuesArray).toList();
        
        Commit[] commitsArray = restTemplate.getForObject(uri + "/commits", Commit[].class);

        List<Commit> commits = Arrays.stream(commitsArray).toList();

        // Comment[] commentArray = restTemplate.getForObject(uri + "/repository/commits/" + commitId, Comment[].class);
        
        // List<Comment> comments = new ArrayList<>();

        Arrays.stream(issuesArray).forEach(x->x.setCommentList(Arrays.stream(restTemplate.getForObject(uri + "/issues/" + x.getNumber() + "/comments", Comment[].class)).toList()));
        // Arrays.stream(issuesArray).forEach(x->x.setComments(new ArrayList<>()));

        return new Project(project.getId(), project.getName(), project.getUrl(), commits, issues);

    }
    
}