package org.example.schooldeneme.Presentation

import jakarta.persistence.Id
import org.example.schooldeneme.Service.IStudentService
import org.example.schooldeneme.dto.Request.StudentRequest
import org.example.schooldeneme.dto.Response.StudentResponse
import org.example.schooldeneme.Service.StudentServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/student")

class StudentController(private val studentService : IStudentService) {

    private val STUDENT_NOT_FOUND_MESSAGE = "öğrenci bulunamadı.."

    @PostMapping
    fun createStudent(@RequestBody req : StudentRequest) : ResponseEntity<StudentResponse> {
        val savedStudent = studentService.createStudent(req)
        return ResponseEntity(savedStudent, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllStudents() : ResponseEntity<List<StudentResponse>> {
        val students = studentService.getAllStudents()
        return ResponseEntity.ok(students)
    }

    @GetMapping("/{studentId}")
    fun getStudentById(@PathVariable studentId : Int) : ResponseEntity<StudentResponse> {
        val validStudent = studentService.getStudentById(studentId)
        return ResponseEntity.ok(validStudent)
    }

    @PutMapping("/{studentId}")
    fun updateStudent(@PathVariable studentId : Int, @RequestBody req : StudentRequest) : ResponseEntity<StudentResponse> {
        val updatedStudent = studentService.updateStudentById(studentId,req)
        return ResponseEntity.ok(updatedStudent)
    }

    @GetMapping("/{studentId}")
    fun isStudentExists(@PathVariable studentId : Int) : ResponseEntity<StudentResponse> {
        val isExist = studentService.getStudentById(studentId)
        if(isExist != null) {
            //println("isStudentExist: $isExist")  // return true yapamadık
            return ResponseEntity.ok(isExist)
        }
        else
        {
//            println("isStudent does not exist: $studentId")
            return ResponseEntity.ok(isExist) // normalde bu fonksiyon hata verir bunu düzeltmek gerekecek
        }
    }

}