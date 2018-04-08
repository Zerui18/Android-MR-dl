package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zzm extends IInterface {

    public static abstract class zza extends Binder implements zzm {

        private static class zza implements zzm {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzI(List<Update> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    obtain.writeTypedList(list);
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzv com_google_android_gms_nearby_messages_internal_zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (com_google_android_gms_nearby_messages_internal_zzv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(zzv com_google_android_gms_nearby_messages_internal_zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (com_google_android_gms_nearby_messages_internal_zzv != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzv.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IMessageListener");
        }

        public static zzm zzeC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new zza(iBinder) : (zzm) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzv com_google_android_gms_nearby_messages_internal_zzv = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzv = (zzv) zzv.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzv);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzv = (zzv) zzv.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_nearby_messages_internal_zzv);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    zzI(parcel.createTypedArrayList(Update.CREATOR));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzI(List<Update> list) throws RemoteException;

    void zza(zzv com_google_android_gms_nearby_messages_internal_zzv) throws RemoteException;

    void zzb(zzv com_google_android_gms_nearby_messages_internal_zzv) throws RemoteException;
}
