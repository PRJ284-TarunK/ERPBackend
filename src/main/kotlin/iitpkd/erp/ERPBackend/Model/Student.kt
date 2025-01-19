package iitpkd.erp.ERPBackend.Model

import iitpkd.erp.ERPBackend.Utility.StudentUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "Student")
class Student (
    @Id
    @Field("_id")
    var studentId: String,
    var rollNo: String,
    var isEligible: Boolean,
    var totalCredits: Float,
    var completedCourses: List<String>?,
    var electiveRange: List<StudentUtil.ElectiveRange>,
    var creditRange: StudentUtil.CreditRange
)
