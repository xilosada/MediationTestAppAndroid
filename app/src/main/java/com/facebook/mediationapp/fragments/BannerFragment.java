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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.mediationapp.R;

public class BannerFragment extends Fragment {

    private static final String TAG = BannerFragment.class.getSimpleName();

    private RelativeLayout bannerAdContainer;
    private Button refreshBannerButton;
    private TextView bannerStatusLabel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banner, container, false);

        bannerStatusLabel = (TextView)view.findViewById(R.id.bannerStatusLabel);
        bannerAdContainer = (RelativeLayout)view.findViewById(R.id.bannerAdContainer);
        refreshBannerButton = (Button)view.findViewById(R.id.refreshBannerButton);
        refreshBannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAdView();
            }
        });
        loadAdView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void loadAdView() {
        // Update progress message
        setLabel(getString(R.string.loading_status));
    }

    private void setLabel(String status) {
        bannerStatusLabel.setText(status);
    }
}
