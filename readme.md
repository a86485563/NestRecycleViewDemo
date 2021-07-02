# NestRecycleViewApp User Guide

- [NestRecycleViewApp User Guide](#nestrecycleviewapp-user-guide)
  - [目標](#目標)
  - [基本設定和使用須知](#基本設定和使用須知)
  - [工具介紹](#工具介紹)
    - [Using Retrofit](#using-retrofit)
      - [Why Retrofit?](#why-retrofit)
      - [使用方式:](#使用方式)
    - [Using Gson](#using-gson)
      - [使用的套件](#使用的套件)
      - [關鍵字介紹](#關鍵字介紹)
  - [參考資料](#參考資料)

## 目標

一隻有關 httpconnect 取值，然後使用巢狀式 RecycleView 來顯示的程式。歐對了他是 kotlin 喔，潮ㄅ。

## 基本設定和使用須知

- 因為要使用"http" 取資料。

  - 將 `targetSdkVersion` 版本調降到 27 以下，因為要避掉使用 https 通訊~~邪~~定。
  - 別忘了加入 `xml<uses-permission android:name="android.permission.INTERNET" />` 到 AndroidManifest.xml 中

    如果出現了 _Android 8: Cleartext HTTP traffic not permitted_ 別懷疑請檢察以上兩點。
    ~~如果還是不行就燒燒香，網路偏方百百種，我只信以上兩個~~

- RecycleView 不詳細介紹了，請看上回。 只簡單講講架構。

  兩組 RecycleView 互相 Nest 一下，產生現在大家都很怕的連結，如下。

  - categroy recycle view 對應到 category_recyclerview_items.xml 用來顯示列表 title，和裝 card recycle view
  - card recycle view 對應到 card_items.xml，顯示 card 名稱和圖片。

- 然後自製 mock server 打給自己連，模擬器手機連 localhost 網址是 `http://10.0.2.2` ，大致是仿造 _/dsp/crts/app/v1/recommendations/landingai/user/2916920972596471_ json 格式如下:

```json {
   "recommendations":{
      "ui_template_version":"1.0",
      "data":[
         {
            "category_metadata":{
               "id":"short_cut_category_1",
               "assigned_area":"SHORT_CUT_AREA",
               "display_name":"測試佩佩珠123",
               "kind":0,
               "start_date":"2020-01-01",
               "end_date":"2099-12-31",
               "max_amount_on_homepage":0,
               "category_layout_type":"N/A",
               "vendor_prefix_allowed":"tw_fetnet",
               "display_order":1,
               "see_more_btn":false,
               "max_products":9999
            },
            "category_products":[
               {
                  "partner_prefix":"tw_fetnet",
                  "prod_id":"short_cut_PizzaHut",
                  "prod_id_suffix":"",
                  "prod_name":"必勝客一鍵訂餐比薩送到家！",
                  "prod_short_description":"想吃比薩就吃必勝客～外送、外帶皆適用",
                  "prod_images_ratio1x1":[
                     ""
                  ],
                  "prod_images_ratio2x3":[
                     "https://toblob.blob.core.windows.net/demo-file/ph_800x600.jpg"
                  ],
                  "prod_price":0,
                  "detailed_URL":"https://www.pizzahut.com.tw/?utm_source=affiliates&utm_medium=fetnetapp&utm_campaign=order",
                  "isAdditionalFiltered":false,
                  "prod_tags":[

                  ],
                  "category_id":[
                     "short_cut_category_1"
                  ],
                  "prod_start_date":"2020-12-01",
                  "prod_end_date":"2099-12-31",
                  "product_layout_type":"OPEN_EXTERNAL_BROWSER",
                  "product_recommend_weight":11,
                  "detailed_URL_for_fetnet_desktop_web":"https://www.pizzahut.com.tw/?utm_source=affiliates&utm_medium=fetnetapp&utm_campaign=order",
                  "detailed_URL_for_fetnet_mobile_web":"https://www.pizzahut.com.tw/?utm_source=affiliates&utm_medium=fetnetapp&utm_campaign=order",
                  "referral_code":{
                     "http_tag_name":"yc_utn",
                     "value":"HASHED_UID()"
                  }
               },
               {
                  "partner_prefix":"tw_fetnet",
                  "prod_id":"short_cut_kfc",
                  "prod_id_suffix":"",
                  "prod_name":"肯德基線上訂餐 美味送到家!",
                  "prod_short_description":"不論外帶、外送皆適用",
                  "prod_images_ratio1x1":[
                     "https://toblob.blob.core.windows.net/demo-file/Ph_300x300.png"
                  ],
                  "prod_images_ratio2x3":[
                     "https://toblob.blob.core.windows.net/demo-file/KFC_800x600.jpg"
                  ],
                  "prod_price":0,
                  "detailed_URL":"https://www.kfcclub.com.tw/tw/?utm_source=FE&utm_medium=APP1&utm_campaign=Order",
                  "isAdditionalFiltered":false,
                  "prod_tags":[

                  ],
                  "category_id":[
                     "short_cut_category_1"
                  ],
                  "prod_start_date":"2020-11-18",
                  "prod_end_date":"2099-12-31",
                  "product_layout_type":"OPEN_EXTERNAL_BROWSER",
                  "product_recommend_weight":10,
                  "detailed_URL_for_fetnet_desktop_web":"https://www.kfcclub.com.tw/tw/?utm_source=FE&utm_medium=APP1&utm_campaign=Order",
                  "detailed_URL_for_fetnet_mobile_web":"https://www.kfcclub.com.tw/tw/?utm_source=FE&utm_medium=APP1&utm_campaign=Order",
                  "referral_code":{
                     "http_tag_name":"yc_utn",
                     "value":"HASHED_UID()"
                  }
               }
            ],
            "model_metadata":"{\"mode\": \"default\", \"num_available_products\": 2}"
         }
      ],
      "recommendation_version":{
         "metadata_datetime":"2021-06-24 08:34:35.549213",
         "model":"1.0.220",
         "code":"4.2.2"
      }
   }
}
```

值得提醒的部分，將圖片從 url 直接改成 base64，因為從模擬器的手機再去取得 https 的圖資源對此篇不是重點所以簡潔帶過。

## <a name="TOC-skill"></a>工具介紹

在使用`gson` 將取得到的資料反序列化變成定義的物件，然後丟給 RecycleView 顯示。

## Using Retrofit

使用`retrofit` 發出 http 的請求

## Why Retrofit?

1. 使用簡單
2. 高相容性，可以使用 okhttp 的設定。
3. 參考資料 :
   - https://square.github.io/retrofit/
   - https://www.freecodecamp.org/news/kriptofolio-app-series-part-5/
   - https://ithelp.ithome.com.tw/articles/10216674

- <a name="TOC-Gson-With-Gradle"></a>Using Gson with Gradle/Android

```
dependencies {
    implementation 'com.google.code.gson:gson:2.8.7'
}
```

## 使用方式:

1. 建立 api `interface`，在此步驟決定 api 相關的設定如 : return 型別、queryparameter `@Query`、url 的路徑 `@Path`、method `@GET @POST ...`等。

   我要打的 api 是 :` http://localhost:3000/recommendations`

   ```kotlin
   interface LifeCicleService {
   @GET("recommendations")
   fun getData(
   ): Call<LifeCircleResponse>;
   }
   ```

2. 建立 retrofit。
   在此步驟設定轉換器、baseUrl。

```kotlin
var retrofit = Retrofit.Builder()
         .addConverterFactory(GsonConverterFactory.create())
         .baseUrl("http://10.0.2.2:3000/")
         .build()
     val teamApi = retrofit.create(LifeCicleService::class.java)

     val call = teamApi.getData()
```

3. 設定成功拿到資料，和失敗的時候回傳。成功就將資料塞進 RecycleView，失敗就吐一個 log

```kotlin
  call.enqueue(object : Callback<LifeCircleResponse> {
         override fun onFailure(call: Call<LifeCircleResponse>?, t: Throwable?) {

             Log.d("Call", " get teams fail ")
         }

         override fun onResponse(call: Call<LifeCircleResponse>?, response: Response<LifeCircleResponse>) {

             Log.d("Call", " get teams  success "+response.body())
             if(response?.body() != null){
                 val parentAdapter = CategoryAdapter(response.body()?.data!! as ArrayList<LifeCycleData>, context)
                 parentRecycleView.setAdapter(parentAdapter)
                 parentAdapter.notifyDataSetChanged()
             }
         }
     })
```

值得提醒的是使用匿名 class 的方式完成 call back

## Using Gson

使用 gson 來完成反序列化(deserialization)，將得到的 response`讀進`程式中使用。

## 使用的套件

1. gson

```kotlin
implementation 'com.google.code.gson:gson:2.8.7'
```

2. Generate kotlin data class from json

   快速建造`data class`(value object) 的好朋友

## 關鍵字介紹

`@SerializedName` 從 response 中對應的資料的欄位

## 參考資料

- retrofit :
  1. https://square.github.io/retrofit/
  2. https://ithelp.ithome.com.tw/articles/10216674
- gson :
  1. https://github.com/google/gson


![image](https://github.com/a86485563/NestRecycleViewDemo/blob/master/Demo.png)
