package GitMiner.GitHubMiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GitMiner.GitHubMiner.model.Comment;
import org.springframework.stereotype.Repository;;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{ 
}
