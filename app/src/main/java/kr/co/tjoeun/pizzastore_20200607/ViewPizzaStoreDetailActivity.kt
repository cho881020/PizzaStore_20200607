package kr.co.tjoeun.pizzastore_20200607

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_pizza_store_detail.*
import kr.co.tjoeun.pizzastore_20200607.datas.PizzaStore

class ViewPizzaStoreDetailActivity : BaseActivity() {

    lateinit var mPizzaStore : PizzaStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
//        Serializable 형태로 첨부된 가게 정보를 받아서 => PizzaStore 형태로 변신 (Casting)시켜서
//        멤버변수로 있는 피자가게 변수에 대입.
        mPizzaStore = intent.getSerializableExtra("store") as PizzaStore

//        대입 된 피자 가게 변수의 데이터들을 이용해서 화면에 출력

        Glide.with(mContext).load(mPizzaStore.logoUrl).into(logoImg)
        storeNameTxt.text = mPizzaStore.name
        phoneNumTxt.text = mPizzaStore.phoneNum


    }

}
