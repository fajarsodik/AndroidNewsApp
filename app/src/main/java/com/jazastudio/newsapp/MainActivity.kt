package com.jazastudio.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: ListNewsAdapter
    private lateinit var listData: ArrayList<NewsData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showDataNews()
    }

    private fun showDataNews() {
        listData = ArrayList()
        listData.clear()
        val callApi = ApiServiceCall()
        val callApiService = callApi.makeApiService(BuildConfig.BASE_URL)
        callApiService.getAllNews().enqueue(object: Callback<ListNewsReponse> {
            override fun onFailure(call: Call<ListNewsReponse>, t: Throwable) {
                Log.e("error get news", "error : ${t.localizedMessage}")
            }

            override fun onResponse(
                call: Call<ListNewsReponse>,
                response: Response<ListNewsReponse>
            ) {
                Log.d("success", "berhasil")
                Log.d("succcess", response?.body()?.articles.toString())
                var num_data_array: Int? = response.body()?.articles?.size
                if (num_data_array != null) {
                    if (num_data_array > 0) {
                        for (i in 0 until num_data_array) {
                            listData.add(response.body()?.articles?.get(i)!!)
                            updateDataAdapter(listData)
                        }
                    } else {

                    }
                } else {

                }
            }

        })
    }

    private fun updateDataAdapter(listData: ArrayList<NewsData>) {
        mAdapter = ListNewsAdapter(listData) {

        }
        rv_list.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }
}
