package com.uilover.project245.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.uilover.project245.Adapter.CartAdapter
import com.uilover.project245.Helper.ChangeNumberItemsListener
import com.uilover.project245.Helper.ManagmentCart
import com.uilover.project245.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        initView()
        initCartList()
        calculateCart()
    }

    private fun initView() {
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun initCartList() {
        binding.apply {
            viewCart.layoutManager = LinearLayoutManager(
                this@CartActivity,
                LinearLayoutManager.VERTICAL, false
            )

            viewCart.adapter =
                CartAdapter(managmentCart.getListCart(), this@CartActivity, object :
                    ChangeNumberItemsListener {
                    override fun onChanged() {
                        calculateCart()
                    }

                })

            emptyTxt.visibility =
                if (managmentCart.getListCart().isEmpty()) View.VISIBLE else View.GONE

            scrollView2.visibility =
                if (managmentCart.getListCart().isEmpty()) View.GONE else View.VISIBLE
        }
    }

    private fun calculateCart() {
        val percentTax = 0.02
        val delivery = 10.0
        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100) / 100.0
        val total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100
        val itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100

        with(binding) {
            totalFeeTxt.text = "$$itemTotal"
            taxTxt.text = "$$tax"
            deliveryTxt.text = "$$delivery"
            totalTxt.text = "$$total"
        }
    }
}