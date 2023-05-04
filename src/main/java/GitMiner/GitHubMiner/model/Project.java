package GitMiner.GitHubMiner.model;
import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Entity
// @Table(name="projects")
public class Project {
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("commits")
    private List<Commit> commits;
    @JsonProperty("issues")
    private List<Issue> issues;

    public Project(Integer id, String name, String url, List<Commit> commits, List<Issue> issues) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.commits = commits;
        this.issues = issues;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("commits")
    public List<Commit> getCommits() {
        return commits;
    }


    @JsonProperty("commits")
    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    @JsonProperty("issues")
    public List<Issue> getIssues() {
        return issues;
    }

    @JsonProperty("issues")
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", name=" + name + ", url=" + url + ", commits=" + commits + ", issues=" + issues
                + "]";
    }

    

}
