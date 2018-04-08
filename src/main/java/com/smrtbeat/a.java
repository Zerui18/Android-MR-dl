package com.smrtbeat;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.quest.Quests;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

class a {
    static final int a = 0;
    static final int b = 1;
    static final int c = 0;
    static final int d = 2;
    static final int e = 4;
    static final int f = 8;
    static final int g = 16;
    static final int h = 32;
    static final /* synthetic */ boolean i = (!a.class.desiredAssertionStatus());
    private static final int j = 76;
    private static final byte k = (byte) 61;
    private static final byte l = (byte) 10;
    private static final String m = "US-ASCII";
    private static final byte n = (byte) -5;
    private static final byte o = (byte) -1;
    private static final byte[] p = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] q;
    private static final byte[] r = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    private static final byte[] s;
    private static final byte[] t = new byte[]{(byte) 45, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 95, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};
    private static final byte[] u;

    static {
        byte[] bArr = new byte[256];
        bArr[0] = (byte) -9;
        bArr[1] = (byte) -9;
        bArr[2] = (byte) -9;
        bArr[3] = (byte) -9;
        bArr[4] = (byte) -9;
        bArr[5] = (byte) -9;
        bArr[6] = (byte) -9;
        bArr[7] = (byte) -9;
        bArr[8] = (byte) -9;
        bArr[9] = n;
        bArr[10] = n;
        bArr[11] = (byte) -9;
        bArr[12] = (byte) -9;
        bArr[13] = n;
        bArr[14] = (byte) -9;
        bArr[15] = (byte) -9;
        bArr[16] = (byte) -9;
        bArr[17] = (byte) -9;
        bArr[18] = (byte) -9;
        bArr[19] = (byte) -9;
        bArr[20] = (byte) -9;
        bArr[21] = (byte) -9;
        bArr[22] = (byte) -9;
        bArr[23] = (byte) -9;
        bArr[24] = (byte) -9;
        bArr[25] = (byte) -9;
        bArr[26] = (byte) -9;
        bArr[27] = (byte) -9;
        bArr[28] = (byte) -9;
        bArr[29] = (byte) -9;
        bArr[30] = (byte) -9;
        bArr[31] = (byte) -9;
        bArr[32] = n;
        bArr[33] = (byte) -9;
        bArr[34] = (byte) -9;
        bArr[35] = (byte) -9;
        bArr[36] = (byte) -9;
        bArr[37] = (byte) -9;
        bArr[38] = (byte) -9;
        bArr[39] = (byte) -9;
        bArr[40] = (byte) -9;
        bArr[41] = (byte) -9;
        bArr[42] = (byte) -9;
        bArr[43] = (byte) 62;
        bArr[44] = (byte) -9;
        bArr[45] = (byte) -9;
        bArr[46] = (byte) -9;
        bArr[47] = (byte) 63;
        bArr[48] = (byte) 52;
        bArr[49] = (byte) 53;
        bArr[50] = (byte) 54;
        bArr[51] = (byte) 55;
        bArr[52] = (byte) 56;
        bArr[53] = (byte) 57;
        bArr[54] = (byte) 58;
        bArr[55] = (byte) 59;
        bArr[56] = (byte) 60;
        bArr[57] = k;
        bArr[58] = (byte) -9;
        bArr[59] = (byte) -9;
        bArr[60] = (byte) -9;
        bArr[61] = o;
        bArr[62] = (byte) -9;
        bArr[63] = (byte) -9;
        bArr[64] = (byte) -9;
        bArr[66] = (byte) 1;
        bArr[67] = (byte) 2;
        bArr[68] = (byte) 3;
        bArr[69] = (byte) 4;
        bArr[70] = (byte) 5;
        bArr[71] = (byte) 6;
        bArr[72] = (byte) 7;
        bArr[73] = (byte) 8;
        bArr[74] = (byte) 9;
        bArr[75] = l;
        bArr[j] = (byte) 11;
        bArr[77] = (byte) 12;
        bArr[78] = (byte) 13;
        bArr[79] = (byte) 14;
        bArr[80] = (byte) 15;
        bArr[81] = (byte) 16;
        bArr[82] = (byte) 17;
        bArr[83] = (byte) 18;
        bArr[84] = (byte) 19;
        bArr[85] = (byte) 20;
        bArr[86] = (byte) 21;
        bArr[87] = (byte) 22;
        bArr[88] = (byte) 23;
        bArr[89] = (byte) 24;
        bArr[90] = (byte) 25;
        bArr[91] = (byte) -9;
        bArr[92] = (byte) -9;
        bArr[93] = (byte) -9;
        bArr[94] = (byte) -9;
        bArr[95] = (byte) -9;
        bArr[96] = (byte) -9;
        bArr[97] = (byte) 26;
        bArr[98] = (byte) 27;
        bArr[99] = (byte) 28;
        bArr[100] = (byte) 29;
        bArr[Quests.SELECT_COMPLETED_UNCLAIMED] = (byte) 30;
        bArr[102] = (byte) 31;
        bArr[Quests.SELECT_RECENTLY_FAILED] = (byte) 32;
        bArr[104] = (byte) 33;
        bArr[105] = (byte) 34;
        bArr[106] = (byte) 35;
        bArr[107] = (byte) 36;
        bArr[108] = (byte) 37;
        bArr[109] = (byte) 38;
        bArr[110] = (byte) 39;
        bArr[111] = (byte) 40;
        bArr[112] = (byte) 41;
        bArr[113] = (byte) 42;
        bArr[114] = (byte) 43;
        bArr[115] = (byte) 44;
        bArr[116] = (byte) 45;
        bArr[117] = (byte) 46;
        bArr[118] = (byte) 47;
        bArr[119] = (byte) 48;
        bArr[120] = (byte) 49;
        bArr[121] = (byte) 50;
        bArr[122] = (byte) 51;
        bArr[123] = (byte) -9;
        bArr[MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES] = (byte) -9;
        bArr[125] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PLAY] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PAUSE] = (byte) -9;
        bArr[128] = (byte) -9;
        bArr[129] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_RECORD] = (byte) -9;
        bArr[131] = (byte) -9;
        bArr[132] = (byte) -9;
        bArr[133] = (byte) -9;
        bArr[134] = (byte) -9;
        bArr[135] = (byte) -9;
        bArr[136] = (byte) -9;
        bArr[137] = (byte) -9;
        bArr[138] = (byte) -9;
        bArr[139] = (byte) -9;
        bArr[140] = (byte) -9;
        bArr[141] = (byte) -9;
        bArr[142] = (byte) -9;
        bArr[143] = (byte) -9;
        bArr[144] = (byte) -9;
        bArr[145] = (byte) -9;
        bArr[146] = (byte) -9;
        bArr[147] = (byte) -9;
        bArr[148] = (byte) -9;
        bArr[149] = (byte) -9;
        bArr[150] = (byte) -9;
        bArr[151] = (byte) -9;
        bArr[152] = (byte) -9;
        bArr[153] = (byte) -9;
        bArr[154] = (byte) -9;
        bArr[155] = (byte) -9;
        bArr[156] = (byte) -9;
        bArr[157] = (byte) -9;
        bArr[158] = (byte) -9;
        bArr[159] = (byte) -9;
        bArr[160] = (byte) -9;
        bArr[161] = (byte) -9;
        bArr[162] = (byte) -9;
        bArr[163] = (byte) -9;
        bArr[164] = (byte) -9;
        bArr[165] = (byte) -9;
        bArr[166] = (byte) -9;
        bArr[167] = (byte) -9;
        bArr[168] = (byte) -9;
        bArr[169] = (byte) -9;
        bArr[170] = (byte) -9;
        bArr[171] = (byte) -9;
        bArr[172] = (byte) -9;
        bArr[173] = (byte) -9;
        bArr[174] = (byte) -9;
        bArr[175] = (byte) -9;
        bArr[176] = (byte) -9;
        bArr[177] = (byte) -9;
        bArr[178] = (byte) -9;
        bArr[179] = (byte) -9;
        bArr[180] = (byte) -9;
        bArr[181] = (byte) -9;
        bArr[182] = (byte) -9;
        bArr[183] = (byte) -9;
        bArr[184] = (byte) -9;
        bArr[185] = (byte) -9;
        bArr[186] = (byte) -9;
        bArr[187] = (byte) -9;
        bArr[188] = (byte) -9;
        bArr[189] = (byte) -9;
        bArr[190] = (byte) -9;
        bArr[191] = (byte) -9;
        bArr[192] = (byte) -9;
        bArr[193] = (byte) -9;
        bArr[194] = (byte) -9;
        bArr[195] = (byte) -9;
        bArr[196] = (byte) -9;
        bArr[197] = (byte) -9;
        bArr[198] = (byte) -9;
        bArr[199] = (byte) -9;
        bArr[200] = (byte) -9;
        bArr[201] = (byte) -9;
        bArr[202] = (byte) -9;
        bArr[203] = (byte) -9;
        bArr[204] = (byte) -9;
        bArr[205] = (byte) -9;
        bArr[206] = (byte) -9;
        bArr[207] = (byte) -9;
        bArr[208] = (byte) -9;
        bArr[209] = (byte) -9;
        bArr[210] = (byte) -9;
        bArr[211] = (byte) -9;
        bArr[212] = (byte) -9;
        bArr[213] = (byte) -9;
        bArr[214] = (byte) -9;
        bArr[215] = (byte) -9;
        bArr[216] = (byte) -9;
        bArr[217] = (byte) -9;
        bArr[218] = (byte) -9;
        bArr[219] = (byte) -9;
        bArr[220] = (byte) -9;
        bArr[221] = (byte) -9;
        bArr[222] = (byte) -9;
        bArr[223] = (byte) -9;
        bArr[224] = (byte) -9;
        bArr[225] = (byte) -9;
        bArr[226] = (byte) -9;
        bArr[227] = (byte) -9;
        bArr[228] = (byte) -9;
        bArr[229] = (byte) -9;
        bArr[230] = (byte) -9;
        bArr[231] = (byte) -9;
        bArr[232] = (byte) -9;
        bArr[233] = (byte) -9;
        bArr[234] = (byte) -9;
        bArr[235] = (byte) -9;
        bArr[236] = (byte) -9;
        bArr[237] = (byte) -9;
        bArr[238] = (byte) -9;
        bArr[239] = (byte) -9;
        bArr[240] = (byte) -9;
        bArr[241] = (byte) -9;
        bArr[242] = (byte) -9;
        bArr[243] = (byte) -9;
        bArr[244] = (byte) -9;
        bArr[245] = (byte) -9;
        bArr[246] = (byte) -9;
        bArr[247] = (byte) -9;
        bArr[248] = (byte) -9;
        bArr[249] = (byte) -9;
        bArr[250] = (byte) -9;
        bArr[251] = (byte) -9;
        bArr[252] = (byte) -9;
        bArr[253] = (byte) -9;
        bArr[254] = (byte) -9;
        bArr[255] = (byte) -9;
        q = bArr;
        bArr = new byte[256];
        bArr[0] = (byte) -9;
        bArr[1] = (byte) -9;
        bArr[2] = (byte) -9;
        bArr[3] = (byte) -9;
        bArr[4] = (byte) -9;
        bArr[5] = (byte) -9;
        bArr[6] = (byte) -9;
        bArr[7] = (byte) -9;
        bArr[8] = (byte) -9;
        bArr[9] = n;
        bArr[10] = n;
        bArr[11] = (byte) -9;
        bArr[12] = (byte) -9;
        bArr[13] = n;
        bArr[14] = (byte) -9;
        bArr[15] = (byte) -9;
        bArr[16] = (byte) -9;
        bArr[17] = (byte) -9;
        bArr[18] = (byte) -9;
        bArr[19] = (byte) -9;
        bArr[20] = (byte) -9;
        bArr[21] = (byte) -9;
        bArr[22] = (byte) -9;
        bArr[23] = (byte) -9;
        bArr[24] = (byte) -9;
        bArr[25] = (byte) -9;
        bArr[26] = (byte) -9;
        bArr[27] = (byte) -9;
        bArr[28] = (byte) -9;
        bArr[29] = (byte) -9;
        bArr[30] = (byte) -9;
        bArr[31] = (byte) -9;
        bArr[32] = n;
        bArr[33] = (byte) -9;
        bArr[34] = (byte) -9;
        bArr[35] = (byte) -9;
        bArr[36] = (byte) -9;
        bArr[37] = (byte) -9;
        bArr[38] = (byte) -9;
        bArr[39] = (byte) -9;
        bArr[40] = (byte) -9;
        bArr[41] = (byte) -9;
        bArr[42] = (byte) -9;
        bArr[43] = (byte) -9;
        bArr[44] = (byte) -9;
        bArr[45] = (byte) 62;
        bArr[46] = (byte) -9;
        bArr[47] = (byte) -9;
        bArr[48] = (byte) 52;
        bArr[49] = (byte) 53;
        bArr[50] = (byte) 54;
        bArr[51] = (byte) 55;
        bArr[52] = (byte) 56;
        bArr[53] = (byte) 57;
        bArr[54] = (byte) 58;
        bArr[55] = (byte) 59;
        bArr[56] = (byte) 60;
        bArr[57] = k;
        bArr[58] = (byte) -9;
        bArr[59] = (byte) -9;
        bArr[60] = (byte) -9;
        bArr[61] = o;
        bArr[62] = (byte) -9;
        bArr[63] = (byte) -9;
        bArr[64] = (byte) -9;
        bArr[66] = (byte) 1;
        bArr[67] = (byte) 2;
        bArr[68] = (byte) 3;
        bArr[69] = (byte) 4;
        bArr[70] = (byte) 5;
        bArr[71] = (byte) 6;
        bArr[72] = (byte) 7;
        bArr[73] = (byte) 8;
        bArr[74] = (byte) 9;
        bArr[75] = l;
        bArr[j] = (byte) 11;
        bArr[77] = (byte) 12;
        bArr[78] = (byte) 13;
        bArr[79] = (byte) 14;
        bArr[80] = (byte) 15;
        bArr[81] = (byte) 16;
        bArr[82] = (byte) 17;
        bArr[83] = (byte) 18;
        bArr[84] = (byte) 19;
        bArr[85] = (byte) 20;
        bArr[86] = (byte) 21;
        bArr[87] = (byte) 22;
        bArr[88] = (byte) 23;
        bArr[89] = (byte) 24;
        bArr[90] = (byte) 25;
        bArr[91] = (byte) -9;
        bArr[92] = (byte) -9;
        bArr[93] = (byte) -9;
        bArr[94] = (byte) -9;
        bArr[95] = (byte) 63;
        bArr[96] = (byte) -9;
        bArr[97] = (byte) 26;
        bArr[98] = (byte) 27;
        bArr[99] = (byte) 28;
        bArr[100] = (byte) 29;
        bArr[Quests.SELECT_COMPLETED_UNCLAIMED] = (byte) 30;
        bArr[102] = (byte) 31;
        bArr[Quests.SELECT_RECENTLY_FAILED] = (byte) 32;
        bArr[104] = (byte) 33;
        bArr[105] = (byte) 34;
        bArr[106] = (byte) 35;
        bArr[107] = (byte) 36;
        bArr[108] = (byte) 37;
        bArr[109] = (byte) 38;
        bArr[110] = (byte) 39;
        bArr[111] = (byte) 40;
        bArr[112] = (byte) 41;
        bArr[113] = (byte) 42;
        bArr[114] = (byte) 43;
        bArr[115] = (byte) 44;
        bArr[116] = (byte) 45;
        bArr[117] = (byte) 46;
        bArr[118] = (byte) 47;
        bArr[119] = (byte) 48;
        bArr[120] = (byte) 49;
        bArr[121] = (byte) 50;
        bArr[122] = (byte) 51;
        bArr[123] = (byte) -9;
        bArr[MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES] = (byte) -9;
        bArr[125] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PLAY] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PAUSE] = (byte) -9;
        bArr[128] = (byte) -9;
        bArr[129] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_RECORD] = (byte) -9;
        bArr[131] = (byte) -9;
        bArr[132] = (byte) -9;
        bArr[133] = (byte) -9;
        bArr[134] = (byte) -9;
        bArr[135] = (byte) -9;
        bArr[136] = (byte) -9;
        bArr[137] = (byte) -9;
        bArr[138] = (byte) -9;
        bArr[139] = (byte) -9;
        bArr[140] = (byte) -9;
        bArr[141] = (byte) -9;
        bArr[142] = (byte) -9;
        bArr[143] = (byte) -9;
        bArr[144] = (byte) -9;
        bArr[145] = (byte) -9;
        bArr[146] = (byte) -9;
        bArr[147] = (byte) -9;
        bArr[148] = (byte) -9;
        bArr[149] = (byte) -9;
        bArr[150] = (byte) -9;
        bArr[151] = (byte) -9;
        bArr[152] = (byte) -9;
        bArr[153] = (byte) -9;
        bArr[154] = (byte) -9;
        bArr[155] = (byte) -9;
        bArr[156] = (byte) -9;
        bArr[157] = (byte) -9;
        bArr[158] = (byte) -9;
        bArr[159] = (byte) -9;
        bArr[160] = (byte) -9;
        bArr[161] = (byte) -9;
        bArr[162] = (byte) -9;
        bArr[163] = (byte) -9;
        bArr[164] = (byte) -9;
        bArr[165] = (byte) -9;
        bArr[166] = (byte) -9;
        bArr[167] = (byte) -9;
        bArr[168] = (byte) -9;
        bArr[169] = (byte) -9;
        bArr[170] = (byte) -9;
        bArr[171] = (byte) -9;
        bArr[172] = (byte) -9;
        bArr[173] = (byte) -9;
        bArr[174] = (byte) -9;
        bArr[175] = (byte) -9;
        bArr[176] = (byte) -9;
        bArr[177] = (byte) -9;
        bArr[178] = (byte) -9;
        bArr[179] = (byte) -9;
        bArr[180] = (byte) -9;
        bArr[181] = (byte) -9;
        bArr[182] = (byte) -9;
        bArr[183] = (byte) -9;
        bArr[184] = (byte) -9;
        bArr[185] = (byte) -9;
        bArr[186] = (byte) -9;
        bArr[187] = (byte) -9;
        bArr[188] = (byte) -9;
        bArr[189] = (byte) -9;
        bArr[190] = (byte) -9;
        bArr[191] = (byte) -9;
        bArr[192] = (byte) -9;
        bArr[193] = (byte) -9;
        bArr[194] = (byte) -9;
        bArr[195] = (byte) -9;
        bArr[196] = (byte) -9;
        bArr[197] = (byte) -9;
        bArr[198] = (byte) -9;
        bArr[199] = (byte) -9;
        bArr[200] = (byte) -9;
        bArr[201] = (byte) -9;
        bArr[202] = (byte) -9;
        bArr[203] = (byte) -9;
        bArr[204] = (byte) -9;
        bArr[205] = (byte) -9;
        bArr[206] = (byte) -9;
        bArr[207] = (byte) -9;
        bArr[208] = (byte) -9;
        bArr[209] = (byte) -9;
        bArr[210] = (byte) -9;
        bArr[211] = (byte) -9;
        bArr[212] = (byte) -9;
        bArr[213] = (byte) -9;
        bArr[214] = (byte) -9;
        bArr[215] = (byte) -9;
        bArr[216] = (byte) -9;
        bArr[217] = (byte) -9;
        bArr[218] = (byte) -9;
        bArr[219] = (byte) -9;
        bArr[220] = (byte) -9;
        bArr[221] = (byte) -9;
        bArr[222] = (byte) -9;
        bArr[223] = (byte) -9;
        bArr[224] = (byte) -9;
        bArr[225] = (byte) -9;
        bArr[226] = (byte) -9;
        bArr[227] = (byte) -9;
        bArr[228] = (byte) -9;
        bArr[229] = (byte) -9;
        bArr[230] = (byte) -9;
        bArr[231] = (byte) -9;
        bArr[232] = (byte) -9;
        bArr[233] = (byte) -9;
        bArr[234] = (byte) -9;
        bArr[235] = (byte) -9;
        bArr[236] = (byte) -9;
        bArr[237] = (byte) -9;
        bArr[238] = (byte) -9;
        bArr[239] = (byte) -9;
        bArr[240] = (byte) -9;
        bArr[241] = (byte) -9;
        bArr[242] = (byte) -9;
        bArr[243] = (byte) -9;
        bArr[244] = (byte) -9;
        bArr[245] = (byte) -9;
        bArr[246] = (byte) -9;
        bArr[247] = (byte) -9;
        bArr[248] = (byte) -9;
        bArr[249] = (byte) -9;
        bArr[250] = (byte) -9;
        bArr[251] = (byte) -9;
        bArr[252] = (byte) -9;
        bArr[253] = (byte) -9;
        bArr[254] = (byte) -9;
        bArr[255] = (byte) -9;
        s = bArr;
        bArr = new byte[257];
        bArr[0] = (byte) -9;
        bArr[1] = (byte) -9;
        bArr[2] = (byte) -9;
        bArr[3] = (byte) -9;
        bArr[4] = (byte) -9;
        bArr[5] = (byte) -9;
        bArr[6] = (byte) -9;
        bArr[7] = (byte) -9;
        bArr[8] = (byte) -9;
        bArr[9] = n;
        bArr[10] = n;
        bArr[11] = (byte) -9;
        bArr[12] = (byte) -9;
        bArr[13] = n;
        bArr[14] = (byte) -9;
        bArr[15] = (byte) -9;
        bArr[16] = (byte) -9;
        bArr[17] = (byte) -9;
        bArr[18] = (byte) -9;
        bArr[19] = (byte) -9;
        bArr[20] = (byte) -9;
        bArr[21] = (byte) -9;
        bArr[22] = (byte) -9;
        bArr[23] = (byte) -9;
        bArr[24] = (byte) -9;
        bArr[25] = (byte) -9;
        bArr[26] = (byte) -9;
        bArr[27] = (byte) -9;
        bArr[28] = (byte) -9;
        bArr[29] = (byte) -9;
        bArr[30] = (byte) -9;
        bArr[31] = (byte) -9;
        bArr[32] = n;
        bArr[33] = (byte) -9;
        bArr[34] = (byte) -9;
        bArr[35] = (byte) -9;
        bArr[36] = (byte) -9;
        bArr[37] = (byte) -9;
        bArr[38] = (byte) -9;
        bArr[39] = (byte) -9;
        bArr[40] = (byte) -9;
        bArr[41] = (byte) -9;
        bArr[42] = (byte) -9;
        bArr[43] = (byte) -9;
        bArr[44] = (byte) -9;
        bArr[46] = (byte) -9;
        bArr[47] = (byte) -9;
        bArr[48] = (byte) 1;
        bArr[49] = (byte) 2;
        bArr[50] = (byte) 3;
        bArr[51] = (byte) 4;
        bArr[52] = (byte) 5;
        bArr[53] = (byte) 6;
        bArr[54] = (byte) 7;
        bArr[55] = (byte) 8;
        bArr[56] = (byte) 9;
        bArr[57] = l;
        bArr[58] = (byte) -9;
        bArr[59] = (byte) -9;
        bArr[60] = (byte) -9;
        bArr[61] = o;
        bArr[62] = (byte) -9;
        bArr[63] = (byte) -9;
        bArr[64] = (byte) -9;
        bArr[65] = (byte) 11;
        bArr[66] = (byte) 12;
        bArr[67] = (byte) 13;
        bArr[68] = (byte) 14;
        bArr[69] = (byte) 15;
        bArr[70] = (byte) 16;
        bArr[71] = (byte) 17;
        bArr[72] = (byte) 18;
        bArr[73] = (byte) 19;
        bArr[74] = (byte) 20;
        bArr[75] = (byte) 21;
        bArr[j] = (byte) 22;
        bArr[77] = (byte) 23;
        bArr[78] = (byte) 24;
        bArr[79] = (byte) 25;
        bArr[80] = (byte) 26;
        bArr[81] = (byte) 27;
        bArr[82] = (byte) 28;
        bArr[83] = (byte) 29;
        bArr[84] = (byte) 30;
        bArr[85] = (byte) 31;
        bArr[86] = (byte) 32;
        bArr[87] = (byte) 33;
        bArr[88] = (byte) 34;
        bArr[89] = (byte) 35;
        bArr[90] = (byte) 36;
        bArr[91] = (byte) -9;
        bArr[92] = (byte) -9;
        bArr[93] = (byte) -9;
        bArr[94] = (byte) -9;
        bArr[95] = (byte) 37;
        bArr[96] = (byte) -9;
        bArr[97] = (byte) 38;
        bArr[98] = (byte) 39;
        bArr[99] = (byte) 40;
        bArr[100] = (byte) 41;
        bArr[Quests.SELECT_COMPLETED_UNCLAIMED] = (byte) 42;
        bArr[102] = (byte) 43;
        bArr[Quests.SELECT_RECENTLY_FAILED] = (byte) 44;
        bArr[104] = (byte) 45;
        bArr[105] = (byte) 46;
        bArr[106] = (byte) 47;
        bArr[107] = (byte) 48;
        bArr[108] = (byte) 49;
        bArr[109] = (byte) 50;
        bArr[110] = (byte) 51;
        bArr[111] = (byte) 52;
        bArr[112] = (byte) 53;
        bArr[113] = (byte) 54;
        bArr[114] = (byte) 55;
        bArr[115] = (byte) 56;
        bArr[116] = (byte) 57;
        bArr[117] = (byte) 58;
        bArr[118] = (byte) 59;
        bArr[119] = (byte) 60;
        bArr[120] = k;
        bArr[121] = (byte) 62;
        bArr[122] = (byte) 63;
        bArr[123] = (byte) -9;
        bArr[MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES] = (byte) -9;
        bArr[125] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PLAY] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_PAUSE] = (byte) -9;
        bArr[128] = (byte) -9;
        bArr[129] = (byte) -9;
        bArr[TransportMediator.KEYCODE_MEDIA_RECORD] = (byte) -9;
        bArr[131] = (byte) -9;
        bArr[132] = (byte) -9;
        bArr[133] = (byte) -9;
        bArr[134] = (byte) -9;
        bArr[135] = (byte) -9;
        bArr[136] = (byte) -9;
        bArr[137] = (byte) -9;
        bArr[138] = (byte) -9;
        bArr[139] = (byte) -9;
        bArr[140] = (byte) -9;
        bArr[141] = (byte) -9;
        bArr[142] = (byte) -9;
        bArr[143] = (byte) -9;
        bArr[144] = (byte) -9;
        bArr[145] = (byte) -9;
        bArr[146] = (byte) -9;
        bArr[147] = (byte) -9;
        bArr[148] = (byte) -9;
        bArr[149] = (byte) -9;
        bArr[150] = (byte) -9;
        bArr[151] = (byte) -9;
        bArr[152] = (byte) -9;
        bArr[153] = (byte) -9;
        bArr[154] = (byte) -9;
        bArr[155] = (byte) -9;
        bArr[156] = (byte) -9;
        bArr[157] = (byte) -9;
        bArr[158] = (byte) -9;
        bArr[159] = (byte) -9;
        bArr[160] = (byte) -9;
        bArr[161] = (byte) -9;
        bArr[162] = (byte) -9;
        bArr[163] = (byte) -9;
        bArr[164] = (byte) -9;
        bArr[165] = (byte) -9;
        bArr[166] = (byte) -9;
        bArr[167] = (byte) -9;
        bArr[168] = (byte) -9;
        bArr[169] = (byte) -9;
        bArr[170] = (byte) -9;
        bArr[171] = (byte) -9;
        bArr[172] = (byte) -9;
        bArr[173] = (byte) -9;
        bArr[174] = (byte) -9;
        bArr[175] = (byte) -9;
        bArr[176] = (byte) -9;
        bArr[177] = (byte) -9;
        bArr[178] = (byte) -9;
        bArr[179] = (byte) -9;
        bArr[180] = (byte) -9;
        bArr[181] = (byte) -9;
        bArr[182] = (byte) -9;
        bArr[183] = (byte) -9;
        bArr[184] = (byte) -9;
        bArr[185] = (byte) -9;
        bArr[186] = (byte) -9;
        bArr[187] = (byte) -9;
        bArr[188] = (byte) -9;
        bArr[189] = (byte) -9;
        bArr[190] = (byte) -9;
        bArr[191] = (byte) -9;
        bArr[192] = (byte) -9;
        bArr[193] = (byte) -9;
        bArr[194] = (byte) -9;
        bArr[195] = (byte) -9;
        bArr[196] = (byte) -9;
        bArr[197] = (byte) -9;
        bArr[198] = (byte) -9;
        bArr[199] = (byte) -9;
        bArr[200] = (byte) -9;
        bArr[201] = (byte) -9;
        bArr[202] = (byte) -9;
        bArr[203] = (byte) -9;
        bArr[204] = (byte) -9;
        bArr[205] = (byte) -9;
        bArr[206] = (byte) -9;
        bArr[207] = (byte) -9;
        bArr[208] = (byte) -9;
        bArr[209] = (byte) -9;
        bArr[210] = (byte) -9;
        bArr[211] = (byte) -9;
        bArr[212] = (byte) -9;
        bArr[213] = (byte) -9;
        bArr[214] = (byte) -9;
        bArr[215] = (byte) -9;
        bArr[216] = (byte) -9;
        bArr[217] = (byte) -9;
        bArr[218] = (byte) -9;
        bArr[219] = (byte) -9;
        bArr[220] = (byte) -9;
        bArr[221] = (byte) -9;
        bArr[222] = (byte) -9;
        bArr[223] = (byte) -9;
        bArr[224] = (byte) -9;
        bArr[225] = (byte) -9;
        bArr[226] = (byte) -9;
        bArr[227] = (byte) -9;
        bArr[228] = (byte) -9;
        bArr[229] = (byte) -9;
        bArr[230] = (byte) -9;
        bArr[231] = (byte) -9;
        bArr[232] = (byte) -9;
        bArr[233] = (byte) -9;
        bArr[234] = (byte) -9;
        bArr[235] = (byte) -9;
        bArr[236] = (byte) -9;
        bArr[237] = (byte) -9;
        bArr[238] = (byte) -9;
        bArr[239] = (byte) -9;
        bArr[240] = (byte) -9;
        bArr[241] = (byte) -9;
        bArr[242] = (byte) -9;
        bArr[243] = (byte) -9;
        bArr[244] = (byte) -9;
        bArr[245] = (byte) -9;
        bArr[246] = (byte) -9;
        bArr[247] = (byte) -9;
        bArr[248] = (byte) -9;
        bArr[249] = (byte) -9;
        bArr[250] = (byte) -9;
        bArr[251] = (byte) -9;
        bArr[252] = (byte) -9;
        bArr[253] = (byte) -9;
        bArr[254] = (byte) -9;
        bArr[255] = (byte) -9;
        bArr[256] = (byte) -9;
        u = bArr;
    }

    private a() {
    }

    static Object a(String str, int i, ClassLoader classLoader) {
        IOException e;
        Throwable th;
        ClassNotFoundException e2;
        InputStream inputStream = null;
        ByteArrayInputStream byteArrayInputStream;
        try {
            ObjectInputStream objectInputStream;
            byteArrayInputStream = new ByteArrayInputStream(a(str, i));
            if (classLoader == null) {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException e3) {
                    e = e3;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (ClassNotFoundException e4) {
                    e2 = e4;
                    throw e2;
                }
            } else {
                objectInputStream = new b(byteArrayInputStream, classLoader);
            }
            Object readObject = objectInputStream.readObject();
            try {
                byteArrayInputStream.close();
            } catch (Exception e5) {
            }
            try {
                objectInputStream.close();
            } catch (Exception e6) {
            }
            return readObject;
        } catch (IOException e7) {
            e = e7;
            byteArrayInputStream = inputStream;
            throw e;
        } catch (ClassNotFoundException e8) {
            e2 = e8;
            byteArrayInputStream = inputStream;
            throw e2;
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream2 = inputStream;
            try {
                byteArrayInputStream.close();
            } catch (Exception e9) {
            }
            try {
                inputStream.close();
            } catch (Exception e10) {
            }
            throw th;
        }
    }

    static String a(Serializable serializable) {
        return a(serializable, 0);
    }

    static String a(Serializable serializable, int i) {
        GZIPOutputStream gZIPOutputStream;
        IOException e;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2 = null;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream dVar;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream;
                dVar = new d(byteArrayOutputStream, i | 1);
                if ((i & 2) != 0) {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(dVar);
                    } catch (IOException e2) {
                        e = e2;
                        outputStream = outputStream2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = outputStream2;
                        try {
                            outputStream2.close();
                        } catch (Exception e3) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e4) {
                        }
                        try {
                            dVar.close();
                        } catch (Exception e5) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e6) {
                        }
                        throw th;
                    }
                    try {
                        objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                    } catch (IOException e7) {
                        e = e7;
                        throw e;
                    }
                } else {
                    outputStream = outputStream2;
                    objectOutputStream = new ObjectOutputStream(dVar);
                }
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                } catch (Exception e8) {
                }
                try {
                    gZIPOutputStream.close();
                } catch (Exception e9) {
                }
                try {
                    dVar.close();
                } catch (Exception e10) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e11) {
                }
                try {
                    return new String(byteArrayOutputStream.toByteArray(), m);
                } catch (UnsupportedEncodingException e12) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
            } catch (IOException e13) {
                e = e13;
                outputStream = outputStream2;
                dVar = outputStream2;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                dVar = outputStream2;
                outputStream2.close();
                gZIPOutputStream.close();
                dVar.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            gZIPOutputStream = outputStream2;
            dVar = outputStream2;
            byteArrayOutputStream = outputStream2;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            outputStream = outputStream2;
            dVar = outputStream2;
            OutputStream outputStream3 = outputStream2;
            outputStream2.close();
            gZIPOutputStream.close();
            dVar.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    static String a(byte[] bArr) {
        String str = null;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    static String a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    static String a(byte[] bArr, int i, int i2) {
        String str = null;
        try {
            str = a(bArr, i, i2, 0);
        } catch (IOException e) {
        }
        if (i || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    static String a(byte[] bArr, int i, int i2, int i3) {
        byte[] b = b(bArr, i, i2, i3);
        try {
            return new String(b, m);
        } catch (UnsupportedEncodingException e) {
            return new String(b);
        }
    }

    static void a(String str, String str2) {
        IOException e;
        Throwable th;
        d dVar;
        try {
            dVar = new d(new FileOutputStream(str2), 0);
            try {
                dVar.write(str.getBytes(m));
                try {
                    dVar.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            dVar = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
            try {
                dVar.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (min = 0; min < 4; min++) {
                charBuffer.put((char) (bArr2[min] & 255));
            }
        }
    }

    static void a(byte[] bArr, String str) {
        IOException e;
        Throwable th;
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
        d dVar = null;
        d dVar2;
        try {
            dVar2 = new d(new FileOutputStream(str), 1);
            try {
                dVar2.write(bArr);
                try {
                    dVar2.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    dVar = dVar2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            dVar2 = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            try {
                dVar.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    static byte[] a(String str) {
        return a(str, 0);
    }

    static byte[] a(String str, int i) {
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        IOException e;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        GZIPInputStream gZIPInputStream = null;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes(m);
        } catch (UnsupportedEncodingException e2) {
            bytes = str.getBytes();
        }
        bytes = c(bytes, 0, bytes.length, i);
        int i2 = (i & 4) != 0 ? 1 : 0;
        if (bytes != null && bytes.length >= 4 && i2 == 0 && 35615 == ((bytes[0] & 255) | ((bytes[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr = new byte[2048];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bytes);
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream2.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayInputStream2 = byteArrayInputStream;
                            } catch (Throwable th2) {
                                th = th2;
                                gZIPInputStream = gZIPInputStream2;
                            }
                        }
                        bytes = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                        }
                        try {
                            gZIPInputStream2.close();
                        } catch (Exception e5) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e6) {
                        }
                    } catch (IOException e7) {
                        e = e7;
                        byteArrayInputStream2 = byteArrayInputStream;
                        try {
                            e.printStackTrace();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e8) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e9) {
                            }
                            try {
                                byteArrayInputStream2.close();
                            } catch (Exception e10) {
                            }
                            return bytes;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayInputStream = byteArrayInputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e11) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e12) {
                            }
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e13) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                    byteArrayInputStream2 = null;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream2.close();
                    return bytes;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
                byteArrayOutputStream = null;
                byteArrayInputStream2 = null;
                e.printStackTrace();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream2.close();
                return bytes;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        }
        return bytes;
    }

    private static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)}));
        } else if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i2)}));
        } else {
            byte[] c = c(i3);
            if (bArr[i + 2] == k) {
                bArr2[i2] = (byte) ((((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) >>> 16);
                return 1;
            } else if (bArr[i + 3] == k) {
                r0 = (((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) | ((c[bArr[i + 2]] & 255) << 6);
                bArr2[i2] = (byte) (r0 >>> 16);
                bArr2[i2 + 1] = (byte) (r0 >>> 8);
                return 2;
            } else {
                r0 = ((((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) | ((c[bArr[i + 2]] & 255) << 6)) | (c[bArr[i + 3]] & 255);
                bArr2[i2] = (byte) (r0 >> 16);
                bArr2[i2 + 1] = (byte) (r0 >> 8);
                bArr2[i2 + 2] = (byte) r0;
                return 3;
            }
        }
    }

    static Object b(String str) {
        return a(str, 0, null);
    }

    static void b(String str, String str2) {
        IOException e;
        Throwable th;
        String d = d(str);
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream.write(d.getBytes(m));
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            try {
                bufferedOutputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    private static final byte[] b(int i) {
        return (i & 16) == 16 ? r : (i & 32) == 32 ? t : p;
    }

    static byte[] b(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            bArr2 = b(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
        }
        return bArr2;
    }

    static byte[] b(byte[] bArr, int i, int i2, int i3) {
        d dVar;
        IOException e;
        OutputStream outputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        } else if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
        } else if ((i3 & 2) != 0) {
            try {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    dVar = new d(byteArrayOutputStream2, i3 | 1);
                } catch (IOException e2) {
                    e = e2;
                    dVar = null;
                    outputStream = byteArrayOutputStream2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = outputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dVar = null;
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e3) {
                    }
                    try {
                        dVar.close();
                    } catch (Exception e4) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e5) {
                    }
                    throw th;
                }
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(dVar);
                    try {
                        gZIPOutputStream2.write(bArr, i, i2);
                        gZIPOutputStream2.close();
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception e6) {
                        }
                        try {
                            dVar.close();
                        } catch (Exception e7) {
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e8) {
                        }
                        return byteArrayOutputStream2.toByteArray();
                    } catch (IOException e9) {
                        e = e9;
                        gZIPOutputStream = gZIPOutputStream2;
                        outputStream = byteArrayOutputStream2;
                        throw e;
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream = gZIPOutputStream2;
                        gZIPOutputStream.close();
                        dVar.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    outputStream = byteArrayOutputStream2;
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream.close();
                    dVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                dVar = null;
                outputStream = null;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                dVar = null;
                byteArrayOutputStream = null;
                gZIPOutputStream.close();
                dVar.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            int i4 = (i3 & 8) != 0 ? 1 : 0;
            int i5 = (i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4);
            if (i4 != 0) {
                i5 += i5 / j;
            }
            Object obj = new byte[i5];
            int i6 = i2 - 2;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i6) {
                b(bArr, i9 + i, 3, obj, i8, i3);
                i5 = i7 + 4;
                if (i4 != 0 && i5 >= j) {
                    obj[i8 + 4] = l;
                    i8++;
                    i5 = 0;
                }
                i8 += 4;
                i7 = i5;
                i9 += 3;
            }
            if (i9 < i2) {
                b(bArr, i9 + i, i2 - i9, obj, i8, i3);
                i8 += 4;
            }
            if (i8 > obj.length - 1) {
                return obj;
            }
            Object obj2 = new byte[i8];
            System.arraycopy(obj, 0, obj2, 0, i8);
            return obj2;
        }
    }

    private static byte[] b(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        byte[] b = b(i4);
        int i6 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        i5 |= i6;
        switch (i2) {
            case 1:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = k;
                bArr2[i3 + 3] = k;
                break;
            case 2:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = k;
                break;
            case 3:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = b[i5 & 63];
                break;
        }
        return bArr2;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        b(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    static void c(String str, String str2) {
        OutputStream bufferedOutputStream;
        IOException e;
        Throwable th;
        byte[] c = c(str);
        OutputStream outputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream.write(c);
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = bufferedOutputStream;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            try {
                outputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    private static final byte[] c(int i) {
        return (i & 16) == 16 ? s : (i & 32) == 32 ? u : q;
    }

    static byte[] c(String str) {
        IOException e;
        int i = 0;
        c cVar = null;
        Throwable th;
        try {
            File file = new File(str);
            if (file.length() > 2147483647L) {
                throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
            }
            Object obj = new byte[((int) file.length())];
            c cVar2 = new c(new BufferedInputStream(new FileInputStream(file)), 0);
            while (true) {
                try {
                    int read = cVar2.read(obj, i, 4096);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } catch (IOException e2) {
                    e = e2;
                    cVar = cVar2;
                } catch (Throwable th2) {
                    th = th2;
                    cVar = cVar2;
                }
            }
            Object obj2 = new byte[i];
            System.arraycopy(obj, 0, obj2, 0, i);
            try {
                cVar2.close();
            } catch (Exception e3) {
            }
            return obj2;
            try {
                cVar.close();
            } catch (Exception e4) {
            }
            throw th;
            throw th;
        } catch (IOException e5) {
            e = e5;
            try {
                throw e;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    static byte[] c(byte[] bArr) {
        return c(bArr, 0, bArr.length, 0);
    }

    static byte[] c(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 < 4) {
                throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
            }
            int i4;
            byte[] c = c(i3);
            Object obj = new byte[((i2 * 3) / 4)];
            byte[] bArr2 = new byte[4];
            int i5 = i;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i + i2) {
                byte b = c[bArr[i5] & 255];
                if (b >= n) {
                    if (b >= o) {
                        i4 = i6 + 1;
                        bArr2[i6] = bArr[i5];
                        if (i4 > 3) {
                            i4 = b(bArr2, 0, obj, i7, i3) + i7;
                            if (bArr[i5] == k) {
                                break;
                            }
                            i6 = i4;
                            i4 = 0;
                        } else {
                            i6 = i7;
                        }
                    } else {
                        i4 = i6;
                        i6 = i7;
                    }
                    i5++;
                    i7 = i6;
                    i6 = i4;
                } else {
                    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i5] & 255), Integer.valueOf(i5)}));
                }
            }
            i4 = i7;
            Object obj2 = new byte[i4];
            System.arraycopy(obj, 0, obj2, 0, i4);
            return obj2;
        }
    }

    static String d(String str) {
        IOException e;
        Throwable th;
        int i = 0;
        c cVar = null;
        c cVar2;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            cVar2 = new c(new BufferedInputStream(new FileInputStream(file)), 1);
            while (true) {
                try {
                    int read = cVar2.read(bArr, i, 4096);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } catch (IOException e2) {
                    e = e2;
                }
            }
            String str2 = new String(bArr, 0, i, m);
            try {
                cVar2.close();
            } catch (Exception e3) {
            }
            return str2;
        } catch (IOException e4) {
            e = e4;
            cVar2 = null;
            try {
                throw e;
            } catch (Throwable th2) {
                th = th2;
                cVar = cVar2;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                cVar.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }
}
