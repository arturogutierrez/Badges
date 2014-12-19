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

import com.github.arturogutierrez.providers.collaborators.HomePackageIdentify;

import java.util.HashMap;

/**
 * Factory created to provide BadgeProvider implementations depending what launcher is being executed
 *
 * @author Arturo Gutiérrez Díaz-Guerra
 */
public class BadgeProviderFactory {

    private Context context;
    private HashMap<String, BadgeProvider> providers;

    public BadgeProviderFactory(Context context) {
        this.context = context;
        providers = new HashMap<String, BadgeProvider>();
        providers.put(SamsungBadgeProvider.HOME_PACKAGE, new SamsungBadgeProvider(context));
        providers.put(LGBadgeProvider.HOME_PACKAGE, new LGBadgeProvider(context));
        providers.put(SonyBadgeProvider.HOME_PACKAGE, new SonyBadgeProvider(context));
        providers.put(HtcBadgeProvider.HOME_PACKAGE, new HtcBadgeProvider(context));
    }

    public BadgeProvider getBadgeProvider() {
        String currentPackage = getHomePackage(context);

        if (providers.containsKey(currentPackage)) {
            return providers.get(currentPackage);
        }

        return new NullBadgeProvider();
    }

    private String getHomePackage(Context context) {
        HomePackageIdentify identify = new HomePackageIdentify();
        return identify.getHomePackage(context);
    }
}
