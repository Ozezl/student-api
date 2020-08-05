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

        studentRepository.save(new Student("Bugs", "Bunny",  2L, "Advanced Physics", "Bunny@email.com"));
        studentRepository.save(new Student("Donald", "Duck", 1L, "Finances", "Duck@email.com"));
        studentRepository.save(new Student("Scooby", "Doo",  1L, "Management", "Doo@email.com"));
        studentRepository.save(new Student("SpongeBob", "SquarePants",  1L, "Electrical Engineer", "SquarePants@email.com"));
        studentRepository.save(new Student("Duffy", "Duck", 3L, "Computer Science", "DDuck@email.com"));
        studentRepository.save(new Student("Tom", "Cat",  1L, "Languages", "Cat@email.com"));
        studentRepository.save(new Student("Mickey", "Mouse",  4L, "Statistics", "Mouse@email.com"));
        studentRepository.save(new Student("Jerry", "Mouse", 2L, "Languages", "JMouse@email.com"));
        studentRepository.save(new Student("Patric", "Star",  1L, "International Relations", "Star@email.com"));
        studentRepository.save(new Student("Woody", "Woodpecker",  1L, "Civil Engineer", "Woodpecker@email.com"));
        studentRepository.save(new Student("Scrooge", "McDuck", 6L, "Business", "McDuck@email.com"));
        studentRepository.save(new Student("Squidward", "Tentacles",  4L, "Humanistic", "Tentacles@email.com"));

        studentRepository.findAll()
                .forEach((student) -> logger.info("Initialized " + student.getFirstName()));

        logger.info("Initialization done");
    }
}
