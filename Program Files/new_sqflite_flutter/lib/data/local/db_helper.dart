import 'dart:io';

import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

class DBHelper {
  // Singleton
  DBHelper._();

  static final DBHelper getInstance = DBHelper._();

  // table not name
  static final String TABLE_NOTE = "note";
  static final String COLUMN_NOTE_SNO = "s_no";
  static final String COLUMN_NOTE_TITLE = "title";
  static final String COLUMN_NOTE_DESC = "desc";

  Database? myDb;

// database open (path ->if exist then open else create)
  Future<Database> getDb() async {
    myDb ??= await openDb();
    return myDb!;
    // if (myDb != null) {
    //   return myDb!;
    // } else {
    //   myDb = await openDb();
    //   return myDb!;
    // }
  }

  Future<Database> openDb() async {
    Directory appDir = await getApplicationDocumentsDirectory();
    String dbPath = join(appDir.path, "note.db");
    return await openDatabase(dbPath, onCreate: (db, version) {
      // create all tables here
      db.execute(
          "create table $TABLE_NOTE ($COLUMN_NOTE_SNO integer primary key autoincrement, $COLUMN_NOTE_TITLE text, $COLUMN_NOTE_DESC text)");
    }, version: 1);
  }

// all queries
  Future<bool> addNote({required String mTitle, required String mDesc}) async {
    var db = await getDb();
    int rowsEffected = await db.insert(
        TABLE_NOTE, {COLUMN_NOTE_TITLE: mTitle, COLUMN_NOTE_DESC: mDesc});
    return rowsEffected > 0;
  }
// reading all data
  Future<List<Map<String, dynamic>>> getAllNots() async {
    var db = await getDb();
    List<Map<String, dynamic>> mData = await db.query(TABLE_NOTE);
    return mData;
  }
}
