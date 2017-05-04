package ipglobal.launchersuiteapp.Activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.json.JSONException;
import org.json.JSONObject;
import ipglobal.launchersuiteapp.LauncherSuiteApp;
import ipglobal.launchersuiteapp.R;

/**
 * Created by oscarcid on 03/05/2017.
 */
public class QRActivity extends Activity {

    RelativeLayout qrContainer; //rlout_qr
    RelativeLayout videoContainer; //video_container
    VideoView videoHolder = null; //video_holder
    Button btnNext; //btn_next

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_activity);
        LauncherSuiteApp.setActivityContext(this);

        btnNext = (Button) findViewById(R.id.btn_next);
        qrContainer = (RelativeLayout) findViewById(R.id.rlout_qr);
        videoContainer = (RelativeLayout) findViewById(R.id.video_container);
        videoHolder = (VideoView) findViewById(R.id.video_holder);

        /*MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoHolder);
        videoHolder.setMediaController(mediaController);*/

        //String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        //Uri video = Uri.parse(vidAddress);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"  + R.raw.video);
        videoHolder.setVideoURI(video);
        videoHolder.setZOrderOnTop(true);
        videoHolder.requestFocus();
        videoHolder.start();

        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoContainer.setVisibility(View.GONE);
                videoHolder.clearFocus();
                videoHolder.setZOrderOnTop(false);
                videoHolder.setVisibility(View.GONE);
                videoHolder.cancelPendingInputEvents();
                System.gc();
                qrContainer.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                btnNext.requestFocus();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView qrView = (ImageView) findViewById(R.id.img_qr);
        JSONObject jsonQR = new JSONObject();
        try {
            jsonQR.put("user_id",16);
            jsonQR.put("user_type",0);
            qrView.setImageBitmap(createQR(jsonQR.toString()));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     * Metodo para crear el QR usando la libreria ZXing
     * @param str en este caso un String, puede ser cualquier cosa
     * @return
     */
    private Bitmap createQR(String str){
        BitMatrix result;
        Bitmap bitmap=null;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, 400,400, null);
            int w = result.getWidth();
            int h = result.getHeight();
            int[] pixels = new int[w * h];
            for (int y = 0; y < h; y++) {
                int offset = y * w;
                for (int x = 0; x < w; x++) {
                    pixels[offset + x] = result.get(x, y) ? Color.BLACK : Color.WHITE;
                }
            }
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, 400, 0, 0, w, h);
        } catch (IllegalArgumentException iae) {
            return null;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
