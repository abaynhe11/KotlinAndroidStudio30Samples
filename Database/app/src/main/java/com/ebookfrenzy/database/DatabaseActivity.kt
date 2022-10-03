package com.ebookfrenzy.database

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_database.*

class DatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
    }

    fun newProduct(view: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)
        val quantity = Integer.parseInt(productQuantity.text.toString())
        val product = Product(productName.text.toString(), quantity)
        dbHandler.addProduct(product)
        productName.setText("")
        productQuantity.setText("")
    }

    fun lookupProduct(view: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)
        val product = dbHandler.findProduct(
                productName.text.toString())
        if (product != null) {
            productID.text = product.id.toString()
            productQuantity.setText(
                    product.quantity.toString())
        } else {
            productID.text = "No Match Found"
        }
    }

    fun removeProduct(view: View) {
        val dbHandler = MyDBHandler(this, null, null, 1)
        val result = dbHandler.deleteProduct(
                productName.text.toString())
        if (result) {
            productID.text = "Record Deleted"
            productName.setText("")
            productQuantity.setText("")
        } else
            productID.text = "No Match Found"
    }
}
