package GitMiner.GitHubMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GitMiner.GitHubMiner.model.Project;
import org.springframework.stereotype.Repository;;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
