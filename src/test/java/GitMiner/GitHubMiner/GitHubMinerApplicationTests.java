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

	@Test
	void findProject(){
		Project project = service.findProject("spring-projects", "spring-framework", "2", "1", "2");
		System.out.println(project);
	}

}
