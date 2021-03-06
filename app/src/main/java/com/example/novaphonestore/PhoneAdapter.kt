package com.example.novaphonestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.novaphonestore.databinding.PhoneListBinding
import com.example.novaphonestore.model.local.entities.PhoneEntity

class PhoneAdapter : RecyclerView.Adapter<PhoneAdapter.PhoneVH>() {

    private var listPhone = listOf<PhoneEntity>()
    private val selectedPhone = MutableLiveData<PhoneEntity>()

    fun update(list: List<PhoneEntity>) {
        listPhone = list
        notifyDataSetChanged()
    }
    fun selectedPhone(): LiveData<PhoneEntity> = selectedPhone


    inner class PhoneVH(private val mBinding: PhoneListBinding) :
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{
        fun bind(phone: PhoneEntity){
            Glide.with(mBinding.ivPhone).load(phone.image).centerCrop().into(mBinding.ivPhone)
            mBinding.tvName.text = phone.name
            mBinding.tvPrice.text = phone.price.toString()
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedPhone.value = listPhone[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneVH {
        return PhoneVH(PhoneListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhoneVH, position: Int) {
        val phone = listPhone[position]
        holder.bind(phone)
    }

    override fun getItemCount() = listPhone.size
}