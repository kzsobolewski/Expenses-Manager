package com.example.expensesmanager.ui.notifications

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.expensesmanager.R
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions
import com.google.firebase.ml.vision.text.FirebaseVisionText
import kotlinx.android.synthetic.main.fragment_reader.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ReaderFragment : Fragment() {

    private lateinit var viewModel: ReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(ReaderViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_reader, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonocr.setOnClickListener {
            if(checkForCameraPermission())
                openCamera()
            else {
                makePermissionsRequest()
            }
        }
    }

    private fun rotateImage(source: Bitmap, angle: Float): Bitmap  {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height,
            matrix, true)
    }

    private fun firebaseTextRecognition(bitmap: Bitmap) {
        val fbVisionImg = FirebaseVisionImage.fromBitmap(bitmap)
//        val options = FirebaseVisionCloudTextRecognizerOptions.Builder()
//            .setLanguageHints(listOf("pl", "cześć", "dzień dobry", "polski"))
//            .build()
        val detector =
            FirebaseVision.getInstance().onDeviceTextRecognizer
//            FirebaseVision.getInstance().getCloudTextRecognizer(options)

        detector.processImage(fbVisionImg)
            .addOnSuccessListener {
                processRecognizedText(it)
            }
            .addOnFailureListener {
                Log.d("TAGF", "Error during image processing.")
                it.printStackTrace()
            }
    }

    private fun processRecognizedText(fbVisionText: FirebaseVisionText) {
        Log.d("TAGF", "recognised text is:" + fbVisionText.getli)

    }

    private val REQUEST_IMAGE_CAPTURE = 1

    private fun checkForCameraPermission(): Boolean =
        (checkSelfPermission(activity!!.applicationContext, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED  ||
                checkSelfPermission(activity!!.applicationContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(activity!!.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
                )

    private fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    Log.d("TAG", "Error in creating file", ex)
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        context!!,
                        "com.example.expensesmanager.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    private fun makePermissionsRequest() =
        ActivityCompat.requestPermissions(
            activity!!,
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_IMAGE_CAPTURE)

    var  currentPhotoPath: String = "0"

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try{
            when(requestCode){
                REQUEST_IMAGE_CAPTURE -> {
                    if(resultCode == RESULT_OK) {
                        val file = File(currentPhotoPath)
                        var bitmap: Bitmap = MediaStore.Images.Media
                            .getBitmap(context!!.contentResolver, Uri.fromFile(file))
                            Log.d("TAGF", "bitmap ready to use")
                            bitmap = rotateImage(bitmap, 90f)
                            thumbnail.setImageBitmap(bitmap)
                            firebaseTextRecognition(bitmap)
                    } else
                        Log.d("TAGF", "Something went wrong")
                }
            }
        } catch (error:Exception) {
            error.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
            Log.d("TAG", "Saving image...")
        }
    }





}