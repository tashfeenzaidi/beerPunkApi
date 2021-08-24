package com.punkapi.beerapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class BeerModel : Parcelable {
    @SerializedName("id")
    @Expose
      var id: Int? = null

    @SerializedName("name")
    @Expose
      var name: String? = null

    @SerializedName("tagline")
    @Expose
      var tagline: String? = null

    @SerializedName("first_brewed")
    @Expose
      var firstBrewed: String? = null

    @SerializedName("description")
    @Expose
      var description: String? = null

    @SerializedName("image_url")
    @Expose
      var imageUrl: String? = null

    @SerializedName("abv")
    @Expose
      var abv: Double? = null

    @SerializedName("ibu")
    @Expose
      var ibu: Double? = null

    @SerializedName("target_fg")
    @Expose
      var targetFg: Int? = null

    @SerializedName("target_og")
    @Expose
      var targetOg: Double? = null

    @SerializedName("ebc")
    @Expose
      var ebc: Int? = null

    @SerializedName("srm")
    @Expose
      var srm: Double? = null

    @SerializedName("ph")
    @Expose
      var ph: Double? = null

    @SerializedName("attenuation_level")
    @Expose
      var attenuationLevel: Double? = null

    protected constructor(`in`: Parcel) {
        id = `in`.readValue(Int::class.java.classLoader) as Int?
        name = `in`.readValue(String::class.java.classLoader) as String?
        tagline = `in`.readValue(String::class.java.classLoader) as String?
        firstBrewed = `in`.readValue(String::class.java.classLoader) as String?
        description = `in`.readValue(String::class.java.classLoader) as String?
        imageUrl = `in`.readValue(String::class.java.classLoader) as String?
        abv = `in`.readValue(Double::class.java.classLoader) as Double?
        ibu = `in`.readValue(Double::class.java.classLoader) as Double?
        targetFg = `in`.readValue(Int::class.java.classLoader) as Int?
        targetOg = `in`.readValue(Double::class.java.classLoader) as Double?
        ebc = `in`.readValue(Int::class.java.classLoader) as Int?
        srm = `in`.readValue(Double::class.java.classLoader) as Double?
        ph = `in`.readValue(Double::class.java.classLoader) as Double?
        attenuationLevel = `in`.readValue(Double::class.java.classLoader) as Double?
    }


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeValue(name)
        dest.writeValue(tagline)
        dest.writeValue(firstBrewed)
        dest.writeValue(description)
        dest.writeValue(imageUrl)
        dest.writeValue(abv)
        dest.writeValue(ibu)
        dest.writeValue(targetFg)
        dest.writeValue(targetOg)
        dest.writeValue(ebc)
        dest.writeValue(srm)
        dest.writeValue(ph)
        dest.writeValue(attenuationLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BeerModel> {
        override fun createFromParcel(parcel: Parcel): BeerModel {
            return BeerModel(parcel)
        }

        override fun newArray(size: Int): Array<BeerModel?> {
            return arrayOfNulls(size)
        }
    }

}