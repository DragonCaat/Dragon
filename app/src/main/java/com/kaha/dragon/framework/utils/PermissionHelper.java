package com.kaha.dragon.framework.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

/**
 * 处理Android 6.0动态权限的工具类.<br>
 * <p>
 * 使用：
 * 1、权限申请：
 * PermissionHelper mHelper = new PermissionHelper(this);
 * mHelper.requestPermission(listener,@NonNull String... permissions)
 * <p>
 * 2、处理申请的结果:
 * 在activity/Fragment重写onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) 方法，
 * 然后调用 mHelper.handleRequestPermissionsResult(requestCode, permissions, grantResults);
 * <p>
 * 例如：
 * //@Override
 * public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {<br>
 * mHelper.handleRequestPermissionsResult(requestCode, permissions, grantResults);
 * }
 * </p>
 *
 * @author Darcy
 * @Date 2018/12/10
 * @package com.darcy.pet.trunk.framework.utils
 * @Desciption
 */
public class PermissionHelper {
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private Activity activity;
    private PermissionCallBack permissionCallBack;

    public PermissionHelper(@NonNull Activity activity) {
        this.activity = activity;
    }


    /**
     * 请求动态权限
     *
     * @param permissionCallBack 回调
     * @param permissions        权限
     **/
    public void requestPermission(PermissionCallBack permissionCallBack, @NonNull String... permissions) {
        this.permissionCallBack = permissionCallBack;
        boolean isMinSdkM = Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
        if (isMinSdkM || permissions.length == 0) {
            if (permissionCallBack != null) {
                permissionCallBack.onPermissionGrant(permissions);
            }
            return;
        }

        ArrayList<String> listGranted = new ArrayList<>(permissions.length);//已授权的列表
        //未授权的列表
        ArrayList<String> listDenied = new ArrayList<>(permissions.length);

        for (String permission : permissions) {
            if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(activity, permission)) {
                listGranted.add(permission);
            } else {
                listDenied.add(permission);
            }
        }

        if (listGranted.size() == permissions.length) {
            String[] strGranted = listGranted.toArray(new String[listGranted.size()]);
            if (null != permissionCallBack) {
                permissionCallBack.onPermissionGrant(strGranted);
            }
        } else {
            String[] strDenied = listDenied.toArray(new String[listDenied.size()]);
            ActivityCompat.requestPermissions(activity, strDenied, REQUEST_PERMISSION_CODE);
        }
    }

    public void handleRequestPermissionsResult(int requestCode, @NonNull final String[] permissions,
                                               @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE: {
                ArrayList<String> listGranted = new ArrayList<>(permissions.length);
                ArrayList<String> listDenied = new ArrayList<>(permissions.length);

                for (String permission : permissions) {
                    if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(activity, permission)) {
                        listGranted.add(permission);
                    } else {
                        listDenied.add(permission);
                    }
                }

                if (listGranted.size() == permissions.length) {
                    String[] strGranted = listGranted.toArray(new String[listGranted.size()]);
                    if (null != permissionCallBack) {
                        permissionCallBack.onPermissionGrant(strGranted);
                    }
                } else {
                    final String[] strDenied = listDenied.toArray(new String[listDenied.size()]);
                    new AlertDialog.Builder(activity)
                            .setMessage("获取相关权限失败将导致部分功能无法正常使用，需要到设置页面手动授权")
                            .setPositiveButton("去授权", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //引导用户至设置页手动授权
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", activity.getApplicationContext().getPackageName(), null);
                                    intent.setData(uri);
                                    activity.startActivity(intent);
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //引导用户手动授权，权限请求失败
                                    if (permissionCallBack != null) {
                                        permissionCallBack.onPermissionDenied(strDenied);
                                    }
                                }
                            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            //引导用户手动授权，权限请求失败
                            if (permissionCallBack != null) {
                                permissionCallBack.onPermissionDenied(strDenied);
                            }
                        }
                    }).show();

                }
                break;
            }
        }
    }


    /**
     * 权限请求回调
     *
     * @author darcy
     * @time 2018-9-18 16:08
     */
    public interface PermissionCallBack {

        void onPermissionGrant(String... permission);

        void onPermissionDenied(String... permission);
    }

}
