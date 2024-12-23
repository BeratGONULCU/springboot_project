package org.example.schooldeneme.jpa

import org.example.schooldeneme.ModelEntity.SchoolEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ISchoolRepository: CrudRepository<SchoolEntity, Int> {
    fun findBySchoolName(schoolName: String)
}