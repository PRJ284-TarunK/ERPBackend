package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Service.CourseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/course-registration")
class CourseRestController(val courseService: CourseService, val objectMapper: ObjectMapper) {
    @Operation(summary = "Get all the courses", description = "Fetch a list of all available courses")
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
                                    "[{\"courseId\":\"678a43cb0c6edaba501f64c6\",\"courseCode\":\"CS2030\",\"title\":\"Data Structures and Algorithms\",\"credits\":\"3-0-0-3\",\"programCode\":\"BTECH-CS\",\"isCore\":true,\"isElective\":false,\"electiveCategory\":\"\",\"quota\":60,\"courseLevel\":2,\"syllabusLink\":\"https://cse.iitpkd.ac.in/courses/cs2030-Data-Structures-and-Algorithms/\",\"slot\":\"B\",\"instructor\":[\"Krithika Ramaswamy\"],\"textBooks\":[],\"referenceBooks\":[],\"preRequisites\":{\"orClause\":[],\"notClause\":[]},\"coRequisites\":{\"orClause\":[],\"notClause\":[]}}, {\"courseId\":\"678a43cb0c6edaba501f64c7\",\"courseCode\":\"CS2060\",\"title\":\"Computer Organisation\",\"credits\":\"3-0-0-3\",\"programCode\":\"BTECH-CS\",\"isCore\":true,\"isElective\":false,\"electiveCategory\":\"\",\"quota\":60,\"courseLevel\":2,\"syllabusLink\":\"http://example.com/cs2060/syllabus\",\"slot\":\"G\",\"instructor\":[\"Sandeep Chandran\"],\"textBooks\":[],\"referenceBooks\":[],\"preRequisites\":{\"orClause\":[\"CS3020\",\"CS2130\",\"CS2030\"],\"notClause\":[\"CS2030\"]},\"coRequisites\":{\"orClause\":[],\"notClause\":[]}}]"
                                """
                        )
                    ]
                )
            ]),
            ApiResponse(responseCode = "404", description = "No courses found", content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "Fetching Failure/Not Found Response",
                            summary = "Sample of Failure response",
                            value = """
                                    "No Courses Found"
                                """
                        )
                    ]
                )
            ])
        ]
    )
    @GetMapping("/get-all-courses")
    fun getCourses(@RequestParam version: String?): ResponseEntity<*> {
        if(version == "v1"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad-Request (versioning doesn't exist)");
        }
        val response = courseService.getAllCourses();
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Courses Found");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(response));
        }
    }
}