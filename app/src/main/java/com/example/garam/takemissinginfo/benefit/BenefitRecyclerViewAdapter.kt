package com.example.garam.takemissinginfo.benefit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.garam.takemissinginfo.R

class BenefitRecyclerViewAdapter(
    private val items: ArrayList<BenefitInfoData>,
    private val context: Context,
    val itemClick:(BenefitInfoData) -> Unit): RecyclerView.Adapter<BenefitRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.benefit_info_recyclerview_layout,parent,false),
        itemClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View, itemClick: (BenefitInfoData) -> Unit) : RecyclerView.ViewHolder(itemView){

        private val benefitName = itemView.findViewById<TextView>(R.id.benefitNameTextView)
        private val detailsInfo = itemView.findViewById<TextView>(R.id.benefitDetailInfoTextView)
        private val competentInstitution = itemView.findViewById<TextView>(R.id.benefitCompetentInstitutionTextView)

        fun bind(list: BenefitInfoData) {
            benefitName.text = list.name
            detailsInfo.text = list.detailsInfo
            competentInstitution.text = list.competentInstitution

            itemView.setOnClickListener {
                itemClick(list)
            }
        }
    }

}