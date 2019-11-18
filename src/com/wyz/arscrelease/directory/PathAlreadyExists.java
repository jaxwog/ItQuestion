package com.wyz.arscrelease.directory;

public class PathAlreadyExists extends DirectoryException
{
  private static final long serialVersionUID = 3776428251424428904L;

  public PathAlreadyExists()
  {
  }

  public PathAlreadyExists(Throwable throwable)
  {
    super(throwable);
  }

  public PathAlreadyExists(String detailMessage) {
    super(detailMessage);
  }

  public PathAlreadyExists(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }
}