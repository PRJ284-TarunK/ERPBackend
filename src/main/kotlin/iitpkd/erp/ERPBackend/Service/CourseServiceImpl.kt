package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Repository.CourseRepo
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(val courseRepo: CourseRepo): CourseService {
    override fun getAllCourses() = courseRepo.findAll();
}