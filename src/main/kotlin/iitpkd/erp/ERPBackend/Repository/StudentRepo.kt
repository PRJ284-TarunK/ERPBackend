package iitpkd.erp.ERPBackend.Repository

import iitpkd.erp.ERPBackend.Model.Student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StudentRepo: MongoRepository<Student, String> {
    fun findByRollNo(rollNo: String): Optional<Student>;
}