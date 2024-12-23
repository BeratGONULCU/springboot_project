package org.example.schooldeneme.Mapper

import org.example.schooldeneme.ModelEntity.*
import org.example.schooldeneme.dto.Request.*
import org.example.schooldeneme.dto.Response.*
import org.springframework.stereotype.Component

@Component
class StudentMapper:IMapper<StudentResponse,StudentRequest,StudentEntity> {

    override fun entityToResponse(entity: StudentEntity): StudentResponse {
        return StudentResponse(
            studentId = entity.studentId,
            studentName = entity.studentName,
            family = FamilyResponse(familyId = entity.familyEntity.familyId, familySurname = entity.familyEntity.familySurname),
            school = SchoolResponse(
                schoolId = entity.schoolEntity.schoolId,
                schoolName = entity.schoolEntity.schoolName,
                studentList = entity.schoolEntity.students.map { student ->
                    StudentResponse(
                        studentId = student.studentId,
                        studentName = student.studentName,
                        family = FamilyResponse(
                            familyId = student.familyEntity.familyId,
                            familySurname = student.familyEntity.familySurname
                            ),
                        school = SchoolResponse(
                            schoolId = student.schoolEntity.schoolId,
                            schoolName = student.schoolEntity.schoolName,
                            studentList = emptyList()
                        ),
                        lessons = student.lessons.map { lesson ->
                            LessonResponse(
                                lessonId = lesson.lessonId,
                                lessonName = lesson.lessonName
                            )
                        }
                    ) }
            ),

            lessons = entity.lessons.map { lesson ->
                LessonResponse(
                  lessonId = lesson.lessonId,
                  lessonName = lesson.lessonName
                )
            }
            // bunun normalde boş olmaması gerekir
        )
    }

    override fun responseToEntity(response: StudentResponse): StudentEntity {
        return StudentEntity(
            studentId = 0, // Bu, yeni bir öğrenci olduğu için id sıfır veriliyor. Gerçek bir uygulama için bu id başka bir yerden alınabilir.
            studentName = response.studentName,

            familyEntity = FamilyEntity(
                familyId = response.family.familyId, // FamilyResponse'ten FamilyEntity'ye dönüştürülür
                familySurname = response.family.familySurname
            ),

            schoolEntity = SchoolEntity(
                schoolId = response.school.schoolId, // SchoolResponse'ten SchoolEntity'ye dönüştürülür
                schoolName = response.school.schoolName,
                students = emptyList() // Okulun öğrenci listesini boş bırakıyoruz çünkü bu tarafın SchoolEntity'yi temsil etmesi gerekiyor
            ),

            lessons = response.lessons.map { lesson ->
                LessonEntity(
                    lessonId = lesson.lessonId,
                    lessonName = lesson.lessonName
                )
            }
        )
    }

    override fun requestToEntity(request: StudentRequest): StudentEntity {
//        return StudentEntity(
//            studentId = 0,
//            studentName = request.studentName,
//            familyEntity = FamilyEntity(
//                familyId = 0,
//                familySurname = "",
//                studentEntity =
//            )
//        )
        TODO()
    }

    override fun entityListToResponseList(entity: List<StudentEntity>): List<StudentResponse> {
        return entity.map { entityToResponse(it) }
    }

    override fun updateRequestToEntity(request: StudentRequest, entity: StudentEntity) {
        entity.studentName = request.studentName
    }
}

/*

class StudentMapper : IMapper<StudentResponse, StudentRequest, StudentEntity> {

    // Entity'den Response'a dönüştürme
    override fun entityToResponse(entity: StudentEntity): StudentResponse {
        return StudentResponse(
            studentId = entity.studentId,
            studentName = entity.studentName,
            family = FamilyResponse(
                familyId = entity.familyEntity.familyId,
                familySurname = entity.familyEntity.familySurname
            ),
            school = SchoolResponse(
                schoolId = entity.schoolEntity.schoolId,
                schoolName = entity.schoolEntity.schoolName,
                students = entity.schoolEntity.students.map { StudentResponse(it.studentId, it.studentName, FamilyResponse(it.familyEntity.familyId, it.familyEntity.familySurname), SchoolResponse(it.schoolEntity.schoolId, it.schoolEntity.schoolName, emptyList()), emptyList()) }
            ),
            lessons = entity.lessons.map { LessonResponse(lessonId = it.lessonId, lessonName = it.lessonName) }
        )
    }

    // Response'dan Entity'ye dönüştürme
    override fun responseToEntity(response: StudentResponse): StudentEntity {
        // Öğrenci bilgilerini almak için gerekli ilişkiler de dahil edilecek
        val familyEntity = FamilyEntity(familyId = response.family.familyId, familySurname = response.family.familySurname)
        val schoolEntity = SchoolEntity(schoolId = response.school.schoolId, schoolName = response.school.schoolName)
        val lessons = response.lessons.map { LessonEntity(lessonId = it.lessonId, lessonName = it.lessonName) }

        return StudentEntity(
            studentId = response.studentId,
            studentName = response.studentName,
            familyEntity = familyEntity,
            schoolEntity = schoolEntity,
            lessons = lessons
        )
    }

    // Request'ten Entity'ye dönüştürme
    override fun requestToEntity(request: StudentRequest): StudentEntity {
        val familyEntity = FamilyEntity(familyId = request.familyId, familySurname = "Default Surname") // Örnek varsayım
        val schoolEntity = SchoolEntity(schoolId = request.schoolId, schoolName = "Default School Name")
        val lessons = request.lessonIds.map { LessonEntity(lessonId = it, lessonName = "Default Lesson") } // Varsayılan dersler

        return StudentEntity(
            studentId = 0, // Varsayılan ID
            studentName = request.studentName,
            familyEntity = familyEntity,
            schoolEntity = schoolEntity,
            lessons = lessons
        )
    }

    // Entity listesinden Response listesine dönüştürme
    override fun entityListToResponseList(entity: List<StudentEntity>): List<StudentResponse> {
        return entity.map { entityToResponse(it) }
    }

    // Entity'yi güncelleme
    override fun updateRequestToEntity(request: StudentRequest, entity: StudentEntity) {
        entity.studentName = request.studentName
        // Aşağıda familyId ve schoolId'yi ilişkilendiriyoruz
        entity.familyEntity = FamilyEntity(familyId = request.familyId, familySurname = "Updated Surname")
        entity.schoolEntity = SchoolEntity(schoolId = request.schoolId, schoolName = "Updated School Name")
        // Ders bilgilerini de güncelleyebilirsiniz
        entity.lessons = request.lessonIds.map { LessonEntity(lessonId = it, lessonName = "Updated Lesson") }
    }
}




* */