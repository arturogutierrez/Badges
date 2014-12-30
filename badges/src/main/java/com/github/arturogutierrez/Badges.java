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
package com.github.arturogutierrez;

import android.content.Context;

import com.github.arturogutierrez.providers.BadgeProvider;
import com.github.arturogutierrez.providers.BadgeProviderFactory;

/**
 * Helper to set badge count on current application icon on any supported launchers.
 *
 * @author Arturo Gutiérrez Díaz-Guerra
 */
public class Badges {

    /**
     * Set badge count on app icon
     *
     * @param context context activity
     * @param count   should be &gt;= 0, passing count as 0 the badge will be removed.
     * @throws BadgesNotSupportedException when the current launcher is not supported by Badges
     */
    public static void setBadge(Context context, int count) throws BadgesNotSupportedException {
        if (context == null) {
            throw new BadgesNotSupportedException();
        }

        BadgeProviderFactory badgeFactory = new BadgeProviderFactory(context);
        BadgeProvider badgeProvider = badgeFactory.getBadgeProvider();
        try {
            badgeProvider.setBadge(count);
        } catch (UnsupportedOperationException exception) {
            throw new BadgesNotSupportedException();
        }
    }

    /**
     * Remove current badge count
     *
     * @param context context activity
     * @throws BadgesNotSupportedException when the current launcher is not supported by Badges
     */

    public static void removeBadge(Context context) throws BadgesNotSupportedException {
        Badges.setBadge(context, 0);
    }
}
