package GitMiner.GitHubMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GitMiner.GitHubMiner.model.User;
import org.springframework.stereotype.Repository;;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { 
}
