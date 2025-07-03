package com.uilover.project2252.Activity.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.uilover.project2252.Activity.Domain.BannerModel

class MainRespository {
    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val listData = MutableLiveData<MutableList<BannerModel>>()
        val ref = FirebaseDatabase.getInstance().getReference("Banners")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val bannerList = mutableListOf<BannerModel>()
                for (bannerSnapshot in snapshot.children) {
                    val banner = bannerSnapshot.getValue(BannerModel::class.java)
                    if (banner != null) {
                        bannerList.add(banner)
                    }
                }
                listData.value = bannerList
            }

            override fun onCancelled(error: DatabaseError) {
                // Nếu có lỗi khi đọc dữ liệu, trả về danh sách rỗng
                listData.value = mutableListOf()
            }
        })

        return listData
    }
}

