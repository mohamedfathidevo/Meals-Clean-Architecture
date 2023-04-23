package com.mohamedfathidev.data.remote

import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.domain.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject constructor(): EntityMapper<MealNetworkEntity, Meal> {
    override fun mapFromEntity(entity: MealNetworkEntity): Meal {
        return Meal(
            idCategory = entity.idCategory,
            strCategory = entity.strCategory,
            strCategoryDescription = entity.strCategoryDescription,
            strCategoryThumb = entity.strCategoryThumb
        )
    }

    override fun mapToEntity(domainModel: Meal): MealNetworkEntity {
        return MealNetworkEntity(
            idCategory = domainModel.idCategory,
            strCategory = domainModel.strCategory,
            strCategoryDescription = domainModel.strCategoryDescription,
            strCategoryThumb = domainModel.strCategoryThumb
        )
    }

    fun mapFromEntityList(entities: List<MealNetworkEntity>): List<Meal>{
        return entities.map { mapFromEntity(it) }
    }
}