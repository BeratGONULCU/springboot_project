package org.example.schooldeneme.jpa

import org.example.schooldeneme.ModelEntity.StudentEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IStudentRepository : CrudRepository<StudentEntity, Int>{
    //abstract fun findByStudentId(studentId: Int): MutableList<StudentEntity>
    fun findBySchoolName(schoolName: String)
}