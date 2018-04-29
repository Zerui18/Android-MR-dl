package com.explore.chenzerui.mr_dl.MRBackend

//import android.arch.persistence.room.*
//import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.content.Context
import com.explore.chenzerui.mr_dl.MainActivity

//class DatabaseHelper(context: Context) {
//
//    @Dao
//    interface _Dao {
//        @Query("SELECT * FROM MRSeriesMeta")
//        fun fetchAllSeries(): List<MRSeriesMeta>

//        @Query("SELECT * FROM MRChapterMeta WHERE seriesOid == :seriesOid")
//        fun fetchAllChapters(seriesOid: String): List<MRChapterMeta>
//
//        @Insert(onConflict = REPLACE)
//        fun insert(series: MRSeriesMeta)
//
//        @Delete
//        fun delete(series: MRSeriesMeta)
//    }
//
//    @Database(entities = [MRSeriesMeta::class, MRChapterMeta::class], version = 1)
//    @TypeConverters(Converters::class)
//    abstract class _Database: RoomDatabase() {
//        abstract fun _dao(): _Dao
//    }
//
//    companion object {
//        val shared by lazy { DatabaseHelper(MainActivity.shared) }
//    }
//
//    private val database = Room.databaseBuilder(context, _Database::class.java, "stored_data.db").build()

//    fun fetchAllSeries(): List<MRSeriesMeta> {
//        val series = database._dao().fetchAllSeries()
//        for(s in series) s.chapters = database._dao().fetchAllChapters(s.oid).toTypedArray()
//        return series
//    }
//
//}