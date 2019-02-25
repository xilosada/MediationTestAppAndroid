/**
 * Copyright (c) 2004-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 * copy, modify, and distribute this software in source code or binary form for use
 * in connection with the web services and APIs provided by Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use of
 * this software is subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be
 * included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.mediationapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.mediationapp.R;

public class RewardedVideoFragment extends Fragment {

    private TextView rewardedVideoAdStatusLabel;
    private Button loadRewardedVideoButton;
    private Button showRewardedVideoButton;


    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rewarded_video, container, false);

        rewardedVideoAdStatusLabel = (TextView) view.findViewById(R.id.rewardedVideoAdStatusLabel);
        loadRewardedVideoButton = (Button) view.findViewById(R.id.loadRewardedVideoButton);
        showRewardedVideoButton = (Button) view.findViewById(R.id.showRewardedVideoButton);

        loadRewardedVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatusLabelText("Loading rewarded video ad...");

            }
        });

        showRewardedVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
