/**
 * Copyright (c) 2004-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.mediationapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.mediationapp.ConfigParameters;
import com.facebook.mediationapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class RewardedVideoFragment extends Fragment implements RewardedVideoAdListener {

  private TextView rewardedVideoAdStatusLabel;
  private Button loadRewardedVideoButton;
  private Button showRewardedVideoButton;
  private RewardedVideoAd mRewardedVideoAd;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getActivity());
    mRewardedVideoAd.setRewardedVideoAdListener(this);
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_rewarded_video, container, false);

    rewardedVideoAdStatusLabel = (TextView) view.findViewById(R.id.rewardedVideoAdStatusLabel);
    loadRewardedVideoButton = (Button) view.findViewById(R.id.loadRewardedVideoButton);
    showRewardedVideoButton = (Button) view.findViewById(R.id.showRewardedVideoButton);

    final String adUnit = FirebaseRemoteConfig.getInstance()
        .getString(ConfigParameters.REWARDED_VIDEO_AD_UNIT);

    loadRewardedVideoButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setStatusLabelText("Loading rewarded video ad..." + adUnit);
        mRewardedVideoAd.loadAd(
            adUnit,
            new AdRequest.Builder().build());
      }
    });

    showRewardedVideoButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mRewardedVideoAd.show();
      }
    });

    return view;
  }

  private void setStatusLabelText(String label) {
    if (rewardedVideoAdStatusLabel != null) {
      rewardedVideoAdStatusLabel.setText(label);
    }
  }

  private void showToast(String message) {
    if (isAdded()) {
      Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onRewardedVideoAdLoaded() {
    setStatusLabelText("Rewarded video ad loaded");
  }

  @Override
  public void onRewardedVideoAdOpened() {

  }

  @Override
  public void onRewardedVideoStarted() {

  }

  @Override
  public void onRewardedVideoAdClosed() {
    setStatusLabelText("Rewarded video closed");
  }

  @Override
  public void onRewarded(RewardItem rewardItem) {

  }

  @Override
  public void onRewardedVideoAdLeftApplication() {

  }

  @Override
  public void onRewardedVideoAdFailedToLoad(int i) {
    setStatusLabelText("Rewarded video failed");
  }

  @Override
  public void onRewardedVideoCompleted() {
    setStatusLabelText("Rewarded video completed");
  }
}
