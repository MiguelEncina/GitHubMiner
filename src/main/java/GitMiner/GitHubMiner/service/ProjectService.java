package GitMiner.GitHubMiner.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import GitMiner.GitHubMiner.model.CommitSearch;
import GitMiner.GitHubMiner.model.Commit_;
import GitMiner.GitHubMiner.model.Issue;
import GitMiner.GitHubMiner.model.IssueSearch;
import GitMiner.GitHubMiner.model.Project;
import GitMiner.GitHubMiner.model.ProjectSearch;
import GitMiner.GitHubMiner.model.User_;
import GitMiner.GitHubMiner.model.Comment;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    public Project findProject(String projectAuthor, String projectName, String sinceCommits, String sinceIssues) {

        String uri = "https://api.github.com/repos/" + projectAuthor + "/" + projectName;
        String bearer = "Bearer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";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearer);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ProjectSearch project = restTemplate.exchange(uri, HttpMethod.GET, entity, ProjectSearch.class).getBody();

        List<IssueSearch> issuesArray = Arrays.stream(restTemplate.exchange(uri + "/issues", HttpMethod.GET, entity, IssueSearch[].class).getBody()).toList();

        List<Issue> issues = new ArrayList<>();

        for(int i = 0; i<issuesArray.size(); i++){
            IssueSearch a = issuesArray.get(i);
            issues.add(new Issue(a.getId().toString(), a.getNumber().toString(), a.getTitle(), a.getBody(), a.getState(), a.getCreatedAt(), a.getUpdatedAt(), a.getClosedAt(), a.getLabels().stream().map(x->x.getName()).toList(),  new User_(a.getUser().getId().toString(), a.getUser().getLogin(), a.getUser().getLogin(), a.getUser().getAvatarUrl(), a.getUser().getUrl()), a.getAssignee(), a.getReactions().getUpvotes(), a.getReactions().getDownvotes(), a.getUrl(), Arrays.stream(restTemplate.exchange(uri + "/issues/" + a.getNumber() + "/comments", HttpMethod.GET, entity, Comment[].class).getBody()).toList()));

        }
        
        List<CommitSearch> commitsArray = Arrays.stream(restTemplate.exchange(uri + "/commits", HttpMethod.GET, entity, CommitSearch[].class).getBody()).toList();
        
        List<Commit_> commits = new ArrayList<>();

        for(int i = 0; i<commitsArray.size(); i++){
            CommitSearch a = commitsArray.get(i);
            commits.add(new Commit_(a.getSha(), "", a.getCommit().getMessage(), a.getCommit().getAuthor().getName(), a.getCommit().getAuthor().getEmail(), a.getCommit().getAuthor().getDate(), a.getCommit().getCommitter().getName(), a.getCommit().getCommitter().getEmail(), a.getCommit().getCommitter().getDate(), a.getUrl()));

        }

        List<Issue> issues_ = issues.stream()
        .filter(i -> {
            String[] s1 = i.getUpdatedAt().split("T");
            String[] s2 = s1[0].split("-");
            LocalDate last = LocalDate.of(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
            Integer difDias = LocalDate.now().getDayOfYear() - last.getDayOfYear();
            return (last.getYear()==LocalDate.now().getYear() && difDias <= Integer.parseInt(sinceIssues) && difDias >= 0);
        }).toList();


        List<Commit_> commits_ = commits.stream()
        .filter(c -> {
            String[] s1 = c.getCommittedDate().split("T");
            String[] s2 = s1[0].split("-");
            LocalDate last = LocalDate.of(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
            Integer difDias = LocalDate.now().getDayOfYear() - last.getDayOfYear();
            return (last.getYear()==LocalDate.now().getYear() && difDias <= Integer.parseInt(sinceCommits) && difDias >= 0);
        }).toList();

        return new Project(project.getId().toString(), project.getName(), project.getUrl(), commits_, issues_);

    }
    
    public Project loadProject(String projectAuthor, String projectName, String sinceCommits, String sinceIssues) {
        Project project = findProject(projectAuthor, projectName, sinceCommits, sinceIssues);
        HttpEntity<Project> request = new HttpEntity<Project>(project);
        ResponseEntity<Project> response = restTemplate.exchange("http://localhost:8080/gitminer/projects", HttpMethod.POST, request, Project.class);
        return response.getBody();
    }


}