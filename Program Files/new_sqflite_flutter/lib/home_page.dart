import 'package:flutter/material.dart';
import 'package:new_sqflite_flutter/data/local/db_helper.dart';

class HomePage extends StatefulWidget {
  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Map<String, dynamic>> allNotes = [];
  DBHelper? dbRef;

  @override
  void initState() {
    super.initState();
    dbRef = DBHelper.getInstance;
    getNotes();
  }

  void getNotes() async {
    allNotes = await dbRef!.getAllNots();
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Notes"),
      ),
      // all nots view here
      body: allNotes.isNotEmpty
          ? ListView.builder(itemCount: allNotes.length,
          itemBuilder: (_, index) {
            return ListTile(
              leading: Text(allNotes[index][DBHelper.COLUMN_NOTE_SNO]),
              title:  Text(allNotes[index][DBHelper.COLUMN_NOTE_TITLE]),
              subtitle:  Text(allNotes[index][DBHelper.COLUMN_NOTE_DESC]),
            );
          })
          : const Center(
              child: Text("No Notes Yet!!"),
            ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // note to be added from here
          dbRef!.addNote(mTitle: "Personal Fav Note", mDesc: "Life is not good");
          getNotes();
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
