package net.honux.springbootdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@SpringBootTest
public class ProjectTest {

    Logger logger = LoggerFactory.getLogger(ProjectTest.class);
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void read() {
        Project project = projectRepository.findById(1L).get();
        logger.info("project: {}", project);
        User user = userRepository.findById(1L).get();
        Set<WorksOn> ws = user.getWorksOn();
        for(WorksOn w: ws) {
            Project p = projectRepository.findById(w.getProjectId()).get();
            logger.info("I go him: {}", p);
        }
    }
}
