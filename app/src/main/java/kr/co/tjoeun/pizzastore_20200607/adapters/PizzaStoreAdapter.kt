package kr.co.tjoeun.pizzastore_20200607.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.co.tjoeun.pizzastore_20200607.R
import kr.co.tjoeun.pizzastore_20200607.datas.PizzaStore

class PizzaStoreAdapter(context: Context, resourceId: Int, list: List<PizzaStore>) : ArrayAdapter<PizzaStore>(context, resourceId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.pizza_store_list_item, null)
        }
        val row = tempRow!!


        return row
    }

}