package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.model.Gender
import com.example.project.model.CatBreed
import com.example.project.model.CatModel

class WorkoutActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        //Glide is used here to load the images
        //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener{
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Unknown,
                    CatBreed.Leg,
                    "Leg Workout",
                    "The best leg workouts to grow your legs for bigger quads,glutes, and hamstrings",
                    "https://hips.hearstapps.com/hmg-prod/images/screen-shot-2022-11-29-at-11-22-10-am-1669738946.png?crop=1.00xw:1.00xh;0,0&resize=640:*"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Abs,
                    "Abs Workout",
                    " The best exercises for the abdomen to get a core of steel. We cover the top abdominal exercises to build your ab",
                    "data:image/jpeg;base64,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"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.HIIT,
                    "Burning HIIT",
                    "High-intensity interval training is a training protocol alternating short periods of intense or explosive anaerobic exercise with brief recovery periods until the point of exhaustion.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRyY0PPYxU7wGVFRc1bofZd9fBlJCOHv_VAA&usqp=CAU"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Arm,
                    "Arm Workout",
                    "These arm exercises and arm workouts build bigger biceps, triceps and forearms.",
                    "https://www.shape.com/thmb/OVJFeJ9OyRXKw2LRddk1Qknpql0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/arm-workouts-with-weights-dumbbell-fly-f28941640cfa48c9b762f30114e5356c.jpg"
                )
            )
        )
    }

    //This will view fragment layout when one of the items from the recycler view is clicked
    // there are 4 fragment layout in res folder
    private fun showSelectionDialog(cat: CatModel){
        val dialog = AlertDialog.Builder(this)
            .setTitle("View ${cat.name}?")
            .setPositiveButton("Yes"){_, _ ->
                //there is another list in the fragment
                //this will show the list of workout in the fragment
                if (cat.breed == CatBreed.Leg){
                    val intent = Intent(this, LegWorkout_List::class.java)
                    startActivity(intent)
                }
                else if (cat.breed == CatBreed.Abs){
                    val intent = Intent(this, ABSWorkout_list::class.java)
                    startActivity(intent)
                }
                else if (cat.breed == CatBreed.HIIT){
                    val intent = Intent(this, BurningHiit_List::class.java)
                    startActivity(intent)
                }
                else if (cat.breed == CatBreed.Arm){
                    val intent = Intent(this, ArmWorkout_List::class.java)
                    startActivity(intent)
                }
            }
            .setNegativeButton("No"){dialog, _ ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }
}