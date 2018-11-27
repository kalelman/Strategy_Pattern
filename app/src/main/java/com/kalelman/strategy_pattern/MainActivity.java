package com.kalelman.strategy_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.action_card)
    Button btnActionCard;
    @BindView(R.id.action_cash)
    Button btnActionCash;
    @BindView(R.id.action_coupon)
    Button btnActionCoupon;


    public SinglePrice singlePrice = SinglePrice.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        singlePrice.setPrice(2.5f);
        btnActionCard.setOnClickListener(this);
        btnActionCash.setOnClickListener(this);
        btnActionCoupon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Payment payment;

        switch (view.getId()) {

            case R.id.action_card:
                payment = new Payment(new Card());
                break;

            case R.id.action_coupon:
                payment = new Payment(new Coupon());
                break;

            case R.id.action_cash:

            default:
                payment = new Payment(new Cash());
                break;
        }

        String finalPrice = new StringBuilder("Final Price: ")
                .append(payment.employStrategy(singlePrice.getPrice())).append(" $").toString();

        Toast.makeText(this, finalPrice, Toast.LENGTH_SHORT).show();
    }
}
