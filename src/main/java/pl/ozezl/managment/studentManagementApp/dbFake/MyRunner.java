package pl.ozezl.managment.studentManagementApp.dbFake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.ozezl.managment.studentManagementApp.model.Student;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);


    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("initializing students...");

        studentRepository.save(new Student("Serega", "Serega", 1L, "Engineer", "email"));
        studentRepository.save(new Student("Jorik", "Jorikov",  1L, "Engineer", "email"));
        studentRepository.save(new Student("Vega", "Vefa",  1L, "Engineer", "email"));

        studentRepository.findAll()
                .forEach((student) -> logger.info("Initialized " + student.getFirstName()));

        logger.info("Initialization done");
    }
}
