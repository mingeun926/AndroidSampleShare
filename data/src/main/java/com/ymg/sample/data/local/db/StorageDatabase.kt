package com.ymg.sample.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ymg.sample.data.local.dao.StorageDao
import com.ymg.sample.data.local.db.StorageDatabase.Companion.DB_VERSION
import com.ymg.sample.data.local.entity.StorageEntity



@Database(entities = [StorageEntity::class], version = DB_VERSION, exportSchema = false)
abstract class StorageDatabase: RoomDatabase() {

    abstract fun storageDao(): StorageDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "storage.db"

        private var INSTANCE: StorageDatabase? = null

        fun getInstance(context: Context): StorageDatabase? {
            if (INSTANCE == null) {
                synchronized(StorageDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        StorageDatabase::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration().build()
                //.addMigrations(MIGRATION_1_2).build()
                }
            }
            return INSTANCE
        }

        /*fun destroyInstance() {
            INSTANCE = null
        }*/

        /*private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create New Table
                database.execSQL("""
                    CREATE TABLE newStorage(
                        id INTEGER PRIMARY KEY NOT NULL,
                        thumbnail TEXT NOT NULL,
                        dateTime INTEGER NOT NULL,
                        type TEXT NOT NULL
                    )
                    """.trimIndent())

                // Insert Data
                database.execSQL("""
                    INSERT INTO newStorage(
                        id,
                        thumbnail,
                        dateTime,
                        type
                    )
                    SELECT * FROM storage
                    """.trimIndent())

                // Delete Old Table
                database.execSQL("DROP TABLE storage")

                // Change Name NewTable
                database.execSQL("ALTER TABLE newStorage RENAME TO storage")
            }
        }*/
    }
}