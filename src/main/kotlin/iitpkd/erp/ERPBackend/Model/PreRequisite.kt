package iitpkd.erp.ERPBackend.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "PreRequisites")
class PreRequisite (
    @Id
    @Field("_id")
    var preRequisiteId: String? = null,
    var studentRollNo: String,
    var courseCode: String,
    var preRequisiteReason: String,
    var preRequisiteStatus: String,
)