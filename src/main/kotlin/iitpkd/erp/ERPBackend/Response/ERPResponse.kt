package iitpkd.erp.ERPBackend.Response

import org.springframework.http.HttpStatus

class ERPResponse (
    val status: HttpStatus,
    val statusCode: Int,
    val data: String?,
    val message: String
)