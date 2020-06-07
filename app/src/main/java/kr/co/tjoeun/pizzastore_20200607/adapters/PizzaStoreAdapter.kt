package kr.co.tjoeun.pizzastore_20200607.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
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

//        그려진 XML에 실제 피자가게 데이터를 반영

//        데이터가 반영될 뷰들을 (XML을 담아둔 변수 row에서) 가져오는 작업
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val storeNameTxt = row.findViewById<TextView>(R.id.storeNameTxt)

//        뷰에 뿌려질 데이터를 들고 있는 변수를 생성
//        액티비티가 전달해준 목록인 mList에서 꺼내보자. => 그려주려는 위치에 맞는 피자가게 꺼내기
        val data = mList[position]

//        data안에 있는 가게이름을 => storeNameTxt의 글자로 설정
        storeNameTxt.text = data.name

        return row
    }

}