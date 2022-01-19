package com.detech.Mito.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.detech.Mito.R;
import com.detech.Mito.databinding.ActivityRewardBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class RewardActivity extends AppCompatActivity {

    ActivityRewardBinding binding;
    private RewardedAd mRewardedAd;
    private RewardedAd Reward_Tow;
    private RewardedAd Reward_three;
    private RewardedAd Reward_four;
    private RewardedAd Reward_five;
    FirebaseDatabase database;
    String currentUid;
    int coins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        currentUid = FirebaseAuth.getInstance().getUid();
        loadAd();

        database.getReference().child("profiles")
                .child(currentUid)
                .child("coins")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        coins = snapshot.getValue(Integer.class);
                        binding.coins.setText(String.valueOf(coins));
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

        binding.video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = RewardActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            loadAd();
                            coins = coins + 3;
                            database.getReference().child("profiles")
                                    .child(currentUid)
                                    .child("coins")
                                    .setValue(coins);
                            binding.video1Icon.setImageResource(R.drawable.check);
                        }
                    });
                } else {
                    Toast.makeText(RewardActivity.this, "Add not loaded please wait", Toast.LENGTH_SHORT).show();

                }
            }
        });

        binding.video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = RewardActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            loadAd();
                            coins = coins + 3;
                            database.getReference().child("profiles")
                                    .child(currentUid)
                                    .child("coins")
                                    .setValue(coins);
                            binding.video2Icon.setImageResource(R.drawable.check);
                        }
                    });
                } else {
                    Toast.makeText(RewardActivity.this, "Add not loaded please wait", Toast.LENGTH_SHORT).show();

                }
            }
        });

        binding.video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = RewardActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            loadAd();
                            coins = coins + 3;
                            database.getReference().child("profiles")
                                    .child(currentUid)
                                    .child("coins")
                                    .setValue(coins);
                            binding.video3Icon.setImageResource(R.drawable.check);
                        }
                    });
                } else {
                    Toast.makeText(RewardActivity.this, "Add not loaded please wait", Toast.LENGTH_SHORT).show();

                }
            }
        });

        binding.video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = RewardActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            loadAd();
                            coins = coins + 3;
                            database.getReference().child("profiles")
                                    .child(currentUid)
                                    .child("coins")
                                    .setValue(coins);
                            binding.video4Icon.setImageResource(R.drawable.check);
                        }
                    });
                } else {
                    Toast.makeText(RewardActivity.this, "Add not loaded please wait", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.video5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = RewardActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            loadAd();
                            coins = coins + 3;
                            database.getReference().child("profiles")
                                    .child(currentUid)
                                    .child("coins")
                                    .setValue(coins);
                            binding.video5Icon.setImageResource(R.drawable.check);
                        }
                    });
                } else {
                    Toast.makeText(RewardActivity.this, "Add not loaded please wait", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-1171612315548548/8647723193",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.

                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                    }
                });
    }
}
//    void loadAd_tow() {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
//                adRequest, new RewardedAdLoadCallback() {
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error.
//
//                        Reward_Tow = null;
//                    }
//
//                    @Override
//                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
//                        Reward_Tow = rewardedAd;
//                    }
//                });
//    }
//    void loadAd_Three() {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
//                adRequest, new RewardedAdLoadCallback() {
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error.
//
//                        Reward_three = null;
//                    }
//
//                    @Override
//                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
//                        Reward_three = rewardedAd;
//                    }
//                });
//    }
//    void loadAd_Four() {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
//                adRequest, new RewardedAdLoadCallback() {
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error.
//
//                        Reward_four = null;
//                    }
//
//                    @Override
//                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
//                        Reward_four = rewardedAd;
//                    }
//                });
//    }
//    void loadAd_Five() {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
//                adRequest, new RewardedAdLoadCallback() {
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error.
//
//                        Reward_five = null;
//                    }
//
//                    @Override
//                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
//                        Reward_five = rewardedAd;
//                    }
//                });
//    }
//
//}