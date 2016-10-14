package xiaoshuai.test02;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2016/10/13.
 */

public class PicViewHolder extends RecyclerView.ViewHolder{
    SimpleDraweeView pic;
    TextView textView;
    public PicViewHolder(View itemView) {
        super(itemView);
        pic=(SimpleDraweeView)itemView.findViewById(R.id.item_simpleDraweeView);
        pic.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
//            pic.setAspectRatio(0.9f);
        //textView=(TextView)itemView.findViewById(R.id.item_name);
    }
}
