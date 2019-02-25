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
import com.facebook.mediationapp.R;

public class InterstitialFragment extends Fragment {

    private TextView interstitialAdStatusLabel;
    private Button loadInterstitialButton;
    private Button showInterstitialButton;

    private String statusLabel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interstitial, container, false);

        interstitialAdStatusLabel = (TextView)view.findViewById(R.id.interstitialAdStatusLabel);
        loadInterstitialButton = (Button)view.findViewById(R.id.loadInterstitialButton);
        showInterstitialButton = (Button)view.findViewById(R.id.showInterstitialButton);

        loadInterstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setLabel("Loading interstitial ad...");

                // Create the interstitial unit with a placement ID (generate your own on the Facebook app settings).
                // Use different ID for each ad placement in your app.

            }
        });

        showInterstitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    private void setLabel(String label) {
        statusLabel = label;
        if (interstitialAdStatusLabel != null) {
            interstitialAdStatusLabel.setText(statusLabel);
        }
    }
}
