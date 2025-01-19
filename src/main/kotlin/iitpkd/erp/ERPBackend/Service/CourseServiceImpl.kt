package iitpkd.erp.ERPBackend.Service

import iitpkd.erp.ERPBackend.Model.Course
import iitpkd.erp.ERPBackend.Repository.CourseRepo
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(val courseRepo: CourseRepo): CourseService {
    override fun getAllCourses(): List<Course>? {
        val courses = courseRepo.findAll();
        if(courses.isEmpty()){
            return null;
        }
        else{
            return courses;
        }
    }
}