package com.almawashi.base.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Spanned;
import android.util.Base64;
import android.util.DisplayMetrics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;



public final class Utils {

    public static int parseInt(String value) {
        try {
            double aDouble = Double.parseDouble(value);
            return (int) aDouble;
        } catch (NumberFormatException e) {
            Timber.e(e, "parseInt: ");
            return 0;
        } catch (Exception e) {
            Timber.e(e, "parseInt: ");
            return 0;
        }
    }

    public static int parseInt(Object object) {
        return parseInt(String.valueOf(object));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static String getFormattedTime(Long time) {
        // FIXME: 1/23/2018 
        return "";
    }

    public static String getFormattedHijriDate(Long date) {
        // TODO: 9/12/2017
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date);

            String day = HijriCalendarDate.getSimpleDateDay(cal, 0, Locale.getDefault());
            String month = HijriCalendarDate.getSimpleDateMonth(cal, 0, Locale.getDefault());
            String year = HijriCalendarDate.getSimpleDateYear(cal, 0, Locale.getDefault());

            return String.format(Locale.getDefault(), "%s %s %s", day, month, year);
        }
        return "";
    }

    public static String getFormattedHijriDateNumberFormat(Long date) {
        // TODO: 9/12/2017
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date);

            String day = HijriCalendarDate.getSimpleDateDay(cal, 0, Locale.getDefault());
            String month = HijriCalendarDate.getSimpleDateMonthNumber(cal, 0, Locale.getDefault());
            String year = HijriCalendarDate.getSimpleDateYear(cal, 0, Locale.getDefault());

            return String.format(Locale.getDefault(), "%s / %s / %s", day, month, year);
        }
        return "";
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static List<String> getPhotosFullUrl(List<String> photosUrls) {
        // TODO: 9/12/2017
        /*if (photosUrls != null && !photosUrls.isEmpty() && !photosUrls.get(0).contains("http")) {
            for (int i = 0; i < photosUrls.size(); i++) {
                String photoUrl = photosUrls.get(i);
                photosUrls.set(i, API.getMoiaPhotoUrl(photoUrl));
            }
        } else if (photosUrls == null)
            photosUrls = new ArrayList<>(0);*/

        return photosUrls;
    }

    public static String getPhotosFullUrl(String photoUrl) {
        // TODO: 9/12/2017
        /*if (Preconditions.checkisNotNullOrEmpty(photoUrl) && !photoUrl.contains("http")) {
            return API.getMoiaPhotoUrl(photoUrl);
        }*/
        return photoUrl;
    }

    public static String stripHtml(String html) {
        return html;

        // FIXME: 8/7/2017
        /*String result = "";
        if (Preconditions.checkisNotNullOrEmpty(html)) {
            try {
                result = Jsoup.parse(Jsoup.parse(html).text()).text();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
        return result;*/
    }

    public static Bitmap decodeBase64(String base64) {
        try {
            byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
            if (decodedString != null) {
                return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            }
        } catch (Exception e) {
            Timber.e(e);
        }
        return null;
    }

    public static String saveToInternalStorage(Context context, Bitmap bitmap) {

                /*
                    ContextWrapper
                        Proxying implementation of Context that simply delegates all of its calls
                        to another Context. Can be subclassed to modify behavior without
                        changing the original Context.
                */
        ContextWrapper wrapper = new ContextWrapper(context);

                /*
                    File
                        An "abstract" representation of a file system entity identified by a
                        pathname. The pathname may be absolute (relative to the root directory
                        of the file system) or relative to the current directory in which
                        the program is running.

                        The actual file referenced by a File may or may not exist. It may also,
                        despite the name File, be a directory or other non-regular file.
                */

                /*
                    public File getDir (String name, int mode)
                        Retrieve, creating if needed, a new directory in which the application can
                        place its own custom data files. You can use the returned File object to
                        create and access files in this directory. Note that files created through
                        a File object will only be accessible by your own application; you can only
                        set the mode of the entire directory, not of individual files.

                        Parameters
                        name : Name of the directory to retrieve. This is a directory
                            that is created as part of your application data.
                        mode : Operating mode. Use 0 or MODE_PRIVATE for the default operation,
                            MODE_WORLD_READABLE and MODE_WORLD_WRITEABLE to control permissions.

                        Returns
                            A File object for the requested directory. The directory will
                            have been created if it does not already exist.
                */

                /*
                    public static final int MODE_PRIVATE
                        File creation mode: the default mode, where the created file can only be
                        accessed by the calling application (or all applications sharing
                        the same USER ID).
                */

        // Initializing a new file
        // The bellow line return a directory in internal storage
        File file = wrapper.getDir("Images", Context.MODE_PRIVATE);

                /*
                    public File (String dirPath, String name)
                        Constructs a new File using the specified directory path and file name,
                        placing a path separator between the two.

                        Parameters
                            dirPath : the path to the directory where the file is stored.
                            name : the file's name.

                        Throws
                            NullPointerException if name == null.
                */

        // Create a file to save the imageName
        String imageName = UUID.randomUUID().toString();
        file = new File(file, imageName + ".jpg");
        /*
            OutputStream
                A writable sink for bytes.

                Most clients will use output streams that write data to the file system
                (FileOutputStream), the network (getOutputStream()/getOutputStream()),
                or to an in-memory byte array (ByteArrayOutputStream).

                Use OutputStreamWriter to adapt a byte stream like this one into a
                character stream.
        */
        OutputStream stream = null;

        try {
        /*
            FileOutputStream
                An output stream that writes bytes to a file. If the output file exists,
                it can be replaced or appended to. If it does not exist, a new
                file will be created.
        */

        /*
            public FileOutputStream (File file)
                Constructs a new FileOutputStream that writes to file. The file will be
                truncated if it exists, and created if it doesn't exist.

                Throws
                    FileNotFoundException : if file cannot be opened for writing.
        */

            stream = new FileOutputStream(file);

        /*
            public boolean compress (Bitmap.CompressFormat format, int quality, OutputStream stream)
                Write a compressed version of the bitmap to the specified outputstream.
                If this returns true, the bitmap can be reconstructed by passing a
                corresponding inputstream to BitmapFactory.decodeStream().

                Note: not all Formats support all bitmap configs directly, so it is
                possible that the returned bitmap from BitmapFactory could be in a
                different bitdepth, and/or may have lost per-pixel alpha
                (e.g. JPEG only supports opaque pixels).

                Parameters
                    format : The format of the compressed imageName
                    quality : Hint to the compressor, 0-100. 0 meaning compress for small
                        size, 100 meaning compress for max quality. Some formats,
                        like PNG which is lossless, will ignore the quality setting
                    stream : The outputstream to write the compressed data.
                Returns
                    true : if successfully compressed to the specified stream.
        */
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);


        } catch (IOException e) {
            Timber.e(e);
        } finally {
            try {

                if (stream != null) {
                    /*
                        public void flush ()
                        Flushes this stream. Implementations of this method should ensure
                        that any buffered data is written out. This implementation does nothing.

                        Throws
                        IOException : if an error occurs while flushing this stream.
                    */
                    stream.flush();

                    /*
                        public void close ()
                        Closes this stream. Implementations of this method should free any
                        resources used by the stream. This implementation does nothing.

                        Throws
                        IOException : if an error occurs while closing this stream.
                    */
                    stream.close();
                }
            } catch (IOException e) {
                Timber.e(e);
            }
        }
        return file.getAbsolutePath();
    }

    public static String getDeviceId(Context context) {
        String id = getUniqueID(context);
        if (id == null)
            id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return id;
    }

    private static String getUniqueID(Context context) {

        String telephonyDeviceId = "NoTelephonyId";
        String androidDeviceId = "NoAndroidId";

        // get telephony id
        try {
            final TelephonyManager tm =
                    (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            telephonyDeviceId = tm.getDeviceId();
            if (telephonyDeviceId == null) {
                telephonyDeviceId = "NoTelephonyId";
            }
        } catch (Exception e) {

        }

        // get internal android device id
        try {
            androidDeviceId =
                    Settings.Secure.getString(context.getContentResolver(),
                            Settings.Secure.ANDROID_ID);
            if (androidDeviceId == null) {
                androidDeviceId = "NoAndroidId";
            }
        } catch (Exception e) {

        }

        // build up the uuid
        try {
            String id =
                    getStringIntegerHexBlocks(androidDeviceId.hashCode()) + "-"
                            + getStringIntegerHexBlocks(telephonyDeviceId.hashCode());

            return id;
        } catch (Exception e) {
            return "0000-0000-1111-1111";
        }
    }

    public static String getStringIntegerHexBlocks(int value) {
        String result = "";
        String string = Integer.toHexString(value);

        int remain = 8 - string.length();
        char[] chars = new char[remain];
        Arrays.fill(chars, '0');
        string = new String(chars) + string;

        int count = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            count++;
            result = string.substring(i, i + 1) + result;
            if (count == 4) {
                result = "-" + result;
                count = 0;
            }
        }

        if (result.startsWith("-")) {
            result = result.substring(1, result.length());
        }

        return result;
    }

    public static String getFormattedDate(long date) {
        // FIXME: 1/23/2018
        return "";
    }

    public static String getFormattedDateAccordingToLocal(long date) {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage()))
            return Utils.getFormattedDate(date);
        else
            return Utils.getFormattedHijriDate(date);
    }

    public static String getJustifiedText(Context context, @ColorRes int colorRs, String content) {
        String textColor = getHexColorFromResource(context, colorRs);
        return String.valueOf(getSpannedJustifiedFromText(content, textColor));
    }

    public static Spanned getSpannedJustifiedFromText(String content, String textColor) {
        return Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify;color:" + textColor + "; \">"
                        + content
                        + "</body>]]>");
    }

    public static String getHexColorFromResource(Context context, int color) {
        return context.getString(color);
    }

    public static void call(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        context.startActivity(intent);
    }

    public static Dialog showFullScreenDialog(Activity activity, OnDialogReadyListener onDialogReadyListener) {
        Dialog dialog = new Dialog(activity);
        if (onDialogReadyListener != null) {
            onDialogReadyListener.OnDialogReady(dialog);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        return dialog;
    }

    public static void openGoogleMaps(Context context, double latitude, double longitude) {
        String uri = String.format(Locale.getDefault(), "geo:%f,%f", latitude, longitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        context.startActivity(intent);
    }

    public static void email(@NonNull AppCompatActivity activity, @Nullable String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null));
        /*emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");*/
        activity.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public interface OnDialogReadyListener {
        void OnDialogReady(Dialog dialog);
    }

    public static final class RxUtils {
        public static void dispose(Disposable disposable) {
            try {
                if (disposable != null && !disposable.isDisposed()) disposable.dispose();
            } catch (Exception e) {
                Timber.e(e, "dispose: ");
            }
        }

        public static void dispose(CompositeDisposable compositeDisposable) {
            try {
                if (compositeDisposable != null && !compositeDisposable.isDisposed())
                    compositeDisposable.clear();
            } catch (Exception e) {
                Timber.e(e, "dispose: ");
            }
        }

        public static <T> void dispose(DisposableObserver<T> disposableObserver) {
            try {
                if (disposableObserver != null && !disposableObserver.isDisposed())
                    disposableObserver.dispose();
            } catch (Exception e) {
                Timber.e(e, "dispose: ");
            }
        }
    }


    //    public static String saveToInternalStorage(Context context, Bitmap bitmapImage) {
//        ContextWrapper cw = new ContextWrapper(context);
//        // path to /data/data/yourapp/app_data/imageDir
//        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
//        // Create imageDir
//        String image = UUID.randomUUID().toString();
//        File myPath = new File(directory, image + ".jpg");
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(myPath);
//            // Use the compress method on the BitMap object to write image to the OutputStream
//            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
//        } catch (FileNotFoundException e) {
//            Timber.e(e);
//        } finally {
//            try {
//                if (fos != null) fos.close();
//            } catch (IOException e) {
//                Timber.e(e);
//            }
//        }
//        return directory.getAbsolutePath();
//    }
}
