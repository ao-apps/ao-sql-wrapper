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
import java.io.Writer;

/**
 * Wraps a {@link Writer}.
 *
 * @author  AO Industries, Inc.
 */
public class WriterWrapper extends Writer implements Wrapper, NoClose {

  private final ConnectionWrapperImpl connectionWrapper;
  private final Writer wrapped;

  public WriterWrapper(ConnectionWrapperImpl connectionWrapper, Writer wrapped) {
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
   * Gets the writer that is wrapped.
   */
  @Override
  public Writer getWrapped() {
    return wrapped;
  }

  @Override
  public boolean isNoClose() {
    Writer out = getWrapped();
    return (out instanceof NoClose) && ((NoClose) out).isNoClose();
  }

  @Override
  public String toString() {
    return getWrapped().toString();
  }

  @Override
  public void write(int c) throws IOException {
    getWrapped().write(c);
  }

  @Override
  public void write(char[] cbuf) throws IOException {
    getWrapped().write(cbuf);
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    getWrapped().write(cbuf, off, len);
  }

  @Override
  public void write(String str) throws IOException {
    getWrapped().write(str);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    getWrapped().write(str, off, len);
  }

  @Override
  public WriterWrapper append(CharSequence csq) throws IOException {
    getWrapped().append(csq);
    return this;
  }

  @Override
  public WriterWrapper append(CharSequence csq, int start, int end) throws IOException {
    getWrapped().append(csq, start, end);
    return this;
  }

  @Override
  public WriterWrapper append(char c) throws IOException {
    getWrapped().append(c);
    return this;
  }

  @Override
  public void flush() throws IOException {
    getWrapped().flush();
  }

  @Override
  public void close() throws IOException {
    getWrapped().close();
  }
}
