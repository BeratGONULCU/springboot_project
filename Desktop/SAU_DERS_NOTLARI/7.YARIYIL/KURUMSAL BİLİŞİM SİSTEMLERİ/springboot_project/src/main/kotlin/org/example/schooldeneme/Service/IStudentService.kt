package org.example.schooldeneme.Service

import com.sun.net.httpserver.Request
import org.example.schooldeneme.dto.Request.StudentRequest
import org.example.schooldeneme.dto.Response.StudentResponse
import jakarta.persistence.Id
import org.example.schooldeneme.dto.Request.SchoolRequest
import org.example.schooldeneme.dto.Response.SchoolResponse

interface IStudentService {
    fun createStudent(request:StudentRequest) : StudentResponse
    fun getAllStudents() : List<StudentResponse>
    fun getStudentById(studentId:Int) : StudentResponse
    fun updateStudentById(studentId: Int, request:StudentRequest) : StudentResponse
    fun existsStudentById(studentId:Int) : StudentResponse
}