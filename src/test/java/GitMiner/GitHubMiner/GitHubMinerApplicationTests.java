package GitMiner.GitHubMiner;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import GitMiner.GitHubMiner.model.Commit;
import GitMiner.GitHubMiner.service.CommitService;

@SpringBootTest
class GitHubMinerApplicationTests {

	@Autowired
	CommitService service;

	@Test
	void findAllCommits() {
		List<Commit> commits = service.findAllCommits("spring-projects", "spring-framework");
		System.out.println(commits);
	}

}
