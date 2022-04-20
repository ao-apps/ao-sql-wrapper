/*
 * ao-sql-wrapper - JDBC API wrapper.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
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
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * Wraps a {@link Reader}.
 *
 * @author  AO Industries, Inc.
 */
public class ReaderWrapper extends Reader implements Wrapper, NoClose {

  private final ConnectionWrapperImpl connectionWrapper;
  private final Reader wrapped;

  public ReaderWrapper(ConnectionWrapperImpl connectionWrapper, Reader wrapped) {
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
   * Gets the reader that is wrapped.
   */
  @Override
  public Reader getWrapped() {
    return wrapped;
  }

  @Override
  public boolean isNoClose() {
    Reader in = getWrapped();
    return (in instanceof NoClose) && ((NoClose)in).isNoClose();
  }

  @Override
  public String toString() {
    return getWrapped().toString();
  }

  @Override
  public int read(CharBuffer target) throws IOException {
    return getWrapped().read(target);
  }

  @Override
  public int read() throws IOException {
    return getWrapped().read();
  }

  @Override
  public int read(char[] cbuf) throws IOException {
    return getWrapped().read(cbuf);
  }

  @Override
  public int read(char[] cbuf, int off, int len) throws IOException {
    return getWrapped().read(cbuf, off, len);
  }

  @Override
  public long skip(long n) throws IOException {
    return getWrapped().skip(n);
  }

  @Override
  public boolean ready() throws IOException {
    return getWrapped().ready();
  }

  @Override
  public boolean markSupported() {
    return getWrapped().markSupported();
  }

  @Override
  public void mark(int readAheadLimit) throws IOException {
    getWrapped().mark(readAheadLimit);
  }

  @Override
  public void reset() throws IOException {
    getWrapped().reset();
  }

  @Override
  public void close() throws IOException {
    getWrapped().close();
  }

  // Java 10: public long transferTo(Writer out) throws IOException;
}
