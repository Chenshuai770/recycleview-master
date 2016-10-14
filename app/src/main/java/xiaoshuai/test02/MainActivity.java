package xiaoshuai.test02;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 *
 * Created by Administrator on 2016/10/13.
 */
public class MainActivity extends AppCompatActivity {
    private Button btn;


    private RecyclerView mRecyclerView;
    private List<Product> mList = new ArrayList<Product>();
    private ArrayList<String> listUrl = new ArrayList<>();
    //uiHandler在主线程中创建，所以自动绑定主线程
    private Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle b=msg.getData();
            String urlname=b.getString("url");
            Log.d("USG",urlname);
            listUrl.add(urlname);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        //问题在这里，大牛，点击button获得数据这里
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listUrl.clear();
                final String url = "http://gank.io/api/data/福利/10/1";
                // String url = "http://www.csdn.net/";
                OkHttpUtils
                        .get()
                        .url(url)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.d("TAT", response);
                                Gson gson = new Gson();
                                Bean bean = gson.fromJson(response, Bean.class);
                                Log.d("TTT", bean + "");
                                String url = null;
                                ArrayList<String> test=new ArrayList<String>();
                                if (bean.isError() == false) {
                                   /* for (int i = 0; i < bean.getResults().size(); i++) {
                                        Log.d("FFF", bean.getResults().get(i).getType());
                                        url = bean.getResults().get(i).getUrl();
                                        Log.i("AAA", url);
                                        test.add(url);
                                        // listUrl.add(url);
                                    }*/

                                }

                                Log.d("LLL",url);
                                Bundle bundle = new Bundle();
                                bundle.putString("url", url);
                                Message meg=new Message();
                                meg.setData(bundle);
                                uiHandler.sendMessage(meg);


                                Log.d("III", listUrl.size() + "");


                            }
                        });


            }
        });




/*
/*//*
 List<String> listUrl = new ArrayList<String>();
 listUrl.add("http://fdfs.xmcdn.com/group16/M08/F1/13/wKgDbFal40bR7Uc6AAH3JpWhLiQ015_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group10/M07/F0/14/wKgDaVal9ZLTP5q1AAFIJeYaktQ092_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group12/M07/E8/35/wKgDXFacqEfReClFAAFvbZHe_mU331_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group9/M05/EE/15/wKgDZlagtF_yH9YXAAEyq6YSxDo657_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group11/M07/FC/B4/wKgDbValyzzy0fBpAAMdsEAuI-Q295_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group9/M01/EF/02/wKgDZlaiCqbTzvIzAAH_l7MCT-k503_android_large.jpg");
 listUrl.add("http://fdfs.xmcdn.com/group9/M01/EF/02/wKgDZlaiCqbTzvIzAAH_l7MCT-k503_android_large.jpg");
 List<Product> mList = new ArrayList<Product>();
 for(int i=0;i<7;i++){
 Product product = new Product();
 //            product.setLocalPosition("res://mipmap/"+i+".png");
 product.setLocalPosition(listUrl.get(i));
 product.setProductName("Picture "+i);
 mList.add(product);
 }*/





       /* listUrl.add("http://ww3.sinaimg.cn/large/610dc034jw1f8qd9a4fx7j20u011hq78.jpg");
        listUrl.add("http://ww3.sinaimg.cn/large/610dc034jw1f8p9eahanlj20u011h42y.jpg");
        listUrl.add("http://ww2.sinaimg.cn/large/610dc034jw1f8o2ov8xi0j20u00u0q61.jpg");
        Log.d("HHH",listUrl.get(0)+"我的数据");
*/




       /* //模拟数据，这里需要获取图片的宽高 ，一般的在我们从服务器请求数据的 时候 它会返回图片的 宽高信息
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.p1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.p2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.p3);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.mipmap.p4);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.mipmap.p5);
        Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(), R.mipmap.p6);
        Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(), R.mipmap.p7);

        List<Product> mList = new ArrayList<Product>();
        Product product1 = new Product("res://mipmap/"+R.mipmap.p1,"Picture 1",bitmap1.getWidth(),bitmap1.getHeight());
        Product product2 = new Product("res://mipmap/"+R.mipmap.p2,"Picture 2",bitmap2.getWidth(),bitmap2.getHeight());
        Product product3 = new Product("res://mipmap/"+R.mipmap.p3,"Picture 3",bitmap3.getWidth(),bitmap3.getHeight());
        Product product4 = new Product("res://mipmap/"+R.mipmap.p4,"Picture 4",bitmap4.getWidth(),bitmap4.getHeight());
        Product product5 = new Product("res://mipmap/"+R.mipmap.p5,"Picture 5",bitmap5.getWidth(),bitmap5.getHeight());
        Product product6 = new Product("res://mipmap/"+R.mipmap.p6,"Picture 6",bitmap6.getWidth(),bitmap6.getHeight());
        Product product7 = new Product("res://mipmap/"+R.mipmap.p7,"Picture 7",bitmap7.getWidth(),bitmap7.getHeight());
        mList.add(product1);
        mList.add(product2);
        mList.add(product3);
        mList.add(product4);
        mList.add(product5);
        mList.add(product6);
        mList.add(product7);*/

        //其他都封装好了，就是listurl里面得到json的数据就可以了，不知道问题出哪里
        listUrl.add("http://ww3.sinaimg.cn/large/610dc034jw1f8qd9a4fx7j20u011hq78.jpg");
        listUrl.add("http://ww3.sinaimg.cn/large/610dc034jw1f8p9eahanlj20u011h42y.jpg");
        listUrl.add("http://ww2.sinaimg.cn/large/610dc034jw1f8o2ov8xi0j20u00u0q61.jpg");

        Log.d("HHH",listUrl.get(0)+"我的数据");

        Log.d("UUU", listUrl.size() + "");
        for (int i = 0; i < listUrl.size(); i++) {
            Product product = new Product();
            product.setLocalPosition(listUrl.get(i));
            mList.add(product);

        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        PicRecyclerViewAdapter adapter = new PicRecyclerViewAdapter(mList, this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //mRecyclerView.setLayoutManager(layoutManager1);
        //添加间隔，Decorator 的翻译就是装饰师，粉刷匠
        // MyItemDecorator myItemDecorator = new MyItemDecorator(2);
        // mRecyclerView.addItemDecoration(myItemDecorator);

        mRecyclerView.setAdapter(adapter);
    }
}

