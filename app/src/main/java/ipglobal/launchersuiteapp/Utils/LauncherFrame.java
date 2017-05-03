package ipglobal.launchersuiteapp.Utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Clase para contener las imagenes del Launcher y escalarlas
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
            ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setZAdjustment(Animation.ZORDER_TOP);
            localScaleAnimation.setDuration(400);
            localScaleAnimation.setFillAfter(true);
            localScaleAnimation.setFillEnabled(true);
            localScaleAnimation.setStartTime(this.animDelay);
            startAnimation(localScaleAnimation);

            ImageView childImage = (ImageView) getChildAt(0);
            childImage.setHovered(true);
            bringToFront();
            setElevation(10);


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
            ImageView childImage = (ImageView) getChildAt(0);
            childImage.setHovered(false);
            setElevation(1);
        }

    }


}//End Class
