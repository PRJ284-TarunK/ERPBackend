package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.Course
import org.springframework.stereotype.Service

@Service
interface CourseService {
    fun getAllCourses(): List<Course>?;
}