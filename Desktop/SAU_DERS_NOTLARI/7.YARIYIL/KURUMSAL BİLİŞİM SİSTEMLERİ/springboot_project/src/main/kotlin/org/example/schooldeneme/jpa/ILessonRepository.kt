package org.example.schooldeneme.jpa

import org.example.schooldeneme.ModelEntity.LessonEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ILessonRepository : CrudRepository<LessonEntity, Int> {
    fun findLessonByLessonName(lessonName: String)
}