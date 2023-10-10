package com.example.project

import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.model.CatBreed
import com.example.project.model.CatModel
import com.example.project.model.Gender

private val FEMALE_SYMBOL = " "
private val MALE_SYMBOL = " "
private const val UNKNOWN_SYMBOL = " "

class CatViewHolder(private val containerView: View, private val imageLoader:
ImageLoader, private val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(containerView) {
    //containerView is the container layout of each item list
    //Here findViewById is used to get the reference of each views inside the container
    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography) }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed) }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender) }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name) }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo) }
    private val catUpdateView: TextView by lazy {
        containerView.findViewById(R.id.cat_update) }

    //This function is called in the adapter to provide the binding function
    fun bindData(cat: CatModel) {
        //Override the onClickListener function
        containerView.setOnClickListener {
            //Here we are using the onClickListener passed from the Adapter
            onClickListener.onClick(cat)
        }
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.Leg -> "Burn thigh in 10 minutes"
            CatBreed.Abs -> "Get started with short and easy abs workouts!"
            CatBreed.HIIT -> "Super intense workout for weight loss"
            CatBreed.Arm -> "Get rid of flabby arms"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }

    //Declare an onCLickListener interface
    interface OnClickListener {
        fun onClick(cat: CatModel)
    }
}

