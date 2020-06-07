package kr.co.tjoeun.pizzastore_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener {
//            권한을 먼저 확인하고 => OK이면 전화 연결

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    실제 전화 거는 코드
                    val myUri = Uri.parse("tel:${mPizzaStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                }

            }

//            실제 권한 체크 실행
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

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
