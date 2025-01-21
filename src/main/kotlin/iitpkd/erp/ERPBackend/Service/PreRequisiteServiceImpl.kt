package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.PreRequisite
import iitpkd.erp.ERPBackend.Repository.PreRequisiteRepo
import iitpkd.erp.ERPBackend.Request.PreRequisiteReq
import org.springframework.stereotype.Service

@Service
class PreRequisiteServiceImpl(val preRequisiteRepo: PreRequisiteRepo): PreRequisiteService {
    override fun createPreRequisite(request: PreRequisiteReq): PreRequisite? {
//        val existingPreRequisite = preRequisiteRepo.findByStudentRollNoAndCourseCode(request.studentRollNo, request.courseCode);
//        if(existingPreRequisite.isPresent && existingPreRequisite.get().filter { item-> item.preRequisiteStatus!="REJECTED" }.isNotEmpty()){
//            return null;
//        }
//        else{
            val newPreRequisite = PreRequisite(
                preRequisiteId = null,
                studentRollNo = request.studentRollNo,
                courseCode = request.courseCode,
                preRequisiteReason = request.preRequisiteReason,
                preRequisiteStatus = "APPLIED"
            )
            return preRequisiteRepo.save(newPreRequisite);
//        }
    }

    override fun getPreRequisitesByStudentRollNo(studentRollNo: String): List<PreRequisite>? {
        val existingPreRequisites = preRequisiteRepo.findByStudentRollNo(studentRollNo);
        val res = existingPreRequisites?.filter { item-> item.preRequisiteStatus!="REJECTED" };
        if(res?.size!=0){
            return res;
        }
        else{
            return null;
        }
    }
}