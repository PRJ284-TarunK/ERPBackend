package iitpkd.erp.ERPBackend.Repository

import iitpkd.erp.ERPBackend.Model.Course
import org.springframework.data.mongodb.repository.MongoRepository

interface CourseRepo: MongoRepository<Course, String> {
}