package org.example.schooldeneme.Service

import org.example.schooldeneme.Mapper.StudentMapper
import org.example.schooldeneme.jpa.IStudentRepository
import org.springframework.stereotype.Service
import org.example.schooldeneme.dto.Request.StudentRequest
import org.example.schooldeneme.dto.Response.StudentResponse

@Service
class StudentServiceImpl(
    var familyRepository: IStudentRepository,
    private val studentMapper: StudentMapper,
    private val iStudentRepository: IStudentRepository
) :IStudentService {

    private val STUDENT_NOT_FOUND_MESSAGE = "bu öğrenci bulunamadı..! "

    override fun getAllStudents(): List<StudentResponse> {
        TODO("Not yet implemented")
    }

    override fun createStudent(request: StudentRequest): StudentResponse {
        TODO("Not yet implemented")
    }

    override fun existsStudentById(studentId: Int): StudentResponse {
        TODO("Not yet implemented")
    }

    override fun getStudentById(studentId: Int): StudentResponse {
        TODO("Not yet implemented")
    }

    override fun updateStudentById(studentId: Int, request: StudentRequest): StudentResponse {
        TODO("Not yet implemented")
    }
}

