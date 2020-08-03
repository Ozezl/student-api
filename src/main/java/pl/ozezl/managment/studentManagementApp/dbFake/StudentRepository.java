package pl.ozezl.managment.studentManagementApp.dbFake;

import org.springframework.data.repository.CrudRepository;
import pl.ozezl.managment.studentManagementApp.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
