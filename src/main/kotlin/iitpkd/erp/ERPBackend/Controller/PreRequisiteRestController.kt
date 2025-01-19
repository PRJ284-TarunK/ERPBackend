package iitpkd.erp.ERPBackend.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import iitpkd.erp.ERPBackend.Request.PreRequisiteReq
import iitpkd.erp.ERPBackend.Response.ERPResponse
import iitpkd.erp.ERPBackend.Service.PreRequisiteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/course-registration")
@CrossOrigin(origins = ["http://localhost:4200"])
class PreRequisiteRestController( val preRequisiteService: PreRequisiteService, val objectMapper: ObjectMapper) {
    @PostMapping("/create-prerequisite")
    fun createPreRequisite(@RequestBody request: PreRequisiteReq): ResponseEntity<ERPResponse> {
        val response = preRequisiteService.createPreRequisite(request);
        if(response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERPResponse(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), null, "Pre-Requisite Data Already Present"));
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(ERPResponse(HttpStatus.CREATED,HttpStatus.CREATED.value(), objectMapper.writeValueAsString(response), "Pre-Requisite Data Created Successfully"));
        }
    }
}