package org.example.schooldeneme.ModelEntity

import jakarta.persistence.*
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.ManyToMany

@Entity
@Table(name = "schoolEntity")
data class SchoolEntity(
    @Id
    @Column(name = "school_id", nullable = false)
    val schoolId: Int,

    @Column(name = "school_name", nullable = false)
    var schoolName: String,
    var secretInfo:String?=null, // bunu response dto da göstermeyeceğiz ama entity ile döndüğünde göstericez (yani kullanıcı bunu göremez.)

    // @OneToMany ilişkisinde 'mappedBy' parametresinde 'students' özelliğini doğru kullanıyoruz
    @OneToMany(mappedBy = "schoolEntity") // 'schoolEntity' burada doğru ilişkilendirilen alan adıdır
    val students: List<StudentEntity> = emptyList()
)

@Entity
@Table(name = "familyEntity")
data class FamilyEntity(
    @Id
    @Column(name = "family_id", nullable = false)
    val familyId: Int,

    @Column(name = "family_surname", nullable = false)
    var familySurname: String,

     //ilişkisini belirtmişsiniz ancak yorum satırına alınmış
     @OneToOne(mappedBy = "familyEntity")
     val studentEntity: StudentEntity? = null
)

@Entity
@Table(name = "lessonEntity")
data class LessonEntity(
    @Id
    @Column(name = "lesson_id", nullable = false)
    val lessonId: Int,

    @Column(name = "lesson_name", nullable = false)
    var lessonName: String,

    // Many-to-Many ilişkisinin tanımlanması
    @ManyToMany(mappedBy = "lessons") // Dersler ile ilgili ilişkiyi StudentEntity yönetecek
    val students: List<StudentEntity> = emptyList() // Dersin alıcı öğrencileri
)

@Entity
@Table(name = "StudentEntity")
data class StudentEntity(
    @Id
    @Column(name = "student_id", nullable = false)
    val studentId: Int,
    @Column(name = "student_name", nullable = false)
    var studentName: String,

    @OneToOne
    @JoinColumn(name = "family_id")
    var familyEntity: FamilyEntity,


    // @ManyToOne ilişkisinde schoolEntity ile ilişki kurulmuş
    @ManyToOne
    @JoinColumn(name = "school_id") // Foreign key ilişkilendirmesi
    var schoolEntity: SchoolEntity,

    // @ManyToMany ilişkisinde lessonEntity ile ilişki kurulmuş
    @ManyToMany
    @JoinTable(
        name = "student_lesson", // Bağlantı tablosu adı
        joinColumns = [JoinColumn(name = "student_id")], // Student tablosuna ait sütun
        inverseJoinColumns = [JoinColumn(name = "lesson_id")] // Lesson tablosuna ait sütun
    )
    val lessons: List<LessonEntity> = emptyList() // Öğrencinin alacağı dersler
)
