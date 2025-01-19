package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.PreRequisite
import iitpkd.erp.ERPBackend.Model.Student
import iitpkd.erp.ERPBackend.Repository.PreRequisiteRepo
import iitpkd.erp.ERPBackend.Repository.StudentRepo
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(val studentRepo: StudentRepo): StudentService {
    override fun getStudentByRollNo(rollNo: String): Student? {
        return studentRepo.findByRollNo(rollNo).orElse(null);
    }
}