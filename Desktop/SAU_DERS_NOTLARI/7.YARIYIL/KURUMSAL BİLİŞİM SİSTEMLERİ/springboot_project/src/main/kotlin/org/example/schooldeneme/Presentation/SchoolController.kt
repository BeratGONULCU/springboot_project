package org.example.schooldeneme.Presentation

import jakarta.persistence.Id
import org.example.schooldeneme.Service.ISchoolService
import org.example.schooldeneme.dto.Request.SchoolRequest
import org.example.schooldeneme.dto.Response.SchoolResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/school")

class SchoolController (private val schoolService: ISchoolService) {
@PostMapping
fun createSchool(@RequestBody req : SchoolRequest) : ResponseEntity<SchoolResponse> {
    val savedSchool = schoolService.createSchool(req)
    return ResponseEntity(savedSchool, HttpStatus.CREATED)
}

@GetMapping
fun receiveAllSchools() : ResponseEntity<List<SchoolResponse>> {
    val allSchool = schoolService.getAllSchool()
    return ResponseEntity.ok(allSchool)
}

@GetMapping("/{schoolId}")
fun receiveSchool(@PathVariable schoolId : Int) : ResponseEntity<SchoolResponse> {
    val validSchool = schoolService.receiveSchoolById(schoolId)
    return ResponseEntity.ok(validSchool)
}

@PutMapping("/{schoolId}")
fun updateSchool(@PathVariable schoolId : Id , @RequestBody req : SchoolRequest) : ResponseEntity<SchoolResponse> {
    val updatedSchool = schoolService.updateSchoolById(schoolId, req)
    return ResponseEntity.ok(updatedSchool)
}

@DeleteMapping("/{schoolId}")
fun deleteSchool(@PathVariable schoolId : Int) : ResponseEntity<SchoolResponse> {
    schoolService.deleteSchoolById(schoolId)
    return ResponseEntity(HttpStatus.NO_CONTENT)
}

}