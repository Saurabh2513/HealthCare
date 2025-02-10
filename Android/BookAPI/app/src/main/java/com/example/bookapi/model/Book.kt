package com.example.bookapi.model

import android.os.Parcel
import android.os.Parcelable

 data class Book(
     val image: String?,
     val isbn13: String?,
     val price: String?,
     val subtitle: String?,
     val title: String?,
     val url: String?
) : Parcelable {
     constructor(parcel: Parcel) : this(
         parcel.readString(),
         parcel.readString(),
         parcel.readString(),
         parcel.readString(),
         parcel.readString(),
         parcel.readString()
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeString(image)
         parcel.writeString(isbn13)
         parcel.writeString(price)
         parcel.writeString(subtitle)
         parcel.writeString(title)
         parcel.writeString(url)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Book> {
         override fun createFromParcel(parcel: Parcel): Book {
             return Book(parcel)
         }

         override fun newArray(size: Int): Array<Book?> {
             return arrayOfNulls(size)
         }
     }
 }