package xiaoshuai.test02;

/**
 * Created by Administrator on 2016/10/13.
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Kodulf on 2016/3/15.
 */
//Decorator 的翻译就是装饰师，粉刷匠
public class MyItemDecorator extends RecyclerView.ItemDecoration {
    private int space;

    public MyItemDecorator(int space) {
        this.space = space;
    }

    //自定义item之间的距离，如果是第一个的话就没有距离，
    //设置上下左右的距离
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=space;
        outRect.right=space;
        outRect.left=space;
        if(parent.getChildPosition(view)!=0){
            outRect.top=space;
        }
    }
}