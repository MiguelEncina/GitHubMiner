package GitMiner.GitHubMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GitMiner.GitHubMiner.model.Issue;
import org.springframework.stereotype.Repository;;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
