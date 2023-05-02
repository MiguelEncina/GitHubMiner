package GitMiner.GitHubMiner;

// import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import GitMiner.GitHubMiner.model.Commit;
import GitMiner.GitHubMiner.service.CommitService;

@SpringBootTest
class GitHubMinerApplicationTests {

	@Autowired
	CommitService service;

	// @Test
	// @DisplayName("Todos los commit")
	// void findAllCommits() {
	// 	List<Commit> commits = service.findAllCommits("spring-projects", "spring-framework");
	// 	System.out.println(commits);
	// }

	@Test
	@DisplayName("Un solo commit")
	void findCommit(){
		Commit commit = service.findCommit("spring-projects", "spring-framework", "ca13b5cbca078002acaee1d095134644a4efded9");
		System.out.println(commit);
	}

}
