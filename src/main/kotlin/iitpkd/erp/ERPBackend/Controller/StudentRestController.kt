package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Response.ERPResponse
import iitpkd.erp.ERPBackend.Service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/course-registration")
@CrossOrigin(origins = ["http://localhost:4200"])
class StudentRestController(val studentService: StudentService, val objectMapper: ObjectMapper) {

    @GetMapping("/get-student")
    fun getStudent(@RequestParam rollNo: String): ResponseEntity<ERPResponse> {
        val response = studentService.getStudentByRollNo(rollNo);
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERPResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), null, "No Student Data Found"));
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(ERPResponse(HttpStatus.OK,HttpStatus.OK.value(), objectMapper.writeValueAsString(response), "Student Data Found"));
        }
    }
}