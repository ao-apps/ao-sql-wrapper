/*
 * ao-sql-wrapper - JDBC API wrapper.
 * Copyright (C) 2020, 2021, 2022, 2025  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-sql-wrapper.
 *
 * ao-sql-wrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-sql-wrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-sql-wrapper.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.sql.wrapper;

import com.aoapps.lang.io.NoClose;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Wraps an {@link InputStream}.
 *
 * @author  AO Industries, Inc.
 */
public class InputStreamWrapper extends InputStream implements Wrapper, NoClose {

  private final ConnectionWrapperImpl connectionWrapper;
  private final InputStream wrapped;

  public InputStreamWrapper(ConnectionWrapperImpl connectionWrapper, InputStream wrapped) {
    this.connectionWrapper = connectionWrapper;
    this.wrapped = wrapped;
  }

  /**
   * Gets the connection wrapper.
   */
  protected ConnectionWrapperImpl getConnectionWrapper() {
    return connectionWrapper;
  }

  /**
   * Gets the input stream that is wrapped.
   */
  @Override
  public InputStream getWrapped() {
    return wrapped;
  }

  @Override
  public boolean isNoClose() {
    InputStream in = getWrapped();
    return (in instanceof NoClose) && ((NoClose) in).isNoClose();
  }

  @Override
  public String toString() {
    return getWrapped().toString();
  }

  @Override
  public int read() throws IOException {
    return getWrapped().read();
  }

  @Override
  public int read(byte[] b) throws IOException {
    return getWrapped().read(b);
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    return getWrapped().read(b, off, len);
  }

  @Override
  public byte[] readAllBytes() throws IOException {
    return getWrapped().readAllBytes();
  }

  @Override
  public byte[] readNBytes(int len) throws IOException {
    return getWrapped().readNBytes(len);
  }

  @Override
  public int readNBytes(byte[] b, int off, int len) throws IOException {
    return getWrapped().readNBytes(b, off, len);
  }

  @Override
  public long skip(long n) throws IOException {
    return getWrapped().skip(n);
  }

  @Override
  public int available() throws IOException {
    return getWrapped().available();
  }

  @Override
  public void close() throws IOException {
    getWrapped().close();
  }

  @Override
  public void mark(int readlimit) {
    getWrapped().mark(readlimit);
  }

  @Override
  public void reset() throws IOException {
    getWrapped().reset();
  }

  @Override
  public boolean markSupported() {
    return getWrapped().markSupported();
  }

  @Override
  public long transferTo(OutputStream out) throws IOException {
    return getWrapped().transferTo(out);
  }
}
