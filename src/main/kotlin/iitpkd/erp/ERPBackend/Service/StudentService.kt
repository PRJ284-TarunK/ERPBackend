package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.Student
import org.springframework.stereotype.Service

@Service
interface StudentService {
    fun getStudentByRollNo(rollNo: String): Student?;
}