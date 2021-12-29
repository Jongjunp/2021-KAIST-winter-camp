package com.example.commontask1_pjj.tab2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.commontask1_pjj.R

class customAdapter (
    private val context: Context, private val dataList:ArrayList<dataVo>
): RecyclerView.Adapter<customAdapter.ItemViewHolder>() {

    var mPosition = 0

    inner class ItemViewHolder(itemView:View):
            RecyclerView.ViewHolder(itemView) {

                private val userPhoto = itemView.findViewById<ImageView>(R.id.userImg)
                private val userName = itemView.findViewById<TextView>(R.id.userNameTxt)
                private val userPay = itemView.findViewById<TextView>(R.id.payTxt)
                private val userAddress: TextView = itemView.findViewById<TextView>(R.id.addressTxt)

                fun bind(datavo: dataVo, context:Context) {
                    if (datavo.photo != "") {
                        val resourceId =
                            context.resources.getIdentifier(datavo.photo, "drawable", context.packageName)
                        if (resourceId > 0) {
                            userPhoto.setImageResource(resourceId)
                        } else {
                            userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                        }
                    } else {
                        userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                    }

                    //TextView data setting
                    userName.text = datavo.name
                    userPay.text = datavo.pay.toString()
                    userAddress.text = datavo.address
                }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)

        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "$position click item!", Toast.LENGTH_SHORT).show()

            //open another activity on item click
            val intent = Intent(context, AnotherActivity::class.java)
            intent.putExtra("image_name",dataList[position].photo)
            context.startActivity(intent)

        }

        holder.itemView.setOnLongClickListener { view ->
            Toast.makeText(view.context, "$position item long click!", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}












