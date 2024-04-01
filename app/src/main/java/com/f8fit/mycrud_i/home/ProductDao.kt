package com.f8fit.mycrud_i.home

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>

    @Delete
    suspend fun deleteProduct(product: Product)
}