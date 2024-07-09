package com.example.customfilesview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

class CustomFilesView @JvmOverloads constructor(context: Context, attrs:AttributeSet, defStyleAttr:Int=0) : ConstraintLayout(context,attrs,defStyleAttr) {

    private var view: View
    private lateinit var fileNameTextView: TextView
    private lateinit var fileSizeTextView: TextView
    private lateinit var createdOnTextView: TextView
    private lateinit var iconImageView: ImageView

    init {
        view = LayoutInflater.from(context).inflate(R.layout.custom_files_view,this,true)
        fileNameTextView = findViewById<TextView?>(R.id.fileNameTextView)
        fileSizeTextView = findViewById(R.id.fileSizeTextView)
        createdOnTextView = findViewById(R.id.createdOnTextView)
        iconImageView = findViewById(R.id.icon)
        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomFilesView)
        val fileName = typedArray.getString(R.styleable.CustomFilesView_setFilename)
        val fileSize = typedArray.getString(R.styleable.CustomFilesView_setFileSize)
        val createdOn = typedArray.getString(R.styleable.CustomFilesView_fileCreated)
        val icon = typedArray.getDrawable(R.styleable.CustomFilesView_fileIcon)
        fileSizeTextView.text = fileSize
        fileNameTextView.text = fileName
        createdOnTextView.text = createdOn
        iconImageView.setImageDrawable(icon)
        typedArray.recycle()
    }


    fun setIcon(icon:Int){
        view.findViewById<ImageView>(R.id.icon).setImageResource(icon)
    }
    fun setCreatedOn(date:Text){
        view.findViewById<TextView>(R.id.createdOnTextView).text = date.toString()
    }

    fun setFileName(fileName:Text){
        view.findViewById<TextView>(R.id.fileNameTextView).text = fileName.toString()
    }

    fun setFileSize(fileSize:Text){
        view.findViewById<TextView>(R.id.fileSizeTextView).text = fileSize.toString()
    }





}