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

import java.sql.Blob;
import java.sql.SQLException;

/**
 * Wraps a {@link Blob}.
 *
 * @author  AO Industries, Inc.
 */
public interface BlobWrapper extends Wrapper, Blob, AutoCloseable {

  /**
   * Gets the blob that is wrapped.
   */
  @Override
  Blob getWrapped();

  /**
   * Calls {@link #free()}
   *
   * @see  #free()
   */
  @Override
  default void close() throws SQLException {
    free();
  }

  @Override
  default long length() throws SQLException {
    return getWrapped().length();
  }

  @Override
  default byte[] getBytes(long pos, int length) throws SQLException {
    return getWrapped().getBytes(pos, length);
  }

  @Override
  InputStreamWrapper getBinaryStream() throws SQLException;

  @Override
  default long position(byte[] pattern, long start) throws SQLException {
    return getWrapped().position(pattern, start);
  }

  @Override
  long position(Blob pattern, long start) throws SQLException;

  @Override
  default int setBytes(long pos, byte[] bytes) throws SQLException {
    return getWrapped().setBytes(pos, bytes);
  }

  @Override
  default int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException {
    return getWrapped().setBytes(pos, bytes, offset, len);
  }

  @Override
  OutputStreamWrapper setBinaryStream(long pos) throws SQLException;

  @Override
  default void truncate(long len) throws SQLException {
    getWrapped().truncate(len);
  }

  @Override
  default void free() throws SQLException {
    getWrapped().free();
  }

  @Override
  InputStreamWrapper getBinaryStream(long pos, long length) throws SQLException;
}
