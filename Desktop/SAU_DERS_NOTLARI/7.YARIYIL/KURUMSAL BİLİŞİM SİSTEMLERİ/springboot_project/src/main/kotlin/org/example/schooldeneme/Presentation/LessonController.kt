package org.example.schooldeneme.Presentation

import jakarta.persistence.Id
import org.example.schooldeneme.Service.ILessonService
import org.example.schooldeneme.dto.Request.LessonRequest
import org.example.schooldeneme.dto.Response.LessonResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/lesson")

class LessonController(private val lessonService : ILessonService) {

    @PostMapping
    fun createLesson(@RequestBody req : LessonRequest) : ResponseEntity<LessonResponse> {
        val new_lesson = lessonService.createLesson(req)
        return ResponseEntity(new_lesson,HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllLesson() :ResponseEntity<List<LessonResponse>>{
        val lessons = lessonService.getAllLesson()
        return ResponseEntity.ok(lessons)
    }

    @GetMapping("/{lessonId}")
    fun deletelessonById(@PathVariable lessonId:Int) : ResponseEntity<LessonResponse> {
        lessonService.deleteLessonById(lessonId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}