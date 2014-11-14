/*
 * Copyright (C) 2014 Arturo Gutiérrez Díaz-Guerra.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.arturogutierrez.providers;

import android.content.Context;
import android.content.Intent;

/**
 * BadgeProvider implementation to support badges on LG devices.
 *
 * @author Arturo Gutiérrez Díaz-Guerra
 */
class LGBadgeProvider extends BadgeProvider {

    public static final String HOME_PACKAGE = "com.lge.launcher2";

    public LGBadgeProvider(Context context) {
        super(context);
    }

    @Override
    public void setBadge(int count) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count_package_name", getPackageName());
        intent.putExtra("badge_count_class_name", getMainActivityClassName());
        intent.putExtra("badge_count", count);

        mContext.sendBroadcast(intent);
    }

    @Override
    public void removeBadge() {
        setBadge(0);
    }
}
