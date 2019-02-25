/**
 * Copyright (c) 2004-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 * copy, modify, and distribute this software in source code or binary form for use
 * in connection with the web services and APIs provided by Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use of
 * this software is subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be
 * included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.mediationapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.facebook.mediationapp.AdUnitsSampleType;
import com.facebook.mediationapp.R;
import com.facebook.mediationapp.adapters.SampleAdapter.Item;

public class SampleAdapter extends ArrayAdapter<Item> {

    public static class Item {
        private String title;
        private boolean isSection;

        public Item(String title, boolean isSection) {
            this.title = title;
            this.isSection = isSection;
        }

        public Item(String title) {
            this(title, false);
        }

        public String getTitle() { return title; }
    }

    private Context context;
    private LayoutInflater inflater;

    public SampleAdapter(Context context) {
        super(context, 0);

        this.context = context;

        // Add the samples and section headers
        add(new Item("Basic Samples", true));
        add(new Item(AdUnitsSampleType.BANNER.getName()));
        add(new Item(AdUnitsSampleType.INTERSTITIAL.getName()));
        add(new Item(AdUnitsSampleType.REWARDED.getName()));

        // Native ad samples
        add(new Item("Native Ad Samples", true));
        add(new Item(AdUnitsSampleType.NATIVE.getName()));
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        final Item item = (Item) getItem(position);
        if (item != null) {
            if (item.isSection) {
                v = inflater.inflate(R.layout.list_item_section, parent, false);
                v.setOnClickListener(null);
                v.setOnLongClickListener(null);
                v.setLongClickable(false);

                final TextView title = (TextView) v.findViewById(R.id.list_item_section_text);
                title.setText(item.title);
            } else {
                v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                final TextView title = (TextView) v.findViewById(android.R.id.text1);
                title.setText(item.title);
            }
        }
        return v;
    }
}
