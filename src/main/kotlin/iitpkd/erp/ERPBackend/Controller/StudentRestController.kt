package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Service.StudentService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course-registration")
class StudentRestController(val studentService: StudentService, val objectMapper: ObjectMapper) {

    @Operation(summary = "Get Student Info", description = "Fetch the student info by RollNo")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Fetching", content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "Fetching Success Response",
                            summary = "Sample of successful response",
                            value = """
                                    "{\"studentId\":\"6789446d59f3134361c29b98\",\"rollNo\":\"112201017\",\"isEligible\":true,\"totalCredits\":18.0,\"completedCourses\":[\"CS2030\",\"CS2060\"],\"electiveRange\":[{\"max\":4,\"min\":2,\"code\":\"PME\"},{\"max\":2,\"min\":1,\"code\":\"HSE\"}],\"creditRange\":{\"min\":18,\"max\":24}}"
                                """
                        )
                    ]
                )
            ]),
            ApiResponse(responseCode = "404", description = "No Student Data found", content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "Fetching Failure/Not Found Response",
                            summary = "Sample of Failure response",
                            value = """
                                    "No Student Data Found"
                                """
                        )
                    ]
                )
            ])
        ]
    )
    @GetMapping("/get-student")
    fun getStudent(@RequestParam rollNo: String, @RequestParam version: String?): ResponseEntity<*> {
        if(version == "v1"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad-Request (versioning doesn't exist)");
        }
        val response = studentService.getStudentByRollNo(rollNo);
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Student Data Found");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(response));
        }
    }
}