package iitpkd.erp.ERPBackend.Repository

import iitpkd.erp.ERPBackend.Model.PreRequisite
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PreRequisiteRepo: MongoRepository<PreRequisite, String> {
//    @Query("{ 'studentRollNo': ?0, 'courseCode': ?1 }")
    fun findByStudentRollNoAndCourseCode(studentRollNo: String, courseCode: String): List<PreRequisite>?;
    fun findByStudentRollNo(studentRollNo: String): List<PreRequisite>?;
}