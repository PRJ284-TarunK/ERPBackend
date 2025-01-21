package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Request.PreRequisiteReq
import iitpkd.erp.ERPBackend.Service.PreRequisiteService
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
class PreRequisiteRestController( val preRequisiteService: PreRequisiteService, val objectMapper: ObjectMapper) {

    @Operation(summary = "Create Pre-Requisite", description = "Create Pre-Requisite for a particular course")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Successful Creation", content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "Creation Success Response",
                            summary = "Sample of successful response",
                            value = """
                                    "{\"preRequisiteId\":\"678e09f46e1e78737a3b3cf0\",\"studentRollNo\":\"112201017\",\"courseCode\":\"CS2060\",\"preRequisiteReason\":\"I have some prior knowledge of this course\",\"preRequisiteStatus\":\"APPLIED\"}"
                                """
                        )
                    ]
                )
            ])
        ]
    )
    @PostMapping("/create-prerequisite")
    fun createPreRequisite(@RequestBody request: PreRequisiteReq, @RequestParam version: String?): ResponseEntity<*> {
        if(version == "v1"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad-Request (versioning doesn't exist)");
        }
        val response = preRequisiteService.createPreRequisite(request);
//        if(response==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pre-Requisite Data Already Present");
//        }
//        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(objectMapper.writeValueAsString(response));
//        }
    }

    @Operation(summary = "Get Pre-Requisites", description = "Fetch all Pre-Requisites for a particular student")
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
                                    "[{\"preRequisiteId\":\"678dd5739ad6df0281896b00\",\"studentRollNo\":\"112201017\",\"courseCode\":\"CS2130\",\"preRequisiteReason\":\"I have some basic knowledge\",\"preRequisiteStatus\":\"REJECTED\"},{\"preRequisiteId\":\"678dd68c9ad6df0281896b01\",\"studentRollNo\":\"112201017\",\"courseCode\":\"CS2130\",\"preRequisiteReason\":\"Hi\",\"preRequisiteStatus\":\"APPLIED\"},{\"preRequisiteId\":\"678e09f46e1e78737a3b3cf0\",\"studentRollNo\":\"112201017\",\"courseCode\":\"CS2060\",\"preRequisiteReason\":\"I have some prior knowledge of this course\",\"preRequisiteStatus\":\"APPLIED\"}]"
                                """
                        )
                    ]
                )
            ]),
            ApiResponse(responseCode = "404", description = "No Pre-Requisite Found", content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "Fetching Failure/Not Found Response",
                            summary = "Sample of Failure response",
                            value = """
                                    "No Pre-Requisite Data Found"
                                """
                        )
                    ]
                )
            ])
        ]
    )
    @GetMapping("/get-prerequisites")
    fun getPreRequisite(@RequestParam studentRollNo: String, @RequestParam version: String?): ResponseEntity<*> {
        if(version == "v1"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad-Request (versioning doesn't exist)");
        }
        val response = preRequisiteService.getPreRequisitesByStudentRollNo(studentRollNo);
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Pre-Requisite Data Found");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(response));
        }
    }
}