package tranhph26979.fpoly.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView tvkq;
Button bai21,bai22,bai23;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvkq=findViewById(R.id.textView);
        bai21=findViewById(R.id.bai21);
        bai22=findViewById(R.id.bai22);
        bai23=findViewById(R.id.bai23);
        bai21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setBai21();
            }
        });
        bai22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setBai22();
            }
        });
        bai23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setBai3();
            }
        });
    }
    String strKQ="";
    private void setBai21() {

        String url="https://trafdual.000webhostapp.com/muonsach.php";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Xử lý kết quả JSON nhận được từ server
                            strKQ="";
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject reader = response.getJSONObject(i);
                                String MADG = reader.getString("MADG");
                                String TENDG = reader.getString("TENDG");
                                String PHAI = reader.getString("PHAI");
                                String NAMSINH = reader.getString("NAMSINH");
                                String NGHENGHIEP = reader.getString("NGHENGHIEP");
                                String DIACHI = reader.getString("DIACHI");
                                strKQ += "Mã đọc giả: "+MADG+", "+"Tên đọc giả: "+TENDG+", "+"Phai: "+PHAI+", "+"Năm sinh: "+NAMSINH+", "+"Nghề Nghiệp: "+NGHENGHIEP+", "+"Địa chỉ: "+DIACHI+"\n\n";
                                // Do something with the reader info (sử dụng thông tin độc giả)
                            }
                            tvkq.setText(strKQ);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvkq.setText(error.getMessage());
                    }
                });
        queue.add(jsonArrayRequest);

    }
    private void setBai22(){
        String url="https://trafdual.000webhostapp.com/dangmuon.php";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Xử lý kết quả JSON nhận được từ server
                            strKQ="";
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject reader = response.getJSONObject(i);
                                String MADG = reader.getString("MADG");
                                String TENDG = reader.getString("TENDG");
                                String PHAI = reader.getString("PHAI");
                                String NAMSINH = reader.getString("NAMSINH");
                                String NGHENGHIEP = reader.getString("NGHENGHIEP");
                                String DIACHI = reader.getString("DIACHI");
                                strKQ += "Mã đọc giả: "+MADG+", "+"Tên đọc giả: "+TENDG+", "+"Phai: "+PHAI+", "+"Năm sinh: "+NAMSINH+", "+"Nghề Nghiệp: "+NGHENGHIEP+", "+"Địa chỉ: "+DIACHI+"\n\n";
                                // Do something with the reader info (sử dụng thông tin độc giả)
                            }
                            tvkq.setText(strKQ);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvkq.setText(error.getMessage());
                    }
                });
        queue.add(jsonArrayRequest);
    }
    private void setBai3(){
        String url="https://trafdual.000webhostapp.com/theloai.php?MATL=4";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Xử lý kết quả JSON nhận được từ server
                            strKQ="";
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject reader = response.getJSONObject(i);
                                String MASH = reader.getString("MASH");
                                String TENSACH = reader.getString("TENSACH");
                                String MATL = reader.getString("MATL");
                                String TENTL = reader.getString("TENTL");
                                strKQ += "Mã sách: "+MASH+", "+"Tên sách: "+TENSACH+", "+"Mã thể loại: "+MATL+", "+"Tên thể loại: "+TENTL+"\n\n";
                                // Do something with the reader info (sử dụng thông tin độc giả)
                            }
                            tvkq.setText(strKQ);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvkq.setText(error.getMessage());
                    }
                });
        queue.add(jsonArrayRequest);
    }
}