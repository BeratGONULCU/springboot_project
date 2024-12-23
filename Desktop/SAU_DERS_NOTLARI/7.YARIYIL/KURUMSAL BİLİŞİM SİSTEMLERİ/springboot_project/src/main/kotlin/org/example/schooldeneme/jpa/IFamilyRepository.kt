package org.example.schooldeneme.jpa

import org.example.schooldeneme.ModelEntity.FamilyEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IFamilyRepository: CrudRepository<FamilyEntity, Int> {
    fun findFamilyByFamilySurnames(familySurname: String)
}