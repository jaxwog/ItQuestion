package com.wyz.arscrelease.androlib.res.util;

import com.wyz.arscrelease.directory.Directory;
import com.wyz.arscrelease.directory.DirectoryException;
import com.wyz.arscrelease.directory.FileDirectory;
import com.wyz.arscrelease.directory.ZipRODirectory;

import java.io.File;
import java.net.URI;


public class ExtFile extends File
{
  private Directory mDirectory;

  public ExtFile(File file)
  {
    super(file.getPath());
  }

  public ExtFile(URI uri) {
    super(uri);
  }

  public ExtFile(File parent, String child) {
    super(parent, child);
  }

  public ExtFile(String parent, String child) {
    super(parent, child);
  }

  public ExtFile(String pathname) {
    super(pathname);
  }

  public Directory getDirectory() throws DirectoryException {
    if (this.mDirectory == null)
      if (isDirectory())
        this.mDirectory = new FileDirectory(this);
      else
        this.mDirectory = new ZipRODirectory(this);


    return this.mDirectory;
  }
}