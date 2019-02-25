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

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.mediationapp.R;

public class NativeAdSampleFragment extends Fragment {

    protected static final String TAG = NativeAdSampleFragment.class.getSimpleName();

    private @Nullable TextView nativeAdStatus;

    private int originalScreenOrientationFlag;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        //  block auto screen orientation for NativeAdSampleFragment.
        if (getActivity() != null) {
            originalScreenOrientationFlag = getActivity().getRequestedOrientation();
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        }

        View view = inflater.inflate(R.layout.fragment_native_ad_sample, container, false);

        nativeAdStatus = view.findViewById(R.id.native_ad_status);

        Button showNativeAdButton = view.findViewById(R.id.load_native_ad_button);
        showNativeAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nativeAdStatus != null) {
                    nativeAdStatus.setText(R.string.loading_status);
                }

                // Create a native ad request with a unique placement ID (generate your own on the
                // Facebook app settings). Use different ID for each ad placement in your app.

            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(originalScreenOrientationFlag);
        }
        nativeAdStatus = null;
        super.onDestroyView();
    }
}
