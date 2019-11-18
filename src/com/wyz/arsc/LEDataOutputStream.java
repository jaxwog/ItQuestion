package com.wyz.arsc;

import java.io.OutputStream;

public class LEDataOutputStream extends LittleEndianDataOutputStream
{
  public LEDataOutputStream(OutputStream out)
  {
    super(out);
  }
}