package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzo extends IInterface {

    public static abstract class zza extends Binder implements zzo {

        private static class zza implements zzo {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzab com_google_android_gms_nearby_messages_internal_zzab) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzab != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzab.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzad com_google_android_gms_nearby_messages_internal_zzad) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzad != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzad.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_nearby_messages_internal_zzag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzag != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzag.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzai com_google_android_gms_nearby_messages_internal_zzai) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzai != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzai.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_nearby_messages_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_nearby_messages_internal_zzj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_nearby_messages_internal_zzj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzo zzeE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzo)) ? new zza(iBinder) : (zzo) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzj com_google_android_gms_nearby_messages_internal_zzj = null;
            switch (i) {
                case 1:
                    zzab com_google_android_gms_nearby_messages_internal_zzab;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzab = (zzab) zzab.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzab);
                    return true;
                case 2:
                    zzag com_google_android_gms_nearby_messages_internal_zzag;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzag = (zzag) zzag.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzag);
                    return true;
                case 3:
                    SubscribeRequest subscribeRequest;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        subscribeRequest = (SubscribeRequest) SubscribeRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(subscribeRequest);
                    return true;
                case 4:
                    zzai com_google_android_gms_nearby_messages_internal_zzai;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzai = (zzai) zzai.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzai);
                    return true;
                case 7:
                    zzh com_google_android_gms_nearby_messages_internal_zzh;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzh = (zzh) zzh.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzh);
                    return true;
                case 8:
                    zzad com_google_android_gms_nearby_messages_internal_zzad;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzad = (zzad) zzad.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzad);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_nearby_messages_internal_zzj = (zzj) zzj.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_nearby_messages_internal_zzj);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(zzab com_google_android_gms_nearby_messages_internal_zzab) throws RemoteException;

    void zza(zzad com_google_android_gms_nearby_messages_internal_zzad) throws RemoteException;

    void zza(zzag com_google_android_gms_nearby_messages_internal_zzag) throws RemoteException;

    void zza(zzai com_google_android_gms_nearby_messages_internal_zzai) throws RemoteException;

    void zza(zzh com_google_android_gms_nearby_messages_internal_zzh) throws RemoteException;

    void zza(zzj com_google_android_gms_nearby_messages_internal_zzj) throws RemoteException;
}
