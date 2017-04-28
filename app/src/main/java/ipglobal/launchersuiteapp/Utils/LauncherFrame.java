package ipglobal.launchersuiteapp.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ipglobal.launchersuiteapp.R;

/**
 * Created by oscarcid on 27/04/2017.
 */

public class LauncherFrame extends RelativeLayout {

    private Context mContext = null;
    private int animDuration;
    private int animDelay = 0;

    public LauncherFrame(Context context) {
        super(context);
    }

    public LauncherFrame(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        this.animDuration = 70;
    }

    public LauncherFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @Override
    protected synchronized void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
        super.onFocusChanged(paramBoolean, paramInt, paramRect);

        if (paramBoolean){
            //ScaleAnimation localScaleAnimation = new ScaleAnimation(1.07F, 1.0F, 1.07F, 1.0F, 1, 0.5F, 1, 0.5F);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setZAdjustment(Animation.ZORDER_TOP);
            localScaleAnimation.setDuration(400);
            localScaleAnimation.setFillAfter(true);
            localScaleAnimation.setFillEnabled(true);
            localScaleAnimation.setStartTime(this.animDelay);
            startAnimation(localScaleAnimation);
            //setBackground(getResources().getDrawable(R.drawable.my_shadow,null));
            //setOutlineProvider(ViewOutlineProvider.BOUNDS);
            bringToFront();
            setBackground(getResources().getDrawable(R.drawable.shadow_fit,null));
            setElevation(10);
            //setBackground(getResources().getDrawable(R.drawable.shadow_new,null));


            /*RoundRectShape rss = new RoundRectShape(new float[] { 0.5f, 0.5f, 0.5f,
                    0.5f, 0.5f, 0.5f, 0.5f, 0.5f }, null, null);
            ShapeDrawable sds = new ShapeDrawable(rss);
            sds.setShaderFactory(new ShapeDrawable.ShaderFactory() {
                @Override
                public Shader resize(int width, int height) {
                    LinearGradient lg = new LinearGradient(0, 0, 0, height,
                            new int[] { Color.parseColor("#e5e5e5"),
                                    Color.parseColor("#e5e5e5"),
                                    Color.parseColor("#e5e5e5"),
                                    Color.parseColor("#e5e5e5") }, new float[] { 0,
                            0.20f, 0.20f, 1 }, Shader.TileMode.REPEAT);
                    return lg;
                }
            });

            LayerDrawable ld = new LayerDrawable(new Drawable[] { sds });
            ld.setLayerInset(0, 1, 1, 1, 1); // inset the shadow so it doesn't start right at the left/top
            //ld.setLayerInset(1, 0, 0, 5, 5); // inset the top drawable so we can leave a bit of space for the shadow to use

            setBackgroundDrawable(ld);*/


        }else{
            ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation2.setZAdjustment(1);
            localScaleAnimation2.setDuration(250);
            localScaleAnimation2.setZAdjustment(Animation.ZORDER_NORMAL);
            localScaleAnimation2.setFillAfter(true);
            localScaleAnimation2.setFillEnabled(true);
            localScaleAnimation2.setStartTime(this.animDelay);
            startAnimation(localScaleAnimation2);
            setBackground(null);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            setElevation(1);
            //setBackground(null);
        }

    }


}//End Class
