package com.example.miras.newsapp.contact.add

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miras.newsapp.R
import com.example.miras.newsapp.entity.Contact
import kotlinx.android.synthetic.main.activity_contact_add.*
import org.koin.android.ext.android.inject
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import com.example.miras.newsapp.core.util.Logger
import android.widget.ArrayAdapter




class ContactAddActivity : AppCompatActivity(), ContactAddContract.View, AdapterView.OnItemSelectedListener {


    private var url = ""
    private var group_id = 0
    override val presenter: ContactAddContract.Presenter by inject()

    var items = arrayOf("Default", "Friends", "Colleague", "Family")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_add)

        addButton.setOnClickListener {
            addNews (nameValue.text.toString(),
                    mobileValue.text.toString(),
                    homeValue.text.toString(),
                    workValue.text.toString())
        }

        ivProfile.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, 1)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter
        spinner!!.onItemSelectedListener = this

        presenter.attachView(this)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1)
            if (resultCode == Activity.RESULT_OK) {
                val selectedImage = data!!.data
                url = getPath(selectedImage)
                Logger.msg(url)
            }
    }

    private fun getPath(uri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = managedQuery(uri, projection, null, null, null)
        val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(column_index)
    }

    private fun addNews(name: String, mobile_phone: String, home_phone: String, work_phone : String) {

        presenter.addContact(name, mobile_phone, home_phone, work_phone, url, group_id)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(contact : Contact) {
        val returnIntent = Intent()
        returnIntent.putExtra("contact", contact)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    override fun onError() {
        val returnIntent = Intent()
        setResult(Activity.RESULT_CANCELED, returnIntent)
        finish()
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        group_id = position
        Logger.msg(group_id)
    }
}
