package GitMiner.GitHubMiner;

// import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import GitMiner.GitHubMiner.model.Project;
import GitMiner.GitHubMiner.service.ProjectService;

@SpringBootTest
class GitHubMinerApplicationTests {

	@Autowired
	ProjectService service;

	// @Test
	// @DisplayName("Todos los commit")
	// void findAllCommits() {
	// 	List<Commit> commits = service.findAllCommits("spring-projects", "spring-framework");
	// 	System.out.println(commits);
	// }

	// @Test
	// @DisplayName("Un solo commit")
	// void findCommit(){
	// 	CommitSearch commit = service.findCommit("spring-projects", "spring-framework", "ca13b5cbca078002acaee1d095134644a4efded9");
	// 	System.out.println(commit);
	// }

	@Test
	void findProject(){
		Project project = service.findProject("spring-projects", "spring-framework", "2", "1");
		System.out.println(project);
	}

}
