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

import com.github.arturogutierrez.BadgesNotSupportedException;

/**
 * Abstract class created to be implemented by different classes to provide badge change support on
 * different launchers.
 *
 * @author Arturo Gutiérrez Díaz-Guerra
 */

public abstract class BadgeProvider {

    protected Context mContext;

    public BadgeProvider(Context context) {
        mContext = context;
    }

    public abstract void setBadge(int count) throws UnsupportedOperationException;
    public abstract void removeBadge() throws UnsupportedOperationException;

    protected String getPackageName() {
        return mContext.getPackageName();
    }

    protected String getMainActivityClassName() {
        return mContext.getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent().getClassName();
    }
}
