package iitpkd.erp.ERPBackend.Model

import iitpkd.erp.ERPBackend.Utility.CourseUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Courses")
class Course(
    @Id
    @Field("_id")
    var courseId: String?,
    var courseCode: String?,
    var title: String?,
    var credits: String?,
    var programCode: String?,
    var isCore: Boolean?,
    var isElective: Boolean?,
    var electiveCategory: String?,
    var quota: Number?,
    var courseLevel: Number?,
    var syllabusLink: String?,
    var slot: String?,
    var instructor: List<String>?,
    var textBooks: List<String>?,
    var referenceBooks: List<String>?,
    var preRequisites: CourseUtil.Requisites?,
    var coRequisites: CourseUtil.Requisites?,
)