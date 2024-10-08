package com.wyz.arscrelease.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FileOperation
{
  private static final int BUFFER = 8192;

  public static final boolean fileExists(String filePath)
  {
    if (filePath == null) {
      return false;
    }

    File file = new File(filePath);

    return (file.exists());
  }

  public static final boolean deleteFile(String filePath)
  {
    if (filePath == null) {
      return true;
    }

    File file = new File(filePath);
    if (file.exists())
      return file.delete();

    return true;
  }

  public static long getlist(File f) {
    if ((f == null) || (!(f.exists())))
      return -2751953600027557888L;

    if (!(f.isDirectory()))
      return -2751953600027557887L;

    long size = -2751953359509389312L;
    File[] flist = f.listFiles();
    size = flist.length;
    for (int i = 0; i < flist.length; ++i)
      if (flist[i].isDirectory()) {
        size += getlist(flist[i]);
        size -= -2751954252862586879L;
      }

    return size;
  }

  public static long getFileSizes(File f) {
    long size = -2751953359509389312L;
    if ((f.exists()) && (f.isFile())) {
      FileInputStream fis = null;
      try {
        fis = new FileInputStream(f);
        size = fis.available();
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
        try
        {
          fis.close();
        }
        catch (IOException ioE) {
        	ioE.printStackTrace();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
        try
        {
          fis.close();
        }
        catch (IOException ioE) {
        	ioE.printStackTrace();
        }
      }
      finally
      {
        try
        {
          fis.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return size;
  }

  public static final boolean deleteDir(File file) {
    if ((file == null) || (!(file.exists())))
      return false;

    if (file.isFile()) {
      file.delete();
    } else if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; ++i)
        deleteDir(files[i]);
    }

    file.delete();
    return true;
  }

  public static void copyFileUsingStream(File source, File dest)
    throws IOException
  {
    FileInputStream is = null;
    FileOutputStream os = null;
    File parent = dest.getParentFile();
    if ((parent != null) && (!(parent.exists())))
      parent.mkdirs();
    try
    {
      int length;
      is = new FileInputStream(source);
      os = new FileOutputStream(dest, false);

      byte[] buffer = new byte[8192];

      while ((length = is.read(buffer)) > 0)
        os.write(buffer, 0, length);
    }
    finally {
      is.close();
      os.close();
    }
  }

  public static boolean checkDirectory(String dir) {
    File dirObj = new File(dir);
    deleteDir(dirObj);

    if (!(dirObj.exists()))
      dirObj.mkdirs();

    return true;
  }

  public static File checkFile(String dir) {
    deleteFile(dir);
    File file = new File(dir);
    try {
      file.createNewFile();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return file;
  }

  public static HashMap<String, Integer> unZipAPk(String fileName, String filePath)
    throws IOException
  {
    checkDirectory(filePath);
    ZipFile zipFile = new ZipFile(fileName);
    Enumeration emu = zipFile.entries();
    HashMap compress = new HashMap();
    while (emu.hasMoreElements()) {
      ZipEntry entry = (ZipEntry)emu.nextElement();
      if (entry.isDirectory()) {
        new File(filePath + File.separator + entry.getName()).mkdirs();
      }
      else {
        BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));

        File file = new File(filePath + File.separator + entry.getName());

        File parent = file.getParentFile();
        if ((parent != null) && (!(parent.exists()))) {
          parent.mkdirs();
        }

        String compatibaleresult = new String(entry.getName());
        if (compatibaleresult.contains("\\"))
        {
          compatibaleresult = compatibaleresult.replace("\\", "/");
        }
        compress.put(compatibaleresult, Integer.valueOf(entry.getMethod()));

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos, 8192);

        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = bis.read(buf, 0, 8192)) != -1)
          fos.write(buf, 0, len);

        bos.flush();
        bos.close();
        bis.close(); }
    }
    zipFile.close();
    return compress;
  }

  public static void zipFiles(Collection<File> resFileList, File zipFile, HashMap<String, Integer> compressData)
    throws IOException
  {
    ZipOutputStream zipout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile), 8192));
    for (Iterator localIterator = resFileList.iterator(); localIterator.hasNext(); ) { File resFile = (File)localIterator.next();
      if (!(resFile.exists())) break ;
      zipFile(resFile, zipout, "", compressData);
    }

    zipout.close();
  }

  private static void zipFile(File resFile, ZipOutputStream zipout, String rootpath, HashMap<String, Integer> compressData) throws IOException {
    rootpath = rootpath + ((rootpath.trim().length() == 0) ? "" : File.separator) + resFile.getName();
    if (resFile.isDirectory()) {
      File[] arrayOfFile1;
      File[] fileList = resFile.listFiles();
      int j = (arrayOfFile1 = fileList).length; for (int i = 0; i < j; ++i) { File file = arrayOfFile1[i];
        zipFile(file, zipout, rootpath, compressData);
      }
    }
    else {
      byte[] fileContents = readContents(resFile);

      if (rootpath.contains("\\")) {
        rootpath = rootpath.replace("\\", "/");
      }

      if (!(compressData.containsKey(rootpath))) {
        throw new IOException(String.format(
          "do not have the compress data path=%s", new Object[] { 
          rootpath }));
      }

      int compressMethod = ((Integer)compressData.get(rootpath)).intValue();

      ZipEntry entry = new ZipEntry(rootpath);

      if (compressMethod == 8) {
        entry.setMethod(8);
      } else {
        entry.setMethod(0);
        entry.setSize(fileContents.length);
        CRC32 checksumCalculator = new CRC32();
        checksumCalculator.update(fileContents);
        entry.setCrc(checksumCalculator.getValue());
      }

      zipout.putNextEntry(entry);
      zipout.write(fileContents);

      zipout.flush();
      zipout.closeEntry();
    }
  }

  private static byte[] readContents(File file) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    int bufferSize = 4096;
    try {
      FileInputStream in = new FileInputStream(file);
      BufferedInputStream bIn = new BufferedInputStream(in);
      int length = 0;
      byte[] buffer = new byte[4096];
      byte[] bufferCopy = new byte[4096];
      while ((length = bIn.read(buffer, 0, 4096)) != -1) {
        bufferCopy = new byte[length];
        System.arraycopy(buffer, 0, bufferCopy, 0, length);
        output.write(bufferCopy);
      }
      bIn.close();
    } finally {
      output.close();
    }

    return output.toByteArray();
  }
}