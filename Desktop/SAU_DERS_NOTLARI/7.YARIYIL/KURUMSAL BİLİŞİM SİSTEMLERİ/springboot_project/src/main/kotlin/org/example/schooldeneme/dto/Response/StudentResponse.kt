package org.example.schooldeneme.dto.Response

data class StudentResponse(
    var studentId: Int,
    var studentName: String,
    val family : FamilyResponse,
    val school : SchoolResponse,
    val lessons : List<LessonResponse>,
    )
