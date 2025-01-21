package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.PreRequisite
import iitpkd.erp.ERPBackend.Request.PreRequisiteReq
import org.springframework.stereotype.Service

@Service
interface PreRequisiteService {
    fun createPreRequisite(request: PreRequisiteReq): PreRequisite?;
    fun getPreRequisitesByStudentRollNo(studentRollNo: String): List<PreRequisite>?;
}