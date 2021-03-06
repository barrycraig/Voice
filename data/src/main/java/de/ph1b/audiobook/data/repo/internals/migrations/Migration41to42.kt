package de.ph1b.audiobook.data.repo.internals.migrations

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class Migration41to42 : Migration {
  override fun migrate(db: SQLiteDatabase) {
    // invalidate modification time stamps so the chapters will be re-scanned
    val lastModifiedCv = ContentValues().apply {
      put("lastModified", 0)
    }
    db.update("tableChapters", lastModifiedCv, null, null)

    val marksCv = ContentValues().apply {
      put("marks", null as String?)
    }
    db.update("tableChapters", marksCv, null, null)
  }
}
