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
package org.agd.badges;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import org.agd.badges.impl.HtcBadgeProvider;
import org.agd.badges.impl.LGBadgeProvider;
import org.agd.badges.impl.SamsungBadgeProvider;
import org.agd.badges.impl.SonyBadgeProvider;

public class Badges {

    public static void setBadge(Context context, int count) throws BadgesNotSupportedException {
        BadgeProvider badgeProvider = Badges.createBadgeProvider(context);
        badgeProvider.setBadge(count);
    }

    public static void removeBadge(Context context) throws BadgesNotSupportedException {
        Badges.setBadge(context, 0);
    }

    private static BadgeProvider createBadgeProvider(Context context) throws BadgesNotSupportedException {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String homePackage = resolveInfo.activityInfo.packageName;

        if (homePackage.equalsIgnoreCase(SamsungBadgeProvider.HOME_PACKAGE)) {
            return new SamsungBadgeProvider(context);
        } else if (homePackage.equalsIgnoreCase(LGBadgeProvider.HOME_PACKAGE)) {
            return new LGBadgeProvider(context);
        } else if (homePackage.equalsIgnoreCase(SonyBadgeProvider.HOME_PACKAGE)) {
            return new SonyBadgeProvider(context);
        } else if (homePackage.equalsIgnoreCase(HtcBadgeProvider.HOME_PACKAGE)) {
            return new HtcBadgeProvider(context);
        }

        throw new BadgesNotSupportedException(homePackage);
    }
}
