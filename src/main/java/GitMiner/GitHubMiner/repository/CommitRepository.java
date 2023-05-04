package GitMiner.GitHubMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GitMiner.GitHubMiner.model.Commit;
import org.springframework.stereotype.Repository;;

@Repository
public interface CommitRepository extends JpaRepository<Commit, Long> { 
}
