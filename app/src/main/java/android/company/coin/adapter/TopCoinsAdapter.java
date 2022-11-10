package android.company.coin.adapter;

import android.app.Activity;
import android.company.coin.Data.Model.TopCoins.CryptoCurrencyList;
import android.company.coin.R;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopCoinsAdapter extends RecyclerView.Adapter<TopCoinsViewHolder>{
    List<CryptoCurrencyList> dataList;
    Context context;
    public static int pos=10;

    public TopCoinsAdapter(List<CryptoCurrencyList> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public TopCoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin,parent,false);
        return new TopCoinsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopCoinsViewHolder holder, int position) {
        holder.coinName.setText(dataList.get(position).getName());
        holder.coinNumber.setText(String.valueOf(position + 1));
        holder.coinSymbol.setText(dataList.get(position).getSymbol());
        Picasso.get().load("https://s2.coinmarketcap.com/static/img/coins/64x64/"+dataList.get(position).getId()+".png")
                .into(holder.coinIcon);
        if(dataList.get(position).getQuotes().get(0).getPercentChange24h() > 00.00){
            holder.coinChangPrice.setTextColor(Color.rgb(0,200,10));
            holder.coinChangPrice.setText(String.format("%02.02f",dataList.get(position).getQuotes().get(0).getPercentChange24h()));
        }
        else{
            holder.coinChangPrice.setTextColor(Color.rgb(200,0,10));
            holder.coinChangPrice.setText(String.format("%02.02f",dataList.get(position).getQuotes().get(0).getPercentChange24h()));

        }
        holder.coinPrice.setText("$"+String.format("%02.02f", dataList.get(position).getQuotes().get(0).getPrice()));
        GlideToVectorYou
                .init()
                .with((Activity) context)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        Log.e("image svg","image svg failed");
                    }

                    @Override
                    public void onResourceReady() {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.coinDiagram.setVisibility(View.VISIBLE);
                        holder.coinDiagram.setColorFilter(R.color.red);
                    }
                })
                .load(Uri.parse("https://s3.coinmarketcap.com/generated/sparklines/web/7d/2781/"+dataList.get(position).getId()+".svg"),holder.coinDiagram);

    }


    @Override
    public int getItemCount() {
         return pos;
    }
}
class TopCoinsViewHolder extends RecyclerView.ViewHolder{
    TextView coinNumber,coinName,coinSymbol,coinPrice,coinChangPrice;
    ImageView coinIcon,coinDiagram;
    ProgressBar progressBar;
    public TopCoinsViewHolder(@NonNull View itemView) {
        super(itemView);
        coinNumber=itemView.findViewById(R.id.number_item_coin);
        coinName=itemView.findViewById(R.id.name_item_coin);
        coinSymbol=itemView.findViewById(R.id.Symbol_item_coin);
        coinPrice=itemView.findViewById(R.id.price_item_coin);
        coinChangPrice=itemView.findViewById(R.id.chang_price_item_Coin);
        coinIcon=itemView.findViewById(R.id.icon_item_coin);
        coinDiagram=itemView.findViewById(R.id.dialog_Item_coin);
        progressBar = itemView.findViewById(R.id.progress_bar_item);
    }

}
