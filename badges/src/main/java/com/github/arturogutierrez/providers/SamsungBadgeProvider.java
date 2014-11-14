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

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * BadgeProvider implementation to support badges on Samsung devices.
 *
 * @author Arturo Gutiérrez Díaz-Guerra
 */
class SamsungBadgeProvider extends BadgeProvider {

    public static final String HOME_PACKAGE = "com.sec.android.app.launcher";

    private static final Uri CONTENT_URI = Uri.parse("content://com.sec.badge/apps");
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PACKAGE = "package";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_BADGE_COUNT = "badgeCount";

    public SamsungBadgeProvider(Context context) {
        super(context);
    }

    @Override
    public void setBadge(int count) {
        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(CONTENT_URI, new String[]{COLUMN_ID}, COLUMN_PACKAGE + "=?", new String[]{getPackageName()}, null);

        if (!cursor.moveToFirst()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_PACKAGE, getPackageName());
            contentValues.put(COLUMN_CLASS, getMainActivityClassName());
            contentValues.put(COLUMN_BADGE_COUNT, count);
            contentResolver.insert(CONTENT_URI, contentValues);
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_BADGE_COUNT, count);
            contentResolver.update(CONTENT_URI, contentValues, COLUMN_ID + "=?", new String[]{String.valueOf(cursor.getInt(0))});
        }
    }

    @Override
    public void removeBadge() {
        setBadge(0);
    }
}
