package com.uilover.project245.Activity

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uilover.project245.Adapter.ColorAdapter
import com.uilover.project245.Adapter.PicsAdapter
import com.uilover.project245.Adapter.SizeAdapter
import com.uilover.project245.Helper.ManagmentCart
import com.uilover.project245.Model.ItemModel
import com.uilover.project245.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)
        item = intent.getSerializableExtra("object")!! as ItemModel

        setupViews()
        setupPicsList()
        setupColorsList()
        setupSizeList()
    }

    private fun setupSizeList() {
        val sizeList = item.size.map { it }
        binding.SizeList.apply {
            adapter = SizeAdapter(sizeList as MutableList<String>)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupColorsList() {
        binding.colorList.adapter = ColorAdapter(item.color)
        binding.colorList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
    }

    private fun setupPicsList() {
        val picList = item.picUrl.toList()
        binding.picList.apply {
            adapter = PicsAdapter(picList as MutableList<String>) { imageUrl ->
                Glide.with(this@DetailActivity)
                    .load(imageUrl)
                    .into(binding.picMain)
            }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupViews() = with(binding) {
        titleTxt.text = item.title
        descriptionTxt.text = item.description
        priceTxt.text = "$${item.price}"
        oldPriceTxt.text = "$${item.oldPrice}"
        oldPriceTxt.paintFlags = priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        ratingTxt.text = "${item.rating} Rating"
        numberItemTxt.text = item.numberInCart.toString()
        updateTotalPrice()

        Glide.with(this@DetailActivity)
            .load(item.picUrl.firstOrNull())
            .into(picMain)

        backBtn.setOnClickListener { finish() }

        plusBtn.setOnClickListener {
            item.numberInCart++
            numberItemTxt.text = item.numberInCart.toString()
            updateTotalPrice()
        }

        minusBtn.setOnClickListener {
            if (item.numberInCart > 1) {
                item.numberInCart--
                numberItemTxt.text = item.numberInCart.toString()
                updateTotalPrice()
            }
        }

        addToCartBtn.setOnClickListener {
            managmentCart.insert(item)
        }
    }

    private fun updateTotalPrice() = with(binding) {
        totalPriceTxt.text = "$${item.price * item.numberInCart}"
    }
}