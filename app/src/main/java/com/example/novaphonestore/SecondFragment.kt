package com.example.novaphonestore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.novaphonestore.databinding.FragmentSecondBinding
import com.example.novaphonestore.viewModel.PhoneViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var mBinding:FragmentSecondBinding
    private val mViewModel : PhoneViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getPhoneDetails().observe(viewLifecycleOwner, Observer {
            mBinding.tvName.text = it.name
            Glide.with(mBinding.ivPhone).load(it.image).into(mBinding.ivPhone)
            mBinding.tvPrice.text = getString(R.string.now,it.price.toString())
            mBinding.tvLastPrice.text = getString(R.string.last,it.lastPrice.toString())
            mBinding.tvDescription.text = it.description

            if(it.credit){
                mBinding.tvCredit.text = "Acepta Credito"

            }else
            {
                mBinding.tvCredit.text = "No Acepta Credito"
            }

           /* mBinding.btVentas.setOnClickListener {
                val mIntent = Intent(Intent.EXTRA_EMAIL).apply {
                   this.setData(Uri.parse("mailto:"))
                    this.putExtra(Intent.EXTRA_EMAIL,"rafael.calderonp@gmail.com")

                }
                if (mIntent.resolveActivity(activity))
                startActivity(mIntent)
            }*/





        })




        //            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

    }
}