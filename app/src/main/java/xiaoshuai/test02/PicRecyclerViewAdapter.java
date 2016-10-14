package xiaoshuai.test02;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */

public class PicRecyclerViewAdapter extends RecyclerView.Adapter<PicViewHolder>{
    List<Product> list;
    Context context;
    public PicRecyclerViewAdapter(List<Product> list,Context context) {
        this.list = list;
        this.context=context;
    }
    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ret = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new PicViewHolder(ret);
    }

    @Override
    public void onBindViewHolder(PicViewHolder holder, int position) {
        Log.d("位置", "position" + position + " Uri:");
        Product product = list.get(position);
        //获取图片的宽高信息，然后得到宽高比 ，然后通过Fresco的SimpleDraweeView的setAspectRatio来设置
        float ratio = (float)product.getWidth() / (float)product.getHeight();
        holder.pic.setAspectRatio(ratio);
        holder.pic.setImageURI(Uri.parse(product.getLocalPosition()));

        Log.d("图片宽度", "Width=" + product.getWidth());
        Log.d("图片高度", "Height=" +product.getHeight());
       // Log.d("加载后的宽度" ,"Ratio="+ratio);
       // holder.textView.setText(product.getProductName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
