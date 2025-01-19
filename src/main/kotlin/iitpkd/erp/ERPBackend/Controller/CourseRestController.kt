package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Response.ERPResponse
import iitpkd.erp.ERPBackend.Service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/course-registration")
@CrossOrigin(origins = ["http://localhost:4200"])
class CourseRestController(val courseService: CourseService, val objectMapper: ObjectMapper) {
    @GetMapping("/get-all-courses")
    fun getCourses(): ResponseEntity<ERPResponse> {
        val response = courseService.getAllCourses();
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERPResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), null, "No Courses Found"));
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(ERPResponse(HttpStatus.OK, HttpStatus.OK.value(), objectMapper.writeValueAsString(response), "Courses Found"));
        }
    }
}