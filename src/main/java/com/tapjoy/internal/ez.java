package com.tapjoy.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ez extends IInterface {

    public static abstract class a extends Binder implements ez {

        static class a implements ez {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(boolean z) {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ez a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ez)) {
                return new a(iBinder);
            }
            return (ez) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            boolean z = false;
            String a;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a = a();
                    reply.writeNoException();
                    reply.writeString(a);
                    return true;
                case 2:
                    boolean z2;
                    int i;
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (data.readInt() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z2 = a(z2);
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a = a(data.readString());
                    reply.writeNoException();
                    reply.writeString(a);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(a, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String a();

    String a(String str);

    void a(String str, boolean z);

    boolean a(boolean z);
}
