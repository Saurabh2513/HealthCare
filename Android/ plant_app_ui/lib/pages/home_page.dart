import 'package:flutter/material.dart';
import 'package:plant_app_ui/pages/colors.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Column(
          children: [
            Stack(
              children: [
                ClipRRect(
                  borderRadius: BorderRadius.only(
                      bottomLeft: Radius.circular(40),
                      bottomRight: Radius.circular(40)),
                  child: Container(
                    height: 300,
                    width: double.maxFinite,
                    color: MainColor,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.all(20.0),
                  child: Image.asset("assets/icons/menu.png"),
                ),
                Padding(
                  padding: EdgeInsets.only(right: 60, top: 100, left: 60),
                  child: Row(
                    children: [
                      Text(
                        "Hello !",
                        style: TextStyle(
                          fontSize: 50,
                          fontStyle: FontStyle.italic,
                        ),
                      ),
                      Spacer(),
                      Image.asset("assets/image/logo.png"),
                    ],
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(top: 270, left: 20, right: 20),
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: Container(
                      child: Row(
                        children: [
                          Container(
                            height: 60,
                            width: 300,
                            child: TextFormField(
                              decoration: InputDecoration(
                                  label: Padding(
                                    padding: const EdgeInsets.only(
                                        left: 25, top: 10),
                                    child: Text(
                                      "Search",
                                      style: TextStyle(
                                        fontSize: 20,
                                        color: MainColor.withOpacity(1),
                                      ),
                                    ),
                                  ),
                                  border: InputBorder.none),
                            ),
                          ),
                          Container(
                            height: 70,
                            width: 70,
                            child: Image.asset("assets/icons/search.png"),
                          ),
                        ],
                      ),
                      width: double.maxFinite,
                      height: 60,
                      color: Colors.white,
                    ),
                  ),
                ),  
              ],
            ),
          ],
        ),
      ),
    );
  }
}
