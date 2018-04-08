package co.cyberz.util.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class b {
    private static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        if (!file.exists()) {
            return null;
        }
        BufferedReader bufferedReader2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                int i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (i > 0) {
                                stringBuffer.append("#").append(readLine);
                            } else {
                                stringBuffer.append(readLine);
                            }
                            i++;
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        }
                    } catch (Exception e2) {
                        bufferedReader = bufferedReader2;
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                bufferedReader2.close();
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                }
            } catch (Exception e4) {
                fileInputStream2 = fileInputStream;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                return stringBuffer.toString();
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader2 = null;
                th = th4;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e8) {
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            fileInputStream2 = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return stringBuffer.toString();
        } catch (Throwable th32) {
            fileInputStream = null;
            th = th32;
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        return a(new File(str));
    }

    public static boolean a(File file, String str) {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        FileOutputStream fileOutputStream2;
        Throwable th;
        BufferedWriter bufferedWriter2 = null;
        boolean z = false;
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
                } catch (FileNotFoundException e) {
                    fileOutputStream2 = fileOutputStream;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    return z;
                } catch (Exception e4) {
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                    throw th;
                }
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    z = true;
                    try {
                        bufferedWriter.close();
                    } catch (Exception e9) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e10) {
                    }
                } catch (FileNotFoundException e11) {
                    bufferedWriter2 = bufferedWriter;
                    fileOutputStream2 = fileOutputStream;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return z;
                } catch (Exception e12) {
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e13) {
            fileOutputStream2 = null;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return z;
        } catch (Exception e14) {
            fileOutputStream = null;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    public static boolean a(String str, String str2) {
        return a(new File(str), str2);
    }
}
