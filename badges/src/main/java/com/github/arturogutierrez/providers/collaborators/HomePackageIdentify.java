package com.github.arturogutierrez.providers.collaborators;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/**
 * Helper to identify the package of current home launcher running
 *
 * Created by Arturo Gutiérrez on 19/12/14.
 */
public class HomePackageIdentify {

    public String getHomePackage(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo != null && resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName != null) {
            return resolveInfo.activityInfo.packageName;
        }

        return context.getPackageName();
    }
}
